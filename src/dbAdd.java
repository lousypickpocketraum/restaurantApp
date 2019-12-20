import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Statement;
import java.io.IOException;
import java.sql.*;

@WebServlet(name="dbAdd")
public class dbAdd extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String yemekAdiEkle=request.getParameter("yemekadi");
        String yemekUcretiEkle=request.getParameter("yemekucreti");
        double yemekUcretiEkle2 = Double.valueOf(yemekUcretiEkle);

        try {
            String host = "jdbc:mysql://localhost:3306/restraurant?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            String userName = "root";
            String userPass = "1234";
            Connection con = DriverManager.getConnection(host, userName, userPass);
            Statement stat = (Statement) con.createStatement();
            String add = "INSERT INTO menu(yemekadi , yemekucreti)"
                    + "VALUES (" + "'" + yemekAdiEkle + "'" +"," + yemekUcretiEkle2 + ")";
            try{
                stat.executeUpdate(add);
                System.out.println("veriler eklendi");
            }catch (Exception e){
                System.out.println(e);
            }

            String sql = "select * from menu";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int id_col = rs.getInt("id");
                String yemek_adi = rs.getString("yemekadi");
                String yemek_ucreti = rs.getString("yemekucreti");

                String p = id_col + " " + yemek_adi + " " + yemek_ucreti + "₺ " ;
                System.out.println(p);
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
