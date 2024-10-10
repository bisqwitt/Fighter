package perks;

import beings.Being;

public abstract class Item {

    protected String name;
    protected int cost;
    protected int amount;

    public Item(String name, int cost, int amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    protected abstract void use(Being target);

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }
}
