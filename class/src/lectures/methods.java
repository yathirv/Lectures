package lectures;
public class methods {

	public static void main(String[] args)
	{
		methods m = new methods();
		
		String Scooby = m.getDoo();
		String Finding = getNemo();
		
		System.out.println(Scooby);
		System.out.println(Finding);
	}
	
	public String getDoo()
	{
		System.out.println("hello world");
		return "scooby doo";
	}

	public static String getNemo()
	{
		System.out.println("bye world");
		return "finding nemo";
	}
}