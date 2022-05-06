public class StepTracker {

    MonthData[] monthToData;
    Converter converter = new Converter();
    int challengeSteps = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] days = new int[30];
    }

    void printStatisticOfTheMonth(int month) {
        for (int i = 0; i < monthToData[month + 1].days.length; i++) {
            if (i == 29) {
                System.out.println("День 30: " + monthToData[month - 1].days[i] + " ");
            } else {
                System.out.print("День " + (i + 1) + ": " + monthToData[month - 1].days[i] + ", ");
            }
        }
    }

    void saveSteps(int month, int day, int steps) {
        if (steps < 0) {
            System.out.println("Введено некорректное значение!");
        } else {
            monthToData[month - 1].days[day - 1] = monthToData[month - 1].days[day - 1] + steps;
            System.out.println("Шаги записаны!");
        }
    }

    int sumMonthSteps(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        return sum;
    }

    int avgMonthSteps(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        return sum / 30;
    }

    String distanceMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        double distance = converter.distance(sum);
        return distance + " км.";
    }

    String sumOfBurnKls(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            sum += monthToData[month - 1].days[i];
        }
        double burnKl = converter.burnKilocalories(sum);
        return burnKl + " ккал.";
    }

    int maxStepsMonth(int month) {
        int maxStep = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] > maxStep) {
                maxStep = monthToData[month - 1].days[i];
            }
        }
        return maxStep;
    }

    int countSuccessDays(int month) {
        int countDays = 0;
        int maxCountDays = 0;
        for (int i = 0; i < monthToData[month - 1].days.length; i++) {
            if (monthToData[month - 1].days[i] >= challengeSteps) {
                countDays += 1;
            } else {
                if (countDays > maxCountDays) {
                    maxCountDays = countDays;
                }
                countDays = 0;
            }
        }
        return maxCountDays;
    }

    void newChallengeStep(int step) {
        if (step < 0) {
            System.out.println("Введено некорректное значение!");
        } else {
            challengeSteps = step;
        }
    }

    void printStatistic(int month) {
        System.out.println("1. Количество пройденных шагов за месяц: ");
        printStatisticOfTheMonth(month);
        System.out.println("2. Общее количество шагов за месяц: " +
                sumMonthSteps(month));
        System.out.println("3. Максимальное количество пройденных шагов за месяц: " +
                maxStepsMonth(month));
        System.out.println("4. Среднее количество шагов за месяц: " +
                avgMonthSteps(month));
        System.out.println("5. Пройденная дистанция за месяц: " +
                distanceMonth(month));
        System.out.println("6. Количество сожженых килокалориев: " +
                sumOfBurnKls(month));
        System.out.println("7. Лучшая серия дней: " +
                countSuccessDays(month));
    }
}