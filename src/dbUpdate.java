import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/dbUpdate")
public class dbUpdate extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String yeniYemekAdiEkle=request.getParameter("yeniYemekAdi");
        String yeniYemekUcretiEkle=request.getParameter("yeniYemekUcreti");
        double yeniYemekUcretiEkle2 = Double.valueOf(yeniYemekUcretiEkle);
        PreparedStatement stat=null;
        try {
            Connection connection = dbConnection.getConnection();
            String update = "UPDATE menu SET yemekadi='"+yeniYemekAdiEkle+"',yemekucreti="+yeniYemekUcretiEkle2+"WHERE id="+id;
            stat = connection.prepareStatement(update);
            stat.executeUpdate(update);
            // anasayfaya yönlendirme
            response.sendRedirect(request.getContextPath());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null)
                    stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
