package lectures;

import java.util.ArrayList;

public class uniqueNumber {

	public static void main(String[] args) {
		
		
		int a[] = {4,4,5,5,5,4,6,6,9,4};
//		System.out.println(a.length); // 9
		ArrayList<Integer> ab = new ArrayList<Integer>();
		
		for(int i=0 ; i<a.length;i++)
		{
			int timesRepeat = 0; // Declaring variable 
			
			if(!ab.contains(a[i])) //The condition is fail and the flow go inside 
			{
				ab.add(a[i]);
				timesRepeat++ ; // Already one time exits so added ++
			
				for (int j=i+1 ; j<a.length;j++)
				{
					if(a[i]==a[j]) //
					{
						timesRepeat++;
						
					}
					
					
				}
				System.out.println(a[i] + " is " + timesRepeat + " times repeated.");
				
				if(timesRepeat == 1)
					System.out.println(a[i]+ " is unique number");
			}
		}
	}
}