import java.util.*;

public class F05_LCMRecursive {
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcdVal = gcd(a, b);
        int lcm = a * b / gcdVal;

        System.out.println("LCM: " + lcm);
        sc.close();
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：輾轉相減法最差情況下，每次只減 1，最多需遞迴 max(a, b) 次，因此時間複雜度為 O(max(a, b))。
 */

