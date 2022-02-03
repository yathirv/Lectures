package lectures;

import java.util.ArrayList;

public class Spilt {

	public static void main(String[] args)
	
	{
		
		ArrayList<String> a = new ArrayList<>();
		a.add("raj");
		a.add("gowtham");
		a.add("harish");
		a.remove(2);
		System.out.println(a.get(1));
		System.out.println(a.size()); // .size()

		String g = "power ranger SPD";
		System.out.println(g.length()); // .length()
		
		String[] splittedstring = g.split(" ");
		String[] splittedstring2 = g.split("ranger");
		System.out.println(splittedstring[0]);
		System.out.println(splittedstring[1]);
		System.out.println(splittedstring2[1].trim());
		
		for (int i = 0; i < g.length(); i++) 
		{
			System.out.println(g.charAt(i));
		}
		for (int m = g.length() - 1; m >= 0; m--) // m = 16 - 1; 15 >= 0 ; 15--
		{
			System.out.println(g.charAt(m) +" - "+ m);
		}

	}

}
