import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> stationIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String code = sc.next();
            stationIndex.put(code, i);
        }
        String start = sc.next();
        String end = sc.next();

        if (!stationIndex.containsKey(start) || !stationIndex.containsKey(end)) {
            System.out.println("Invalid");
        } else {
            int idx1 = stationIndex.get(start);
            int idx2 = stationIndex.get(end);
            System.out.println(Math.abs(idx1 - idx2) + 1);
            sc.close();
        }
    }
}
/*
 * Time Complexity: O(n)
 * 說明：讀取 n 個站名並建立索引表需 O(n) 時間；查詢兩站位置並計算間距為 O(1)。
 */
