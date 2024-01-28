import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBasis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
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

        /*
        Идея в том, чтобы брать префикс и суффикс одинакового размера
        и сравнивать их, если они одинаковые, то основание строки это все символы идущие до суффикса
        */

        boolean flag = true;
        for (int i = str.length()-2; i >= 0; i--) {//i - индекс конца основы
            int basis = i;
            int basisLen = basis+1;//длинна основы
            int suffixBegin = str.length()-basisLen;//индекс начала суффикса
            boolean answer = (array[basis] + array[suffixBegin-1] * degree[basisLen]) % remains == array[str.length()-1] % remains;
            if (answer) {
                System.out.println(str.length()-basisLen);
                return;
            }
        }
        if(flag)
            System.out.println(str.length());

    }
}
