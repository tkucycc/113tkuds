class Loopc {
    public static void main(String[] args) {
        int x = 0;
        int i = 1;
        int count = 0;

        while (++i <= 101) { // ++i 會先變成 2，再檢查是否小於等於 101
            x = x + 1;
            count++;
        }

        System.out.println(count); // 輸出結果？
    }
}
