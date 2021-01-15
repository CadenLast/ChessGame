package chess;

import javax.swing.ImageIcon;

public class Bishop extends Piece{
	public Bishop(String color, int x, int y)
	{
		super(color, x, y);
	}
	public boolean correctDirection(int x, int y)
	{
		if(Math.abs(y-this.y)==Math.abs(x-this.x))
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
			return new ImageIcon("C:Black_Bishop.png");
		}
		else
		{
			return new ImageIcon("C:White_Bishop.png");
		}
	}
}
