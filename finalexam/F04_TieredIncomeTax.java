import java.util.*;

public class F04_TieredIncomeTax {
    public static int calculateTax(int income) {
        int[] brackets = {540000, 1210000, 2420000, 4530000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

        int tax = 0;
        int last = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income > brackets[i]) {
                tax += (brackets[i] - last) * rates[i];
                last = brackets[i];
            } else {
                tax += (income - last) * rates[i];
                return tax;
            }
        }
        // income > 4530000
        tax += (income - last) * rates[4];
        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            int tax = calculateTax(income);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        double average = (double) totalTax / n;
        System.out.printf("Average: $%.0f\n", average);
        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入計算稅額為固定 5 段級距判斷，視為 O(1)，總共處理 n 筆資料，因此總體時間複雜度為 O(n)。
 */

