package structure;
import perks.Item;

public enum ItemCollector {

    HealPotion(perks.HealPotion.class),
    StrengthPotion(perks.StrengthPotion.class),
    MaxHpPotion(perks.MaxHpPotion.class);

    public final Class<? extends Item> item;

    ItemCollector(Class<? extends Item> item) {
        this.item = item;
    }

    public Item getItemInstance() {
        try {
            return item.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
