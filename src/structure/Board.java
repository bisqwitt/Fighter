package structure;

import beings.Enemy;
import beings.Player;
import perks.Item;

public class Board {

    private Player player;
    private Enemy enemy;

    private int money = 0;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        player = Player.defaultPlayer();
        enemy = Enemy.defaultEnemy();
    }

    public void openShop() {
        Item selection = Ui.showShop();
        if (selection != null) {
            if(selection.getCost() > money) {
                Ui.signalNotEnoughMoney(money, selection.getCost());
                Ui.showShop();
            } else {
                player.addItem(selection);
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
