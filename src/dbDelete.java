import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dbDelete")
public class dbDelete extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		PreparedStatement stat = null;
		try {
			Connection connection = dbConnection.getConnection();
			String add = "DELETE FROM menu WHERE id="+id;
			stat = connection.prepareStatement(add);
			stat.executeUpdate(add);
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
