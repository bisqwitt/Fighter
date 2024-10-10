package structure;

import beings.Enemy;
import beings.Player;

public class Board {

    private Player player;
    private Enemy enemy;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        player = Player.defaultPlayer();
        enemy = Enemy.defaultEnemy();
    }

    public void openShop() {
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
}
