public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("=== 基本氣泡排序 ===");
        System.out.println("氣泡排序過程：\n");

        int n = array.length;
        int totalComparisons = 0;
        int totalSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int roundComparisons = 0;
            int roundSwaps = 0;

            System.out.printf("第 %d 輪排序：\n", i + 1);

            for (int j = 0; j < n - i - 1; j++) {
                System.out.printf("比較 array[%d]=%d 與 array[%d]=%d → ",
                        j, array[j], j + 1, array[j + 1]);
                roundComparisons++;
                totalComparisons++;

                if (array[j] > array[j + 1]) {
                    // 交換
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    System.out.println("交換");
                    swapped = true;
                    roundSwaps++;
                    totalSwaps++;
                } else {
                    System.out.println("不交換");
                }
            }

            System.out.printf("第 %d 輪結束：比較 %d 次，交換 %d 次\n", i + 1, roundComparisons, roundSwaps);
            printArray(array);

            if (!swapped) {
                System.out.println("提早結束：陣列已經排序完成\n");
                break;
            }
        }

        System.out.printf("排序完成！總比較次數：%d，總交換次數：%d\n", totalComparisons, totalSwaps);
        System.out.print("最終結果：");
        printArray(array);
    }

    static void printArray(int[] array) {
        System.out.print("目前陣列：[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]\n");
    }
}
