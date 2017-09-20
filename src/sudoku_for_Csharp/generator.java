package sudoku_for_Csharp;

import java.util.ArrayList;
import java.util.Random;

public class generator {
	static final int SIZE = 9;
	int[][] board;
	int[][] resboard;
	boolean flag = false;
	
	public generator() {
		board = new int[SIZE][SIZE];
		resboard = new int[SIZE][SIZE];
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++)
				board[i][j] = 0;
		}
		board[0][0] = 7;
	}
	
	public void generateN(int N){
		generateOne();
		for(int t=0;t<N;t++){
			int[][] tmp = new int[SIZE][SIZE];
			assign(resboard, tmp);
			change(tmp);
			for (int i = 0; i < 9; i++) {  
                for (int j = 0; j < 9; j++) {
                    System.out.print(tmp[i][j] + " ");  
                }  
                System.out.println();  
            }
			System.out.println();
		}
	}
	
	public void generateOne(){
		generate(1);
		flag = false;
	}
	private void generate(int num){
		if(flag)
			return;
		if(num==SIZE*SIZE){
			for (int i = 0; i < 9; i++) {  
                for (int j = 0; j < 9; j++) {
                	resboard[i][j] = board[i][j];
                    System.out.print(board[i][j] + " ");  
                }  
                System.out.println();  
            }  
			flag = true;
			return;
		}
		int x = num/9, y = num%9;
		if(board[x][y]==0){
			int i = 0;
			Random r = new Random();
			while(i<9){
				ArrayList<Integer> mylist = new ArrayList<Integer>(9);
				int m = r.nextInt(9)+1;
				while(mylist.contains(m))	m = r.nextInt(9)+1;
				mylist.add(m);
				i++;
				//System.out.println(x + " " + y + " " + m);
				if(isValid(board, x, y, m)){
					board[x][y] = m;
					generate(num+1);
				}
			}
			board[x][y] = 0;
		}else{
			generate(num+1);
		}
	}
	
	private boolean isValid(int[][] board, int row, int col, int c){
		for(int i=0;i<9;i++){
			if(board[i][col]!=0 && board[i][col]==c)	return false;
			if(board[row][i]!=0 && board[row][i]==c)	return false;
			
			int cube1 = 3*(row/3)+i/3, cube2 = 3*(col/3)+i%3;
			if(board[cube1][cube2]!=0 && board[cube1][cube2]==c)	return false;
		}
		return true;
	}
	
	public void change(int[][] board) {
		Random random = new Random();
		int rowtime = random.nextInt(10)+5;
		int coltime = random.nextInt(10)+5;
		int numtime = random.nextInt(15)+10;
		
		for(int i=0;i<numtime;i++){
			int x = random.nextInt(9)+1;
			int y = random.nextInt(9)+1;
			if(x!=y&&x!=7&&y!=7)
				swapnum(board, x, y);
			else
				--i;
		}
		for(int i=0;i<rowtime;i++){
			int base = 3*random.nextInt(3);
			int x = base + random.nextInt(3);
			int y = base + random.nextInt(3);
			if(x!=y&&x!=0&&y!=0)
				swaprow(board, x, y);
		}
		for(int i=0;i<coltime;i++){
			int base = 3*random.nextInt(3);
			int x = base + random.nextInt(3);
			int y = base + random.nextInt(3);
			if(x!=y&&x!=0&&y!=0)
				swapcol(board, x, y);
		}
		
	}
	
	public void swapnum(int[][] board,int i,int j){
		for(int x=0;x<9;x++){
			for(int y=0;y<9;y++){
				board[x][y] = (board[x][y]==i)?j:(board[x][y]==j)?i:board[x][y];
			}
		}
	}
	public void swaprow(int[][] board,int i,int j){
		int[] tmp = new int[9];
		tmp = board[i];
		board[i] = board[j];
		board[j] = tmp;
	}
	public void swapcol(int[][] board,int i,int j){
		int tmp = 0;
		for(int x=0;x<9;x++){
			tmp = board[x][i];
			board[x][i] = board[x][j];
			board[x][j] = tmp;
		}
	}
	public void assign(int[][] raw,int[][] a){
		for(int i=0;i<SIZE;i++){
			for(int j=0;j<SIZE;j++){
				a[i][j] = raw[i][j];
			}
		}
	}
	
	public static void main(String[] args){
		generator g = new generator();
		g.generateN(1000);
	}
}
