package io.github.codeutilities.util;

public enum ChatType {
    SUCCESS("§a§l»", '7'),
    FAIL("§cError:", '7'),
    INFO_YELLOW("§6§l➤", 'e'),
    INFO_BLUE("§9§l➤", 'b');

    private final String prefix;
    private final char trailing;

    ChatType(String prefix, char trailing) {
        this.prefix = prefix;
        this.trailing = trailing;
    }

    public String getString() {
        return this.prefix;
    }

    public char getTrailing() {
        return trailing;
    }
}
