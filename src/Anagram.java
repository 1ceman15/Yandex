import java.io.*;
import java.util.Arrays;
public class Anagram {
    public static void main(String[] args) throws IOException {
        String str1, str2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        char[] mas1 = str1.toCharArray();
        char[] mas2 = str2.toCharArray();
        Arrays.sort(mas1);
        Arrays.sort(mas2);
        if(mas1.length!=mas2.length) System.out.println("NO");
        else {
            boolean flag= true;
            for(int i =0;i<mas1.length;i++)
                if(mas1[i]!=mas2[i]) flag=false;
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
