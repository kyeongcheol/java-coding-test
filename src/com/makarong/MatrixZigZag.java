package com.makarong;


import java.util.Scanner;

/**
 * @author kcyang
 * 
 * README.md 참고
 * 
 * 1. 문제
 * 
 * n x n 크기의 행렬의 각 칸에 1 부터 n(2 제곱) 까지의 숫자가 지그재그 방향으로 채워져 있습니다. 다음은 n = 5 인 경우의 예시입니다.
 * 
 * 이때 r 행, c 열의 칸에 어떤 숫자가 적혀있는지 구하려고 합니다. 예를 들어 위 그림에서 r=3, c=2 인 경우 3행, 2열의 위치에는 9가 들어있습니다.
 * 지그재그 행렬의 크기 n, 행의 위치 r, 열의 위치 c가 매개변수로 주어질 떄, n x n 크기의 지그재그 행렬의 r 행 c 열에 들어있는 숫자를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 2. 제한사항
 * - n은 1 이상 10,000,000 이하의 자연수입니다.
 * - r과 c는 각각 1이상 n 이하의 자연수입니다.
 * - 정답이 2의 31제곱 -1 보다 커질 수 있음에 주의하세요. 
 * 
 * 3. 입출력 예시
 * 
 * #1 n=5, r=3, c=2 result 9
 * #2 n=6, r=5, c=4 result 29
 * 
 * 출처 : 마카롱팩토리 코딩테스트 (프로그래머스)
 */
public class MatrixZigZag {
	
	public long solution(int n, int r, int c) {

        int row = n;
        int col = n;
        
        int [][] array = new int[row][col];
        
        // 배열에 입력할 증가값 
        int cnt = 1;
         
        // 배열의 현재 위치 
        int x = 0;
        int y = 0;

        boolean up = true;		// 배열의 방향
        
        System.out.println("===cnt=== " +cnt);
        array[x][y] = cnt++;	// 배열 초기화
        
        System.out.println("===배열 초기화 === " + array[0][0]);
        int total = col*row;	
        
        while(cnt <= total) {
             
        	// 2차원 배열의 오른쪽 끝에 도달하는 경우
            if(x == col-1 && cnt <= total) {
                array[++y][x]= cnt++;
                up = false;
            } 
            
            // 2차원 배열의 아래쪽 끝에 도달하는 경우
            if(y == row-1 && cnt <= total) {
            	array[y][++x] = cnt++;
            	up = true;
            }
            
            // 2차원 배열의 위쪽 끝에 도달하는 경우
            if(y == 0 && cnt <= total){
            	array[y][++x] = cnt++;
            	up = false;
            }
            
            // 2차원 배열의 왼쪽 끝에 도달하는 경우
            if(x == 0 && cnt <= total) {
            	array[++y][x] = cnt++;
            	up = true;
            }
            
            // 그 외 방향이 up 인 경우
            if(up && x != col-1 && y != 0 && cnt <= total) {
            	array[--y][++x] = cnt++;
            }
            
            // 그 외 방향이 down 인 경우
            if(!up && y != row-1 && x !=0 && cnt <= total) {
            	array[++y][--x] = cnt++;
            }
            
        } 
        
        for(int i=0; i < row; i++) {
            for(int j=0; j < col; j++) {
                System.out.printf("%d ", array[i][j]);
            }
             
            System.out.println("\n");
        }
        
        long answer = array[r-1][c-1];
        return answer;
    }
	
	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();
        in.close();
        
        MatrixZigZag zigzag = new MatrixZigZag();
        long answer = zigzag.solution(n, r, c);
        
        System.out.println("===answer=== " + answer);
		
        
	}
        
}
