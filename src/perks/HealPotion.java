package perks;

import beings.Being;

public class HealPotion extends Item {

    public HealPotion() {
        super("Heal Potion", "hp", "Heal for 10hp", 5, 10);
    }

    @Override
    public void use(Being target) {
        target.setCurrentHp(target.getCurrentHp() + amount);
    }
}
