package structure;

public enum TurnAction {
    Attack,
    Ability,
    Item;

    public static TurnAction stringMap(String value) {
        return switch (value) {
            case "at" -> TurnAction.Attack;
            case "ab" -> TurnAction.Ability;
            case "i" -> TurnAction.Item;
            default -> null;
        };
    }
}
