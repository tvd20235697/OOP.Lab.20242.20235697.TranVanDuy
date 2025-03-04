import java.util.Scanner;

public class DayMonthYear {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thang:");
        int month = sc.nextInt();
        System.out.println("Nhap nam:");
        int year = sc.nextInt();
        
        if (Month(month) && Year(year)) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    System.out.println("31");
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    System.out.println("30");
                    break;
                case 2:
                    if (namnhuan(year)) {
                        System.out.println("29");
                    } else {
                        System.out.println("28");
                    }
                    break;
                default:
                    System.out.println("Nhap lai:))");
            }
        } else {
            System.out.println("Nhap lai:))");
        }
    }

    public static boolean Month(int a) {
        return (a >= 1) && (a <= 12);
    }

    public static boolean Year(int a) {
        return a >= 1;
    }

    public static boolean namnhuan(int a) {
        if (a % 4 == 0) {
            if (a % 100 == 0 && a % 400 != 0) return false;
            if (a % 400 == 0) return true;
            return true;
        }
        return false;
    }
}
