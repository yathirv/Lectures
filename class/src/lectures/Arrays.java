package lectures;

import java.util.ArrayList;

public class Arrays {

	public static void main(String[] args) {
		
		
		int   [] Num  = { 1, 2, 3, 4, 5, 6 };
		Object[] Obj  = { 5, 6 , "gowtham" };
		String[] Name = { "Apple", "Orange", "Banana" };
		
		int row[ ] = new int[5];
		    row[0] = 1;
		    row[4] = 5;

        String A[ ] = new String[10];
               A[0] = "Hello";
               A[8] = "Geeks!!!";
        
        
        System.out.println(A.length); // .length // to find array.length
        System.out.println(Obj);     // Only Shows the memory location 
        
/*      Enhanced for loop syntax
        From this array row every time in every iteration
        one has to be picked out */

		for (int element : row) {
			System.out.println(element); 
		}

		for (int element : Num) {
			System.out.println(element);
		}
		
		for (Object element : Obj) {
			System.out.println(element);
		}
		
		for (String k : Name) {
			System.out.println(k);
		}
		
		for (int element : Num)
		{
			if (element % 2 == 0) {
				System.out.println(element);
				break;
		}
			else
			{
				System.out.println(element + " is odd");
			}

		}
		
		ArrayList<String> a = new ArrayList<>();
		a.add("Scooby");
		a.add("Dooby");
		a.add("Doo !");
		a.remove(2);
		
		System.out.println(a.get(1));
		System.out.println(a.size()); // .size()
		
	}
}