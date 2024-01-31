import java.io.*;
import java.util.Arrays;

public class zFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        if (str.length() == 1) {
            System.out.println(0);
            return;
        }
        long[] array = new long[str.length()];
        long[] degree = new long[str.length()];

        degree[0] = 1;
        long remains = (int) Math.pow(10, 9) + 7;//делитель
        long x = 257;
        array[0] = (long) str.charAt(0) % remains;

        //Хеширование строки и запись степеней x
        for (int i = 1; i < str.length(); i++) {
            degree[i] = (degree[i - 1] * x) % remains;
            array[i] = (array[i - 1] * x + (long) (str.charAt(i))) % remains;
        }
        int[] answer = new int[str.length()];
        pw.print("0 ");
        for (int i = 1; i <= str.length() - 1; i++) {
            int suffixBeg = i;
            int length = 1;
            int prefix = 0;
            boolean flag= true;
            for (int j = i; j<=str.length()-1;j++) {
                boolean helper = (array[prefix] + array[suffixBeg-1] * degree[length]) % remains == array[j] % remains;
                if (helper) {
                    prefix++;
                    length++;
                    flag = false;
                    continue;
                }
                break;
            }
            if(flag) {
                pw.print("0 ");
            }
            else
                pw.print((length-1)+" ");
        }

        pw.flush();

    }
}




