import java.io.*;
import java.util.*;

public class BOJ_1339 {
	static int N;
	static Map<Character, Integer> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //단어 개수 입력
		for(int i=0; i<N; i++) {
			String str = br.readLine(); //단어
			int tmp = 1; //1의 자릿수부터 자릿수를 곱해주기 위해 tmp 선언
			for (int j = str.length()-1; j >= 0 ; j--) {
				char word = str.charAt(j); //뒤에서부터 앞으로 알파벳 가져옴...
				
				if(!map.containsKey(word)) { //key가 없으면, tmp 그대로 map에 저장
					map.put(word, tmp);
				}else { //key가 이미 있으면, 해당 value와 tmp를 더해서 덮어씀
					map.put(word, map.get(word)+tmp);
				}
				
				tmp *= 10; //자릿수만큼 곱해준다
			}
		}

		//map의 value들을 배열로 만들어주고 내림차순으로 정렬
		Object[] mapValues = map.values().toArray();
		Arrays.sort(mapValues, Collections.reverseOrder());		
//		for (int i = 0; i < mapValues.length; i++) {
//			System.out.println(mapValues[i]);
//		}
		
		//큰 자릿수부터 9부터 차례로 곱해주며 sum을 구한다
		int num = 9, sum = 0;
		for (int i = 0; i < mapValues.length; i++) {
			sum += Integer.parseInt(mapValues[i].toString()) * num;
			num--;
		}

		System.out.println(sum);
	}

}
