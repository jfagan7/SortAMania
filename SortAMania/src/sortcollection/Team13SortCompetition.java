package sortcollection;
import java.util.Arrays;

public class Team13SortCompetition implements Comparable<Object>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1=generateRandomIntArray(10000);
		System.out.println(Arrays.toString(test1));
		insertionSort(test1);
		System.out.println(Arrays.toString(test1));
		calculateRunTime(test1);
	}
	public static void calculateRunTime(int[]test)
	{
		long startTime = System.nanoTime();
		//methodToTime();
		int median = challengeOne(test);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println(median);
		System.out.println(duration);
	}
	public static int challengeOne(int[]test)
	{
		insertionSort(test);
		if(test.length%2==0)
		{
			return (int)(test[test.length/2]+test[(test.length/2)-1])/2;
		}
		return (int)test[test.length/2];
	}
	public static int challengeFive(int[]test)
	{
		
		return -1;
	}
	
	private static void intSwap(int[] arr, int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void insertionSort(int[] list1)
	{
		for(int i=1;i<list1.length;i++)
			for(int j=i;j>0;j--)
			{
				if(list1[j]<list1[j-1])
					intSwap(list1, j, j-1);
			}
			
	}
	private static int[] generateRandomIntArray(int size)
	{
		int[] randomArray= new int[size];
		for(int i=0;i<randomArray.length;i++)
		{
			randomArray[i]= (int )(Math.random() * size);
		}
		return randomArray;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
