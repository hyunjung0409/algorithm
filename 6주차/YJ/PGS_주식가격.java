import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Queue<Long> queue = new LinkedList<>();
        
        for (int i = 0; i < prices.length; i++) {
            queue.add(Long.valueOf(prices[i]));
        }
        
        int idx = 0;
        
        while(!queue.isEmpty()) {
            int cnt = 0;
            long stock = queue.poll();

            for (long next_stock : queue) {
                cnt++;
                if (stock > next_stock) {
                    break;
                }
              
            }
            // if (cnt == 0 && idx != prices.length - 1) {
            //     cnt = 1;
            // }
            answer[idx] = cnt;
            idx++;
            
        }
       
//         for (int i = 0; i < prices.length; i++) {
//             for (int j = i + 1; j < prices.length; j++) {
//                 answer[i]++;
                
//                 if (prices[i] > prices[j]) {
//                     break;
//                 }
//             }
//         }
        
        return answer;
    }
}