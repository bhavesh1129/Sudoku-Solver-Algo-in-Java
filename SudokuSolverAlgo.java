import java.util.Arrays;

public class Sudoku {

	public static void main(String[] args) {
		int[][] board = {
				  { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
				  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
				  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
				  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
				  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
				  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
				  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
				  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
				  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
				};
		sudoku(board,0,0);
	}
	
	public static void sudoku(int[][] board,int row,int col) {
		if(row==9) {
			//Printing Board
			for(int i=0;i<9;i++) {
				System.out.println(Arrays.toString(board[i]));
			}
			return;
		}
		//If we completed current row,go to the next row
		if(col==9) {
			sudoku(board,row+1,0);
			return;
		}
		//If current item is blank
		if(board[row][col]==0) {
			for(int i=1;i<=9;i++) {
				if(isSafe(board,row,col,i)) {
					board[row][col]=i;
					sudoku(board,row,col+1);
					board[row][col]=0;
				}
			}
		}else {
			sudoku(board,row,col+1);
		}
		
	}
	public static boolean isSafe(int[][] board, int row, int col, int value) {
		for(int c=0;c<9;c++) {
			if(board[row][c]==value) {
				return false;
			}
		}
		for(int r=0;r<9;r++) {
			if(board[r][col]==value) {
				return false;
			}
		}
		int rowChunk=row/3;
		int colChunk=col/3;
		for(int R=rowChunk*3;R<(rowChunk+1)*3;R++) {
			for(int C=colChunk*3;C<(colChunk+1)*3;C++) {
				if(board[R][C]==value) {
					return false;
				}
			}
		}
		return true;
	}

}
