import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;


public class Mirror {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String trash = br.readLine();
        String[] str = br.readLine().split(" ");
        //Использую отсортированное множество, чтобы избавиться от повторов
        //и вывести элементы в порядке возрастания
        TreeSet<Integer> set = new TreeSet<>();

        long[] array = new long[str.length];
        long[] degree = new long[str.length];
        long[] reverse = new long[str.length];//массив, который хранит хеши перевернутой строки
        int reverseIndex = str.length-1;

        degree[0] = 1;
        long remains = (int) Math.pow(10, 9) + 7;//делитель
        long x = 257;

        array[0] = Long.parseLong(str[0])%remains;
        reverse[0] = Long.parseLong( str[reverseIndex]) % remains;
        reverseIndex--;

        //Хеширование строки и запись степеней x
        //Так как вводные данные - числа, хеширование происходит сразу по ним
        for (int i = 1; i < str.length; i++) {
            degree[i] = (degree[i - 1] * x) % remains;
            array[i] = (array[i - 1] * x + Long.parseLong(str[i])) % remains;
            reverse[i] = (reverse[i-1] * x + Long.parseLong(str[reverseIndex]) ) % remains;
            reverseIndex--;
        }
        //идем до середины массива, так как, очевидно,
        //что в зеркале не может отражаться меньше половины всех видимых элементов
        for (int i = 0; i < str.length/2; i++) {
            int len = i+1;
            reverseIndex = str.length - len -1;
            int reverseLen = reverseIndex+1;
            int preI = i - len;
            long mirror = reverse[reverseIndex] % remains;
            if(reverseLen==len){
                boolean helper = array[i] % remains == reverse[reverseIndex] % remains;
                if(helper)
                    set.add(len);
            }else if(reverseLen<len){
                continue;
            }else {
                boolean helper = (array[i] + reverse[reverseIndex-len] * degree[len]) % remains == reverse[reverseIndex] % remains;
                if(helper)
                    set.add(reverseLen);
            }

        }
        //добавляем случай, когда зеркала нет, и все элементы настоящии
        set.add(str.length);


        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext())
            pw.print(iter.next()+" ");
        pw.flush();
    }

}
