package app.business.leetcode;

import java.util.*;
class Point {
    int i;
    int j;

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }


    @Override
    public String toString() {
        return "Point{" +
                ", i=" + i +
                ", j=" + j +
                '}';
    }
}

class PathNode {
    PathNode cameFrom;
    Point point;

    public PathNode(PathNode cameFrom, Point point) {
        this.cameFrom = cameFrom;
        this.point = point;
    }

    @Override
    public String toString() {
        return "PathNode{" +
                "cameFrom=" + cameFrom +
                ", point=" + point +
                '}';
    }
}

public class Tasks {

    public static void main(String[] args) {


//        System.out.println(validPath(10,
//               new int[][] {{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}},
//        1,
//        0));


//        System.out.println(validPath2(10,
//                new int[][] {{2,9},{7,8},{5,9},{7,2},{3,8},{2,8},{1,6},{3,0},{7,0},{8,5}},
//                1,
//                0));


    }
//first in first out - DFS

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjaency = new LinkedList<>();
        for(int i = 0; i < n; i++){
            adjaency.add(new LinkedList<>());
        }

        for(int i = 0; i < n; i++){
            List<Integer> g = adjaency.get(i);
            for(int j = 0; j < graph[i].length; j++){
                g.add(graph[i][j]);
            }
        }
        List<List<Integer>> listList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(graph[0][0]);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);
        seen[graph[0][0]] = true;
        while (!queue.isEmpty()) {
            // Get the current node.
            int node = queue.poll();

           //  Check if we have reached the target node.
            if (node == graph.length - 1) {

            }

            // Add all neighbors to the stack.
            for (int neighbor : adjaency.get(node)) {
                // Check if neighbor has been added to the queue before.
                if (!seen[neighbor]) {
                    seen[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();




    }


    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0){
            return true;
        }
        List<List<Integer>> adjaency = new LinkedList<>();
        for(int i = 0; i < n; i++){
            adjaency.add(new LinkedList<>());
        }

        for(int [] arr : edges){
            adjaency.get(arr[0]).add(arr[1]);
            adjaency.get(arr[1]).add(arr[0]);
        }

        LinkedList<Integer> q = new LinkedList<>();
        q.push(source);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()){
            int current = q.removeFirst();

            if(current == destination){
                return true;
            }
            if(visited.contains(current)){
                continue;
            }

            visited.add(current);

            List<Integer> neib = adjaency.get(current);
            for(int it : neib){
                q.push(it);
            }


        }
        return false;

    }


    public static boolean validPath2(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjacency_list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        boolean seen[] = new boolean[n];
        Arrays.fill(seen, false);

        while (!stack.isEmpty()) {
            // Get the current node.
            int node = stack.pop();

            // Check if we have reached the target node.
            if (node == destination) {
                return true;
            }

            // Check if we've already visited this node.
            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            // Add all neighbors to the stack.
            for (int neighbor : adjacency_list.get(node)) {
                stack.push(neighbor);
            }
        }
        return false;
    }
}
