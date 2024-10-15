package perks;

import beings.Being;

public abstract class Item {

    protected final String name;
    protected final String abbreviation;
    protected final String description;
    protected int cost;
    protected int amount;

    public Item(String name, String abbreviation, String description, int cost, int amount) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
        this.cost = cost;
        this.amount = amount;
    }

    public abstract void use(Being target);

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
