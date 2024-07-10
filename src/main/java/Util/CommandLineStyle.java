package Util;

public class CommandLineStyle {

    // ANSI escape codes for colors and formatting
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String UNDERLINE = "\u001B[4m";

    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Methods to format text with ANSI codes
    public static String colorize(String text, String color) {
        return color + text + RESET;
    }

    public static String bold(String text) {
        return BOLD + text + RESET;
    }

    public static String underline(String text) {
        return UNDERLINE + text + RESET;
    }

    public static String red(String text) {
        return colorize(text, RED);
    }

    public static String green(String text) {
        return colorize(text, GREEN);
    }

    public static String yellow(String text) {
        return colorize(text, YELLOW);
    }

    public static String blue(String text) {
        return colorize(text, BLUE);
    }

    public static String purple(String text) {
        return colorize(text, PURPLE);
    }

    public static String cyan(String text) {
        return colorize(text, CYAN);
    }

    public static String white(String text) {
        return colorize(text, WHITE);
    }
}
