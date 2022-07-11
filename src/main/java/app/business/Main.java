package app.business;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        int [] [] mat = {
//                {1,1,0,0,0},
//                {1,1,1,1,0},
//                {1,0,0,0,0},
//                {1,1,0,0,0},
//                {1,1,1,1,1}};
//
//        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));

        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 1));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(2, (v1, v2) -> v1-v2);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                priorityQueue.add(matrix[i][j]);
            }
        }
        if(priorityQueue.isEmpty()){
            return 0;
        }
        int res = -1;
        while (!priorityQueue.isEmpty() || k > 0){
            res = priorityQueue.poll();
            k--;
        }
        return res;
    }


//    public static int[] kWeakestRows(int[][] mat, int k) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v1-v2);
//        Map<Integer, Integer> indexRes = new LinkedHashMap<>();
//        for(int i = 0; i < mat.length; i++){
//            int count = 0;
//            for(int j = 0; j < mat[i].length; j++){
//                if(mat[i][j] == 1){
//                    count++;
//                }
//            }
//            indexRes.put(i, count);
//            priorityQueue.add(count);
//        }
//        int idx = 0;
//        int [] res = new int[k];
//        while (k != 0){
//            int num = priorityQueue.poll();
//            int index = indexRes.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() == num).findFirst().get().getKey();
//            res[idx++] = index;
//            indexRes.remove(index);
//            k--;
//        }
//        return res;
//
//    }

//    public static int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2-v1);
//        for(int v : stones){
//            priorityQueue.add(v);
//        }
//        while (priorityQueue.size() > 1){
//            int currentBiggest = priorityQueue.poll();
//            int currentBiggest2 = priorityQueue.poll();
//            priorityQueue.add(currentBiggest - currentBiggest2);
//
//        }
//        return priorityQueue.poll();
//
//    }

    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>()
        {

            public int compare(K k1, K k2)
            {

                int comp = map.get(k2).compareTo(map.get(k1));

                if (comp == 0)
                    return 1;

                else
                    return comp;
            }
        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }
}
