import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/siparisVer")
public class siparisVer extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        PreparedStatement stat=null;
        try {
            Connection connection = dbConnection.getConnection();
            String sql = "select * from menu";
            stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            List<SiparisItem> arrayList2 = new ArrayList<SiparisItem>();
            while (rs.next()) {
                String siparis_yemek_adi = rs.getString("yemekadi");
                String siparis_yemek_ucreti = rs.getString("yemekucreti");
                SiparisItem siparisItem = new SiparisItem();
                siparisItem.setSiparisYemekAdi(siparis_yemek_adi);
                siparisItem.setSiparisYemekUcreti(siparis_yemek_ucreti);
                arrayList2.add(siparisItem);
            }
            request.setAttribute("items",arrayList2);

            RequestDispatcher rd = request.getRequestDispatcher("SiparisVer.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            // TODO Auto-generated catch block
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
