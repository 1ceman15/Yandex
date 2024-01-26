import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Elevator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long ppl = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long[] mas = new long[N+1];
        BigInteger time = new BigInteger("0");
        long free = ppl;
        for (int i = 1; i <= N; i++) {
            mas[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i >= 1 ; i--){
            free=ppl;
            if(mas[i]==0)continue;
            if(mas[i]>=ppl) {
                if (mas[i] % ppl == 0) {
                    time = time.add(BigInteger.valueOf((long) (mas[i] / ppl) * i));
                    mas[i] = 0;
                    continue;
                } else {
                    time = time.add(BigInteger.valueOf(((long) (mas[i] / ppl) + 1) * i));
                    free -= mas[i] % ppl;
                    mas[i] = 0;

                }
            }else {
                time = time.add(BigInteger.valueOf(i));
                free-=mas[i];
                mas[i]=0;
            }
            for (int j = i; j >= 1 ; j--){
                if(free==0)break;
                if(mas[j]==0)continue;
                if(mas[j]>=free){
                    mas[j] = mas[j]-free;
                    free=0;
                    break;
                }
                else{
                    free-=mas[j];
                    mas[j]=0;
                }
            }
        }
        time = time.multiply(BigInteger.valueOf(2));
        System.out.println(time);



    }
}
