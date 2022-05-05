import java.sql.*;

public class Database {
    private static Database single_instance = null;

    Connection connection;

    private Database()
    {
        String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "STUDENT";
        String password = "STUDENT";

        try {
            this.connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connection succeded");
        } catch (SQLException e) {
            System.out.println("DB Connection Error");
            e.printStackTrace();
        }
    }

    public static Database getInstance()
    {
        if (single_instance == null)
            single_instance = new Database();
        return single_instance;
    }

    public void addCountry(int id, String name, String code, String continent) throws SQLException {
        String sql = "INSERT INTO countries (id, name, code, continent) VALUES ('" + id + "','" + name + "','" + code + "','" + continent + "')";
        Statement statement = this.connection.createStatement();
        int rows = statement.executeUpdate(sql);
        if (rows > 0) {
            System.out.println("A row has been inserted into the table countries");
            statement.close();
        }
    }

    public void addContinent(int id, String name) throws SQLException {
        String sql = "INSERT INTO continents (id, name) VALUES ('" + id + "','" + name +"')";
        Statement statement = this.connection.createStatement();
        int rows = statement.executeUpdate(sql);
        if (rows > 0) {
            System.out.println("A row has been inserted into the table continents");
            statement.close();
        }
    }

    public void findCountry(int id) throws SQLException {
        String sql = "SELECT * from countries WHERE id=" + id;
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            String str1 = result.getString(1);
            String str2 = result.getString(2);
            String str3 = result.getString(3);
            String str4 = result.getString(4);
            System.out.println(str1 + str2 + str3 + str4);
        }
        statement.close();
    }

    public void findCountry(String name) throws SQLException {
        String sql = "SELECT * from countries WHERE name='" + name + "'";
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            String str1 = result.getString(1);
            String str2 = result.getString(2);
            String str3 = result.getString(3);
            String str4 = result.getString(4);
            System.out.println(str1 + str2 + str3 + str4);
        }
        statement.close();
    }

    public void findContinent(int id) throws SQLException {
        String sql = "SELECT * from continents WHERE id=" + id;
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            String str1 = result.getString(1);
            String str2 = result.getString(2);
            System.out.println(str1 + str2);
        }
        statement.close();
    }

    public void findContinent(String name) throws SQLException {
        String sql = "SELECT * from continents WHERE name='" + name + "'";
        Statement statement = this.connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            String str1 = result.getString(1);
            String str2 = result.getString(2);
            System.out.println(str1 + str2);
        }
        statement.close();
    }

//    String sql = "INSERT INTO continents (id, name)"
//            + "VALUES ('1', 'Europe')";
//    Statement statement = connection.createStatement();
//    int rows = statement.executeUpdate(sql);
//            if(rows > 0){
//        System.out.println("A row has been inserted");
//    }
//    statement.close();
}