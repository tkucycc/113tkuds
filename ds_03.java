import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = scanner.nextLine();

        System.out.print("請輸入年齡：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 吸收換行符號

        System.out.print("請輸入城市：");
        String city = scanner.nextLine();

        System.out.println("\n--- 個人資訊 ---");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);

        scanner.close();
    }
}
