package com.makarong;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author kcyang
 * 
 * 1. 문제
 * 
 * 임의의 자연수 N이 주어질 때 각 자리의 숫자를 정렬하려고 합니다. 예를 들어 주어진 숫자 N = 2613 인 경우
 * 각 자릿수를 오름차순으로 정렬하면 1236이 되며, 내림차순으로 정렬하면 6321 이 되고, 두 숫자의 합은 7557 이 됩니다.
 * 임의의 자연수 N 이 매개변수로 주어질 때 N의 각 자릿수를 오름차순으로 정렬한 수와 내림차순으로 정렬한 수의 합을 return 하도록 solution 함수를 완성해주세요.
 * 
 * 2. 제한사항 : N 은 1 이상 10억 이하의 자연수입니다.
 * 
 * 3. 입출력 예시
 * 
 * #1 2613 의 각 자릿수를 오름차순 정렬하면 1236 이며, 내림차순 정렬하면 6321 입니다. 1236 + 6321 = 7557
 * #2 33285 의 각 자릿수를 오름차순 정렬하면 23358 이며, 내림차순 정렬하면 85332 입니다. 23358 + 85332 = 108690
 * 
 * 출처 : 마카롱팩토리 코딩테스트 (프로그래머스)
 */
public class OrderbySum {
	
	public int solution(int N) {
		
		System.out.println("===input data=== " + N);
		
		// integer to string -> string list
        String [] list = Integer.toString(N).split("");
        
        // 오름차순
        Arrays.sort(list);
        StringBuilder sb1 = new StringBuilder();
        for(String aList : list) sb1.append(aList);
        
        System.out.println("===ascending order=== " + sb1);

        // 내림차순
        Arrays.sort(list, Collections.reverseOrder());
        StringBuilder sb2 = new StringBuilder();
        for(String aList : list) sb2.append(aList);
        
        System.out.println("===descending order=== " + sb2);
        
        // string to integer
        int asc = Integer.parseInt(sb1.toString());
        int desc = Integer.parseInt(sb2.toString());

        // 오름차순 + 내림차순
        int answer = asc+desc;

        return answer;
        
    }
	
	public static void main(String [] args) {
		
		OrderbySum orderbySum = new OrderbySum();
//		int N = 1236;
		int N = 33285;
		int answer = orderbySum.solution(N);
		
		System.out.println("===sum=== " + answer);
	        
	}
}
