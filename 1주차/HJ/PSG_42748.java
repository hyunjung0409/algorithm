import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    
        for(int n=0; n<commands.length; n++){
            List<Integer> list = new ArrayList<>();
            for(int m=commands[n][0]-1; m<commands[n][1]; m++){
                list.add(array[m]);
            }
            Collections.sort(list);
            answer[n] = list.get(commands[n][2]-1);
        }

        return answer;
    }
    
}