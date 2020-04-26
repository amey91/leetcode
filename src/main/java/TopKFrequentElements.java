package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            // value to count
            // load factor of 0.75, prevent rehashing
            Map<Integer, Integer> map = new HashMap<>((int) (nums.length / 0.75 + 1));
            for(int i = 0; i < nums.length; i++) {

                // get (default or existing) + 1
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            // allocate initial capacity since it is already known to prevent rehashing
            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(
                            map.size(),
                            (e1, e2) -> {
                                return e1.getValue() - e2.getValue();
                            });

            for (Map.Entry<Integer, Integer> mapEntry: map.entrySet()) {
                pq.add(mapEntry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] result = new int[k];
            for (int i = 0; i<k; i++) {
                result[i]=pq.poll().getKey();
            }
            return result;
        }
    }
}
