import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class AllSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder str = new StringBuilder("");
        TreeSet<Integer> ts = new TreeSet<>();
        boolean[] array = new boolean[N];
        Arrays.fill(array, false);
        func(str,N,array, pw);
        pw.flush();

    }

    static StringBuilder func(StringBuilder str, int N, boolean[] array, PrintWriter pw){
        if(str.length()==N) {
            pw.print(str+"\n");
            return str;
        }


        for (int i = 1; i <= N; i++) {
            if(array[i-1] == true)
                continue;
            str = str.append(i);
            array[i-1] = true;
            func(str, N, array,pw);
            str = str.deleteCharAt(str.length()-1);
            array[i-1] = false;

        }
        return str;

    }
}
