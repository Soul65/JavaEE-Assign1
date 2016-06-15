public class Team
{
	private String TeamID;
	private String Name;	
	private String HeadCoach;
	private String AsstCoach;
	private String Manager;
	
	public Team()
	{
		setName(null);
		setManager(null);
		setHeadCoach(null);
		setAsstCoach(null);
	}
	
	public String getTeamID() 
	{
		return TeamID;
	}

	void setTeamID(String teamID) 
	{
		TeamID = teamID;
	}

	public String getName() 
	{
		return Name;
	}

	void setName(String name) 
	{
		Name = name;
	}

	public String getHeadCoach() 
	{
		return HeadCoach;
	}

	void setHeadCoach(String headCoach) 
	{
		HeadCoach = headCoach;
	}

	public String getAsstCoach() 
	{
		return AsstCoach;
	}

	void setAsstCoach(String asstCoach) 
	{
		AsstCoach = asstCoach;
	}
	
	public String getManager() 
	{
		return Manager;
	}

	void setManager(String manager) 
	{
		Manager = manager;
	}	
}