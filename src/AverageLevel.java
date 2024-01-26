import java.io.*;
import java.util.*;


public class AverageLevel {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] mas = new int[N];
        int[] answer = new int[N];
        String hp = br.readLine();
        String[] help = hp.split(" ");
        for (int i = 0; i < N; i++) {
            mas[i] = Integer.parseInt(help[i]);
        }
        int sum = 0;
        int c = 0;
        for (int i = 0; i < N; i++) {
            if(i==0){
                answer[i] = mas[i]*0-sum;
            }else {
                answer[i]= mas[i]*i-sum;
            }
            sum+=mas[i];
        }
        sum = 0;
        c = 0;
        for (int i = (N-1); i >=0; i--) {
            answer[i] = answer[i] + (sum-mas[i]*c);
            sum+=mas[i];
            c++;
        }
        for (int i =0 ; i < N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
}
