
public class King extends Piece {

	
	
	
	
	
	public King(boolean tem, int V) {
		super(tem, V);
		this.availableCells = new Cell [8];
		if (tem== true){  // true = white  false= black
			this.setName("wK");
			this.indexH = 7 ;
		}else{
			this.setName("bK");
			this.indexH = 0 ;
		}
		this.myBoard.newPieceInCell(this) ;
		this.searchAvailableCells() ;
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		public void testAvailabe(int H, int V, int A) { // H&V number want be bls of
			// indH &indV A = index
			if ((this.indexH + H) >= 8 || (this.indexV + V) >= 8
					|| (this.indexV + V) < 0 || (this.indexH + H) < 0) {
				this.availableCells[A] = null;

			} // ok

			else if (myBoard.bordaCell[this.indexH + H][this.indexV + V].cellPiece == null) { // if
																								// cell
																								// null

				this.availableCells[A] = myBoard.bordaCell[this.indexH + H][this.indexV
						+ V];

			} else if (myBoard.bordaCell[this.indexH + H][this.indexV + V].cellPiece.team == this.team) {
				this.availableCells[A] = null;

			} else {

				this.availableCells[A] = myBoard.bordaCell[this.indexH + H][this.indexV
						+ V];
			}
			return;
		}
		
//		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchAvailableCells
		public void searchAvailableCells(){
			
			
			for (int i = 0; i < 8; i++) {
				switch (i) {
				case 0:
					this.testAvailabe(-1, 0, i);
					break;
				case 1:
					this.testAvailabe(1,0, i);
					break;
				case 2:
					this.testAvailabe(0, 1, i);
					break;
				case 3:
					this.testAvailabe(0, -1, i);
					break;
				case 4:
					this.testAvailabe(-1, -1, i);
					break;
				case 5:
					this.testAvailabe(1, 1, i);
					break;
				case 6:
					this.testAvailabe(1, -1, i);
					break;
				case 7:
					this.testAvailabe(-1, 1, i);
					break;

				default:
					break;
				}
				
			}
		}
//		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
		

}
