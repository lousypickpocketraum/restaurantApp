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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// anasayfaya gitmek için urlPattern boþ string olmalý
@WebServlet(urlPatterns = "")
public class dbFetch extends HttpServlet {
	
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    response.setCharacterEncoding("UTF-8");
    PreparedStatement stat=null;
    try {
        Connection connection = dbConnection.getConnection();
        String sql = "select * from menu";
        stat = connection.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        List<MenuItem> arrayList = new ArrayList<MenuItem>();
        while (rs.next()) {
            int id_col = rs.getInt("id");
            String yemek_adi = rs.getString("yemekadi");
            String yemek_ucreti = rs.getString("yemekucreti");
            MenuItem menuItem = new MenuItem();
            menuItem.setId(id_col);
            menuItem.setYemekAdi(yemek_adi);
            menuItem.setYemekUcreti(yemek_ucreti);
            arrayList.add(menuItem);
        }
        request.setAttribute("items",arrayList);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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

