package perks;

import beings.Being;

public class StrengthPotion extends Item {

    public StrengthPotion() {
        super("Strength Potion", 20, 10);
    }

    @Override
    protected void use(Being target) {
        target.setAttackDmg(target.getAttackDmg() + amount);
    }
}
