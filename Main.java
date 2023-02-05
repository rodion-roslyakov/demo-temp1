import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите данные");
        String input = s.nextLine();
        String[] strings = input.split(" ");
        calculator result = new calculator();
        result.calc(input);
    }
    }
    class calculator {
        public static String calc(String input)  {

            if (input.contains(" ")) {

            } else {
                System.out.println("Cтрока не является математической операцией, или выражение необходимо записать через пробел, например: 1 + 1 или VI + VII");
                return input;
            }
            String[] strings = input.split(" ");
           int count = strings.length;



                for (String element : strings) {
                System.out.println(element);
            }
            if (count != 3) {
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    return input;
                }
            String s1 = strings[0];
            String s2 = strings[2];
            String s3 = strings[1];
            System.out.println(s1);

            if  (s3.equals("/") || s3.equals("*") ||s3.equals("-") ||s3.equals("+")) {

            } else { System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                return input;

            }



            int k1 = 1;
            int k2 = 1;
            int x1 = -1;
            int x2 = -1;

            String[] ROMANS = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            String[] Arabic = {"1","2","3","4","5","6","7","8","9","10"};
            for (int i = 0; i < ROMANS.length; i++) {
                if (s1.equals(ROMANS[i])) {
                    x1 = i + 1;
                    k1 = 0;
                }
                if (s2.equals(ROMANS[i])) {
                    x2 = i + 1;
                    k2 = 0;
                }
            }

                for (int i = 0; i < Arabic.length; i++) {
                    if (s1.equals(Arabic[i])) {
                        x1 = i + 1;
                        k1 = 2;
                    }
                    if (s2.equals(Arabic[i])) {
                        x2 = i + 1;
                        k2 = 2;
                    }

                    if ((k1 == 0 && k2 == 2) || (k2 == 0 && k1 == 2)) {
                        System.out.println("Используются одновременно разные системы счисления");
                        return input;
                    }
                }
                    if (k1==1 || k2==1)  {
                        System.out.println("Должен быть математический формат типа: два операнда и один оператор (+, -, /, *), числовой диапазон: от 1 до 10 ");
                        return input;
                    }

            if (k1 + k2 == 0) {
                if (x1 > 0 && x2 > 0 && x1 <= 10 && x2 <= 10) {
                    int SS = 0;
                    if (s3.equals("+")) {
                        SS = x1 + x2;
                    }

                    if (s3.equals("-")) {
                        SS = x1 - x2;
                    }

                    if (s3.equals("*")) {
                        SS = x1 * x2;
                    }

                    if (s3.equals("/")) {
                        SS = x1 / x2;
                    }

                    if (SS < 1){
                        System.out.println("В римской системе нет отрицательных чисел");
                        return input;
                    }
                    int m1 = SS / 10;
                    int m2 = SS % 10;
                    String M11;
                    switch (m1) {
                        case 10:
                            M11 = "С";
                            break;
                        case 9:
                            M11 = "XC";
                            break;
                        case 8:
                            M11 = "LXXX";
                            break;
                        case 7:
                            M11 = "LXX";
                            break;
                        case 6:
                            M11 = "LX";
                            break;
                        case 5:
                            M11 = "L";
                            break;
                        case 4:
                            M11 = "XL";
                            break;
                        case 3:
                            M11 = "XXX";
                            break;
                        case 2:
                            M11 = "XX";
                            break;
                        case 1:
                            M11 = "X";
                            break;

                        default:
                            M11 = "";
                    }
                    String M22;
                    if (m2 == 0) {
                        M22 = "";
                    } else {
                        M22 = ROMANS[m2 - 1];
                    }


                    System.out.print(M11 + M22);
                } else {
                    System.out.println("Вводимые значения должны быть в диапазоне от 1 до 10");
                    return input;
                }
            }

            if (k1 == 2 && k2 == 2) {

                x1 = Integer.parseInt(s1.trim());
                x2 = Integer.parseInt(s2.trim());


                if (x1 > 0 && x2 > 0 && x1 <= 10 && x2 <= 10) {
                    if (s3.equals("+")) {
                        System.out.println(x1 + x2);
                    }

                    if (s3.equals("-")) {
                        System.out.println(x1 - x2);
                    }

                    if (s3.equals("*")) {
                        System.out.println(x1 * x2);
                    }

                    if (s3.equals("/")) {
                        System.out.println(x1 / x2);
                    }
                } else {
                    System.out.println("Вводимые значения должны быть в диапазоне от 1 до 10");
                    return input;
                }
            }
            return input;
        }
    }
