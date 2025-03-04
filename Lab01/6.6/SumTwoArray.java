import java.util.Scanner;
import java.util.Arrays;
public class SumTwoArray {
     public static void main(String[] args)
     {
    	 Scanner sc=new Scanner(System.in);
    	 System.out.println("nhap kich thuoc:");
    	 int n=sc.nextInt();
    	 int[] a=new int[n];
    	 int[] b=new int[n];
    	 System.out.println("nhap phan tu mang a:");
    	 for(int i=0;i<n;i++)
    	 {
    		 a[i]=sc.nextInt();
    	 }
    	 System.out.println("nhap phan tu mang b:");
    	 for(int i=0;i<n;i++)
    	 {
    		 b[i]=sc.nextInt();
    	 }
    	 System.out.println("phan tu mang a:");
    	 for(int i=0;i<n;i++)
    	 {
    		 System.out.print(a[i]+" ");
    	 }
    	 System.out.println("phan tu mang b:");
    	 System.out.println();
    	 for(int i=0;i<n;i++)
    	 {
    		 System.out.print(b[i]+" ");
    	 }
    	 System.out.println();
    	 for(int i=0;i<n;i++)
    	 {
    		 a[i]=a[i]+b[i];
    	 }
    	 System.out.println("tong 2 mang:");
    	 for(int i=0;i<n;i++)
    	 {
    		 System.out.print(a[i]+" ");
    	 }
     }
}
