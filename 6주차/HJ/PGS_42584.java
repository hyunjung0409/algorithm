//프로그래머스 주식가격 레벨2 효율성 실패
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> input = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        
        for(int i = 0 ; i < prices.length; i++ ){
            for(int j = i ; j < prices.length; j++){
                input.add(prices[j]);
            }
        
            int standard = input.poll();
            while(!input.isEmpty()){
                if(input.peek() >= standard){
                    temp.add(input.poll());
                }else{
                    temp.add(input.poll());
                    break;
                }
            }
            
            answer[i] = temp.size();
            input.clear();
            temp.clear();
        }
        
        return answer;
    }
}