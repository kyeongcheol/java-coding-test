package com.makarong;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kcyang
 * 
 * 1. 문제
 * 
 * 단어 퍼즐은 주어진 단어 조각들을 이용해서 주어진 문장을 완성하는 퍼즐입니다. 이때, 주어진 각 단어 조각들은 각각 무한개씩 있다고 가정합니다. 
 * 예를 들어 주어진 단어 조각이 [“ba”, “na”, “n”, “a”]인 경우 "ba", "na", "n", "a" 단어 조각이 각각 무한개씩 있습니다. 
 * 이때, 만들어야 하는 문장이 “banana”라면 “ba”, “na”, “n”, “a”의 4개를 사용하여 문장을 완성할 수 있지만, “ba”, “na”, “na”의 3개만을 사용해도 “banana”를 완성할 수 있습니다. 
 * 사용 가능한 단어 조각들을 담고 있는 배열 strs와 완성해야 하는 문자열 t가 매개변수로 주어질 때, 주어진 문장을 완성하기 위해 사용해야 하는 단어조각 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 
 * 만약 주어진 문장을 완성하는 것이 불가능하면 -1을 return 하세요.
 * 
 * 2. 제한사항
 * 
 * - strs는 사용 가능한 단어 조각들이 들어있는 배열로, 길이는 1 이상 100 이하입니다.
 * - strs의 각 원소는 사용 가능한 단어조각들이 중복 없이 들어있습니다.
 * - 사용 가능한 단어 조각들은 문자열 형태이며, 모든 단어 조각의 길이는 1 이상 5 이하입니다.
 * - t는 완성해야 하는 문자열이며 길이는 1 이상 20,000 이하입니다.
 * - 모든 문자열은 알파벳 소문자로만 이루어져 있습니다.
 * 
 * 
 * 3. 입출력 예시
 * 
 * #1 strs : ["ba","na","n","a"] , t : "banana", result : 3
 * #2 strs : ["app","ap","p","l","e","ple","pp"], t: "apple", result : 2
 * #3 strs : ["ba","an","nan","ban","n"], t: "banana", result : -1
 * 
 *
 */
public class WordPuzzle {
	
	String t;           // 완성 문자열
    String[] strs;      // 사용 가능한 단어 조각
    int dp[];           // i번째부터 단어의 마지막까지 문자열을 만드는 최소 횟수
    
    // 문자열의 길이 순 정렬 : 긴 단어를 우선적으로 채우도록 정렬
    // Comparator 익명클래스 사용
    Comparator<String> c = new Comparator<String>() { 
        public int compare(String s1, String s2) { 
            return Integer.compare(s2.length(), s1.length()); 
        } 
    };

    
    public int result(int idx){
        
        if(idx == t.length())
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        // dp[idx] 초기화, t 의 최대 길이는 20,000 이하이므로 20001 로 초기화
        dp[idx] = 20001;
        for(int i=0; i<strs.length; i++){
            
            // 현재 만들어진 문자열 + 새로운 퍼즐의 크기 < 단어의 길이
            if(idx + strs[i].length() <= t.length()){
            	
                boolean flag = true;
                for(int j = 0; j < strs[i].length(); j++) {
                    if(t.charAt(idx + j) != strs[i].charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) 
                    dp[idx] = Math.min(dp[idx], result(idx + strs[i].length()) + 1);
            }
        }
        return dp[idx];
    }
    
    public int solution(String[] strs, String t) {
        
    	// dp 배열 초기화
        dp = new int[t.length()];
        Arrays.fill(dp, -1);
        Arrays.sort(strs, c);		// 긴 단어로 정렬 : Arrays.sort(string 배열, Comparator Interface)
        
        this.strs = strs; 
        this.t = t;
        
        int answer = result(0);
        return answer = (answer <= 20000) ? answer : -1;
    }
    
    public static void main(String [] args) {
    	
    	String[] strs = {"ba", "na", "n", "a"};
    	String t = "banana";
    	WordPuzzle wordPuzzle = new WordPuzzle();
    	int answer;
    	answer = wordPuzzle.solution(strs, t);
    	
    	System.out.println("answer" + answer);
    }

}
