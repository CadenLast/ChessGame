package chess;

import javax.swing.ImageIcon;

public class Knight extends Piece {
	public Knight(String color, int x, int y) {
		super(color, x, y);
	}

	public boolean correctDirection(int x, int y) {
		if ((Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1)
				|| (Math.abs(this.x - x) == 1 && Math.abs(this.y - y) == 2)) {
			return true;
		}
		return false;
	}

	public boolean canMove(int x, int y, boolean realMove) {
		if (realMove) {
			if (willBeCheck(x, y)) {
				return false;
			}
		}
		if (Board.getSquare(x, y) == null) {
			return true;
		} else if (!(Board.getSquare(x, y).color.equals(this.color))) {
			return canTake(x, y, realMove);
		} else {
			return false;
		}
	}
	@Override
	public boolean canTake(int x, int y, boolean realMove) {
		if (!Board.getSquare(x, y).getColor().equals(color)) {
			if ((Math.abs(this.x - x) == 2 && Math.abs(this.y - y) == 1)
					|| (Math.abs(this.x - x) == 1 && Math.abs(this.y - y) == 2)) {
				return true;
			}
			return false;
		}
		return false;
	}

	public ImageIcon getIcon() {
		if (color.equals("Black")) {
			return new ImageIcon("C:Black_Knight.png");
		} else {
			return new ImageIcon("C:White_Knight.png");
		}
	}
}
