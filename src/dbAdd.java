import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name="dbAdd")
public class dbAdd extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String yemekAdiEkle=request.getParameter("yemekAdi");
        String yemekUcretiEkle=request.getParameter("yemekUcreti");
        double yemekUcretiEkle2 = Double.valueOf(yemekUcretiEkle);
        PreparedStatement stat = null;
        try {
            stat = (PreparedStatement) dbConnection.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String add = "INSERT INTO menu(yemekadi , yemekucreti)"
                + "VALUES (" + "'" + yemekAdiEkle + "'" +"," + yemekUcretiEkle2 + ")";
        try{
            stat.executeUpdate(add);
        }catch (Exception e){
            System.out.println(e);
        }


    }
}
