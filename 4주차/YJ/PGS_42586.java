import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.add(progresses[i]); //기능의 작업진도를 큐에 넣음
        }
        
        int idx = 0;
        int max_days;
        
        //첫번째 기능의 작업일수를 max_days에 초기화
        if ((100 - queue.peek()) % speeds[idx] == 0) {
            max_days = (100 - queue.peek()) / speeds[idx];
        }
       else {
            max_days = (100 - queue.peek()) / speeds[idx] + 1;
        }
        
        idx++;
        int cnt = 1;
        queue.remove();
        
        while(!queue.isEmpty()) {
            int days = 0;
            if ((100 - queue.peek()) % speeds[idx] == 0) {
                days = (100 - queue.peek()) / speeds[idx];
            }
            else {
                days = (100 - queue.peek()) / speeds[idx] + 1;
            }
            idx++;
            
            //max_days보다 작업일수가 크면 앞의 작업과 같이 배포할 수 없으므로 max_days 갱신, 앞의 작업들을 배포한다는 의미에서 answers에 cnt값 추가, cnt는 다시 1로 초기화
            if (max_days < days) {
                max_days = days;
                answer.add(cnt);
                cnt = 1;
                queue.remove();
            }
            //작업일수가 max_days보다 작으면 앞의 작업과 같이 배포할 수 있다는 뜻이므로 cnt 증가
            else {
                cnt++;
                queue.remove();
            }
            
        }
        
        answer.add(cnt);
        
        
        int[] result = new int[answer.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}