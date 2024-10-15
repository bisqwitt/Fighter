package perks;

import beings.Being;

public class MaxHpPotion extends Item {

    public MaxHpPotion() {
        super("Max Hp Potion","mhp", "Gain 10 max hp", 20, 10);
    }

    @Override
    public void use(Being target) {
        target.setMaxHp(target.getMaxHp() + amount);
    }
}
