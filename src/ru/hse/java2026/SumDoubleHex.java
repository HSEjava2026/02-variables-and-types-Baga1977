package ru.hse.java2026;

public class SumDoubleHex {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println(0.0);
            return;
        }

        double totalSum = 0.0; 

        for (String arg : args) {
            if (arg == null) {
                continue;
            }

            int i = 0;
            while (i < arg.length()) {
                while (i < arg.length() && Character.isWhitespace(arg.charAt(i))) { 
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
                    totalSum += Double.parseDouble(part); 
                } catch (NumberFormatException e) {
                    System.err.println("Пропущено некорректное значение: " + part);
                }
            }
        }

        System.out.println(totalSum);
    }
}
