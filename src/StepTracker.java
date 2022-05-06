public class StepTracker {

    int[][] monthToData;
    Converter converter = new Converter();

    StepTracker() {
        monthToData = new int[12][30];
    }

    void printStatisticOfTheMonth(int month){
        for (int i = 0; i < monthToData[month - 1].length; i++){
            if (i == 29){
                System.out.println("День 30: " + monthToData[month - 1][i] + " ");
            } else {
                System.out.print("День " + (i+1) + ": " + monthToData[month - 1][i] + ", ");
            }
        }
    }

    void saveSteps(int month, int day, int steps, int challengeSteps){
        if (steps < 0){
            System.out.println("Введено некорректное значение!");
        } else if (steps >= challengeSteps) {
            System.out.println("Ура! На сегодня цель достигнута!");
            monthToData[month - 1][day - 1] += steps;
        } else {
            System.out.println("Шаги записаны!");
            monthToData[month - 1][day - 1] += steps;
        }
    }

    int sumMonthSteps(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
            sum += monthToData[month - 1][i];
        }
        return sum;
    }

    int avgMonthSteps(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
            sum += monthToData[month - 1][i];
        }
        return sum / 30;
    }

    String distanceMonth(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
            sum += monthToData[month - 1][i];
        }
        double distance = converter.Distance(sum);
        return distance + " км.";
    }

    String sumOfBurnKls(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
            sum += monthToData[month - 1][i];
        }
        double burnKl = converter.BurnKilocalories(sum);
        return burnKl + " ккл.";
    }

    int maxStepsMonth(int month){
        int maxStep = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
            if (monthToData[month - 1][i] > maxStep){
                maxStep = monthToData[month - 1][i];
            }
        }
        return maxStep;
    }

    int countSuccessDays(int month, int challengeSteps){
        int countDays = 0;
        int maxCountDays = 0;
        for (int i = 0; i < monthToData[month - 1].length; i++){
           if (monthToData[month - 1][i] >= challengeSteps){
               countDays += 1;
           } else {
               if (countDays > maxCountDays){
                   maxCountDays = countDays;
               }
               countDays = 0;
           }
        }
        return maxCountDays;
    }
}