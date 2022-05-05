public class Converter {

    double Distance(int steps){
       double distance = steps * 75;
       return distance;
    }

    double BurnKilocalories(int steps){
        double burnKilocalories = (steps * 50) / 1000;
        return burnKilocalories;
    }
}
