import java.util.Random;

public class Minesweeper {

    private char[][] table;
    private int defaultTableSize = 10;
    private int defaultMineDensity = 7;

    public Minesweeper() {
        table = new char[defaultTableSize][defaultTableSize];
    }

    public Minesweeper(int tableSize) {
        table = new char[tableSize][tableSize];
    }

    public void initializeBoard() {

        for (int i = 0; i < table.length; i++)
            for (int j = 0; j < table.length; j++) {
                table[i][j] = fillMine(defaultMineDensity);
            }

    }

    private char fillMine(int mineDensity) {
        Random rand = new Random();

        int randValue = rand.nextInt(mineDensity) + 1;
        if (randValue == 1)
            return '*';
        else
            return '.';
    }

    public void printBoard() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void fillNumbers() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (table[i][j] != '*')
                    table[i][j] = countNumberOfMines(i, j);
            }
        }
    }

    private char countNumberOfMines(int x, int y) {

        int numberOfMines = 0;
        int REDIX=10;//redix 10 is for decimal number, for hexa use redix 16

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((x + i > -1) && (x + i < table.length) && (y + j > -1) && (y + j < table.length) && (table[x + i][y + j] == '*')) {
                    numberOfMines++;
                }
            }
        }
        if (numberOfMines != 0)
            return Character.forDigit(numberOfMines,REDIX);
        else
            return '.';
    }
}
