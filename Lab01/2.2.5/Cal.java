import javax.swing.JOptionPane;
import java.util.Scanner;
public class Cal {
    public static void main(String[] args) {
        String strnum1;
        String strnum2;
        String strnotification = "Bạn vừa nhập: ";
        strnum1 = JOptionPane.showInputDialog(null, "Vui lòng nhập số thứ nhất: ", "Nhập số thứ nhất", JOptionPane.INFORMATION_MESSAGE);
        strnum2 = JOptionPane.showInputDialog(null, "Vui lòng nhập số thứ hai: ", "Nhập số thứ hai", JOptionPane.INFORMATION_MESSAGE);
        strnotification += strnum1 + " và " + strnum2;
        JOptionPane.showMessageDialog(null, strnotification, "Hiển thị hai số", JOptionPane.INFORMATION_MESSAGE);
        double a=Double.parseDouble(strnum1);
        double b=Double.parseDouble(strnum2);
        System.out.println("a+b="+(a+b));
        System.out.println("a-b="+(a-b));
        System.out.println("a*b="+(a*b));
        System.out.println("a/b="+(a/b));
        System.exit(0);
    }
}
