package perks;

import beings.Being;

public class HealPotion extends Item {

    public HealPotion() {
        super("Heal Potion", 5, 10);
    }

    @Override
    protected void use(Being target) {
        target.setCurrentHp(target.getCurrentHp() + amount);
    }
}
