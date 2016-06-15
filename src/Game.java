import java.sql.Date;
import java.sql.Time;

public class Game 
{
	Date GameDate;
	Time GameTime;
	String Arena;
	String Home;
	String Visitor;
	int HomeScore;
	int VisitorScore;
	char Overtime;
	char ShootOut;
		
	public Game() 
	{
		setGameDate(null);
		setGameTime(null);
		setArena(null);
		setHome(null);
		setVisitor(null);
		setHomeScore(0);
		setVisitorScore(0);
		setOvertime(' ');
		setShootOut(' ');
	}

	public Date getGameDate() 
	{
		return GameDate;
	}
	
	void setGameDate(Date gameDate) 
	{
		GameDate = gameDate;
	}
	
	public Time getGameTime() 
	{
		return GameTime;
	}
	
	void setGameTime(Time gameTime) 
	{
		GameTime = gameTime;
	}
	
	public String getArena() 
	{
		return Arena;
	}
	
	void setArena(String arena) 
	{
		Arena = arena;
	}
	
	public String getHome() 
	{
		return Home;
	}
	
	void setHome(String home) 
	{
		Home = home;
	}
	
	public String getVisitor() 
	{
		return Visitor;
	}
	
	void setVisitor(String visitor) 
	{
		Visitor = visitor;
	}
	
	public int getHomeScore() 
	{
		return HomeScore;
	}
	
	void setHomeScore(int homeScore) 
	{
		HomeScore = homeScore;
	}
	
	public int getVisitorScore() 
	{
		return VisitorScore;
	}
	
	void setVisitorScore(int visitorScore) 
	{
		VisitorScore = visitorScore;
	}
	
	public char getOvertime() 
	{
		return Overtime;
	}
	
	void setOvertime(char overtime) 
	{
		Overtime = overtime;
	}
	
	public char getShootOut() 
	{
		return ShootOut;
	}
	
	void setShootOut(char shootOut) 
	{
		ShootOut = shootOut;
	}
}
