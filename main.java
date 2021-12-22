import java.sql.*;

public class main {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\sqlite3\\Airline_ticket_booking\\Airline_ticket.db");
            Statement st = con.createStatement();

            st.execute("SELECT * FROM TicketDetails");
            ResultSet result = st.getResultSet();
            while(result.next()){
                String name = result.getString("name");
                int price = result.getInt("price");
                String destination = result.getString("destination");
                System.out.println(name + " | "+ price + " | "+ destination);
            }
            result.close();
            st.close();
            con.close();;


        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Something went wrong");
        }
    }
}