public class StepsStatistic {

    StepTracker stepTracker = new StepTracker();

    void stepStatistic(int month, int challengeSteps){
         System.out.println("Статистика за " + month + " месяц:");
         System.out.println("1. Количество пройденных шагов за месяц: ");
         stepTracker.printStatisticOfTheMonth(month);
         System.out.println("2. Общее количество шагов за месяц: ");
         stepTracker.sumMonthSteps(month);
         System.out.println("3. Максимальное количество пройденных шагов за месяц: ");
         stepTracker.maxStepsMonth(month);
         System.out.println("4. Среднее количество шагов за месяц: ");
         stepTracker.avgMonthSteps(month);
         System.out.println("5. Пройденная дистанция за месяц: ");
         stepTracker.distanceMonth(month);
         System.out.println("6. Количество сожженых килокалориев: ");
         stepTracker.sumOfBurnKls(month);
         System.out.println("7. Лучшая серия дней: ");
         stepTracker.countSuccessDays(month, challengeSteps);
    }
}
