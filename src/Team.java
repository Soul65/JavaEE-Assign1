// Bean for NHL team
public class Team
{
	private String TeamID;
	private String Name;	
	private String HeadCoach;
	private String AsstCoach;
	private String Manager;
	private int Wins;
	private int Losses;
	private int OTs;
	
	public Team()
	{
		setName(null);
		setManager(null);
		setHeadCoach(null);
		setAsstCoach(null);
		setWins(0);
		setLosses(0);
		setOTs(0);
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

	public int getOTs() {
		return OTs;
	}

	void setOTs(int oTs) {
		OTs = oTs;
	}

	public int getLosses() {
		return Losses;
	}

	void setLosses(int losses) {
		Losses = losses;
	}

	public int getWins() {
		return Wins;
	}

	void setWins(int wins) {
		Wins = wins;
	}	
}