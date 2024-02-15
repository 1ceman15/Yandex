import java.io.*;
//В коде сравнивается половина палиндрома с перевернутой другой половиной
public class SubPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        long answer = str.length();//каждая буква строки является палиндромом

        //Чтобы не выходить за пределы массива, добавляется пробел спереди и сзади
        str = " " + str + " ";

        long[] array = new long[str.length()];
        long[] degree = new long[str.length()];
        long[] reverse = new long[str.length()];//массив, который хранит хеши перевернутой строки
        int reverseIndex = str.length() - 2;//-2 так как добавляется пробел в начало строки
        //нужен предпоследний индекс строки

        degree[0] = 1;

        long remains = (int) Math.pow(10, 9) + 13;//делитель
        //Поменял делитель с +7 на +13 так как при +7 была коллизия на 42 тесте
        long x = 257;
        //Так как цикл хеширования начинается с 2, задается вручную
        degree[1] = x;

        array[0] = 0;//пробел в начале равен 0
        reverse[0] = 0;
        //пробел в конце равен 0
        array[str.length()-1] = 0;
        reverse[str.length()-1] = 0;
        array[1] = (long) str.charAt(1) % remains;
        reverse[1] = (long) str.charAt(reverseIndex) % remains;
        reverseIndex--;

        //Хеширование строки и запись степеней x
        for (int i = 2; i < str.length()-1; i++) {
            degree[i] = (degree[i - 1] * x) % remains;
            array[i] = (array[i - 1] * x + (long) str.charAt(i)) % remains;
            reverse[i] = (reverse[i - 1] * x + (long) str.charAt(reverseIndex)) % remains;
            reverseIndex--;
        }
        for (int i = 1; i <str.length()-2; i++) {
            //Для палиндрома четной длинны
            int halfLen = Math.min(i, str.length() - 2 - i);
            int firstHalf = i;
            int left = i - halfLen + 1;
            reverseIndex = str.length() - i - 2;
            int reverseEnd = reverseIndex - halfLen + 1;
            int start = 0;
            int end = halfLen;
            int mid = end;
            halfLen = 0;
            //когда start и end равны, значит бинпоиск закончился
            while (start <= end) {
                //mid - длинна половины палиндрома
                boolean helper = (array[firstHalf] + reverse[reverseEnd - 1] * degree[mid]) % remains
                        == (reverse[reverseIndex] + array[left - 1] * degree[mid]) % remains;
                if (helper) {
                    start = mid+1;
                    halfLen = mid;
                } else {
                    end = mid - 1;
                }
                mid = (start + end) / 2;
                left = i - mid + 1;
                reverseEnd = reverseIndex - mid + 1;
            }
            answer += halfLen;//К ответу добавляется половина длинны, так как,
            //если строка длинной N является палиндромом, то все убирая по символу с двух сторон
            //тоже будет получаться палиндром


            //Для палиндрома нечетной длинны
            halfLen = Math.min(i-1,str.length()-2-i);
            firstHalf = i;
            left = firstHalf - halfLen;
            reverseIndex = str.length() - i -1;
            reverseEnd =  reverseIndex - halfLen;
            start = 0;
            end = halfLen;
            mid = end;
            halfLen = 0;

            while (start<=end){
                //mid+1 так как mid это длинна половины палиндрома нн считая опорного(центрального) символа
                boolean helper = (array[firstHalf] + reverse[reverseEnd-1] * degree[mid+1]) % remains
                        == (reverse[reverseIndex] + array[left-1] * degree[mid+1]) % remains;
                if(helper){
                    start = mid+1;
                    halfLen = mid;
                }
                else {
                    end = mid-1;
                }
                mid = (start+end)/2;
                left = i-mid;
                reverseEnd = reverseIndex - mid;
            }
            answer+=halfLen;

        }

        System.out.println(answer);
    }

}

