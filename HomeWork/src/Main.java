public class Main {

    public static final int N = 10;

    public static void main(String[] args) {
        char[][] field = createField(N);
        printField(field);
    }

    public static char[][] createField(int size) {
        char[][] field = new char[size][size];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '-';
            }
        }

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

        return field;
    }

    public static void printField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
}