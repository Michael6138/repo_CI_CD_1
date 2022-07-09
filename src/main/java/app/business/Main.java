package app.business;

import java.util.*;

//Input: mat =
//        [[1,1,0,0,0],
//        [1,1,1,1,0],
//        [1,0,0,0,0],
//        [1,1,0,0,0],
//        [1,1,1,1,1]],
//        k = 3
//        Output: [2,0,3]
//        Explanation:
//        The number of soldiers in each row is:
//        - Row 0: 2
//        - Row 1: 4
//        - Row 2: 1
//        - Row 3: 2
//        - Row 4: 5
//        The rows ordered from weakest to strongest are [2,0,3,1,4].

/*
step 1


 */

public class Main {

    public static void main(String[] args) {

        int [] [] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}};

        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v1-v2);
        Map<Integer, Integer> indexRes = new LinkedHashMap<>();
        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    count++;
                }
            }
            indexRes.put(i, count);
            priorityQueue.add(count);
        }
        int idx = 0;
        int [] res = new int[k];
        while (k != 0){
            int num = priorityQueue.poll();
            int index = indexRes.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() == num).findFirst().get().getKey();
            res[idx++] = index;
            indexRes.remove(index);
            k--;
        }
        return res;

    }

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
