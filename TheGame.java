import java.util.Scanner;

public class TheGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Chess Game!");
		Scanner inputUser = new Scanner(System.in);
		Board myBoard = Board.getmyBoard();
//		myBoard.input = inputUser;
		myBoard.sortPieces();
		myBoard.showBoard();
		boolean playerWhoNow = true;
		System.out.println("============");
		System.out.println("White player:");
		System.out.println("============");
		while (myBoard.testLiveKings()) {
//			String frominputuser = inputUser.nextLine();
			myBoard.inputUsers(playerWhoNow,inputUser);
			myBoard.movePiece();
			myBoard.showBoard();
			if (playerWhoNow) {
				playerWhoNow = false;
				System.out.println("============");
				System.out.println("Black player:");
				System.out.println("============");
			} else {
				playerWhoNow = true;
				System.out.println("============");
				System.out.println("White player:");
				System.out.println("============");
			}
		}
		if (playerWhoNow) {
			System.out.println("Black player is winner.");
		} else {
			System.out.println("White player is winner.");
		}

	}

}
