import java.util.Scanner;

public class Calculator
{
    static int add(final int x, final int y) {
        return x + y;
    }
    
    static double mul(final double x, final double y) {
        return x * y;
    }
    
    static int mul(final int x, final int y) {
        return x * y;
    }
    
    static double div(final double x, final double y) {
        if (y != 0.0) {
            return x / y;
        }
        System.out.println("Division error, second number cannot be 0!!! :/");
        return 0.0;
    }
    
    static int sub(final int x, final int y) {
        return x - y;
    }
    
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("1. int add");
        System.out.println("2. int sub");
        System.out.println("3. int mul");
        System.out.println("4. double mul");
        System.out.println("5. double div");
        System.out.println("Enter choice:");
        final int option = sc.nextInt();
        System.out.println("Enter the numbers:");
        switch (option) {
            case 1: {
                final int a = sc.nextInt();
                final int b = sc.nextInt();
                System.out.println(String.valueOf(a) + "+" + b + "=" + add(a, b));
            }
            case 2: {
                final int a = sc.nextInt();
                final int b = sc.nextInt();
                System.out.println(String.valueOf(a) + "-" + b + "=" + sub(a, b));
            }
            case 3: {
                final int a = sc.nextInt();
                final int b = sc.nextInt();
                System.out.println(String.valueOf(a) + "*" + b + "=" + mul(a, b));
            }
            case 4: {
                final double e = sc.nextDouble();
                final double f = sc.nextDouble();
                System.out.println(String.valueOf(e) + "*" + f + "=" + mul(e, f));
                break;
            }
        }
    }
}
