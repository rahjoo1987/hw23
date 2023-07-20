package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TravelHistoryServlet")
public class TravelHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database credentials
        String url = "jdbc:mysql://your_database_url/your_database_name";
        String username = "your_username";
        String password = "your_password";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Query to retrieve travel history from the database
            String sql = "SELECT origin_city, destination_city, date, ticket_number FROM travel_history";

            // Execute the query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Display the travel history in the response
            out.println("<html><body>");
            out.println("<h1>Travel History</h1>");
            out.println("<ul>");

            while (rs.next()) {
                String originCity = rs.getString("origin_city");
                String destinationCity = rs.getString("destination_city");
                String date = rs.getString("date");
                String ticketNumber = rs.getString("ticket_number");

                out.println("<li>");
                out.println("Origin City: " + originCity);
                out.println("Destination City: " + destinationCity);
                out.println("Date: " + date);
                out.println("Ticket Number: " + ticketNumber);
                out.println("</li>");
            }

            out.println("</ul>");
            out.println("</body></html>");

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
