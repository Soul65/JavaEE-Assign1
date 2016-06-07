
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayTeams
 */
@WebServlet("/DisplayTeams")
public class DisplayTeams extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTeams() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "/index.jsp";
		String[] teamNames = null;
		HttpSession session = request.getSession();
		Connection myConnection = null;
		String userName = "mallen";
		String password = "1234";
		Properties connectionProps = new Properties();
		
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		
		try
		{
			myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LeagueDB", connectionProps);
			ResultSet rs = myConnection.prepareStatement("SELECT TEAMNAME, HEADCOACH, ASSTCOACH, MANAGER FROM TEAMS").executeQuery();
			
			while(rs.next())
			{
				System.out.print(rs.getString("TEAMNAME"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		session.setAttribute("teamNames", teamNames);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}

}
