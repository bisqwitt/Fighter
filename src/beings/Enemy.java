package beings;
import structure.Board;

public class Enemy extends Being {

    public static Enemy defaultEnemy() {
        return new Enemy(75, 10);
    }

    public Enemy(long maxHp, long attackDmg) {
        super("Beings.Enemy", maxHp, attackDmg);
    }

    @Override
    public void turn(Board board) {
        attack(board.getPlayer());
    }
}
