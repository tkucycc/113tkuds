public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1, 5, 6, 8, 4, 10};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("陣列元素的總和為：" + sum);
    }
}
