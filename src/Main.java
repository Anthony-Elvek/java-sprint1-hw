import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int challengeSteps = 10000;

        System.out.println("Вас приветствует Счетчик шагов!");

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1){
                System.out.println("Введите месяц:");
                System.out.println("1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь," +
                        " 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь");
                int monthInput = scanner.nextInt();
                System.out.println("В какой день ввести шаги?");
                int day = scanner.nextInt();
                System.out.println("Какое количество шагов ввести?");
                int steps = scanner.nextInt();
                if (monthInput <= 0 || monthInput > 12 || day < 0 || steps < 0){
                    System.out.println("Введено некорректное значение!");
                }else {
                    stepTracker.saveSteps(monthInput, day, steps, challengeSteps);
                }
            } else if (userInput == 2){
                System.out.println("Какой месяц вас интересует?");
                System.out.println("1 - январь, 2 - февраль, 3 - март, 4 - апрель, 5 - май, 6 - июнь," +
                        " 7 - июль, 8 - август, 9 - сентябрь, 10 - октябрь, 11 - ноябрь, 12 - декабрь");
                int monthInput = scanner.nextInt();
                if (monthInput <= 0 || monthInput > 12){
                    System.out.println("Введено некорректное значение!");
                } else {
                    System.out.println("1. Количество пройденных шагов за месяц: ");
                    stepTracker.printStatisticOfTheMonth(monthInput);
                    System.out.println("2. Общее количество шагов за месяц: " +
                    stepTracker.sumMonthSteps(monthInput));
                    System.out.println("3. Максимальное количество пройденных шагов за месяц: " +
                    stepTracker.maxStepsMonth(monthInput));
                    System.out.println("4. Среднее количество шагов за месяц: " +
                    stepTracker.avgMonthSteps(monthInput));
                    System.out.println("5. Пройденная дистанция за месяц: " +
                    stepTracker.distanceMonth(monthInput));
                    System.out.println("6. Количество сожженых килокалориев: " +
                    stepTracker.sumOfBurnKls(monthInput));
                    System.out.println("7. Лучшая серия дней: " +
                    stepTracker.countSuccessDays(monthInput, challengeSteps));
                }
            } else if (userInput == 3) {
                System.out.println("Введите новую цель: ");
                int stepChallenge = scanner.nextInt();
                if (challengeSteps < 0){
                    System.out.println("Введено некорректное значение!");
                }else {
                    challengeSteps = stepChallenge;
                }
            } else if (userInput == 0){
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

