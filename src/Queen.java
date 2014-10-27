
public class Queen extends Piece {
	
	
	

	public Queen(boolean tem, int V) {
		super(tem, V);
		this.availableCells = new Cell[56];
		if (tem == true) { // true = white false= black
			this.setName("wQ");
			this.indexH = 7;
		} else {
			this.setName("bQ");
			this.indexH = 0;
		}
		this.myBoard.newPieceInCell(this);
		this.searchAvailableCells();
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>to Upgradepawn
	public Queen(boolean tem, int V,int H) {
		super(tem, V);
		this.availableCells = new Cell[56];
		if (tem == true) { // true = white false= black
			this.setName("wQ");
			this.indexH = H;
		} else {
			this.setName("bQ");
			this.indexH = H;
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
//			>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchAvailableCells
			public void searchAvailableCells(){
				int numB1 = 1 ;
				int numB2 = 1 ;
				int numB3 = 1 ;
				int numB4 = 1 ;
				int numB5 = 1 ;
				int numB6 = 1 ;
				int numB7 = 1 ;
				int numB8 = 1 ;
				
				
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
//				>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				for (int i = 28; i < 56; i++) {
					if (i < 35) {
						if (this.testAvailabe(numB5 , 0, i)){
							numB5++;
						}else{
							this.FilterAvailable(i, 35);
							i = 35 ;
							continue;
						}
						
						
						
					} else if (i < 42) {
						if(this.testAvailabe(numB6 * -1, 0, i)){
							numB6++;
						}else{
							this.FilterAvailable(i, 42);
							i= 42 ;
							continue;
						}
						
						
					} else if (i < 49) {
						if(this.testAvailabe(0, numB7 , i)){
							numB7++;
						}else{
							this.FilterAvailable(i, 49);
							i= 49;
							continue;
						}

						
						
						
					} else if (i < 56) {
						if(this.testAvailabe(0, numB8*-1, i)){
							numB8++;
						}else{
							this.FilterAvailable(i, 56);
							i= 56 ;
							continue;
						}

						
					}

					}
				
				
				
			}
//			>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.FilterAvailable

			public void FilterAvailable ( int A, int numGrb){
			
					for (int k = A+1; k < numGrb; k++) {
						this.availableCells[k] = null;
					}
					

				
			}
	

}
