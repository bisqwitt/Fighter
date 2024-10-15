package beings;

import perks.Item;
import structure.Board;
import structure.TurnAction;
import structure.Ui;

import java.util.ArrayList;
import java.util.List;

public class Player extends Being {

    private final List<Item> inventory = new ArrayList<>();

    public Player(long maxHp, long attackDmg) {
        super("Player", maxHp, attackDmg);
    }

    public static Player defaultPlayer() {
        return new Player(100, 50);
    }

    public void useAbility() {

    }

    public void useItem() {
        Item item = Ui.openInventoryAndSelectItem(inventory);
        if(item != null) {
            item.use(this);
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
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
