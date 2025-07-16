import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static final char EMPTY = '.';
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initBoard();

        char currentPlayer = 'X';
        boolean gameEnded = false;

        printBoard();

        while (!gameEnded) {
            System.out.print("請玩家 " + currentPlayer + " 輸入位置 (row col)：");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // 輸入合法性檢查
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("⚠️ 超出邊界，請重新輸入！");
                continue;
            }

            if (board[row][col] != EMPTY) {
                System.out.println("⚠️ 該位置已被佔用，請重新輸入！");
                continue;
            }

            // 放置棋子
            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();

            // 勝負檢查
            if (checkWin(row, col, currentPlayer)) {
                System.out.println("🎉 玩家 " + currentPlayer + " 獲勝！");
                gameEnded = true;
            } else if (isBoardFull()) {
                System.out.println("🤝 平手！");
                gameEnded = true;
            } else {
                // 換人
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = EMPTY;
    }

    static void printBoard() {
        System.out.println("\n=== 5×5 井字遊戲 ===");
        System.out.print("  ");
        for (int col = 0; col < SIZE; col++) System.out.print(col + " ");
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean checkWin(int row, int col, char player) {
        return checkLine(row, 0, 0, 1, player) || // 該行
               checkLine(0, col, 1, 0, player) || // 該列
               checkLine(0, 0, 1, 1, player) ||   // 主對角線
               checkLine(0, SIZE - 1, 1, -1, player); // 副對角線
    }

    static boolean checkLine(int startRow, int startCol, int dRow, int dCol, char player) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            int r = startRow + i * dRow;
            int c = startCol + i * dCol;
            if (r >= 0 && r < SIZE && c >= 0 && c < SIZE && board[r][c] == player) {
                count++;
            } else {
                break;
            }
        }
        return count == SIZE;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == EMPTY)
                    return false;
        return true;
    }
}
