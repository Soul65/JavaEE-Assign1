/* Name: Matt Allen and Rob Syed
 * PROG3060
 * Assignment 1
 * Date: 06/16/16
 * Description: Displays NHL teams
 * */

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
			// Get db connection
			myConnection = DriverManager.getConnection("jdbc:derby://localhost:1527/G:/School Stuff/Term 6/Java/glassfish4/LeagueDB", connectionProps);
			ResultSet rs = myConnection.prepareStatement("SELECT TEAMID, TEAMNAME, " +
				"heads.FIRSTNAME || ' ' || heads.LASTNAME AS HEADCOACH, " + 
				"assts.FIRSTNAME || ' ' || assts.LASTNAME AS ASSTCOACH, " + 
				"manages.FIRSTNAME || ' ' || manages.LASTNAME AS MANAGER " + 
				"FROM TEAM " +
				"JOIN STAFF heads ON HEADCOACH = heads.STAFFID " +
				"JOIN STAFF assts ON ASSTCOACH = assts.STAFFID " +
				"JOIN STAFF manages ON MANAGER = manages.STAFFID").executeQuery();
			
			// Loop through all teams
			while(rs.next())
			{
				Team currentTeam = new Team();
				currentTeam.setTeamID(rs.getString("TEAMID"));
				currentTeam.setName(rs.getString("TEAMNAME"));
				currentTeam.setHeadCoach(rs.getString("HEADCOACH"));
				currentTeam.setAsstCoach(rs.getString("ASSTCOACH"));
				currentTeam.setManager(rs.getString("MANAGER"));				
								
				ResultSet gamesRS = myConnection.prepareStatement("SELECT HOMESCORE, VISITORSCORE, OT "
						+ "FROM GAME WHERE HOME = '" + rs.getString("TEAMID") + "' AND HOMESCORE IS NOT NULL").executeQuery();
				
				int wins = 0;
				int losses = 0;
				int OTs = 0;
				
				// Loops through teams games to calculate standings
				while(gamesRS.next())
				{
					if(gamesRS.getInt("HOMESCORE") > gamesRS.getInt("VISITORSCORE"))
					{
						
						wins++;
					}
					else
					{
						losses++;
					}
					
					if(gamesRS.getString("OT").charAt(0) == 'Y')
					{
						OTs++;
					}
				}
				
				currentTeam.setWins(wins);
				currentTeam.setLosses(losses);
				currentTeam.setOTs(OTs);				
				
				teams.add(currentTeam);
			}
			
			session.setAttribute("Teams", teams);			
			session.setAttribute("username", userName);
			session.setAttribute("password", password);
			session.setAttribute("error", "");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			url = "/index.jsp";
			session.setAttribute("error", "Wrong username and/or password");
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}