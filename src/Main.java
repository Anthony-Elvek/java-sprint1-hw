import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        System.out.println("Вас приветствует Счетчик шагов!");

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Введите месяц:");
                System.out.println("1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь," +
                        " 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь");
                int monthInput = scanner.nextInt();
                System.out.println("В какой день ввести шаги?");
                int day = scanner.nextInt();
                System.out.println("Какое количество шагов ввести?");
                int steps = scanner.nextInt();
                if (monthInput <= 0 || monthInput > 12 || day < 0 || steps < 0) {
                    System.out.println("Введено некорректное значение!");
                } else {
                    stepTracker.saveSteps(monthInput, day, steps);
                }
            } else if (userInput == 2) {
                System.out.println("Какой месяц вас интересует?");
                System.out.println("1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь," +
                        " 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь");
                int monthInput = scanner.nextInt();
                if (monthInput <= 0 || monthInput > 12) {
                    System.out.println("Введено некорректное значение!");
                } else {
                    stepTracker.printStatistic(monthInput);
                }
            } else if (userInput == 3) {
                System.out.println("Введите новую цель: ");
                int stepChallenge = scanner.nextInt();
                stepTracker.newChallengeStep(stepChallenge);
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Такой команды не существует, попробуйте снова");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов в определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}

