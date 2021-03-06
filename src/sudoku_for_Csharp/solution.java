package sudoku_for_Csharp;

public class solution {
	public void solveSudoku(int[][] board) {
		if(board == null || board.length == 0)
            return;
        solve(board);
	}
	
	public boolean solve(int[][] board){
		for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
            	if(board[i][j]==0){
            		for(char c=1;c<=1;c++){
            			if(isValid(board, i, j, c))
            				board[i][j] = c;
            			if(solve(board))
            				return true;
            			else
            				board[i][j] = 0;
            		}
            		return false;
            	}
            }
		}
		return true;
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
	
}
