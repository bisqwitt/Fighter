package beings;

import structure.Board;
import structure.TurnAction;
import structure.Ui;

public abstract class Being {

    protected String name;

    protected long maxHp;
    protected long currentHp;

    protected long attackDmg;

    public Being(String name, long maxHp, long attackDmg) {
        this.name = name;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attackDmg = attackDmg;
    }

    abstract public void turn(Board board);

    public void attack(Being target) {
        target.takeDamage(attackDmg);
        Ui.signalMove(this, target, TurnAction.Attack);
        if(!target.isAlive()) {
            Ui.signalDeath(target);
        }
    }

    public void takeDamage(long attackDmg) {
        currentHp = currentHp - attackDmg;
    }

    public boolean isAlive() {
        return currentHp > 0;
    }

    public String getName() {
        return name;
    }

    public long getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(long currentHp) {
        this.currentHp = currentHp;
        if(this.currentHp > maxHp) {
            this.currentHp = maxHp;
        }
    }

    public long getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(long maxHp) {
        this.maxHp = maxHp;
    }

    public long getAttackDmg() {
        return attackDmg;
    }

    public void setAttackDmg(long attackDmg) {
        this.attackDmg = attackDmg;
    }
}
