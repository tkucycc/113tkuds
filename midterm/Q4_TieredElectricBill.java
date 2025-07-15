import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] bills = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            bills[i] = calc(kWh);
            total += bills[i];
        }

        for (int bill : bills) {
            System.out.println("Bill: $" + bill);
        }

        System.out.println("Total: $" + total);
        System.out.println("Average: $" + Math.round((double) total / n));
        sc.close();
    }

    static int calc(int kWh) {
        double sum = 0;

        if (kWh > 1000) {
            sum += (kWh - 1000) * 8.46;
            kWh = 1000;
        }
        if (kWh > 700) {
            sum += (kWh - 700) * 6.24;
            kWh = 700;
        }
        if (kWh > 500) {
            sum += (kWh - 500) * 5.04;
            kWh = 500;
        }
        if (kWh > 330) {
            sum += (kWh - 330) * 3.70;
            kWh = 330;
        }
        if (kWh > 120) {
            sum += (kWh - 120) * 2.45;
            kWh = 120;
        }
        sum += kWh * 1.68;

        return (int) Math.round(sum);
    }
}
/*
 * Time Complexity: O(n)
 * 說明：每筆輸入僅需一次 calc 計算（最多 6 個條件段），總共 n 筆為線性處理。
 */