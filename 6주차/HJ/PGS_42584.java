//프로그래머스 주식가격 레벨2 효율성 실패
//프로그래머스 주식가격 레벨2 
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> input = new LinkedList<>();
        
        for(int i = 0 ; i < prices.length; i++ ){
            for(int j = i ; j < prices.length; j++){
                input.add(prices[j]);
            }
        
            int standard = input.poll();
            int cnt=0;
            while(!input.isEmpty()){
                cnt++;
                if(input.poll() < standard){
                    break;
                }
                
            }
            
            answer[i] = cnt;
            input.clear();
        }
        
        return answer;
    }
}