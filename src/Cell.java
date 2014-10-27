public class Cell {
	private boolean type; // Black = true , White = false
	private int indH;
	private int indV;
	public boolean status; // full = true , null = false
	public String visibleText;
	public Piece cellPiece;

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>constructor
	public Cell(int indexH, int indexV) {
		this.status = false;
		this.indH = indexH;
		this.indV = indexV;
		if (indexH % 2 == indexV % 2) {
			this.type = false;
		} else {
			this.type = true;
		}
		this.setvisibleText();

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void leavePiece() {
		this.cellPiece = null;
		this.status = false;
		this.setvisibleText();
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void comePiece(Piece pie) {
		this.cellPiece = pie;
		this.visibleText = pie.getName();
		this.status = true;
		this.cellPiece.indexH = this.indH;
		this.cellPiece.indexV = this.indV;
		this.cellPiece.myCell = this;
		return;
	}

	public int getIndH() {
		return indH;
	}

	public int getIndV() {
		return indV;
	}

	// >>>>>>>>>>>>>>>>>>>>>>>..
	public void setvisibleText() {
		if (this.type) {
			this.visibleText = "**";
		} else {
			this.visibleText = "..";
		}
		return;
	}

}
