import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("What's your name?");
    String name=sc.nextLine();
    System.out.println("How old r u?");
    int age=sc.nextInt();
    System.out.println("How tall r u(m)?");
    double tall=sc.nextDouble();
    System.out.println("Mrs/Ms."+name+" , "+age+" year old."+"Your height is "+ tall+"m.");
    System.exit(0);
	}
}