import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        StepsStatistic statistic = new StepsStatistic();
        int challengeSteps = 10000;
        System.out.println("Вас приветствует Счетчик шагов!");
        System.out.println("Введите дату: ");

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1){
                System.out.println("В какой месяц ввести шаги?");
                int monthInput = scanner.nextInt();
                System.out.println("В какой день ввести шаги?");
                int day = scanner.nextInt();
                System.out.println("Какое количество шагов ввести?");
                int steps = scanner.nextInt();
                stepTracker.saveSteps(monthInput, day, steps, challengeSteps);
            } else if (userInput == 2){
                System.out.println("Какой месяц вас интересует?");
                int month = scanner.nextInt();
                statistic.stepStatistic(month, challengeSteps);
            } else if (userInput == 3) {
                System.out.println("Введите новую цель: ");
                int stepChallenge = scanner.nextInt();
                challengeSteps = stepChallenge;
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

