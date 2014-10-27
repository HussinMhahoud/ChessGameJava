
public class Rook extends Piece {

	public Rook(boolean tem, int V) {
		super(tem, V);
		this.availableCells = new Cell[28];
		if (tem == true) { // true = white false= black
			this.setName("wR");
			this.indexH = 7;
		} else {
			this.setName("bR");
			this.indexH = 0;
		}
		this.myBoard.newPieceInCell(this);
		this.searchAvailableCells();
		// TODO Auto-generated constructor stub
	}// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public boolean testAvailabe(int H, int V, int A) { // H&V number want be bls of
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
             return false ;
		} else {

			this.availableCells[A] = myBoard.bordaCell[this.indexH + H][this.indexV
					+ V];
			 return false ;
		}
		return  true ;
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchAvailableCells
	public void searchAvailableCells(){
		int numB1 = 1 ;
		int numB2 = 1 ;
		int numB3 = 1 ;
		int numB4 = 1 ;
		
		
		for (int i = 0; i < 28; i++) {
		if (i < 7) {
			if (this.testAvailabe(numB1 , 0, i)){
				numB1++;
			}else{
				this.FilterAvailable(i, 7);
				i = 7 ;
				continue;
			}
			
			
			
		} else if (i < 14) {
			if(this.testAvailabe(numB2 * -1, 0, i)){
				numB2++;
			}else{
				this.FilterAvailable(i, 14);
				i= 14 ;
				continue;
			}
			
			
		} else if (i < 21) {
			if(this.testAvailabe(0, numB3 , i)){
				numB3++;
			}else{
				this.FilterAvailable(i, 21);
				i= 21;
				continue;
			}

			
			
			
		} else if (i < 28) {
			if(this.testAvailabe(0, numB4*-1, i)){
				numB4++;
			}else{
				this.FilterAvailable(i, 28);
				i= 28 ;
				continue;
			}

			
		}

		}
		
		
		
		
		
		
		
		
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.FilterAvailable

	public void FilterAvailable ( int A, int numGrb){
	
			for (int k = A+1; k < numGrb; k++) {
				this.availableCells[k] = null;
			}
			

		
	}
//	

	
}
