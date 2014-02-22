
public class Pawn extends Piece {
//	private int numOfMov ;

	
	
	
	
	public Pawn(boolean tem , int V){
		super(tem,V);
		
		this.availableCells = new Cell [4];
		if (tem== true){  // true = white  false= black
			this.setName("wP");
			this.indexH = 6 ;
		}else{
			this.setName("bP");
			this.indexH = 1 ;
		}
		this.myBoard.newPieceInCell(this) ;
		this.searchAvailableCells() ;
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>...testAvailabe
	public void testAvailabe(int H, int V, int A) { // H&V number want be bls of
													// indH &indV A = index
		if ((this.indexH + H) >= 8 || (this.indexV + V) >= 8 || (this.indexV + V) < 0 || (this.indexH + H) < 0) {
			this.availableCells[A] = null;
			
		}else if(myBoard.bordaCell[this.indexH + H][this.indexV+ V].cellPiece == null){          // if cell null 
			if(myBoard.bordaCell[this.indexH + H][this.indexV+ V].getIndV()!= this.indexV){// this problem
				this.availableCells[A] = null;
			}else{
				this.availableCells[A] = myBoard.bordaCell[this.indexH + H][this.indexV+ V];
				
			}
			
		}else if(myBoard.bordaCell[this.indexH + H][this.indexV+ V].cellPiece.team == this.team) {
			this.availableCells[A] = null;
		}else if (myBoard.bordaCell[this.indexH + H][this.indexV+ V].getIndV() == this.indexV){
			this.availableCells[A] = null;
		}
		else{
			
			this.availableCells[A] = myBoard.bordaCell[this.indexH + H][this.indexV+ V];
		}
		return ;
	}
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>searchAvailableCells
	public void searchAvailableCells(){
		int numAvailabe = 4 ;
		
		if (this.team) {
		    if (this.indexH !=6){
		    	numAvailabe = 3 ;
		    }
		}else{
			if (this.indexH !=1 ){
				numAvailabe = 3 ;
			}
		}
		
		
		
		
		int checPlayer = 1 ;    // this to use with all team
		if (this.team==false){
			checPlayer = -1  ;
		}

		for (int i = 0; i < numAvailabe; i++) {
			switch (i) {
			case 0:
				this.testAvailabe((checPlayer * -1), (0 * checPlayer), i);
				break;
			case 1:
				this.testAvailabe((checPlayer * -1), 1 * checPlayer, i);
				break;
			case 2:
				this.testAvailabe(-1 * checPlayer, -1 * checPlayer, i);
				break;
			case 3:
				if (this.testFirsetCell((checPlayer * -1), (0 * checPlayer))) {
					this.testAvailabe(-2 * checPlayer, 0 * checPlayer, i);
				} else {
					this.availableCells[3] = null;
				}

				break;
			default:
				break;
			}
			
		}
		this.Upgrade();
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
	public boolean testFirsetCell(int H, int V) { // H&V number want be bls of
		// indH &indV A = index
if ((this.indexH + H) >= 8 || (this.indexV + V) >= 8 || (this.indexV + V) < 0 || (this.indexH + H) < 0) {
        this.availableCells[0] = null;

}else if(myBoard.bordaCell[this.indexH + H][this.indexV+ V].cellPiece == null){
	return true ;
}

return false ;

	}	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.Upgradepawn
	private void Upgrade (){
		if (this.indexH == 0 || this.indexH == 7) {
			myBoard.bordaCell[this.indexH][this.indexV].cellPiece = new Queen(this.team, this.indexV, this.indexH) ;
		}
	}
	
	
	

}
