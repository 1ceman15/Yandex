import java.io.*;

public class TwoDecimal {
    public static void main(String[] args) throws IOException {
        int a, b, c, d;
        int upRes, downRes;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String help = br.readLine();
        String[] mas = help.split(" ");
        a = Integer.parseInt(mas[0]);
        b = Integer.parseInt(mas[1]);
        c = Integer.parseInt(mas[2]);
        d = Integer.parseInt(mas[3]);
        if(b==d) {
            upRes = a + c;
            downRes=b;
            int max = (downRes>upRes)?downRes:upRes;
            int hp=1;
            for(int i=1;i<=max;i++){
                if(downRes%i==0 & upRes%i==0)
                    hp=i;
            }
            downRes/=hp;
            upRes/=hp;
        }
        else {
            downRes = b*d;
            upRes =(a*d)+(b*c);
            int max = (downRes>upRes)?downRes:upRes;
            int hp=1;
            for(int i=1;i<=max;i++){
                if(downRes%i==0 & upRes%i==0)
                    hp=i;
            }
            downRes/=hp;
            upRes/=hp;
        }
        System.out.print(upRes+ " " + downRes);


    }
}
