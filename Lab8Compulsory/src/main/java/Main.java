import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        database.addCountry(1,"Romania","+40", "Europe");
        database.addContinent(3,"North America");
        database.findCountry(1);
        database.findCountry("Romania");
        database.findContinent(3);
        database.findContinent("Asia");
    }
}
