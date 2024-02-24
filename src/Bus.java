import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Bus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        visited[0] = true;

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        int[] mas = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = mas[0];
        int finish = mas[1];
        distance[start] = 0;

        int R = Integer.parseInt(br.readLine());
        HashMap<Integer, HashMap<Integer, ArrayList<int[]>>> roads = new HashMap<>();
        //В ArrayList хранятся данные о всех рейсах из одного города в другой
        for (int i = 0; i < R; i++) {
            mas = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int from = mas[0];//Откуда
            int departure = mas[1];//Время отправления
            int to = mas[2];//Куда
            int arrive = mas[3];//Время прибытия
            roads.computeIfAbsent(from, f -> new HashMap<Integer, ArrayList<int[]>>());
            //roads.get(from).put(to, new int[]{departure,arrive});
            roads.get(from).computeIfAbsent(to, f -> new ArrayList<>());
            roads.get(from).get(to).add(new int[]{departure, arrive});
        }

        while (isContains(visited, false)) {
            int now = minimum(distance, visited);
            if (!roads.containsKey(now) || now == Integer.MAX_VALUE)
                break;
            visited[now] = true;
            int time = distance[now];
            HashMap<Integer, ArrayList<int[]>> inner = roads.get(now);
            for (Integer x : inner.keySet()) {
                for (int[] y : inner.get(x)) {
                    int departure = y[0];
                    int arrive = y[1];
                    if (departure >= time) {//Проверяем только те рейсы, на которые мы успеваем
                        if (distance[x] > arrive) {//Обновляем время, только если оно лучше
                            distance[x] = arrive;
                        }
                    }
                }
            }
        }

        if (distance[finish] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(distance[finish]);


    }
    static int minimum ( int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE;//Хранит минимальную длительность пути до вершины
        int index = Integer.MAX_VALUE;//Хранит индекс вершины с минимальным путем до нее
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < min && visited[i] == false) {//Нам подходят только те вершины, которые еще не были обработаны
                min = distance[i];
                index = i;
            }
        }
        return index;
    }
    static boolean isContains ( boolean[] mas, boolean val){
        for (Boolean x : mas) {
            if (x == val)
                return true;
        }
        return false;
    }
}

