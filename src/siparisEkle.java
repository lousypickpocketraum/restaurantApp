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

@WebServlet(urlPatterns = "/siparisEkle")
public class siparisEkle extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{

        String siparis_yemek_adi = request.getParameter("siparisYemek");
        String siparis_yemek_ucreti=request.getParameter("siparisYemekUcreti");
        String siparis_adet = request.getParameter("siparisAdet");
        double siparis_adet2 = Double.valueOf(siparis_adet);

        response.setCharacterEncoding("UTF-8");
        PreparedStatement stat=null;
        try {
            Connection connection = dbConnection.getConnection();
            String siparisadd = "INSERT INTO siparis(siparisadi , siparisucreti, siparisadet)"
                    + "VALUES (" + "'" + siparis_yemek_adi + "'" +"," + siparis_yemek_ucreti + "," + siparis_adet2+")";
            stat = connection.prepareStatement(siparisadd);
            stat.executeUpdate(siparisadd);
            // siparisVer yönlendirme
            response.sendRedirect("siparisVer");
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
