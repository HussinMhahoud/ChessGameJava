public class Piece {
	private String name;
	public int indexH;
	public int indexV;
	public boolean team; // player2 Black = false , player1 White = true
	public boolean live; // Died = false live = true
	public Cell myCell;
	public Cell [] availableCells ;
	public Board myBoard ;
	
	
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>constructor
	public  Piece(boolean tem,  int V) {   // every piece it know thim indexh when it new
		myBoard = Board.getmyBoard();
		this.team = tem ;
		this.live = true ;
		this.indexV = V ;
		
	}
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void diedPiece(){
		this.live = false ;
		return;
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void searchAvailableCells(){
//		i want this in all pieces  but that different to every one
	}
//	>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
