// Bean for a player in a team
public class TeamPlayer
{
	private String Name;
	private String Position;
	private int Jersey;
	
	public TeamPlayer()
	{
		setName(null);
		setPosition(null);
		setJersey(0);
	}
	
	public String getName() 
	{
		return Name;
	}
	
	void setName(String name) 
	{
		Name = name;
	}
	
	public String getPosition() 
	{
		return Position;
	}
	
	void setPosition(String position) 
	{
		Position = position;
	}
	
	public int getJersey() 
	{
		return Jersey;
	}
	
	void setJersey(int jersey) 
	{
		Jersey = jersey;
	}
}
