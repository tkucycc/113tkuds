import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            items[i] = new Item(parts[0], Integer.parseInt(parts[1]));
        }

        // 插入排序（由大到小）
        for (int i = 1; i < n; i++) {
            Item key = items[i];
            int j = i - 1;
            while (j >= 0 && items[j].qty < key.qty) {
                items[j + 1] = items[j];
                j--;
            }
            items[j + 1] = key;
        }

        // 輸出前 10 筆
        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(items[i].name + " " + items[i].qty);
        }
        sc.close();
    }
}
/*
 * Time Complexity: O(n^2)
 * 說明：使用插入排序對 n 筆資料排序，最壞情況每一項都需比較與移動前面所有元素，故時間複雜度為 O(n^2)。
 */
