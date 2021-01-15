package chess;

import javax.swing.ImageIcon;

public abstract class Piece {
	boolean castle = true;
	String color;
	int x = 0;
	int y = 0;
	boolean enPassant;

	Piece(String color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	
	public abstract boolean correctDirection(int x, int y);

	public abstract ImageIcon getIcon();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean canCastle()
	{
		return castle;
	}

	public String getColor() {
		return color;
	}

	public void take(int x, int y) {
		if (!(Board.getSquare(x, y).color.equals(color))) {
			if (canMove(x, y, true)) {
				Board.getSquare(x, y).taken();
				move(x, y);
			}
		}
	}

	public boolean canTake(int x, int y, boolean realMove) {
		if (x - this.x > 0 && y - this.y > 0 && Math.abs(y - this.y) == Math.abs(x - this.x)) {
			if ((x - this.x == 1 && 1 == y - this.y) || (canMove(x - 1, y - 1, realMove)&&Board.isEmpty(x-1,  y-1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x > 0 && y - this.y == 0) {
			if (x - this.x == 1 || (canMove(x - 1, y, realMove)&&Board.isEmpty(x-1,  y))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x > 0 && y - this.y < 0 && Math.abs(y - this.y) == Math.abs(x - this.x)) {
			if ((x - this.x == 1 && y - this.y == -1) || (canMove(x - 1, y + 1, realMove)&&Board.isEmpty(x-1,  y+1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x == 0 && y - this.y > 0) {
			if (y - this.y == 1 || (canMove(x, y - 1, realMove)&&Board.isEmpty(x,  y-1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x == 0 && y - this.y < 0) {
			if (y - this.y == -1 || (canMove(x, y + 1, realMove)&&Board.isEmpty(x,  y+1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x < 0 && y - this.y > 0 && Math.abs(y - this.y) == Math.abs(x - this.x)) {
			if ((x - this.x == -1 && y - this.y == 1) || (canMove(x + 1, y - 1, realMove)&&Board.isEmpty(x+1,  y-1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x < 0 && y - this.y == 0) {
			if (x - this.x == -1 || (canMove(x + 1, y, realMove)&&Board.isEmpty(x+1,  y))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x < 0 && y - this.y < 0 && Math.abs(y - this.y) == Math.abs(x - this.x)) {
			if ((x - this.x == -1 && y - this.y == -1) || (canMove(x + 1, y + 1, realMove)&&Board.isEmpty(x+1,  y+1))) {
				return true;
			} else {
				return false;
			}
		} else if (x - this.x == 0 && y - this.y == 0) {
			return false;
		}
		return false;
	}

	public void taken() {
		x = -1;
		y = -1;
	}

	public void move(int x, int y) {
		if (!(Board.turn.equals(color)) || !(correctDirection(x, y))) {
			return;
		}
		if (canMove(x, y, true)) {
			Board.moveList(this.x, this.y, x, y);
			Board.setSquare(x, y, this);
			Board.buttons[this.x][this.y].setIcon(new ImageIcon(""));
			Board.buttons[this.x][this.y].invalidate();
			Board.buttons[this.x][this.y].revalidate();
			Board.buttons[this.x][this.y].repaint();
			Board.setNull(this.x, this.y);
			this.x = x;
			this.y = y;
			Board.buttons[x][y].setIcon(getIcon());
			Board.buttons[x][y].invalidate();
			Board.buttons[x][y].revalidate();
			Board.buttons[x][y].repaint();
			if (Board.turn.equals("White")) {
				Board.turn = "Black";
			} else {
				Board.turn = "White";
			}
			castle=false;
		}
	}

	public boolean willBeCheck(int x, int y) {
		int oldx = this.x;
		int oldy = this.y;
		Piece oldPiece = null;
		if (!Board.isEmpty(x, y)) {
			oldPiece = Board.getSquare(x, y);
		}
		Board.setNull(this.x, this.y);
		Board.setSquare(x, y, this);
		this.x = x;
		this.y = y;
		if (Board.getKing(color).isCheck()) {
			this.x = oldx;
			this.y = oldy;
			Board.setSquare(oldx, oldy, this);
			if (oldPiece != null) {
				oldPiece.setX(x);
				oldPiece.setY(y);
				Board.setSquare(x, y, oldPiece);
			} else {
				Board.setNull(x, y);
			}

			return true;
		}
		this.x = oldx;
		this.y = oldy;
		Board.setSquare(oldx, oldy, this);

		if (oldPiece != null) {
			oldPiece.setX(x);
			oldPiece.setY(y);
			Board.setSquare(x, y, oldPiece);
		} else {
			Board.setNull(x, y);
		}

		return false;
	}

	public boolean canMove(int x, int y, boolean realMove) {
		if (realMove) {
			if (willBeCheck(x, y)) {
				return false;
			}
		}
		if (!correctDirection(x, y)) {
			return false;
		}
		int xdir;
		int ydir;
		if (Board.isEmpty(x, y)) {
			xdir = x - this.x;
			ydir = y - this.y;
			if (xdir > 0 && ydir > 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y + ydir)) {
						return false;
					}
					xdir--;
					ydir--;
				}
				return true;
			} else if (xdir > 0 && ydir == 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y)) {
						return false;
					}
					xdir--;
				}
				return true;
			} else if (xdir > 0 && ydir < 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y + ydir)) {
						return false;
					}
					xdir--;
					ydir++;
				}
				return true;
			} else if (xdir == 0 && ydir > 0) {
				while (ydir != 0) {
					if (!Board.isEmpty(this.x, this.y + ydir)) {
						return false;
					}
					ydir--;
				}
				return true;
			} else if (xdir == 0 && ydir < 0) {
				while (ydir != 0) {
					if (!Board.isEmpty(this.x, this.y + ydir)) {
						return false;
					}
					ydir++;
				}
				return true;
			} else if (xdir < 0 && ydir > 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y + ydir)) {
						return false;
					}
					xdir++;
					ydir--;
				}
				return true;
			} else if (xdir < 0 && ydir == 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y)) {
						return false;
					}
					xdir++;
				}
				return true;
			} else if (xdir < 0 && ydir < 0) {
				while (xdir != 0) {
					if (!Board.isEmpty(this.x + xdir, this.y + ydir)) {
						return false;
					}
					xdir++;
					ydir++;
				}
				return true;
			}
		} else if (!(Board.getSquare(x, y).getColor().equals(this.color))) {
			return canTake(x, y, realMove);
		}
		return false;
	}
	public boolean enPassant()
	{
		return enPassant;
	}
}
