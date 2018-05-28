public class Application {

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.initializeBoard();
        game.printBoard();
        game.fillNumbers();
        game.printBoard();
    }
}
