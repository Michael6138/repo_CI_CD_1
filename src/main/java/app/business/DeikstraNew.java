package app.business;

import java.util.*;

class Edge {
    int destination;
    int weight;


    public Edge(int destination,int weight) {
        this.weight = weight;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", destination=" + destination +
                '}';
    }
}



public class DeikstraNew {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(allShortestPaths(
                10, new int[][]{{0,2,10},{0, 6, 3},{0, 1, 3}, {6, 4, 12}, {3, 7, 7}, {3, 0, 3}, {1, 3, 23}, {6, 3, 9} }, 0)));

    }

    public static int [] allShortestPaths(int n, int[][] edges, int start) {
        List<List<Edge>> adjacencyList = new LinkedList<>();
        int [] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;
        for(int i = 0; i < n; i++){
            adjacencyList.add(new LinkedList<>());
        }
        for(int [] arr : edges){
            adjacencyList.get(arr[0]).add(new Edge(arr[1], arr[2]));
        }

        LinkedList<Integer> q = new LinkedList<>();
        q.add(start);

        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()){
            int current = q.removeFirst();
            visited.add(current);
            List<Edge> neib = adjacencyList.get(current);
            Collections.sort(neib, Comparator.comparingInt(i -> i.weight));
            for(Edge i : neib){
                if(!q.contains(i.destination) && !visited.contains(i.destination)){
                    q.add(i.destination);
                }
              int currentResult = result[current] + i.weight;
                if(result[i.destination] == -1 || result[i.destination] > currentResult){
                    result[i.destination] = currentResult;
                }
            }
        }
        return result;
    }
}
