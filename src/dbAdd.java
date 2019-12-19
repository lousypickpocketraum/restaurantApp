import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="menuEkle")
public class dbAdd extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String yemekAdiEkle=request.getParameter("yemekadi");
        String yemekUcretiEkle=request.getParameter("yemekucreti");
        double yemekUcretiEkle2 = Double.valueOf(yemekUcretiEkle);





    }
}
