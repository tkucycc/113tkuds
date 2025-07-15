import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];
        String[] rawTimes = new String[n];

        for (int i = 0; i < n; i++) {
            String time = sc.nextLine();
            rawTimes[i] = time;
            times[i] = toMinutes(time);
        }

        String query = sc.nextLine();
        int queryMin = toMinutes(query);

        int idx = binarySearch(times, queryMin);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(rawTimes[idx]);
        }
        sc.close();
    }

    // 將 "HH:mm" 字串轉換成當天總分鐘數
    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 找第一個比 queryMin 大的時間的索引
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // 若 left == arr.length，代表 No train
    }
    
}
/*
 * Time Complexity: O(log n)
 * 說明：使用 binary search 找出下一班車時間，陣列長度最多 80，查詢時間為 log n。
 */