import java.io.*;
import java.util.*;

//Тут используется другой написанный класс Stack
public class BracketSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack stack = new Stack(str);
        boolean fl = true;
        for (int i = 0; i < str.length(); i++) {
            if(stack.put(str.charAt(i))){
                continue;
            }else {
                System.out.println("no");
                fl = false;
                return;
            }
        }
        if(!stack.check()) fl= false;
        if(fl) System.out.println("yes");
        else System.out.println("no");

    }
}
