// PGS/괄호 변환/1시간 20분

import java.util.*;

class Solution {
    int index;
    
    public String solution(String p) {
        // if(p.length() == 0){
        //     return p;
        // }   
        if(p.isEmpty()) //문자열 길이가 0일 때, true 반환
            return p;
            
        boolean correct = isCorrect(p);
        String u = p.substring(0, index);
        String v = p.substring(index, p.length());
        
        if(correct){
            return u + solution(v);
        }
        
        String answer = "(" + solution(v) + ")";
        for(int i = 1; i < u.length() - 1; i++){
            if(u.charAt(i) == '('){
                answer += ")";
            }else{
                answer += "(";
            }
        }
        
        return answer;
        
    }
    
    boolean isCorrect(String str){
        boolean flag = true; //올바른 괄호 문자열인지 체크하는 변수
        int left = 0, right = 0; //최소 균형잡힌 괄호 문자열 찾기위한 변수
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
                st.push('(');
            }else{
                right++;
                if(st.isEmpty()){
                    flag = false;
                }else{
                    st.pop();
                }
            }
            
            if(left == right){
                index = i + 1; //u의 length, v의 시작위치
                return flag;
            }
        }
        
        return flag;
    }
    
}