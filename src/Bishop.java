
public class Bishop extends Piece {

	
	
	
	
	
	
	public Bishop(boolean tem, int V) {
		super(tem, V);

		this.availableCells = new Cell[28];
		if (tem == true) { // true = white false= black
			this.setName("wB");
			this.indexH = 7;
		} else {
			this.setName("bB");
			this.indexH = 0;
		}
		this.myBoard.newPieceInCell(this);
		this.searchAvailableCells();
	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
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
//		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchAvailableCells
		public void searchAvailableCells(){
			int numB1 = 1 ;
			int numB2 = 1 ;
			int numB3 = 1 ;
			int numB4 = 1 ;
			
			
			for (int i = 0; i < 28; i++) {
			if (i < 7) {
				if (this.testAvailabe(numB1 * -1, numB1, i)){
					numB1++;
				}else{
					this.FilterAvailable(i, 7);
					i = 7 ;
					continue;
				}
				
				
				
			} else if (i < 14) {
				if(this.testAvailabe(numB2 * -1, numB2 * -1, i)){
					numB2++;
				}else{
					this.FilterAvailable(i, 14);
					i= 14 ;
					continue;
				}
				
				
			} else if (i < 21) {
				if(this.testAvailabe(numB3, numB3 * -1, i)){
					numB3++;
				}else{
					this.FilterAvailable(i, 21);
					i= 21;
					continue;
				}

				
				
				
			} else if (i < 28) {
				if(this.testAvailabe(numB4, numB4, i)){
					numB4++;
				}else{
					this.FilterAvailable(i, 28);
					i= 28 ;
					continue;
				}

				
			}

			}
		}
//		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.FilterAvailable

		public void FilterAvailable ( int A, int numGrb){
		
				for (int k = A+1; k < numGrb; k++) {
					this.availableCells[k] = null;
				}
				

			
		}
//		
		
		
		
}
