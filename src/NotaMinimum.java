import java.io.*;

public class NotaMinimum {
    public static void main(String[] args) throws IOException {
        int N, M;
        String help;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        help = br.readLine();
        String[] mas = help.split(" ");
        N = Integer.parseInt(mas[0]);
        M = Integer.parseInt(mas[1]);
        int array[] = new int[N];
        mas = null;
        help = br.readLine();
        mas = help.split(" ");
        for(int i =0;i<N;i++)
            array[i] = Integer.parseInt(mas[i]);
        mas = null;
        int[][] array2 = new int[M][2];
        for(int i=0;i<M;i++){
            help = br.readLine();
            mas = help.split(" ");
            array2[i][0] = Integer.parseInt(mas[0]);
            array2[i][1] = Integer.parseInt(mas[1]);
        }
        boolean flag = true;
        for(int i =0; i<M; i++){
            flag = true;
            int min = Integer.MAX_VALUE;
            for(int j=array2[i][0]; j<=array2[i][1];j++){
                if(min>array[j])min=array[j];
            }
            for(int j=array2[i][0]; j<=array2[i][1];j++){
                if(array[j]!=min){
                    System.out.println(array[j]);
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("NOT FOUND");
        }


    }
}