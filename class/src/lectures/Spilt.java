package lectures;

public class Spilt {

	public static void main(String[] args)
	
	{
		
		String title = "Tom and Jerry ";
		System.out.println(title.length()); // .length()
		
		String[] broken = title.split(" ");
		String[] apart = title.split("and");
		
		System.out.println(broken[1]);
		System.out.println(apart[1].trim());
		
		for (int i = 0; i < title.length(); i++) 
		{
			System.out.println(title.charAt(i));
		}
		for (int m = title.length() - 1; m >= 0; m--)
//			     m = 14 - 1           ; 13 >= 0 ; 13--
		{
			System.out.println(title.charAt(m) +" - "+ m);
		}

	}

}
