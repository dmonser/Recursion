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
        int x = x0;
        int y = y0;
        char yes = '$';
        path[x][y] = 'H';
        printField(path);

        while (x != 0 || y != 0) {
            char direction = where_from(field, x, y);
            if (direction == 'N') {
                System.out.println("Нет такого пути :-(");
                break;
            } else if (direction == 'U') {
                path[x][y] = yes;
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = yes;
                x -= 1;
            }
            System.out.println();
            printField(path);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0 && i == 0){
                    System.out.print("P ");
                } else if (j == x0 && i == y0) {
                    System.out.print("H ");
                } else if (path[j][i] == yes) {
                    System.out.print("Х ");
                } else {
                    System.out.print(path[j][i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static char where_from(char[][] field, int x, int y) {
//        Random rd = new Random();
        char U = 'U';
        char L = 'L';
        char N = 'N';
        char[] arr = new char[]{U, L};

        if (x < 0 || y < 0) {
            System.exit(404);
        }

        if (x == 0) {
            if (field[x][y - 1] == '-') {
                return 'U';
            } else {
                return 'N';
            }
        }

        if (y == 0) {
            if (field[x - 1][y] == '-') {
                return 'L';
            } else {
                return 'N';
            }
        }

        if (field[x - 1][y] == '*' && field[x][y - 1] == '*') {
            return N;
        }

        if (field[x][y - 1] == '-' && field[x - 1][y] == '-') {
//            int index = rd.nextInt(0, 2);
//            return arr[index];
            return L;
        }

        if (field[x][y - 1] == '-' && field[x - 1][y] == '*') {
            return U;
        }

        if (field[x][y - 1] == '*' && field[x - 1][y] == '-') {
            return L;
        }

        return '!';
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