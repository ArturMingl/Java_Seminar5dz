/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
И вывести Доску.*/
public class task3 {
    public static void main(String[] args) {

        int[] queens = new int[8];
        findPosition(0, queens);

        // Вывод доски в консоль
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (queens[row] == col) {
                    System.out.print("▣ ");
                } else {
                    System.out.print("▢ ");
                }
            }
            System.out.println();
        }
    }

    // Функция для поиска позиций ферзей
    private static boolean findPosition(int row, int[] queens) {
        if (row == 8) {
            return true;// Если удалось расставить всех ферзей -> true
        }
        for (int col = 0; col < 8; col++) {
            boolean isSafe = true;
            for (int i = 0; i < row; i++) {
                // Проверка на наличие конфликтов
                if (queens[i] == col || queens[i] == col - row + i || queens[i] == col + row - i) {
                    isSafe = false;
                    break;
                }
            }
            if (isSafe) {
                queens[row] = col; // Внесение позиции ферзя в массив
                if (findPosition(row + 1, queens)) {
                    return true;
                }
            }
        }
        return false;
    }
}