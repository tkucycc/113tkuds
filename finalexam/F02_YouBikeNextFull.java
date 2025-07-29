import java.util.*;

public class F02_YouBikeNextFull {
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static String minutesToTime(int mins) {
        return String.format("%02d:%02d", mins / 60, mins % 60);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = timeToMinutes(sc.nextLine());
        }
        int query = timeToMinutes(sc.nextLine());

        // Binary search for first time > query
        int left = 0, right = n - 1, ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (ans == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(minutesToTime(times[ans]));
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋於已排序的時間陣列中，尋找第一個大於查詢時間的時刻，因此時間複雜度為 O(log n)。
 */

