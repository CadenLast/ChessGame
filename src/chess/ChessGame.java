package chess;

import javax.swing.JFrame;

public class ChessGame extends JFrame {

	public ChessGame(String name) {
		super(name);
		setResizable(false);
	}

	private static void createAndShowGUI() {
		ChessGame frame = new ChessGame("Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Board.remakeBoard(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		Board.createBoard();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

}
