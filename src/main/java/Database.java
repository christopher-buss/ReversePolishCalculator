package database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * The class Database.
 * Basic data analysis of top URLs ranking (provided by Google).
 */
public class Database {
  private String databaseUrl = "jdbc:postgresql://localhost:5432/CS2855/";
  private String user;
  private String password;

  /**
   * For each row.
   *
   * @param connection the connection
   * @param query the query
   * @param consumer the consumer
   * @throws SQLException the SQL exception
   */
  private static void forEachRow(Connection connection, String query, ResultSetConsumer consumer)
      throws SQLException {
    try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {
      while (resultSet.next()) {
        consumer.consume(resultSet);
      }
    }
  }

  /**
   * Query one.
   * List the 10 most popular URLs in descending order (decending with respect to popularity)
   *
   * @param connection the connection
   * @throws SQLException the SQL exception
   */
  private static void queryOne(Connection connection) throws SQLException {
    forEachRow(connection, "SELECT id, name, tld " + "FROM   topurl " + "WHERE  id <= 10 ",
        resultSet -> System.out.println(resultSet.getString("id") + "\t\t"
            + resultSet.getString("name") + "\t\t" + resultSet.getString("tld")));
  }

  /**
   * Query two.
   * List  the  10 distinct most  popular  top level  domains  in  descending  order
   * (with  respect  to popularity).
   *
   * @param connection the connection
   * @throws SQLException the SQL exception
   */
  private static void queryTwo(Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      statement.execute(
          "CREATE VIEW top_ten_tld AS SELECT * FROM (SELECT *, ROW_NUMBER() OVER (PARTITION BY tld,"
              + " tld1 ORDER BY id) AS ROW_NUMBER FROM topurl) "
              + "AS rows WHERE ROW_NUMBER = 1 ORDER BY id");
    }

