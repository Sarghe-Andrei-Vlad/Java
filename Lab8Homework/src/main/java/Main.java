import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.getInstance();
        database.feedDB();
    }
}
