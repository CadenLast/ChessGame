package chess;

import javax.swing.ImageIcon;

public class Queen extends Piece{
	public Queen(String color, int x, int y)
	{
		super(color, x, y);
	}
	public boolean correctDirection(int x, int y)
	{
		if(Math.abs(y-this.y)==Math.abs(x-this.x)||(x-this.x!=0&&y-this.y==0)||(x-this.x==0&&y-this.y!=0))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public ImageIcon getIcon()
	{
		if(color.equals("Black"))
		{
			return new ImageIcon("C:Black_Queen.png");
		}
		else
		{
			return new ImageIcon("C:White_Queen.png");
		}
	}
}
