package Car_Garrage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class newCar {
    public void car() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/workshop";
        String user = "root";
        String pass = "Sundar@$2004";

        String query = "select serviceId from service_details where employeeId=7";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        System.out.println("New Cars");
        int i = 0;
        while (rs.next()) {
            System.out.println("Service Id: " + rs.getInt(1));
            i++;
        }
        if (i == 0) {
            System.out.println(" _________________________");
            System.out.println("|                         |");
            System.out.println("|   No new cars arrived   |");
            System.out.println("|_________________________|");
        }
    }
}
