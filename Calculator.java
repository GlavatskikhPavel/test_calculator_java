package calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(calc(line));
    }

    static String calc(String input) throws Exception {

        String lineOppend = oppend(input);

        boolean okRims;

        String[] line = input.split("[-|+|*|/]");

        if (line.length < 2) {
            throw new Exception("Строка не является математической операцией");
        }

        if (line.length != 2 && (lineOppend != "+" || lineOppend != "-" || lineOppend != "*" || lineOppend != "/")) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int one = 0;
        int tho = 0;

        if (Rims.doesTheKeyContain(line[0]) && Rims.doesTheKeyContain(line[1])) {
            one = Rims.parseArabic(line[0]);
            tho = Rims.parseArabic(line[1]);
            okRims = true;
            if ((one >= 1 && one <= 10) && (tho >= 1 && tho <= 10)) {
            } else throw new Exception("Числа должны быть от 1 до 10 включительно");

            if (one < tho) {
                throw new Exception("В римской системе нет отрицательных чисел");
            }

        } else if (!Rims.doesTheKeyContain(line[0]) && !Rims.doesTheKeyContain(line[1])) {
            one = Integer.parseInt(line[0]);
            tho = Integer.parseInt(line[1]);
            okRims = false;
            if ((one >= 1 && one <= 10) && (tho >= 1 && tho <= 10)) {
            } else throw new Exception("Числа должны быть от 1 до 10 включительно");
        } else throw new Exception("Используются одновременно разные системы счисления");

        int result = calculator(one, tho, lineOppend);

        if (okRims != true) {
            return String.valueOf(result);
        } else return okRimsParse(result);
    }

    static int calculator(int one, int tho, String lineOppend) {
        if (lineOppend.equals("+")) return one + tho;
        else if (lineOppend.equals("-")) return one - tho;
        else if (lineOppend.equals("*")) return one * tho;
        else if (lineOppend.equals("/")) return one / tho;
        else return -1;
    }

    static String okRimsParse(int i) {
        for (Map.Entry<String, Integer> pair : Rims.mapArabic.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            if (value.equals(i)) {
                return key;
            }
        }
        return null;
    }

    static String oppend(String input) {
        if (input.contains("+")) {
            return "+";
        } else if (input.contains("-")) {
            return "-";
        } else if (input.contains("*")) {
            return "*";
        } else if (input.contains("/")) {
            return "/";
        } else return null;
    }

    static class Rims {
        public static Map<String, Integer> mapArabic;

        static {
            mapArabic = new HashMap<>();
            mapArabic.put("I", 1);
            mapArabic.put("II", 2);
            mapArabic.put("III", 3);
            mapArabic.put("IV", 4);
            mapArabic.put("V", 5);
            mapArabic.put("VI", 6);
            mapArabic.put("VII", 7);
            mapArabic.put("VIII", 8);
            mapArabic.put("IX", 9);
            mapArabic.put("X", 10);
            mapArabic.put("XI", 11);
            mapArabic.put("XII", 12);
            mapArabic.put("XIII", 13);
            mapArabic.put("XIV", 14);
            mapArabic.put("XV", 15);
            mapArabic.put("XVI", 16);
            mapArabic.put("XVII", 17);
            mapArabic.put("XVIII", 18);
            mapArabic.put("XIX", 19);
            mapArabic.put("XX", 20);
            mapArabic.put("XXI", 21);
            mapArabic.put("XXII", 22);
            mapArabic.put("XXIII", 23);
            mapArabic.put("XXIV", 24);
            mapArabic.put("XXV", 25);
            mapArabic.put("XXVI", 26);
            mapArabic.put("XXVII", 27);
            mapArabic.put("XXVIII", 28);
            mapArabic.put("XXIX", 29);
            mapArabic.put("XXX", 30);
            mapArabic.put("XXXI", 31);
            mapArabic.put("XXXII", 32);
            mapArabic.put("XXXIII", 33);
            mapArabic.put("XXXIV", 34);
            mapArabic.put("XXXV", 35);
            mapArabic.put("XXXVI", 36);
            mapArabic.put("XXXVII", 37);
            mapArabic.put("XXXVIII", 38);
            mapArabic.put("XXXIX", 39);
            mapArabic.put("XL", 40);
            mapArabic.put("XLI", 41);
            mapArabic.put("XLII", 42);
            mapArabic.put("XLIII", 43);
            mapArabic.put("XLIV", 44);
            mapArabic.put("XLV", 45);
            mapArabic.put("XLVI", 46);
            mapArabic.put("XLVII", 47);
            mapArabic.put("XLVIII", 48);
            mapArabic.put("XLIX", 49);
            mapArabic.put("L", 50);
            mapArabic.put("LI", 51);
            mapArabic.put("LII", 52);
            mapArabic.put("LIII", 53);
            mapArabic.put("LIV", 54);
            mapArabic.put("LV", 55);
            mapArabic.put("LVI", 56);
            mapArabic.put("LVII", 57);
            mapArabic.put("LVIII", 58);
            mapArabic.put("LIX", 59);
            mapArabic.put("LX", 60);
            mapArabic.put("LXI", 61);
            mapArabic.put("LXII", 62);
            mapArabic.put("LXIII", 63);
            mapArabic.put("LXIV", 64);
            mapArabic.put("LXV", 65);
            mapArabic.put("LXVI", 66);
            mapArabic.put("LXVII", 67);
            mapArabic.put("LXVIII", 68);
            mapArabic.put("LXIX", 69);
            mapArabic.put("LXX", 70);
            mapArabic.put("LXXI", 71);
            mapArabic.put("LXXII", 72);
            mapArabic.put("LXXIII", 73);
            mapArabic.put("LXXIV", 74);
            mapArabic.put("LXXV", 75);
            mapArabic.put("LXXVI", 76);
            mapArabic.put("LXXVII", 77);
            mapArabic.put("LXXVIII", 78);
            mapArabic.put("LXXIX", 79);
            mapArabic.put("LXXX", 80);
            mapArabic.put("LXXXI", 81);
            mapArabic.put("LXXXII", 82);
            mapArabic.put("LXXXIII", 83);
            mapArabic.put("LXXXIV", 84);
            mapArabic.put("LXXXV", 85);
            mapArabic.put("LXXXVI", 86);
            mapArabic.put("LXXXVII", 87);
            mapArabic.put("LXXXVIII", 88);
            mapArabic.put("LXXXIX", 89);
            mapArabic.put("XC", 90);
            mapArabic.put("XCI", 91);
            mapArabic.put("XCII", 92);
            mapArabic.put("XCIII", 93);
            mapArabic.put("XCIV", 94);
            mapArabic.put("XCV", 95);
            mapArabic.put("XCVI", 96);
            mapArabic.put("XCVII", 97);
            mapArabic.put("XCVIII", 98);
            mapArabic.put("XCIX", 99);
            mapArabic.put("C", 100);
        }

        public static boolean doesTheKeyContain(String line) {
            for (Map.Entry<String, Integer> pair : mapArabic.entrySet()) {
                String key = pair.getKey();
                Integer value = pair.getValue();
                if (line.equals(key)) {
                    return true;
                }
            }
            return false;
        }

        public static int parseArabic(String line) {
            for (Map.Entry<String, Integer> pair : mapArabic.entrySet()) {
                String key = pair.getKey();
                Integer value = pair.getValue();
                if (line.equals(key)) {
                    return value;
                }
            }
            return -1;
        }
    }
}
