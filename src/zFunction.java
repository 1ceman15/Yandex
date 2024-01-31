import java.io.*;

public class zFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
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

        pw.print("0 "); //Сохраняю все сразу в буфер обмена
        for (int i = 1; i <= str.length() - 1; i++) {
            int suffixBeg = i;
            int suffixLen = str.length()-i;
            int length;
            int prefix = 0;
            //проверяю совпадения первых символов, если они не совпадают, то очевидно, что суффикс не совпадает вообще
            if((array[0]+array[suffixBeg-1]*degree[1])%remains!=array[suffixBeg]%remains) {
                pw.print("0 ");
            //проверяю, вдруг совпадает весь символ
            } else if ((array[suffixLen-1] + array[suffixBeg-1] * degree[suffixLen]) % remains == array[str.length()-1] % remains) {
                pw.print(suffixLen+" ");
            //Бинарный поиск по индексу элемента
            }else {
                int left = i;
                int right = str.length()-1;
                while (left<right){
                    int index = (left+right)/2;//предположительный индекс конца совпадения префикса с суффиксом
                    int indexLen = index-suffixBeg+1;
                    //проверка совпадения суффикса до index с префиксом
                    boolean helper1 = (array[indexLen-1] + array[suffixBeg-1] * degree[indexLen])%remains == array[index]%remains;
                    //проверка совпадение суффикса до index+1 c префиксом
                    boolean helper2 = (array[indexLen] + array[suffixBeg-1] * degree[indexLen+1])%remains == array[index+1]%remains;
                    //если суффикс до index совпадает с префиксом и суффикс до index+1 не совпадает, то длинна индекса это ответ
                    if(helper1 && !helper2){
                        pw.print(indexLen+" ");
                        break;
                    }
                    else if(helper1){
                        left = index;
                        index = (left+right)/2;
                        indexLen = index-suffixBeg+1;
                    }
                    else {
                        right = index;
                        index = (left+right)/2;
                        indexLen = index - suffixBeg+1;
                    }
                }
            }
        }

        pw.flush();//вывод всего из буфера в консоль

    }


}




