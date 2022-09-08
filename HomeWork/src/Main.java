import java.util.Random;

public class Main {

    public static final int N = 10;

    public static void main(String[] args) {
        char[][] field = createField(N, true);
//        printField(field);
        System.out.println();
        findPath(field, 3, 8);
    }

    public static void findPath(char[][] field, int x0, int y0) { // TODO: 08.09.2022 Not working!!!
        char[][] path = createField(N, true);
        int x = x0;
        int y = y0;
        char yes = '$';

        while (x != 0 || y != 0) {
            char direction = where_from(path, x, y);
            if (direction == 'N'){
                System.out.println("Нет такого пути :-(");;
            } else if (direction == 'U') {
                path[x][y] = yes;
                y -= 1;
            } else if (direction == 'L') {
                path[x][y] = yes;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == x0 && j == y0){
                    System.out.print("Ч ");
                } else if (path[i][j] == yes){
                    System.out.print("Х ");
                } else {
                    System.out.print(path[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static char where_from(char[][] field, int x, int y) { // ################# Is a working?
        Random rd = new Random();
        char U = 'U';
        char L = 'L';
        char N = 'N';
        char[] arr = new char[]{U, L};

        if (x == 0 && y == 0) {
            return N;
        }

        if (field[x - 1][y] == '*' && field[x][y - 1] == '*') {
            return N;
        }

        if (field[x - 1][y] == '-' && field[x][y - 1] == '-') {
            int index = rd.nextInt(0, 2);
            return arr[index];
        }

        if (field[x - 1][y] == '*' && field[x][y - 1] == '-') {
            return U;
        }

        if (field[x - 1][y] == '-' && field[x][y - 1] == '*') {
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
            field[0][0] = 'Щ';
            field[0][3] = '*';
            field[0][4] = '*';
            field[1][4] = '*';
            field[1][6] = '*';
            field[1][7] = '*';
            field[2][3] = '*';
            field[2][5] = '*';
            field[2][9] = '*';
            field[3][1] = '*';
            field[4][6] = '*';
            field[5][2] = '*';
            field[5][5] = '*';
            field[6][3] = '*';
            field[6][6] = '*';
            field[6][7] = '*';
            field[6][8] = '*';
            field[7][7] = '*';
            field[8][7] = '*';
            field[9][5] = '*';
            field[9][6] = '*';
        }

        return field;
    }

    public static void printField(char[][] field) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}