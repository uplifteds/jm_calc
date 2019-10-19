import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean ISMULT = false;
        boolean ISSUM = false;
        boolean ISDEDUCE = false;
        boolean ISDIV = false;
        System.out.print("Type math expression (using Arabic or Roman numbers): ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        List<String> list = null;
        if (input.contains("*")){
            ISMULT = true;
            list = new ArrayList<String>(Arrays.asList(input.split(" [*] ")));
        } else if (input.contains("+")){
            ISSUM = true;
            list = new ArrayList<String>(Arrays.asList(input.split(" [+] ")));
        } else if (input.contains("-")){
            ISDEDUCE = true;
           list = new ArrayList<String>(Arrays.asList(input.split(" - ")));
        } else if (input.contains("/")){
            ISDIV = true;
            list = new ArrayList<String>(Arrays.asList(input.split(" / ")));
        }

        String rarg0 = list.get(0);
        String rarg2 = list.get(1);

        int a = 0;
        int b = 0;
        try {
            a = Integer.parseInt(rarg0);
            b = Integer.parseInt(rarg2);
        } catch (NumberFormatException e) {}

        IAriphmetics iAriphmetics = null;
        boolean brk = false;
        if (a>0 && b>0) {
            iAriphmetics = new ArabicExpression(rarg0, rarg2);
            brk = false;
        } else if (a==0 && b==0){
            iAriphmetics = new RomanExpression(rarg0, rarg2);
            brk = false;
        } else if (a==0 && b>0){
            iAriphmetics = null;
            brk = true;
            System.out.println("Wrong input");
        } else if (b==0 || a==0){
            iAriphmetics = null;
            brk = true;
            System.out.println("Wrong input");
        }

        if (brk == false) {
            if (ISMULT) {
                System.out.println("Result: " + iAriphmetics.multiply());
            } else if (ISSUM) {
                System.out.println("Result: " + iAriphmetics.sum());
            } else if (ISDEDUCE) {
                System.out.println("Result: " + iAriphmetics.deduce());
            } else if (ISDIV) {
                System.out.println("Result: " + iAriphmetics.divide());
            }
        } else {
            System.out.println("Wrong input");
        }
    }
}