    forEachRow(connection, "SELECT tld, tld1 FROM top_ten_tld LIMIT 10", resultSet -> System.out
        .println(resultSet.getString("tld") + "\t\t" + resultSet.getString("tld1")));
  }

  /**
   * Query three.
   * List the 10 distinct most popular descriptions of the rightmost parts of the top level 
   * domains in descending order (with respect to popularity).  
   *
   * @param connection the connection
   * @throws SQLException the SQL exception
   */
  private static void queryThree(Connection connection) throws SQLException {
    forEachRow(connection, "SELECT * " + "FROM map " + "INNER JOIN top_ten_tld "
        + "ON map.tld = top_ten_tld.tld AND top_ten_tld.tld1 = '' OR map.tld = top_ten_tld.tld1 "
        + "ORDER BY top_ten_tld.id " + "LIMIT 10",
        resultSet -> System.out
            .println(resultSet.getString("tld") + "\t\t" + resultSet.getString("description")));
  }

  /**
   * Query four.
   * List the top 10 distinct most popular left-most substrings appearing in more than one line in
   * the topURLs file. E.g., the occurrence of both “google.com” and “google.co.uk” in the file, 
   * means that the leftmost substring “google” appears in more than one line.
   *
   * @param connection the connection
   * @throws SQLException the SQL exception
   */
  private static void queryFour(Connection connection) throws SQLException {
    forEachRow(connection,
        "SELECT name FROM (SELECT DISTINCT ON (name) MIN(id) AS id, name FROM topurl "
        + "GROUP BY name HAVING COUNT(*) > 1) AS list ORDER BY id LIMIT 10",
        resultSet -> System.out.println(resultSet.getString("name")));
  }

  /**
   * Execute query with table data.
   *
   * @param query the query
   * @param connection the connection
   * @param tableData the table data
   */
  private static void executeStatement(String query, Connection connection, String tableData) {
    try (Statement statement = connection.createStatement()) {
      statement.execute(query + tableData);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Drop table using SQL query.
   *
   * @param connection the connection
   * @param tableData the table data
   */
  private static void dropTable(Connection connection, String tableData) {
    executeStatement("DROP TABLE IF EXISTS ", connection, tableData + " CASCADE");
  }

  /**
   * Creates the table using SQL query.
   *
   * @param connection the connection
   * @param tableData the table data
   */
  private static void createTable(Connection connection, String tableData) {
    executeStatement("CREATE TABLE ", connection, tableData);
  }

  /**
   * Gets the database result set.
   * For use in checking for existing tables and views to drop.
   *
   * @param connection the connection
   * @return the database result set
   * @throws SQLException the SQL exception
   */
  private static ResultSet getDatabaseResultSet(Connection connection) throws SQLException {
    return connection.getMetaData().getTables(connection.getCatalog(), null, "%",
        new String[] {"TABLE"});
  }

  /**
   * Drop existing tables.
   * Drops any tables or views in the database.
   *
   * @param resultSet the result set
   * @param connection the connection
   * @throws SQLException the SQL exception
   */
  private static void dropExistingTables(ResultSet resultSet, Connection connection)
      throws SQLException {
    while (resultSet.next()) {
      dropTable(connection, resultSet.getString(3));
    }
  }

  /**
   * Insert data from TopURL into table.
   *
   * @param connection the connection
   */
  private static void insertTopUrlIntoTable(Connection connection) {
    try (
        BufferedReader bufferedReader =
            new BufferedReader(new FileReader("Assignment3/TopURLs.txt"));
        PreparedStatement statement = connection
            .prepareStatement("INSERT INTO topurl(id, name, tld, tld1) VALUES(?, ?, ?, ?)")) {
      int count = 0;
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split("\\s+", 4);
        statement.setInt(1, Integer.parseInt(splitLine[0]));
        statement.setString(2, splitLine[1]);
        statement.setString(3, splitLine[2]);
        statement.setString(4, splitLine[3].trim());
        statement.addBatch();
        count++;
        if (count % 100 == 0) {
          statement.executeBatch();
        }
      }
      statement.executeBatch();
    } catch (SQLException | IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Insert data from mapping into table.
   *
   * @param connection the connection
   */
  private static void insertMappingIntoTable(Connection connection) {
    try (
        BufferedReader bufferedReader =
            new BufferedReader(new FileReader("Assignment3/mapping.txt"));
        PreparedStatement statement =
            connection.prepareStatement("INSERT INTO map(tld, description) VALUES (?, ?)")) {
      int count = 0;
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        String[] splitLine = line.split("\\s+", 2);
        statement.setString(1, splitLine[0]);
        statement.setString(2, splitLine[1]);
        statement.addBatch();
        count++;
        if (count % 100 == 0) {
          statement.executeBatch();
        }
      }
      statement.executeBatch();
    } catch (SQLException | IOException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    Database app = new Database();
    app.getInput();
    try (Connection connection = app.connectToDatabase()) {
      System.out.println("Connected to PostgreSQL server successfully.");

      ResultSet resultSet = getDatabaseResultSet(connection);
      dropExistingTables(resultSet, connection);

      createTable(connection,
          "map(" + "tld varchar(15), " + "description varchar(124), " + "PRIMARY KEY (tld));");
      insertMappingIntoTable(connection);

      createTable(connection,
          "topurl(" + "id int, " + "name varchar(40), " + "tld varchar(15), " + "tld1 varchar(10), "
              + "PRIMARY KEY (id)), " + "FOREIGN KEY (tld) REFERENCES map (tld))");
      insertTopUrlIntoTable(connection);

      /* Print out queries */
      System.out.println("################# 1st Query ################");
      queryOne(connection);
      System.out.println("################# 2nd Query ################");
      queryTwo(connection);
      System.out.println("################# 3rd Query ################");
      queryThree(connection);
      System.out.println("################# 4th Query ################");
      queryFour(connection);

    } catch (SQLException err) {
      System.out.println(err.getMessage());
    }
  }

  /**
   * Gets the input.
   *
   * @return the input
   */
  private void getInput() {
    Scanner kbd = new Scanner(System.in);
    System.out.print("Enter username: ");
    user = kbd.next();
    System.out.print("Enter password: ");
    password = kbd.next();
    databaseUrl += user; // Append username to URL
    kbd.close();
  }

  /**
   * Connect to database.
   *
   * @return the connection
   * @throws SQLException the SQL exception
   */
  private Connection connectToDatabase() throws SQLException {
    return DriverManager.getConnection(databaseUrl, user, password);
  }

  /**
   * Interface that defines a consumer of a ResultSet.
   */
  @FunctionalInterface
  private interface ResultSetConsumer {
    /**
     * Consume.
     *
     * @param resultSet the result set
     * @throws SQLException the sql exception
     */
    void consume(ResultSet resultSet) throws SQLException;
  }
}
