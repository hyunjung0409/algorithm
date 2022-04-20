import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int[] nums = new int[commands[i][1] - commands[i][0] + 1]; //각 answer 길이 구함
            int idx = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) { //nums에 i번째부터 j번째까지 숫자 넣기
                nums[idx] = array[j];
                idx++;
            }
            Arrays.sort(nums); //정렬
            
            answer[i] = nums[commands[i][2] - 1]; //k번째 숫자 
        }
        
        return answer;
    }
}