import java.util.Scanner;
import java.util.Arrays;
public class SortSumAVGArray {
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Nhap do dai mang:");
    	int n=sc.nextInt();
    	int[] a = new int[n];
    	System.out.println("Nhap cac phan tu cua mang:");
    	for(int i=0;i<n;i++)
    	{
    		a[i]=sc.nextInt();
    	}
    	int sum=0;
    	for(int i=0;i<n;i++)
    	{
    		sum=sum+a[i];
    		for(int j=i+1;j<n;j++)
    		{
    			if(a[i]>a[j])
    			{
    				int b=a[j];
    				a[j]=a[i];
    				a[i]=b;
    			}
    		}
    	}
    	for(int i=0;i<n;i++)
    	{
    		System.out.print(a[i]+" ");
    	}
    	System.out.println();
    	System.out.println("Sum="+sum+"\nAVG="+(sum/n));
    	System.exit(0);
    }
}
