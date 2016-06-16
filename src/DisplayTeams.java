
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		String url = "/AllTeams.jsp";
		HttpSession session = request.getSession();
		Connection myConnection = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Properties connectionProps = new Properties();
		ArrayList<Team> teams = new ArrayList<Team>();		
		
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		
		try
		{
			myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/G:/School Stuff/Term 6/Java/glassfish4/LeagueDB", connectionProps);
			ResultSet rs = myConnection.prepareStatement("SELECT TEAMID, TEAMNAME, " +
				"heads.FIRSTNAME || ' ' || heads.LASTNAME AS HEADCOACH, " + 
				"assts.FIRSTNAME || ' ' || assts.LASTNAME AS ASSTCOACH, " + 
				"manages.FIRSTNAME || ' ' || manages.LASTNAME AS MANAGER " + 
				"FROM TEAM " +
				"JOIN STAFF heads ON HEADCOACH = heads.STAFFID " +
				"JOIN STAFF assts ON ASSTCOACH = assts.STAFFID " +
				"JOIN STAFF manages ON MANAGER = manages.STAFFID").executeQuery();
			
			while(rs.next())
			{
				Team currentTeam = new Team();
				currentTeam.setTeamID(rs.getString("TEAMID"));
				currentTeam.setName(rs.getString("TEAMNAME"));
				currentTeam.setHeadCoach(rs.getString("HEADCOACH"));
				currentTeam.setAsstCoach(rs.getString("ASSTCOACH"));
				currentTeam.setManager(rs.getString("MANAGER"));
				teams.add(currentTeam);
			}			
			
			session.setAttribute("Teams", teams);			
			session.setAttribute("username", userName);
			session.setAttribute("password", password);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}