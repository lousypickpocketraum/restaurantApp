import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "")
public class siparisVer extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String id = request.getParameter("id");
        List<MenuItem> arrayList = new ArrayList<MenuItem>();
        MenuItem menuItem = new MenuItem();
        menuItem.setId(siparisId);
        menuItem.setYemekAdi(yemekUcretiEkle2);
        menuItem.setYemekUcreti(yemek_ucreti);
        arrayList.add(menuItem);
    }
}
