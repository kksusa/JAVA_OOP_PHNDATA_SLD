import java.util.Scanner;

public class CheckPhone {
        /**Проверка правильности ввода номера телефона*/
        public static int CheckNumbers(String param) {
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.printf(param + ": ");
            if (iScanner.hasNextInt() == true) {
                int number = iScanner.nextInt();
                if (number > 99 && number < 1000) { // Номер состоит из трёх цифр
                    return number;
                } else {
                    System.out.println("Номер введен неправильно.");
                    continue;
                }
            } else {
                System.out.println("Номер введен неправильно.");
                continue;
            }
        }
    }
}
