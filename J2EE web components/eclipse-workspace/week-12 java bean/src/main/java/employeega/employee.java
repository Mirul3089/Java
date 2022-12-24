package employeega;

public class employee implements java.io.Serializable{
	private int id;
	private String name;

	public employee(){
		
	}

	public void setId(int id){
		this.id=id;
		}

	public int getId()
	{
		return id;
		}

	public void setName(String name)
	{
		this.name=name;
	}

	public String getName()
	{
		return name;
	}
	}