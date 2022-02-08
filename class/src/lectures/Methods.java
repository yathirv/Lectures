package lectures;
public class Methods {

	public static void main(String[] args)
	{
		Methods m = new Methods();
		
		String Scooby = m.Doo();
		String Finding = Nemo();
		
		ChildMethod c = new ChildMethod();
		c.child();
		
		System.out.println(Scooby);
		System.out.println(Finding);
	}
	
	public String Doo() //Return type is string 
	{
		System.out.println("hello world");
		return "scooby doo";
		
	}

	public static String Nemo()
	{
		System.out.println("bye world");
		return "finding nemo";
	}
}