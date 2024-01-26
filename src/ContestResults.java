import java.io.*;
public class ContestResults {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a,b,c;
        a=Integer.parseInt(br.readLine());
        b=Integer.parseInt(br.readLine());
        c=Integer.parseInt(br.readLine());
        if(b==0 & a!=0){
            System.out.println("Yes");
            return;
        }
        if(b%c==0) {
            if ((a / 1) > (b / c)) System.out.println("Yes");
            else System.out.println("No");
        }else {
            if ((a / 1) > (b / c)+1) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}
