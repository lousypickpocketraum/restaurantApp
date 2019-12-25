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

@WebServlet(name="dbFetch")
    public class dbFetch extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();

            PreparedStatement stat = null;
            try {
                Connection connection = dbConnection.getConnection();
                String sql = "select * from menu";
                ResultSet rs = stat.executeQuery(sql);
                writer.write("<html>");
                writer.write("<head><style>" +
                        "table, th, td{border: 1px solid black; border-collapse:collapse;}" +
                        "th, td{padding:5px; text-align:left;}" +
                        "</style></head>");
                writer.write("<body>");
                writer.write("<table>");
                writer.write("<tr><th>Boşluk :)</th><th>Yemek Adı</th><th>Yemek Ücreti</th></tr>");
                while (rs.next()) {
                    int id_col = rs.getInt("id");
                    String yemek_adi = rs.getString("yemekadi");
                    String yemek_ucreti = rs.getString("yemekucreti");
                    writer.write("<tr>");
                    writer.write("<td>"+id_col+"</td>");
                    writer.write("<td>"+yemek_adi+"</td>");
                    writer.write("<td>"+yemek_ucreti+"₺ </td>");
                    writer.write("<td><button type='button'>Güncelle</button></td>");
                    writer.write("<td><button type='button'>Sil</button></td>");
                    writer.write("</tr>");
                }
                writer.write("</table></body></html>");
            } catch (SQLException | ClassNotFoundException e) {
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

