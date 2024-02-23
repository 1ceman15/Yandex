import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuickDijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] mas = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int N = (int) mas[0];
        int K = (int) mas[1];
        HashMap<Long, HashMap<Long, Long>> map = new HashMap<>();
        HashMap<Integer,Boolean> visit = new HashMap<>();

        for (int i = 0; i < K; i++) {
            mas = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            map.computeIfAbsent(mas[0],  f -> new HashMap<Long, Long>());
            map.computeIfAbsent(mas[1],  f -> new HashMap<Long, Long>());
            map.get(mas[0]).put(mas[1], mas[2]);
            map.get(mas[1]).put(mas[0],mas[2]);
            visit.put((int)mas[0], false);
            visit.put((int)mas[1], false);

        }

        mas = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int start = (int) mas[0];
        int finish = (int) mas[1];
        br.close();
        //Под индексом 0 хранится вершина, а под индексом 1 расстояние до нее от начала
        PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(arr -> arr[1]));

        for (int i = 1; i <= N; i++) {
            if(i==start){
                priorityQueue.add(new long[]{start, 0});
                continue;
            }
            priorityQueue.add(new long[]{i, Long.MAX_VALUE});
        }

        long[] distance = new long[N+1];//Чтобы индексы совпадали с вершинами графов

        Arrays.fill(distance, Long.MAX_VALUE);//Заполнение всего массива
        distance[start] = 0;//Так как мы уже находимся в этой точке


        while (!visit.isEmpty()){
            int now = (int) minimum(priorityQueue);
            if(now==Integer.MAX_VALUE || distance[now]==Long.MAX_VALUE)//Если now равен бесконечности, значит можно дальше не обрабатывать
                break;
            visit.remove(now);
            HashMap<Long,Long> inner = map.get((long)now);
            long cost = distance[now];
            if(inner == null)
                continue;
            for(Long x: inner.keySet()){
                long newCost = cost + inner.get(x);
                if(distance[x.intValue()]>newCost) {//Меняем длину пути, только если она меньше
                    //priorityQueue.remove(new long[]{now,distance[x.intValue()]});
                    distance[x.intValue()] = newCost;
                    priorityQueue.add(new long[]{x,distance[x.intValue()]});
                }
                if(now==finish)
                    break;

            }
        }
        if(distance[finish]==Long.MAX_VALUE){//Если там бесконечность, значит до вершины невозможно добраться
            System.out.println(-1);
        }else {
            System.out.println(distance[finish]);
        }


    }
    //Функция для нахождения непосещенной вершины с минимальным расстоянием(Возвращает индекс)
    static long minimum(PriorityQueue<long[]> priorityQueue){
        long[] mas =  priorityQueue.peek();//Хранит индекс вершины с минимальным путем до нее
        priorityQueue.remove(mas);
        if (mas==null)
            return Integer.MAX_VALUE;

        return mas[0];
    }

}