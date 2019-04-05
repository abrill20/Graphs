
public class Vertex 
{
	private String name;
	private FlagValue flag; // 0=unvisited, 1=waiting, 2=visited
	
	public Vertex(String n)
	{
		name = n;
		flag = FlagValue.UNVISITED;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String n)
	{
		name = n;
	}

	public FlagValue getFlag()
	{
		return flag;
	}

	public void setVisited()
	{
		flag = FlagValue.VISITED;
	}

	public void setWaiting()
	{
		flag = FlagValue.WAITING;
	}

	public void setUnvisited()
	{
		flag = FlagValue.UNVISITED;
	}

	public boolean isUnvisited()
	{
		return flag == FlagValue.UNVISITED;
	}
}