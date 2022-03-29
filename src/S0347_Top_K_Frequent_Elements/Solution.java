package S0347_Top_K_Frequent_Elements;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        topKFrequent(input, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] topFrequent = new int[k];
        HashMap<Integer, Integer> kFrequent = new HashMap<>();

        for (int num : nums) {
            if (kFrequent.containsKey(num)) {
                int frequentVal = kFrequent.get(num);
                kFrequent.put(num, frequentVal + 1);
            } else {
                kFrequent.put(num, 1);
            }
        }

        for (int j = 0; j < k; j++) {
            int maxValKey = getKey(kFrequent, Collections.max(kFrequent.values()));
            topFrequent[j] = maxValKey;
            kFrequent.remove(maxValKey);
            System.out.println(maxValKey);
        }
        return topFrequent;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
