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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setCharacterEncoding("UTF-8");
        PreparedStatement stat=null;
        PreparedStatement stat2=null;
        try {
            Connection connection = dbConnection.getConnection();
            //menudeki verileri çekiyor
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

            //siparisteki verileri çekiyor
            String sql2 = "select * from siparis";
            stat2 = connection.prepareStatement(sql2);
            ResultSet rs2 = stat2.executeQuery();
            List<SiparisItem> arrayList3 = new ArrayList<SiparisItem>();
            while (rs2.next()) {
                String siparis_yemek_adi2 = rs2.getString("siparisadi");
                String siparis_yemek_ucreti2 = rs2.getString("siparisucreti");
                int siparis_adeti=rs2.getInt("siparisadet");
                SiparisItem siparisItem2 = new SiparisItem();
                siparisItem2.setSiparisYemekAdi(siparis_yemek_adi2);
                siparisItem2.setSiparisYemekUcreti(siparis_yemek_ucreti2);
                siparisItem2.setSiparisAdeti(siparis_adeti);
                arrayList3.add(siparisItem2);
            }
            request.setAttribute("items2",arrayList3);


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
