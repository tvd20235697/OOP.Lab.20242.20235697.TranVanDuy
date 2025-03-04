import javax.swing.JOptionPane;
import java.util.Scanner;
public class Pt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="1.Phuong tinh bac 1 mot bien\n2.He phuong trinhb 2 bien\n3.Phuong trinh bac 2 mot bien";
        String strnum3;
        strnum3=JOptionPane.showInputDialog(null,s,"Option",JOptionPane.INFORMATION_MESSAGE);
        double p=Double.parseDouble(strnum3);
        if(p==1)
        {
            String s1;
            s1=JOptionPane.showInputDialog(null,"Nhap a:","Nhap he so cua phuong trinh ax+b=0",JOptionPane.INFORMATION_MESSAGE);
            Double a=Double.parseDouble(s1);
            String s2;
            s2=JOptionPane.showInputDialog(null,"nhap b:","Nhap he so cua phuong trinh ax+b=0",JOptionPane.INFORMATION_MESSAGE);
            Double b=Double.parseDouble(s2);
            if(a==0)
            {
                if(b!=0) JOptionPane.showMessageDialog(null,"Vo nghiem","Result",JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null,"Vo so nghiem","Result",JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null,"x=-b/a="+(-b/a),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        if(p==2)
        {
            String s1="Nhap he so cua he phuong trinh:\nax+by=c\nmx+ny=d\nNhap:";
            String s2;
            s2=JOptionPane.showInputDialog(null,s1,"Nhap a",JOptionPane.INFORMATION_MESSAGE);
            Double a=Double.parseDouble(s2);
            String s3;
            s3=JOptionPane.showInputDialog(null,s1,"Nhap b",JOptionPane.INFORMATION_MESSAGE);
            Double b=Double.parseDouble(s3);
            String s4;
            s4=JOptionPane.showInputDialog(null,s1,"Nhap c",JOptionPane.INFORMATION_MESSAGE);
            Double c=Double.parseDouble(s4);
            String s5;
            s5=JOptionPane.showInputDialog(null,s1,"Nhap m",JOptionPane.INFORMATION_MESSAGE);
            Double m=Double.parseDouble(s5);
            String s6;
            s6=JOptionPane.showInputDialog(null,s1,"Nhap n",JOptionPane.INFORMATION_MESSAGE);
            Double n=Double.parseDouble(s6);
            String s7;
            s7=JOptionPane.showInputDialog(null,s1,"Nhap d",JOptionPane.INFORMATION_MESSAGE);
            Double d=Double.parseDouble(s7);
            Double D=a*n-b*m;
            Double D1=a*d-m*c;
            Double D2=b*d-n*c;
            if(D==0)
            {
                if(D1==0&&D2==0) JOptionPane.showMessageDialog(null,"Vo so nghiem","Result",JOptionPane.INFORMATION_MESSAGE);
                else JOptionPane.showMessageDialog(null,"Vo nghiem","Result",JOptionPane.INFORMATION_MESSAGE);
            }
            else JOptionPane.showMessageDialog(null,"x="+(D/D1)+"\ny="+(D/D2),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        if(p==3)
        {
            String s1="Nhap he so cua he phuong trinh:a*x^2+b*x+c=0\nNhap:";
            String s2;
            s2=JOptionPane.showInputDialog(null,s1,"Nhap a",JOptionPane.INFORMATION_MESSAGE);
            Double a=Double.parseDouble(s2);
            String s3;
            s3=JOptionPane.showInputDialog(null,s1,"Nhap b",JOptionPane.INFORMATION_MESSAGE);
            Double b=Double.parseDouble(s3);
            String s4;
            s4=JOptionPane.showInputDialog(null,s1,"Nhap c",JOptionPane.INFORMATION_MESSAGE);
            Double c=Double.parseDouble(s4);
            Double delt=b*b-4*a*c;
            if(delt<0) JOptionPane.showMessageDialog(null,"Vo nghiem","Result",JOptionPane.INFORMATION_MESSAGE);
            if(delt==0) JOptionPane.showMessageDialog(null,"x1=x2="+(-b/(2*a)),"Result",JOptionPane.INFORMATION_MESSAGE);
            if(delt>0) 
            {
                Double x1=(-b+Math.sqrt(delt))/(2*a);
                Double x2=(-b-Math.sqrt(delt))/(2*a);
                JOptionPane.showMessageDialog(null,"x1="+x1+"\nx1="+x2,"Result",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        System.exit(0);
    }
}
