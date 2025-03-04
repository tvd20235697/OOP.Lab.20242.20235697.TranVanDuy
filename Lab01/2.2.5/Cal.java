import javax.swing.JOptionPane;
import java.util.Scanner;
public class Cal {
    public static void main(String[] args) {
        String strnum1;
        String strnum2;
        strnum1 = JOptionPane.showInputDialog(null, "Vui lòng nhập số thứ nhất: ", "Nhập số thứ nhất", JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "Vui lòng nhập số thứ hai: ", "Nhập số thứ hai", JOptionPane.INFORMATION_MESSAGE);
        double a=Double.parseDouble(strnum1);
        double b=Double.parseDouble(strnum2);
        String s="1.Tinh tong\n2.Tinh hieu\n3.Tinh tich\n4.Tinh thuong";
        String strnum3;
        strnum3=JOptionPane.showInputDialog(null,s,"Option",JOptionPane.INFORMATION_MESSAGE);
        double c=Double.parseDouble(strnum3);
        if(c==1)
        {
            JOptionPane.showMessageDialog(null,"a+b="+(a+b),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        if(c==2)
        {
            JOptionPane.showMessageDialog(null,"a+b="+(a+b),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        if(c==3)
        {
            JOptionPane.showMessageDialog(null,"a+b="+(a+b),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        if(c==4)
        {
            JOptionPane.showMessageDialog(null,"a+b="+(a+b),"Result",JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}
