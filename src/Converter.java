public class Converter {

    double distance(int steps){
       double distance = steps * 75;
       return distance / 100000;
    }

    double burnKilocalories(int steps){
        double burnKkl = steps * 50;
        return burnKkl / 1000;
    }
}
