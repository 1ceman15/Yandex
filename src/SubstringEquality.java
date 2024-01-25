import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubstringEquality {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] mas = new String[N];
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            int size = Integer.parseInt(arr[0]);
            int A = Integer.parseInt(arr[1]);
            int B = Integer.parseInt(arr[2]);
            if(str.substring(A,A+size).equals(str.substring(B,B+size))){
                mas[i]="yes";
            }
            else
                mas[i]="no";

        }
        for (int i = 0; i < N; i++) {
            System.out.println(mas[i]);
        }
    }
}

