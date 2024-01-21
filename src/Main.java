import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());
        String[] hp = br.readLine().split(" ");
        int[] mas = new int[N];
        for (int i = 0; i < N; i++) {
            mas[i] = Integer.parseInt(hp[i]);
        }
        QuickSort.qs(mas,0,mas.length-1);
        for (int x: mas) {
            System.out.print(x+" ");
        }
    }
}




