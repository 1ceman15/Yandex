import java.util.Arrays;
import java.util.Random;

class QuickSort{
    static Random rd = new Random();//Используется для ускорения сортировки, так как
                                    //сортировку по центральному элементку можно намеренно сломать
    public static void qs(int[] mas, int start, int end) {
        if(end-start<=0)return;
        int[] index = partition(mas,start,end);
        qs(mas,start,index[0]-1);
        qs(mas, index[1], end);
    }
    //Three-way partition
    public static int[] partition(int[] mas, int start, int end){
        int pivot = mas[(start+end)/2];//рандомный индекс для ускорения работы
        int eq = start;
        int now = start;
        int gt = start;
        while (now<=end){
            if(mas[now]<pivot){
                int helper = mas[now];
                mas[now] = mas[gt];
                mas[gt] = mas[eq];
                mas[eq] = helper;
                now++;
                gt++;
                eq++;
            }else if(mas[now]==pivot){
                int helper = mas[now];
                mas[now] = mas[gt];
                mas[gt] = helper;
                gt++;
                now++;
            }
            else {
                now++;
            }
        }
        int[] rt ={eq,gt};
        return rt;
    }


    //partition c выбором индекса опорного элемента
    //для задачи A из 4.0 дз по сортировкам
    public static int partition2(int[] mas, int start, int end,int index){
        int pivot = mas[index];
        int eq = start;
        int now = start;
        int gt = start;
        while (now<=end){
            if(mas[now]<pivot){
                int helper = mas[now];
                mas[now] = mas[gt];
                mas[gt] = mas[eq];
                mas[eq] = helper;
                now++;
                gt++;
                eq++;
            }else if(mas[now]==pivot){
                int helper = mas[now];
                mas[now] = mas[gt];
                mas[gt] = helper;
                gt++;
                now++;
            }
            else {
                now++;
            }
        }
        return eq;
    }
    static void swap(int mas[],int a, int b){
        int helper = mas[a];
        mas[a] = mas[b];
        mas[b] = helper;
    }
}