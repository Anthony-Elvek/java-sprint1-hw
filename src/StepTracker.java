public class StepTracker {

    int[][] monthToData;
    int ChallengeSteps = 10000;
    Converter converter = new Converter();

    StepTracker() {
        monthToData = new int[12][30];
    }


    void printAllSteps(){
        for (int i = 0; i < monthToData.length; i++){
            for (int j = 0; j < monthToData[i].length; j++){
                if (j == 29){
                    System.out.println("День 30: " + monthToData[i][j] + " ");
                } else {
                    System.out.print("День " + (j+1) + ": " + monthToData[i][j] + ", ");
                }
            }
        }
    }

    void printStatisticOfTheMonth(int month){
        for (int i = 0; i < monthToData[month-1].length; i++){
            if (i == 29){
                System.out.println("День 30: " + monthToData[month][i] + " ");
            } else {
                System.out.print("День " + (i+1) + ": " + monthToData[month][i] + ", ");
            }
        }
    }

    void saveSteps(int steps, int month, int day){
        if (steps < 0){
            System.out.println("Введено некорректное значение!");
        } else if (steps >= 10000) {
            System.out.println("Ура! На сегодня цель достигнута!");
            monthToData[month - 1][day - 1] += steps;
        } else {
            System.out.println("Шаги записаны");
            monthToData[month - 1][day - 1] += steps;
        }
    }

    int sumMonthSteps(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            sum += monthToData[month][i];
        }
        return sum;
    }

    int avgMonthSteps(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            sum += monthToData[month][i];
        }
        return sum / 30;
    }

    String distanceMonth(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            sum += monthToData[month][i];
        }
        double distance = converter.Distance(sum);
        return distance + " км.";
    }

    String sumOfBurnKls(int month){
        int sum = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            sum += monthToData[month][i];
        }
        double burnKl = converter.BurnKilocalories(sum);
        return burnKl + " ккл.";
    }

    int maxStepsMonth(int month){
        int maxStep = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            if (monthToData[month][i] > maxStep){
                maxStep = monthToData[month][i];
            }
        }
        return maxStep;
    }

    int countSuccessDays(int month){
        int countDays = 0;
        for (int i = 0; i < monthToData[month].length; i++){
            for (int j = 1;  j < monthToData[month].length; i++) {
                if (monthToData[month][i] >= 10000 && monthToData[month][j] >= 10000){
                    countDays += 1;
               }
            }
        }
        return countDays;
    }
}