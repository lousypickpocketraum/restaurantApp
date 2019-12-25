import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/dbAdd")
public class dbAdd extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	String yemekAdiEkle=request.getParameter("yemekAdi");
        String yemekUcretiEkle=request.getParameter("yemekUcreti");
        double yemekUcretiEkle2 = Double.valueOf(yemekUcretiEkle);
        PreparedStatement stat = null;
        try {
        	 Connection connection = dbConnection.getConnection();
        	 String add = "INSERT INTO menu(yemekadi , yemekucreti)"
  	                + "VALUES (" + "'" + yemekAdiEkle + "'" +"," + yemekUcretiEkle2 + ")";
 			 stat = connection.prepareStatement(add);
 			 stat.executeUpdate(add);
 			 // anasayfaya yönlendirme
 			response.sendRedirect(request.getContextPath());
		} catch (SQLException| ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stat!=null)
					stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        

    }
}
