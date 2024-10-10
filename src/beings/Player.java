package beings;

import structure.Board;
import structure.TurnAction;
import structure.Ui;

public class Player extends Being {

    public Player(long maxHp, long attackDmg) {
        super("Player", maxHp, attackDmg);
    }

    public static Player defaultPlayer() {
        return new Player(100, 50);
    }

    public void useAbility() {

    }

    public void useItem() {

    }

    @Override
    public void turn(Board board) {
        TurnAction decision = Ui.getTurnDecision();
        switch (decision) {
            case TurnAction.Attack -> board.getPlayer().attack(board.getEnemy());
            case TurnAction.Ability -> board.getPlayer().useAbility();
            case TurnAction.Item -> board.getPlayer().useItem();
        }
    }
}
