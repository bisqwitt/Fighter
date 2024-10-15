package perks;

import beings.Being;

public class StrengthPotion extends Item {

    public StrengthPotion() {
        super("Strength Potion", "sp", "Deal 10 more damage", 20, 10);
    }

    @Override
    public void use(Being target) {
        target.setAttackDmg(target.getAttackDmg() + amount);
    }
}
