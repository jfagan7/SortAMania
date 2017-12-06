package sortcollection;
import java.util.Arrays;

public class Team13SortCompetition{

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
		radixSort(test,1);
		if(test.length%2==0)
		{
			return (int)(test[test.length/2]+test[(test.length/2)-1])/2;
		}
		return (int)test[test.length/2];
	}
	public static int challengeFive(Object[]test, Object query)
	{
		String[]copy=new String[test.length];
		for(int i =0;i<copy.length;i++)
		{
			copy[i]=test[i].toString();
		}
		mergeSort(copy);
		for(int x =0;x<copy.length;x++)
		{
			if(copy[x].compareToIgnoreCase(query.toString())==0)
				return x;
		}
		return -1;
	}
	public static void objectSort(Object[]arr)
	{
		String[]objStr=new String[arr.length];
		for(int i =0;i<objStr.length;i++)
		{
			objStr[i]=arr[i].toString();
		}
		mergeSort(objStr);
		
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
	public static void combSort(int[]list1)
	{
		int n=list1.length;
		int gap=n;
		boolean swapped=true;
		
		while(gap!=1 ||swapped==true)
		{
			gap=getNextGap(gap);
			swapped =false;
			for(int i=0;i<n-gap;i++)
			{
				if(list1[i]>list1[i+gap])
				{
					intSwap(list1,i,i+gap);
					swapped=true;
				}
			}
		}
	}
	public static int getNextGap(int num)
	{
		int gap = (num*10)/13;
		 
	    if (gap < 1)
	    {
	        return 1;
	    }
	    return gap;
	}
	static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
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
	public static String[] merge(String[] list1,String[] list2)
	{
		int size= list1.length+list2.length;
		String[] result=new String[size];
		int i=0; //current position in result
		int j=0; //current position in list1
		int k=0; //current position in list2
		while(i<size)
		{
			if(j<list1.length&&k<list2.length)
			{
				if(list1[j].compareTo(list2[k])<0)
				{
					result[i]=list1[j];
					j++;
				}
				else
				{
					result[i]=list2[k];
					k++;
				}
			}
			else if(j==list1.length)
			{
				result[i]=list2[k];
				k++;
			}
			else
			{
				result[i]=list1[j];
				j++;
			}
			i++;
		}
		return result;
	}
	public static String[] mergeSort(String[] list)
	{
		if(list.length>1)
		{
			String[] list1=new String[list.length/2];
			String[] list2=new String[list.length-list1.length];
			int z=0;
			for(int x=0;x<list1.length;x++)
			{
				list1[x]=list[x];
				z=x+1;
			}
			for(int y=0;y<list2.length;y++)
			{
				list2[y]=list[z];
				z++;
			}
			String[] sort1=mergeSort(list1);
			String[] sort2=mergeSort(list2);
			String[] newList=merge(sort1,sort2);
			return newList;
		}
		return list;
	}
	public static void bubbleSort(String [] list1)
	{
		 int n = list1.length;
	        for (int i = 0; i < n-1; i++)
	            for (int j = 0; j < n-i-1; j++)
	                if (list1[j].compareToIgnoreCase(list1[j+1])> 0)
	                {
	                    stringSwap(list1,j,j+1);
	                }
	}
	private static void stringSwap(String[] arr, int i, int j)
	{
		String temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
