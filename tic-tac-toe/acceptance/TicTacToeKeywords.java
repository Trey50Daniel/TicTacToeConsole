import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe t;
	
	public void startNewGame() {
		t = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		t.playerMark(row, col);
	}
	
	public String getMark(int row, int col) {
		return t.boardArray[row][col].toString();
	}
    
	public String getWinner() {
		return "";
	}
}
