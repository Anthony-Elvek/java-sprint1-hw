public class Converter {

    double Distance(int steps){
       double distance = steps * 75;
       return distance / 100000;
    }

    double BurnKilocalories(int steps){
        double burnKilocalories = (steps * 50) / 1000;
        return burnKilocalories;
    }
}
