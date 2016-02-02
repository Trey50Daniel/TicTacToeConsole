package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;
import edu.jsu.mcis.TicTacToe.positionState;
import edu.jsu.mcis.TicTacToe.theWinner;

public class TicTacToeTest {
	
	private TicTacToe t;
	@Before
	public void setup() {
		t = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		positionState[][] testBoardArray = t.boardArray.clone();
		positionState initialBoardValue = positionState.Blank;
		positionState s;
		for (int j = 0; j<testBoardArray[0].length; j++){
			for (int i = 0; i<testBoardArray.length; i++){
				s = testBoardArray[i][j];
				assertEquals(initialBoardValue, s);
			}
		}
		
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		positionState[][] testBoardArray = t.boardArray.clone();
		testBoardArray[0][2] = positionState.X;
		positionState player1 = positionState.X;
		t.playerMark(0, 2);
		assertEquals(testBoardArray[0][2], t.boardArray[0][2]);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		positionState[][] testBoardArray = t.boardArray.clone();
		testBoardArray[2][0] = positionState.O;
		positionState player2 = positionState.O;
		t.playerMark(2, 0);
		assertEquals(testBoardArray[2][0], t.boardArray[2][0]);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		t.playerMark(0, 0);
		t.playerMark(0, 0);
		assertEquals(positionState.X, t.boardArray[0][0]);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		positionState player1 = positionState.X;
		t.playerMark(0, 0);
		theWinner winningPlayer = t.checkWinner(0, 0);
		assertEquals(theWinner.NONE, winningPlayer);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		positionState player1 = positionState.X;
		positionState player2 = positionState.O;
		theWinner thisDudeWon;
		t.playerMark(0, 0);
		thisDudeWon = t.checkWinner(0, 0);
		t.playerMark(1, 1);
		thisDudeWon = t.checkWinner(1, 1);
		t.playerMark(0, 1);
		thisDudeWon = t.checkWinner(0, 1);
		t.playerMark(1, 2);
		thisDudeWon = t.checkWinner(1, 2);
		t.playerMark(0, 2);
		thisDudeWon = t.checkWinner(0, 2);
		assertEquals(theWinner.X, thisDudeWon);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		positionState player1 = positionState.X;
		positionState player2 = positionState.O;
		theWinner thisDudeWon;
		t.playerMark(1, 1);
		thisDudeWon = t.checkWinner(1, 1);
		t.playerMark(0, 0);
		thisDudeWon = t.checkWinner(0, 0);
		t.playerMark(2, 0);
		thisDudeWon = t.checkWinner(2, 0);
		t.playerMark(0, 2);
		thisDudeWon = t.checkWinner(0, 2);
		t.playerMark(0, 1);
		thisDudeWon = t.checkWinner(0, 1);
		t.playerMark(2, 1);
		thisDudeWon = t.checkWinner(2, 1);
		t.playerMark(1, 2);
		thisDudeWon = t.checkWinner(1, 2);
		t.playerMark(1, 0);
		thisDudeWon = t.checkWinner(1, 0);
		t.playerMark(2, 2);
		thisDudeWon = t.checkWinner(2, 2);
	}

	@Test
	public void testGameIsWonByXDiagonally() {
		positionState player1 = positionState.X;
		positionState player2 = positionState.O;
		theWinner thisDudeWon;
		t.playerMark(1, 1);
		thisDudeWon = t.checkWinner(1, 1);
		t.playerMark(0, 1);
		thisDudeWon = t.checkWinner(0, 1);
		t.playerMark(0, 0);
		thisDudeWon = t.checkWinner(0, 0);
		t.playerMark(0, 2);
		thisDudeWon = t.checkWinner(0, 2);
		t.playerMark(2, 2);
		thisDudeWon = t.checkWinner(2, 2);
		assertEquals(theWinner.X, thisDudeWon);
	}
	
	@Test
	public void testGameIsWonByOHorizontally() {
		positionState player1 = positionState.X;
		positionState player2 = positionState.O;
		theWinner thisDudeWon;
		t.playerMark(1, 1);
		thisDudeWon = t.checkWinner(1, 1);
		t.playerMark(2, 0);
		thisDudeWon = t.checkWinner(2, 0);
		t.playerMark(0, 0);
		thisDudeWon = t.checkWinner(0, 0);
		t.playerMark(2, 2);
		thisDudeWon = t.checkWinner(2, 2);
		t.playerMark(0, 2);
		thisDudeWon = t.checkWinner(0, 2);
		t.playerMark(2, 1);
		thisDudeWon = t.checkWinner(2, 1);
		assertEquals(theWinner.O, thisDudeWon);
	}
}
