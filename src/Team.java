public class Team
{
	private String Name;
	private String Manager;
	private String HeadCoach;
	private String AsstCoach;
	
	public Team()
	{
		setName(null);
		setManager(null);
		setHeadCoach(null);
		setAsstCoach(null);
	}

	String getName() 
	{
		return Name;
	}

	void setName(String name) 
	{
		Name = name;
	}

	String getManager() 
	{
		return Manager;
	}

	void setManager(String manager) 
	{
		Manager = manager;
	}

	String getHeadCoach() 
	{
		return HeadCoach;
	}

	void setHeadCoach(String headCoach) 
	{
		HeadCoach = headCoach;
	}

	String getAsstCoach() 
	{
		return AsstCoach;
	}

	void setAsstCoach(String asstCoach) 
	{
		AsstCoach = asstCoach;
	}
}