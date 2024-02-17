import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class DijkstraWithWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mas = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = mas[0];
        int start = mas[1];
        int finish = mas[2];
        int[] distance = new int[N+1];//Чтобы индексы совпадали с вершинами графов
        boolean[] visited = new boolean[N+1];
        int[] parents = new int[N+1];

        Arrays.fill(visited,false);
        visited[0] = true;

        Arrays.fill(distance, Integer.MAX_VALUE);//Заполнение всего массива
        distance[start] = 0;//Так как мы уже находимся в этой точке
        parents[start] = -1;

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            HashMap<Integer, Integer> inner = new HashMap<>();//Внутренняя хеш-таблица
            mas = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < N; j++) {
                if(mas[j] <= 0 )
                    continue;
                inner.put(j+1,mas[j]);
            }
            map.put(i,inner);
        }

        while (isContains(visited,false)){
            int now = minimum(distance,visited);
            if(now==Integer.MAX_VALUE)//Если now равен бесконечности, значит можно дальше не обрабатывать
                break;
            visited[now] = true;//Мы обработали вершину
            HashMap<Integer,Integer> inner = map.get(now);
            int cost = distance[now];
            for(Integer x: inner.keySet()){
                int newCost = cost + inner.get(x);
                if(distance[x]>newCost) {//Меняем длину пути, только если она меньше
                    distance[x] = newCost;
                    parents[x] = now;//Записываем откуда мы пришли в эту вершину
                }

            }
        }
        if(distance[finish] == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        String answer = " " + finish;
        int index = parents[finish];
        while (index!=-1){
            answer = " " + index + answer;
            index = parents[index];
        }
        System.out.println(answer.substring(1,answer.length()));

    }
    //Функция для нахождения непосещенной вершины с минимальным расстоянием(Возвращает индекс)
    static int minimum(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE;//Хранит минимальную длительность пути до вершины
        int index = Integer.MAX_VALUE;//Хранит индекс вершины с минимальным путем до нее
        for (int i = 1; i < distance.length; i++) {
            if(distance[i] < min && visited[i] == false){//Нам подходят только те вершины, которые еще не были обработаны
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
    //Функция для проверки, остались ли еще вершины, которые не обработаны
    static boolean isContains(boolean[] mas, boolean val){
        for (Boolean x: mas) {
            if(x==val)
                return true;
        }
        return false;
    }

}
