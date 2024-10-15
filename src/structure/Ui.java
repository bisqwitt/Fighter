package structure;

import beings.Being;
import perks.Item;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Ui {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static TurnAction getTurnDecision() {
        write("What will you do? (Attack - at, Ability - ab, Item - i)");
        String answer = read();
        TurnAction decision = TurnAction.stringMap(answer);
        if(decision == null) {
            write("invalid answer");
            return getTurnDecision();
        }
        return decision;
    }

    public static boolean askOpenShop() {
        write("Open shop? (y/n)");
        String answer = read();
        return switch (answer) {
            case "y" -> true;
            case "n" -> false;
            default -> askOpenShop();
        };
    }

    public static Item openInventoryAndSelectItem(List<Item> inventory) {
        write("Inventory: ");
        if(inventory.isEmpty()) {
            write("empty");
        } else {
            inventory.forEach(item -> write(item.getName() + " (" + item.getAbbreviation() + ")"));
        }
        Item item = readItemSelection();

        if(item != null && inventory.stream().map(Item::getName).noneMatch(name -> name.equals(item.getName()))) {
            write("You don't have this item you goof");
            return openInventoryAndSelectItem(inventory);
        }
        write("Player used item: " + item.getName());
        return item;
    }

    public static Item showShop() {
        write("Welcome to the shop my Friend. What do you need?");
        Arrays.stream(ItemCollector.values()).map(ItemCollector::getItemInstance).forEach(item ->
                write(item.getName() + ": " + item.getCost() + "gold" + " (" + item.getAbbreviation() + ")" + " - " + item.getDescription()));

        Item item = readItemSelection();
        if(item != null) {
            write("Item bought: " + item.getName() + " (-" + item.getCost() + ")");
        }
        return item;
    }

    private static Item readItemSelection() {
        String answer = read();
        Optional<Item> selection = Arrays.stream(ItemCollector.values()).map(ItemCollector::getItemInstance)
                .filter(item -> item.getAbbreviation().equals(answer)).findFirst();
        return selection.orElse(null);
    }

    public static void signalMove(Being executor, Being target, TurnAction action) {
        if(action == TurnAction.Attack) {
            write(executor.getName() + " attacked " + target.getName() + ".");
            write("Hp " + target.getName() + ": " + target.getCurrentHp() + " of " + target.getMaxHp() + " (-" + executor.getAttackDmg() + ")");
        }
        wait(1);
    }

    public static void signalDeath(Being victim) {
        write(victim.getName() + " died.");
    }

    public static void signalNotEnoughMoney(int money, int cost) {
        write("You don't have enough money. (Money: " + money + ", Cost: " + cost + ")");
    }

    public static void signalNewBalance(int balance, int diffInt) {
        String difference = diffInt > 0 ? "+" + diffInt : "" + diffInt;
        write("Money: " + balance + "(" + difference + ")");
    }

    public static void signalTurnOf(Being b) {
        write("\n- " + b.getName() + " turn -");
    }

    private static void write(String text) {
        System.out.println(text);
    }

    private static String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void wait(int timeInSeconds) {
        try {
            TimeUnit.SECONDS.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
