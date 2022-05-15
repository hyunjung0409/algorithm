//테케 미통과

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            q.add((100-progresses[i])%speeds[i] == 0 ? (100-progresses[i]/speeds[i]) : ((100-progresses[i])/speeds[i] + 1));
        }

        int start = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            int next = q.poll();
            if(start >= next){
                cnt++;
            }else{
                result.add(cnt);
                start = next;
                cnt = 1;
            }
        }
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.poll();
        }
        
        return answer;
    }
}