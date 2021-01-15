package chess;

import javax.swing.ImageIcon;

public class Rook extends Piece{
	
	public Rook(String color, int x, int y)
	{
		super(color, x, y);
	}
	public boolean correctDirection(int x, int y)
	{
		if((x-this.x!=0&&y-this.y==0)||(x-this.x==0&&y-this.y!=0))
		{
			return true;
		}
		return false;		
	}
	public ImageIcon getIcon()
	{
		if(color.equals("Black"))
		{
			return new ImageIcon("C:Black_Rook.png");
		}
		else
		{
			return new ImageIcon("C:White_Rook.png");
		}
	}
}
