package ru.hse.java2026;

public class Sum {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println(0);
            return;
        }

        int totalSum = 0;

        for (String arg : args) {
            if (arg == null) {
                continue;
            }

            int i = 0;
            while (i < arg.length()) {
                while (i < arg.length() && Character.isWhitespace(arg.charAt(i))) { //isWhitespace для обработки юникода
                    i++;
                }

                if (i >= arg.length()) {
                    break;
                }

                int start = i;
                
                while (i < arg.length() && !Character.isWhitespace(arg.charAt(i))) {
                    i++;
                }

                String part = arg.substring(start, i);
                try {
                    totalSum += Integer.parseInt(part);
                } catch (NumberFormatException e) {
                    System.err.println("Пропущено некорректное значение: " + part);
                }
            }
        }

        System.out.println(totalSum);
    }
}