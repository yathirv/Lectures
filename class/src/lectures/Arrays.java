package lectures;

public class Arrays {

	public static void main(String[] args) {
		
		int  [] row = new int[5];
		row[0] = 1;
		row[4] = 5;

		int   [] Num = { 1, 2, 3, 4, 5, 6 };
	
		Object[] Obj = { 5, 6 , "gowtham" };

		String[] Name = { "swetha", "gowtham", "suriya" };
		
        String A[] = new String[10];
               A[0] = "Hello";
               A[8] = "Geeks!!!";
        
        
        System.out.println(A.length); // .length // to find array.length
        System.out.println(Obj);     // Only Shows the memory location 

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
		
	}
}