import java.util.Scanner;



public class Board {
	public Cell[][] bordaCell = new Cell[8][8];
	private char[] lettersV;
	private char[] numberH;
//	public Scanner input;
	private Cell fristCell;
	private Cell secndCell;
	public String inputuser;
	private Pawn[] pawns;
	private King[] kings;
	private Queen[] Queens;
	private Bishop[] Bishops;
	private Knight[] Knights;
	private Rook[] Rooks;

	// >>>>>>>>>>>>>only one object
	private static volatile Board myBoard;

	private Board() {
		this.lettersV = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
		this.numberH = new char[] { '8', '7', '6', '5', '4', '3', '2', '1' };
//		this.input = new Scanner(System.in);
		this.pawns = new Pawn[16];
		this.kings = new King[2];
		this.Queens = new Queen[2];
		this.Rooks = new Rook[4];
		this.Knights = new Knight[4];
		this.Bishops = new Bishop[4];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.bordaCell[i][j] = new Cell(i, j);
			}
		}

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>sort pieces
	public void sortPieces() {
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Pawns
		for (int j = 0; j < 16; j++) {
			if (j < 8) {
				this.pawns[j] = new Pawn(true, j);
			} else {
				this.pawns[j] = new Pawn(false, 15 - j);
			}
		}
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>> kings & Queens
		for (int j = 0; j < 2; j++) {
			boolean tm = true;
			if (j > 0) {
				tm = false;
			}
			kings[j] = new King(tm, 4);
			Queens[j] = new Queen(tm, 3);
		}
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Rook & Knight & Bishop
		this.sortRookKnightBishop(0, true);
		this.sortRookKnightBishop(2, false);
	}

	private void sortRookKnightBishop(int i, boolean tm) {
		for (int j = 0; j < 2; j++) {
			int indv = 0; // 1st place
			if (j > 0) {
				indv = 7; // 2nd place
			}
			Rooks[i + j] = new Rook(tm, indv);
		}

		for (int j = 0; j < 2; j++) {
			int indv = 1;
			if (j > 0) {
				indv = 6;
			}
			Knights[i + j] = new Knight(tm, indv);
		}

		for (int j = 0; j < 2; j++) {
			int indv = 2;
			if (j > 0) {
				indv = 5;
			}
			Bishops[i + j] = new Bishop(tm, indv);
		}

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> to get the object of
	// college
	public static Board getmyBoard() {
		if (myBoard == null) {
			myBoard = new Board();
		}
		return myBoard;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void showBoard() {

		for (int i = 0; i < 8; i++) {
			if (i == 0) {
				System.out.print(" ");
			}
			System.out.print(" " + this.lettersV[i] + " ");
		}
		System.out.println("");
		for (int i = 0; i < 8; i++) {
			System.out.print(this.numberH[i] + " ");
			for (int j = 0; j < 8; j++) {
				System.out.print(this.bordaCell[i][j].visibleText + " ");

			}
			System.out.println("");

		}

		return;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>inputUsers.
	public void inputUsers(boolean player,Scanner inputuser) {

		while (true) {
			this.inputuser = inputuser.nextLine();
			this.inputuser = this.inputuser.toUpperCase();
			if (this.inputuser.length() != 5) {
				System.out.println("invalid movement");
				continue;
			}
				
			if (fundchar(this.inputuser.charAt(0), this.lettersV)== false
					|| fundchar(this.inputuser.charAt(3), this.lettersV)== false) {
				System.out.println("invalid movement");
				continue;
			}	
			
				
				
				if (fundchar(this.inputuser.charAt(1), this.numberH) == false
						|| fundchar(this.inputuser.charAt(4), this.numberH)== false) {
					System.out.println("invalid movement");
					continue;
				}
					this.fristCell = this.bordaCell[fundIndex(
							this.inputuser.charAt(1), this.numberH)][fundIndex(
							this.inputuser.charAt(0), this.lettersV)];
					this.secndCell = this.bordaCell[fundIndex(
							this.inputuser.charAt(4), this.numberH)][fundIndex(
							this.inputuser.charAt(3), this.lettersV)];
				
			
			
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			if (this.fristCell.cellPiece == null) {
				System.out.println("invalid movement");
				continue;
			} else if (this.fristCell.cellPiece.availableCells == null) {
				System.out.println("invalid movement");
				continue;
			}else if (this.fristCell.cellPiece.team != player) {
				System.out.println("invalid movement");
				continue;
			} 
			// >>>>>>>>>>>>>>>>>>>>>>>>>>
			if (testSecndCell()) {
				break;
			} else {
				System.out.println("invalid movement");
			}

		}

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean fundchar(char c, char[] a) {
		for (int i = 0; i < a.length; i++) {
			if (c == a[i]) {
				return true;
			}
		}
		return false;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public int fundIndex(char c, char[] a) {
		int z = 0;
		for (int i = 0; i < a.length; i++) {
			if (c == a[i]) {
				z = i;
			}
		}
		return z;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean testSecndCell() {
		for (int i = 0; i < this.fristCell.cellPiece.availableCells.length; i++) {
			if (this.fristCell.cellPiece.availableCells[i] == null) {
				this.fristCell.cellPiece.searchAvailableCells();
				continue;
			} else {
				this.fristCell.cellPiece.searchAvailableCells();
			}

			if (secndCell.equals(this.fristCell.cellPiece.availableCells[i])) { 
				return true;
			}

		}
		return false;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.to end game
	public boolean testLiveKings() {
		for (int i = 0; i < 2; i++) {
			if (this.kings[i].live == false) {
				return false;
			}
		}

		return true;

	}

	// ?>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void movePiece() {
		if (secndCell.cellPiece != null) {
			this.secndCell.cellPiece.live = false;
			//this.fristCell.cellPiece.searchAvailableCells();      // but that to no thing 
		}
		this.fristCell.cellPiece.searchAvailableCells();
		this.secndCell.comePiece(this.fristCell.cellPiece);
		this.fristCell.leavePiece();
		this.secndCell.cellPiece.searchAvailableCells();

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>newPiecein cell
	public void newPieceInCell(Piece p) {
		this.bordaCell[p.indexH][p.indexV].cellPiece = p;
		this.bordaCell[p.indexH][p.indexV].visibleText = p.getName();
	}
}
