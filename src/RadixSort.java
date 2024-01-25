import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class RadixSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] array = new String[N];
        for (int i = 0; i < N; i++)
            array[i] = br.readLine();
        String out = Arrays.toString(array);
        System.out.println("Initial array:");
        out = out.substring(1,out.length()-1);
        System.out.println(out);
        System.out.println("**********");
        int index = array[0].length()-1;
        int phase = 1;
        while (index>=0) {
            System.out.println("Phase "+ phase);
            radixSort(array, index);
            index--;
            phase++;
        }
        out = Arrays.toString(array);
        System.out.println("Sorted array:");
        out = out.substring(1,out.length()-1);
        System.out.println(out);
        System.out.println("**********");


    }
     static void radixSort(String[] array,int index){//i показывает разряд числа, по которому идет сортировка на данный момент
        int[] count = new int[10];
        HashMap<Integer, String> out = new HashMap<>();
         for (int i = 0; i < 10; i++) {
             out.put(i,"Bucket "+i+": ");
         }
        String[] mas = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            count[Integer.parseInt(array[i].substring(index, index+1))] +=1;
        }
        int[] pos = new int[10];
        pos[0] = 0;
        int sum = count[0];
        for (int i = 1; i < 10; i++) {
            pos[i] = sum;
            sum+=count[i];
        }
        for (int i = 0; i < array.length; i++) {
            int helper = Integer.parseInt(mas[i].substring(index,index+1));
            array[pos[helper]] = mas[i];
            out.put(helper, out.get(helper) + mas[i]+" ");
            pos[helper]++;
        }
         for (int i = 0; i < 10; i++) {
             if(out.get(i).length()<=10){
                 System.out.println(out.get(i)+ "empty");
             }
             else{
                 String str = out.get(i);
                 str = str.substring(0,11)+ str.substring(11,str.length()-1).replace(" ", ", ");
                 System.out.println(str);

             }
         }
         System.out.println("**********");

    }
}
