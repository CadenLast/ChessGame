package chess;

import javax.swing.ImageIcon;

public class King extends Piece {

	public King(String color, int x, int y) {
		super(color, x, y);
	}

	public boolean correctDirection(int x, int y) {
		if ((Math.abs(x - this.x) == 1 && y - this.y == 0) || (x - this.x == 0 && Math.abs(y - this.y) == 1)
				|| (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == Math.abs(x - this.x))) {
			return true;
		} else if ((x - this.x == -2 && y - this.y == 0 && color.equals("Black"))&&!isCheck()) {
			if (castle && Board.getSquare(0, 7).canCastle()) {
				if (Board.getSquare(0, 7).canMove(3, 7, false) && !willBeCheck(3, 7) && !willBeCheck(2, 7)) {
					castleQueen();
					return false;
				}
			}
			return false;
		} else if ((x - this.x == -2 && y - this.y == 0 && color.equals("White")&&!isCheck())) {
			if (castle && Board.getSquare(0, 0).canCastle()) {
				if (Board.getSquare(0, 0).canMove(3, 0, false) && !willBeCheck(3, 0) && !willBeCheck(2, 0)) {
					castleQueen();
					return false;
				}
			}
			return false;
		} else if ((x - this.x == 2 && y - this.y == 0 && color.equals("Black"))&&!isCheck()) {
			if (castle && Board.getSquare(0, 7).canCastle()) {
				if (Board.getSquare(7, 7).canMove(5, 7, false) && !willBeCheck(5, 7) && !willBeCheck(6, 7)) {
					castleKing();
					return false;
				}
			}
			return false;
		} else if ((x - this.x == 2 && y - this.y == 0 && color.equals("White"))&&!isCheck()) {
			if (castle && Board.getSquare(7, 0).canCastle()) {
				if (Board.getSquare(7, 0).canMove(5, 0, false) && !willBeCheck(5, 0) && !willBeCheck(6, 0)) {
					castleKing();
					return false;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	public void castleQueen() {
		if (color.equals("Black")) {
			Piece rook = Board.getSquare(0, 7);
			Board.setNull(x, y);
			Board.setSquare(x - 2, y, this);
			Board.setSquare(x - 1, y, rook);
			rook.setX(x - 1);

			Board.buttons[x][y].setIcon(new ImageIcon(""));
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			Board.setNull(x, y);
			x-=2;
			Board.buttons[x][y].setIcon(getIcon());
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			
			Board.buttons[0][7].setIcon(new ImageIcon(""));
			Board.buttons[0][7].invalidate();
			Board.buttons[0][7].revalidate();
			Board.buttons[0][7].repaint();
			Board.setNull(0, 7);
			Board.buttons[3][7].setIcon(Board.getSquare(3,y).getIcon());
			Board.buttons[3][7].invalidate();
			Board.buttons[3][7].revalidate();
			Board.buttons[3][7].repaint();
			if (Board.turn.equals("White")) {
				Board.turn = "Black";
			} else {
				Board.turn = "White";
			}
			castle=false;
		}
		if (color.equals("White")) {
			Piece rook = Board.getSquare(7, 0);
			Board.setNull(x, y);
			Board.setSquare(x - 2, y, this);
			Board.setSquare(x - 1, y, rook);
			rook.setX(x - 1);

			Board.buttons[x][y].setIcon(new ImageIcon(""));
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			Board.setNull(x, y);
			x-=2;
			Board.buttons[x][y].setIcon(getIcon());
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			
			Board.buttons[0][0].setIcon(new ImageIcon(""));
			Board.buttons[0][0].invalidate();
			Board.buttons[0][0].revalidate();
			Board.buttons[0][0].repaint();
			Board.setNull(0, 0);
			Board.buttons[3][0].setIcon(Board.getSquare(3,y).getIcon());
			Board.buttons[3][0].invalidate();
			Board.buttons[3][0].revalidate();
			Board.buttons[3][0].repaint();
			if (Board.turn.equals("White")) {
				Board.turn = "Black";
			} else {
				Board.turn = "White";
			}
			castle=false;
		}
	}

	public void castleKing() {
		if (color.equals("Black")) {
			Piece rook = Board.getSquare(7, 7);
			Board.setNull(x, y);
			Board.setSquare(x + 2, y, this);
			Board.setSquare(x + 1, y, rook);
			rook.setX(x + 1);

			Board.buttons[x][y].setIcon(new ImageIcon(""));
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			Board.setNull(x, y);
			x+=2;
			Board.buttons[x][y].setIcon(getIcon());
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			
			Board.buttons[7][7].setIcon(new ImageIcon(""));
			Board.buttons[7][7].invalidate();
			Board.buttons[7][7].revalidate();
			Board.buttons[7][7].repaint();
			Board.setNull(7, 7);
			Board.buttons[5][7].setIcon(Board.getSquare(5,y).getIcon());
			Board.buttons[5][7].invalidate();
			Board.buttons[5][7].revalidate();
			Board.buttons[5][7].repaint();
			if (Board.turn.equals("White")) {
				Board.turn = "Black";
			} else {
				Board.turn = "White";
			}
			castle=false;
		}
		if (color.equals("White")) {
			Piece rook = Board.getSquare(7, 0);
			Board.setNull(x, y);
			Board.setSquare(x + 2, y, this);
			Board.setSquare(x + 1, y, rook);
			rook.setX(x + 1);

			Board.buttons[x][y].setIcon(new ImageIcon(""));
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			Board.setNull(x, y);
			x+=2;
			Board.buttons[x][y].setIcon(getIcon());
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			
			Board.buttons[7][0].setIcon(new ImageIcon(""));
			Board.buttons[7][0].invalidate();
			Board.buttons[7][0].revalidate();
			Board.buttons[7][0].repaint();
			Board.setNull(7, 0);
			Board.buttons[5][0].setIcon(Board.getSquare(5,y).getIcon());
			Board.buttons[5][0].invalidate();
			Board.buttons[5][0].revalidate();
			Board.buttons[5][0].repaint();
			if (Board.turn.equals("White")) {
				Board.turn = "Black";
			} else {
				Board.turn = "White";
			}
			castle=false;
		}
	}

	public boolean isCheck() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!Board.isEmpty(i, j)) {
					if (!(Board.getSquare(i, j).getColor().equals(color))) {
						if (Board.getSquare(i, j).canMove(x, y, false)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public ImageIcon getIcon() {
		if (color.equals("Black")) {
			return new ImageIcon("C:Black_King.png");
		} else {
			return new ImageIcon("C:White_King.png");
		}
	}
}
