//프로그래머스 주식가격 레벨2 15분
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i = 0 ; i < prices.length; i++ ){
            int cnt = 0;
            int standard = prices[i];
            
            for(int j = i+1 ; j < prices.length; j++){
                cnt++;
                if(prices[j] < standard ){
                    break;
                }
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}