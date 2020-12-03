package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    public static Connection connection() throws Exception {
        String user = "sa";
        String pwd = "ZZDxsxcyh211522";
        String database = "rw";
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName="
                +database+ ";user=" +user + ";password=" +pwd;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url);
    }
}