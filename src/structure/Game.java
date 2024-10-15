package structure;

import beings.Being;
import beings.Enemy;

import java.util.Random;

public class Game {

    Random random = new Random();

    private final Board board;

    public Game() {
        board = new Board();
    }

    public void play() {
        while(playRound()) {
            int goldGained = random.nextInt(6) + 5;
            board.setMoney(board.getMoney() + goldGained);
            Ui.signalNewBalance(board.getMoney(), goldGained);

            if(Ui.askOpenShop()) {
                board.openShop();
            }
            board.setEnemy(Enemy.defaultEnemy());
        };
    }

    private boolean playRound() {
        do {
            turn(board.getPlayer());
            if(board.getEnemy().isAlive()) {
                turn(board.getEnemy());
            }
        } while(board.getPlayer().isAlive() && board.getEnemy().isAlive());
        return board.getPlayer().isAlive();
    }

    private void turn(Being b) {
        Ui.signalTurnOf(b);
        b.turn(board);
    }

}
