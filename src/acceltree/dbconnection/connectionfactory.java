package acceltree.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionfactory {
	
	 String driverClassName = "com.mysql.jdbc.Driver";
     String connectionUrl = "jdbc:mysql://192.168.2.155:3306/defecttracking";
     String dbUser = "root";
     String dbPwd = "root";

     private static connectionfactory connectionfactory = null;

     private connectionfactory() {
             try {
                     Class.forName(driverClassName);
             } catch (ClassNotFoundException e) {
                     e.printStackTrace();
             }
     }

     public Connection getConnection() throws SQLException {
             Connection conn = null;
            
             conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
             return conn;
     }

     public static connectionfactory getInstance() {
             if (connectionfactory == null) {
                     connectionfactory = new connectionfactory();
             }
             return connectionfactory;
     }
     

}
