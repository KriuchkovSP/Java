import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    public static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    public static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    public static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view(String[] team_left, String[] team_right, int max_lenght) {
        int SHIFT = 8;
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
        side += "Темная сторона";
        while (temp.length() + side.length() < top10.length() + TAB + max_lenght + SHIFT) {
            side += " ";
        }
        side += AnsiColors.ANSI_BLUE + "Светлая сторона" + AnsiColors.ANSI_RESET;
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
            temp = team_left[i - 1];
            while(temp.length() < max_lenght + SHIFT) {
                temp += " ";
            }
            System.out.print(AnsiColors.ANSI_GREEN + temp + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_BLUE + team_right[i - 1] + AnsiColors.ANSI_RESET);
            System.out.println(mid10);
        }
        for (int j = 1; j <= Main.NUMHEROTOCREATE; j++) {
            System.out.print(getChar(new Vector2(10, j)));
        }
        System.out.print("|");
        for (int k = 0; k < TAB; k++) {
            System.out.print(" ");
        }
        temp = team_left[9];
        while(temp.length() < max_lenght + SHIFT) {
            temp += " ";
        }
        System.out.print(AnsiColors.ANSI_GREEN + temp + AnsiColors.ANSI_RESET);
        System.out.println(AnsiColors.ANSI_BLUE + team_right[9] + AnsiColors.ANSI_RESET);
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.NUMHEROTOCREATE; i++) {
            if (Main.darkside.get(i).getPosition().isEqual(position)) {
                if (!(Main.darkside.get(i).status.equals("dead"))) {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.darkside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_RED + Main.darkside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                }
            }
            if (Main.lightside.get(i).getPosition().isEqual(position)) {
                if (!(Main.lightside.get(i).status.equals("dead"))){
                    str = "|" + AnsiColors.ANSI_BLUE + Main.lightside.get(i).getClassHero().toUpperCase().charAt(0)
                        + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_RED + Main.lightside.get(i).getClassHero().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                }
            } 
        }
        return str;
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
