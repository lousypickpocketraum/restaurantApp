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


@WebServlet(name="dbAdd",urlPatterns = "/dbAdd")
public class dbAdd extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String yemekAdiEkle=request.getParameter("yemekAdi");
        String yemekUcretiEkle=request.getParameter("yemekUcreti");
        double yemekUcretiEkle2 = Double.valueOf(yemekUcretiEkle);
		response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        PreparedStatement stat = null;
        
        try {
        	 Connection connection = dbConnection.getConnection();

        	 String add = "INSERT INTO menu(yemekadi , yemekucreti)"
  	                + "VALUES (" + "'" + yemekAdiEkle + "'" +"," + yemekUcretiEkle2 + ")";
 			 stat = connection.prepareStatement(add);
 			 stat.executeUpdate(add);


			String sql = "select * from menu";
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				int id_col = rs.getInt("id");
				String yemek_adi = rs.getString("yemekadi");
				String yemek_ucreti = rs.getString("yemekucreti");
				writer.write("<html>");
				writer.write("<head><style>" +
						"table, th, td{border: 1px solid black; border-collapse:collapse;}" +
						"th, td{padding:5px; text-align:left;}" +
						"</style></head>");
				writer.write("<body>");
				writer.write("<table>");
				writer.write("<tr><th>Yemek Adı</th><th>Yemek Ücreti</th></tr>");
				writer.write("<tr>");
				writer.write("<td>"+id_col+"</td>");
				writer.write("<td>"+yemek_adi+"</td>");
				writer.write("<td>"+yemek_ucreti+"</td>");
				writer.write("</tr>");
				writer.write("</table></body></html>");

			}
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
