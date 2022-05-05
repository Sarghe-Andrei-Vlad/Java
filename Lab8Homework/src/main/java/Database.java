import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public void feedDB(){
        String fileName = "D:\\Facultate\\An2Sem2\\PA---Java\\Lab8Homework\\src\\main\\resources\\concap.csv";
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            reader.readNext();
            String[] lineInArray;
            int id = 1;
            while ((lineInArray = reader.readNext()) != null) {
                single_instance.addCountry(id,lineInArray[0],lineInArray[1],lineInArray[2],lineInArray[3],lineInArray[4],lineInArray[5]);
                id++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCountry(int id, String name, String capitalName, String capitalLongitude, String capitalLatitude, String code, String continent) throws SQLException {
        String sql = "INSERT INTO countries (id, name, capitalName, capitalLongitude, capitalLatitude, code, continent) VALUES ('" + id + "','" + name + "','" + capitalName + "','" + capitalLongitude + "','" + capitalLatitude + "','" + code + "','" + continent + "')";
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

    public static double distance(double lat1, double lat2, double lon1, double lon2)
    {
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double r = 6371;
        return(c * r);
    }

    public static void showDistances()
    {
        double lat1 = 53.32055555555556;
        double lat2 = 53.31861111111111;
        double lon1 = -1.7297222222222221;
        double lon2 = -1.6997222222222223;
        System.out.println(distance(lat1, lat2,
                lon1, lon2) + " K.M");
    }
}

//    String sql = "INSERT INTO continents (id, name)"
//            + "VALUES ('1', 'Europe')";
//    Statement statement = connection.createStatement();
//    int rows = statement.executeUpdate(sql);
//            if(rows > 0){
//        System.out.println("A row has been inserted");
//    }
//    statement.close();