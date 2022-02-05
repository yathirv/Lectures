package lectures;

public class Spilt {

	public static void main(String[] args)
	
	{
		
		String word = "Tom and Jerry ";
		System.out.println(word.length()); // .length()
		
		String[] broken = word.split(" ");
		String[] apart = word.split("and");
		
		System.out.println(broken[1]);
		System.out.println(apart[1].trim());
		
		for (int i = 0; i < word.length(); i++) 
		{
			System.out.println(word.charAt(i));
		}
		for (int m = word.length() - 1; m >= 0; m--) // m = 16 - 1; 15 >= 0 ; 15--
		{
			System.out.println(word.charAt(m) +" - "+ m);
		}

	}

}
