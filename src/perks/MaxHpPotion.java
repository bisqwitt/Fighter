package perks;

import beings.Being;

public class MaxHpPotion extends Item {

    public MaxHpPotion() {
        super("Max Hp Potion", 20, 10);
    }

    @Override
    protected void use(Being target) {
        target.setMaxHp(target.getMaxHp() + amount);
    }
}
