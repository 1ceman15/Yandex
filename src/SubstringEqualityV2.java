import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringEqualityV2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = " "+str; //Пробел нужен, чтобы нумерация массива начиналась с 1
        int N = Integer.parseInt(br.readLine());

        long[] array = new long[str.length()];
        long[] degree = new long[str.length()];

        degree[0] = 1;
        long remains = (int) Math.pow(10,9)+7;
        long x = 257;

        for (int i = 1; i < str.length(); i++) {
            degree[i] = (degree[i-1]*x)%remains;
            array[i] = (array[i-1] * x + (long) (str.charAt(i)) )%remains;
        }
        for (int i = 0; i < N; i++) {
            String[] helper = br.readLine().split(" ");
            int size = Integer.parseInt(helper[0]);
            int A = Integer.parseInt(helper[1])+1;
            int B = Integer.parseInt(helper[2])+1;
            boolean answer = ((array[A+size-1]+array[B-1]*degree[size])%remains) == ((array[B+size-1]+array[A-1]*degree[size])%remains);
            if(answer)
                System.out.println("yes");
            else
                System.out.println("no");
        }



    }
}
