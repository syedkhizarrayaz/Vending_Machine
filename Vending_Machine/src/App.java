import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Welcome to the Vending Machine!");
        Scanner S = new Scanner(System.in);
        System.out.println("Enter your cash(must be more than 10 Rupees): ");
        int cash = S.nextInt();
        if (cash >= 10) {
            Vending_Machine vm = new Vending_Machine(cash);
            vm.select_items();
        } else {
            System.out.println("cash must be more than 10 Rupees");
        }
        S.close();
    }
}
