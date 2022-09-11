import java.util.Random;

public class Main {

    public static final int N = 10;

    public static void main(String[] args) {
        char[][] field = createField(N, true);
        printField(field);
        System.out.println();
        findPath(field, 8, 3);
    }

    public static void findPath(char[][] field, int x0, int y0) {
        char[][] path = createField(N, true);

        where_from(field, x0, y0, path);
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0 && i == 0){
                    System.out.print("P ");
                } else if (j == x0 && i == y0) {
                    System.out.print("H ");
                } else if (path[j][i] == 'L' || path[j][i] == 'U') {
                    System.out.print("Х ");
                } else {
                    System.out.print(path[j][i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static char where_from(char[][] field, int x, int y, char[][] memory) {
        if (memory[x][y] != '-' && memory[x][y] != '*') {
            return memory[x][y];
        }

        if (x > 0) {
            int left_x = x - 1;
            int left_y = y;
            if (left_x == 0 && left_y == 0){
                memory[x][y] = 'L';
                return 'L';
            }
            if (field[left_x][left_y] != '*'){
                if (where_from(field, left_x, left_y, memory) != 'N') {
                    memory[x][y] = 'L';
                    return 'L';
                }
            }
        }
        if (y > 0){
            int up_x = x;
            int up_y = y - 1;
            if (up_x == 0 && up_y == 0){
                memory[x][y] = 'U';
                return 'U';
            }
            if (field[up_x][up_y] != '*') {
                if (where_from(field, up_x, up_y, memory) != 'N'){
                    memory[x][y] = 'U';
                    return 'U';
                }
            }
        }
        memory[x][y] = 'N';
        return 'N';
    }

    public static char[][] createField(int size, boolean withCacti) {
        char[][] field = new char[size][size];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '-';
            }
        }

        if (withCacti) {
            field[3][0] = '*';
            field[4][0] = '*';
            field[4][1] = '*';
            field[6][1] = '*';
            field[7][1] = '*';
            field[3][2] = '*';
            field[5][2] = '*';
            field[9][2] = '*';
            field[1][3] = '*';
            field[6][4] = '*';
            field[2][5] = '*';
            field[5][5] = '*';
            field[3][6] = '*';
            field[6][6] = '*';
            field[7][6] = '*';
            field[8][6] = '*';
            field[7][7] = '*';
            field[7][8] = '*';
            field[5][9] = '*';
            field[6][9] = '*';
        }

        return field;
    }

    public static void printField(char[][] field) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(field[j][i] + " ");
            }
            System.out.println();
        }
    }
}