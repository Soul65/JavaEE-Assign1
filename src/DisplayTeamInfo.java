
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
		ArrayList<Game> games = new ArrayList<Game>();
		ArrayList<Game> scheduledGames = new ArrayList<Game>();
		int wins = 0;
		int losses = 0;
		int OTs = 0;
		int SOs = 0;
		
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
			
			rs = myConnection.prepareStatement("SELECT GAMEDATE, GAMETIME, ARENANAME, ht.TEAMNAME AS HOME, vt.TEAMNAME AS VISITOR, "
					+ "HOMESCORE, VISITORSCORE, OT, SO "
					+ "FROM GAME JOIN ARENA ON ARENA = ARENAID "
					+ "JOIN TEAM ht ON HOME = ht.TEAMID "
					+ "JOIN TEAM vt ON VISITOR = vt.TEAMID "
					+ "WHERE HOME = '" + teamID + "' AND HOMESCORE IS NOT NULL").executeQuery();
			
			while(rs.next())
			{
				Game game = new Game();
				game.setGameDate(rs.getDate("GAMEDATE"));
				game.setGameTime(rs.getTime("GAMETIME"));
				game.setArena(rs.getString("ARENANAME"));
				game.setHome(rs.getString("HOME"));
				game.setVisitor(rs.getString("VISITOR"));
				game.setHomeScore(rs.getInt("HOMESCORE"));
				game.setVisitorScore(rs.getInt("VISITORSCORE"));
				game.setOvertime(rs.getString("OT").charAt(0));
				game.setShootOut(rs.getString("SO").charAt(0));
				games.add(game);
				
				if(rs.getInt("HOMESCORE") > rs.getInt("VISITORSCORE"))
				{
					wins++;
				}
				else
				{
					losses++;
				}
				
				if(rs.getString("OT").charAt(0) == 'Y')
				{
					OTs++;
				}
				
				if(rs.getString("SO").charAt(0) == 'Y')
				{
					SOs++;
				}
			}
			
			session.setAttribute("Games", games);
			session.setAttribute("Wins", wins);
			session.setAttribute("Losses", losses);
			session.setAttribute("OTs", OTs);
			session.setAttribute("SOs", SOs);
			
			rs = myConnection.prepareStatement("SELECT GAMEDATE, GAMETIME, ARENANAME, ht.TEAMNAME AS HOME, vt.TEAMNAME AS VISITOR, "
					+ "HOMESCORE, VISITORSCORE, OT, SO "
					+ "FROM GAME JOIN ARENA ON ARENA = ARENAID "
					+ "JOIN TEAM ht ON HOME = ht.TEAMID "
					+ "JOIN TEAM vt ON VISITOR = vt.TEAMID "
					+ "WHERE HOME = '" + teamID + "' AND HOMESCORE IS NULL").executeQuery();
			
			while(rs.next())
			{
				Game game = new Game();
				game.setGameDate(rs.getDate("GAMEDATE"));
				game.setGameTime(rs.getTime("GAMETIME"));
				game.setArena(rs.getString("ARENANAME"));
				game.setHome(rs.getString("HOME"));
				game.setVisitor(rs.getString("VISITOR"));
				scheduledGames.add(game);
			}
			
			session.setAttribute("ScheduledGames", scheduledGames);			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}