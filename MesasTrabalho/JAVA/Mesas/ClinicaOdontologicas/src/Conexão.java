import java.sql.DriverManager;

public class Conexão {
    public static java.sql.Connection getConnection() throws Exception{

        String url = "jdbc:h2:~/test";

        Class.forName("org.h2.Driver").newInstance();

        return DriverManager.getConnection(url,"sa","");
    }

}
