package structure;

import beings.Being;

import java.io.*;

public class Ui {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static TurnAction getTurnDecision() {
        write("What will you do? (Attack - at, abilities.Ability - ab, Item - i)");
        String answer = read();
        TurnAction decision = TurnAction.stringMap(answer);
        if(decision == null) {
            write("invalid answer");
            return getTurnDecision();
        }
        return decision;
    }

    public static boolean askOpenShop() {
        write("Do you want to open shop? (y/n)");
        String answer = read();
        return switch (answer) {
            case "y" -> true;
            case "n" -> false;
            default -> askOpenShop();
        };
    }

    public static boolean showShop() {
        return false;
    }

    public static void signalMove(Being executor, Being target, TurnAction action) {
        if(action == TurnAction.Attack) {
            write(executor.getName() + " attacked " + target.getName() + ".");
            write("Hp " + target.getName() + ": " + target.getCurrentHp() + " of " + target.getMaxHp() + " (-" + executor.getAttackDmg() + ")");
        }
    }

    public static void signalDeath(Being victim) {
        write(victim.getName() + " died.");
    }

    public static void signalNewBalance(int balance, int gain) {
        write("New balance: " + balance + "(" + gain + ")");
    }

    public static void signalTurnOf(Being b) {
        write("- " + b.getName() + " turn -");
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

}
