import java.util.Scanner;

public class Vending_Machine {
    int no_of_states = 3;
    String[] Items = { "Prince", "Juice" };
    int[] inputs = { 10, 20 };
    int Cash;
    int[] final_state = { 1, 2 };
    int initial_state = 0;
    int cash_return;
    int[][] TT = { { 1, 2 } };

    Vending_Machine(int cash) {
        this.Cash = cash;
    }

    public void select_items() {
        Scanner S = new Scanner(System.in);
        int i = 0;
        int choose;
        do {
            for (; i < inputs.length; i++) {
                System.out.println("select " + i + " for " + Items[i] + " for Rupees " + inputs[i]);
            }
            System.out.println("select 9 for exit: ");
            choose = S.nextInt();
            if (choose == 0) {
                int rv = cash_return(this.Cash, inputs[choose]);
                System.out.println("Your returned amount: " + rv);
                if (rv > 0) {
                    this.Cash = inputs[choose];
                    System.out.println(return_item());
                    break;
                } else {
                    System.out.println("You entered insufficient amount");
                    System.out.println("Your returned amount: " + this.Cash);
                    break;
                }
            }
            if (choose == 1) {
                int rv = cash_return(this.Cash, inputs[choose]);
                System.out.println("Your returned amount: " + rv);
                if (rv > 0) {
                    this.Cash = inputs[choose];
                    System.out.println(return_item());
                    break;
                } else {
                    System.out.println("You entered insufficient amount");
                    System.out.println("Your returned amount: " + this.Cash);
                    break;
                }
            }
            if (choose == 9) {
                System.out.println("Your returned amount: " + this.Cash);
                break;
            }
        } while (true);
        S.close();
    }

    private int cash_return(int cash, int cost) {
        this.cash_return = cash - cost;
        return this.cash_return;
    }

    private String return_item() {
        int cs = this.initial_state;
        int i = 0;
        int len = final_state.length;
        while (i < 1) {
            cs = transition(cs, Cash);
            i++;
        }
        for (int j = 0; j < len; j++) {
            if (cs == this.final_state[j]) {
                return "Please collect your: " + Items[j];
            }
        }
        return "Item is not in the vending machine";
    }

    private int transition(int initial_state, int cash) {
        int len = inputs.length;
        int i = 0;
        for (; i < len; i++) {
            if (cash == inputs[i]) {
                break;
            }
        }
        return TT[initial_state][i];
    }
}
