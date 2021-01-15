package chess;

import javax.swing.ImageIcon;

public class Pawn extends Piece {
	public Pawn(String color, int x, int y) {
		super(color, x, y);
	}

	public boolean correctDirection(int x, int y) {
		if (color.equals("White")) {
			if (y - this.y == 1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y) == null) {
				if (Board.getSquare(x, y - 1).enPassant()) {
					Board.getSquare(x, y - 1).taken();
					Board.setSquare(x, y - 1, null);
					Board.buttons[x][y - 1].setIcon(new ImageIcon(""));
					Board.buttons[x][y - 1].invalidate();
					Board.buttons[x][y - 1].revalidate();
					Board.buttons[x][y - 1].repaint();
					Board.setNull(x, y - 1);
					return true;
				}
			} else if (y - this.y == 1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y).getColor() == "Black") {
				return true;
			} else if (y - this.y == 1 && this.x == x) {
				return true;
			} else if (this.y == 1 && this.x == x) {
				if (y == 3 && this.x == x) {
					enPassant = true;
					return true;
				}
			}
		} else if (color.equals("Black")) {
			if (y - this.y == 1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y) == null) {
				if (Board.getSquare(x, y + 1).enPassant()) {
					Board.getSquare(x, y + 1).taken();
					Board.setSquare(x, y + 1, null);
					Board.buttons[x][y + 1].setIcon(new ImageIcon(""));
					Board.buttons[x][y + 1].invalidate();
					Board.buttons[x][y + 1].revalidate();
					Board.buttons[x][y + 1].repaint();
					Board.setNull(x, y + 1);
					return true;
				}
			} else if (y - this.y == -1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y).getColor() == "White") {
				return true;
			} else if (y - this.y == -1 && this.x == x) {
				return true;
			} else if (this.y == 6 && this.x == x) {
				if (y == 4 && this.x == x) {
					enPassant = true;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean canMove(int x, int y, boolean realMove) {
		if (realMove) {
			if (willBeCheck(x, y)) {
				return false;
			}
		}
		if (color.equals("White")) {
			if (Board.isEmpty(x, y) == true) {
				return true;
			} else if (y - this.y == 1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y).getColor() == "Black") {
				return true;
			}
		}
		if (color.equals("Black")) {
			if (Board.isEmpty(x, y) == true) {
				return true;
			} else if (y - this.y == -1 && Math.abs(x - this.x) == 1 && Board.getSquare(x, y).getColor() == "White") {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canTake(int x, int y, boolean realMove) {
		if (Board.getSquare(x, y).color != this.color) {
			if (color.equals("White")) {
				if ((Math.abs(x - this.x) == 1) && (y - this.y == 1)) {
					return true;
				}
			} else if (color.equals("Black")) {
				if ((Math.abs(x - this.x) == 1) && (y - this.y == -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public ImageIcon getIcon() {
		if (color.equals("Black")) {
			return new ImageIcon("C:Black_Pawn.png");
		} else {
			return new ImageIcon("C:White_Pawn.png");
		}
	}

}
