import java.io.*;
import java.util.Arrays;

public class Groups {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long[] array = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long people = array[0];
            long a = array[1];
            long b = array[2];

            long remains = people % a;
            long groups = people / a;

            remains -= (b-a)*groups;

            if(remains<=0)
                pw.print("YES\n");
            else
                pw.print("NO\n");
        }


        pw.flush();
    }
}
