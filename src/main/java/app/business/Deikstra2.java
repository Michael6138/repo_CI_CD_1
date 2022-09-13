package app.business;

import java.util.*;

class Point {
    int weight;
    int i;
    int j;

    Point(int i, int j, int weight) {
        this.weight = weight;
        this.i = i;
        this.j = j;
    }


    @Override
    public String toString() {
        return "Point{" +
                "weight=" + weight +
                ", i=" + i +
                ", j=" + j +
                '}';
    }
}

class PathNode {
    PathNode cameFrom;
    int costSum;
    Point point;

    public PathNode(PathNode cameFrom, int costSum, Point point) {
        this.cameFrom = cameFrom;
        this.costSum = costSum;
        this.point = point;
    }

    @Override
    public String toString() {
        return "PathNode{" +
                "cameFrom=" + cameFrom +
                ", costSum=" + costSum +
                ", point=" + point +
                '}';
    }
}

public class Deikstra2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int n = sc.nextInt();
        Point[][] arr = new Point[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new Point(i, j, 1 + random.nextInt(50));

            }

        }

        arr[0][0].weight = arr[n - 1][n - 1].weight = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j].weight + " ");
            }

            System.out.println();
        }

        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};//// up, left, down, right

        Point start = arr[0][0];

        PathNode[][] pathNodes = new PathNode[n][n];
        pathNodes[0][0] = new PathNode(null, 0, start);

        LinkedList<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Point cur = q.removeFirst();
            PathNode vpn = pathNodes[cur.i][cur.j];
            for (int[] move : moves) {
                try {
                    Point u = arr[cur.i + move[0]][cur.j + move[1]];
                    int curSum = vpn.costSum + u.weight;
                    PathNode upn = pathNodes[u.i][u.j];
                    if (upn == null) {
                        pathNodes[u.i][u.j] = new PathNode(vpn, curSum, u);
                        q.add(u);
                    } else if (curSum < upn.costSum) {
                        upn.cameFrom = vpn;
                        upn.costSum = curSum;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {

                }
            }

        }


        LinkedList<Point> path = new LinkedList<>();
        PathNode cur = pathNodes[n - 1][n - 1];
        while (cur.cameFrom != null) {
            path.addFirst(cur.point);
            cur = cur.cameFrom;
        }

        System.out.println(path);





    }

}




