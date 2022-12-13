import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    public static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    public static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    public static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        TextLogger.logFormat();
        String gameover = "";
            if (Main.GameOver(Main.darkside)) {
                gameover = AnsiColors.ANSI_BLUE+"Темная сторона пала :("+AnsiColors.ANSI_RESET;
            } else if (Main.GameOver(Main.lightside)){
                gameover = AnsiColors.ANSI_GREEN+"Светлая сторона пала, тьма воссторжестовала!"+AnsiColors.ANSI_RESET;
            }
        int TAB = 3;
        String temp = "";
        if (step++ == 0) {
            temp = "First step!";
        } else {
            temp = "Step " + step;
        }
        System.out.print(AnsiColors.ANSI_RED + temp + AnsiColors.ANSI_RESET);
        String side = "";
        while (temp.length() + side.length() < top10.length() + TAB) {
            side += " ";
        }
        side += "Светлая сторона";
        int max_lenght = TextLogger.logOut(0)[0].length();
        while (temp.length() + side.length() < top10.length() + TAB + max_lenght) {
            side += " ";
        }
        side += AnsiColors.ANSI_BLUE + "Темная сторона" + AnsiColors.ANSI_RESET;
        System.out.println(AnsiColors.ANSI_GREEN + side);
        
        System.out.println(ConsoleView.top10);
        for (int i = 1; i <= Main.NUMHEROTOCREATE - 1; i++) {
            for(int j = 1; j <= Main.NUMHEROTOCREATE; j++) {
                System.out.print(getChar(new Vector2(i, j)));
            }
            System.out.print("|");
            for (int k = 0; k < TAB; k++) {
                System.out.print(" ");
            }
            // На последнем ходе не обновляется статус на Герой убит... Пока не могу придумать решение.
            // скорее всего надо пересмотреть генерацию сообщений... в классе завести текст результата?

            System.out.print(AnsiColors.ANSI_GREEN + TextLogger.logOut(i - 1)[0] + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_BLUE + TextLogger.logOut(i - 1)[1] + AnsiColors.ANSI_RESET);
            System.out.println(mid10);
        }
        for (int j = 1; j <= Main.NUMHEROTOCREATE; j++) {
            System.out.print(getChar(new Vector2(10, j)));
        }
        System.out.print("|");
        for (int k = 0; k < TAB; k++) {
            System.out.print(" ");
        }

        System.out.print(AnsiColors.ANSI_GREEN + TextLogger.logOut(9)[0] + AnsiColors.ANSI_RESET);
        System.out.println(AnsiColors.ANSI_BLUE + TextLogger.logOut(9)[1] + AnsiColors.ANSI_RESET);
        System.out.println(ConsoleView.bottom10);
        if (Main.GameOver(Main.darkside) || Main.GameOver(Main.lightside)) {
            System.out.println(gameover);
        } else {
            System.out.println("Press ENTER");
        }
    }

    private static String getChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.NUMHEROTOCREATE; i++) {
            if (Main.lightside.get(i).getPosition().isEqual(position)) {
                if (!(Main.lightside.get(i).status.equals("dead"))) {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.lightside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_RED + Main.lightside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                }
            }
            if (Main.darkside.get(i).getPosition().isEqual(position)) {
                if (!(Main.darkside.get(i).status.equals("dead"))){
                    str = "|" + AnsiColors.ANSI_BLUE + Main.darkside.get(i).getClassHero().toUpperCase().charAt(0)
                        + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_RED + Main.darkside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                }
            } 
        }
        
        return str;
    }

    public static int checkHero(Vector2 position) {
        int result = 0;
        for (int i = 0; i < Main.NUMHEROTOCREATE; i++) {
            if (Main.lightside.get(i).getPosition().isEqual(position)) {
                if (!(Main.lightside.get(i).status.equals("dead"))) {
                    result = 777;
                }
            }
            if (Main.darkside.get(i).getPosition().isEqual(position)) {
                if (!(Main.darkside.get(i).status.equals("dead"))) {
                    result = 666;
                }
            }
        }
        return result;
    }

    private static String formatDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
}
