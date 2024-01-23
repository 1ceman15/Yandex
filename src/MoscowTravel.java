import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MoscowTravel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long ax = Long.parseLong(input[0]);
        long ay = Long.parseLong(input[1]);
        long bx = Long.parseLong(input[2]);
        long by = Long.parseLong(input[3]);
        double LineTripAx = Math.sqrt((ax * ax) + (ay * ay));
        double LineTripBx =  Math.sqrt((bx * bx) +  (by * by));
        double LineTrip = LineTripAx + LineTripBx;

        double tg = Math.abs(Math.atan2(ay, ax) - Math.atan2(by, bx));
        double CircleTrip;
        if (LineTripAx > LineTripBx) {
            CircleTrip = tg * LineTripBx + LineTripAx - LineTripBx;
        } else if (LineTripAx == LineTripBx) {
            CircleTrip = tg * LineTripBx;
        } else {
            CircleTrip = tg * LineTripAx + LineTripBx - LineTripAx;
        }
        System.out.println(Math.min(CircleTrip, LineTrip));

    }
}