
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
@WebServlet("/DisplayTeamInfo")
public class DisplayTeamInfo extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTeamInfo() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "/TeamInfo.jsp";
		HttpSession session = request.getSession();
		Connection myConnection = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		Properties connectionProps = new Properties();				
		String teamID = request.getParameter("teamID");		
		ArrayList<TeamPlayer> roster = new ArrayList<TeamPlayer>();
		
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		
		try
		{
			//jdbc:derby://localhost:1527/G:/School Stuff/Term 6/Java/glassfish4/LeagueDB
			myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/LeagueDB", connectionProps);
			ResultSet rs = myConnection.prepareStatement("SELECT FIRSTNAME || ' ' || LASTNAME AS NAME, POSITION, JERSEY " + 
				"FROM ROSTER JOIN PLAYER " +
				"ON PLAYER = PLAYERID " +
				"WHERE TEAM = '" + teamID + "'").executeQuery();
			
			while(rs.next())
			{
				TeamPlayer player = new TeamPlayer();
				player.setName(rs.getString("NAME"));
				player.setPosition(rs.getString("POSITION"));
				player.setJersey(rs.getInt("JERSEY"));
				roster.add(player);
			}
			
			session.setAttribute("Roster", roster);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}