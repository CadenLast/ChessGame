package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board {
	private static Piece board[][] = new Piece[8][8];

	static String turn = "White";
	static King whiteKing;
	static King blackKing;
	static Color BROWN = new Color(150, 72, 35);
	static Color WHITE = new Color(255, 255, 255);
	static int x1 = 0;
	static int y1 = 0;
	static int x2 = 0;
	static int y2 = 0;
	static int count = 0;
	static JButton A1 = new JButton("");
	static JButton A2 = new JButton("");
	static JButton A3 = new JButton("");
	static JButton A4 = new JButton("");
	static JButton A5 = new JButton("");
	static JButton A6 = new JButton("");
	static JButton A7 = new JButton("");
	static JButton A8 = new JButton("");
	static JButton B1 = new JButton("");
	static JButton B2 = new JButton("");
	static JButton B3 = new JButton("");
	static JButton B4 = new JButton("");
	static JButton B5 = new JButton("");
	static JButton B6 = new JButton("");
	static JButton B7 = new JButton("");
	static JButton B8 = new JButton("");
	static JButton C1 = new JButton("");
	static JButton C2 = new JButton("");
	static JButton C3 = new JButton("");
	static JButton C4 = new JButton("");
	static JButton C5 = new JButton("");
	static JButton C6 = new JButton("");
	static JButton C7 = new JButton("");
	static JButton C8 = new JButton("");
	static JButton D1 = new JButton("");
	static JButton D2 = new JButton("");
	static JButton D3 = new JButton("");
	static JButton D4 = new JButton("");
	static JButton D5 = new JButton("");
	static JButton D6 = new JButton("");
	static JButton D7 = new JButton("");
	static JButton D8 = new JButton("");
	static JButton E1 = new JButton("");
	static JButton E2 = new JButton("");
	static JButton E3 = new JButton("");
	static JButton E4 = new JButton("");
	static JButton E5 = new JButton("");
	static JButton E6 = new JButton("");
	static JButton E7 = new JButton("");
	static JButton E8 = new JButton("");
	static JButton F1 = new JButton("");
	static JButton F2 = new JButton("");
	static JButton F3 = new JButton("");
	static JButton F4 = new JButton("");
	static JButton F5 = new JButton("");
	static JButton F6 = new JButton("");
	static JButton F7 = new JButton("");
	static JButton F8 = new JButton("");
	static JButton G1 = new JButton("");
	static JButton G2 = new JButton("");
	static JButton G3 = new JButton("");
	static JButton G4 = new JButton("");
	static JButton G5 = new JButton("");
	static JButton G6 = new JButton("");
	static JButton G7 = new JButton("");
	static JButton G8 = new JButton("");
	static JButton H1 = new JButton("");
	static JButton H2 = new JButton("");
	static JButton H3 = new JButton("");
	static JButton H4 = new JButton("");
	static JButton H5 = new JButton("");
	static JButton H6 = new JButton("");
	static JButton H7 = new JButton("");
	static JButton H8 = new JButton("");

	static ChessGame frame = new ChessGame("GridLayoutDemo");

	static GridLayout grid = new GridLayout(8, 8);
	
	public static String moveList="position startpos moves ";

	static JButton[][] buttons = { { H8, G8, F8, E8, D8, C8, B8, A8 }, { H7, G7, F7, E7, D7, C7, B7, A7 },
			{ H6, G6, F6, E6, D6, C6, B6, A6 }, { H5, G5, F5, E5, D5, C5, B5, A5 }, { H4, G4, F4, E4, D4, C4, B4, A4 },
			{ H3, G3, F3, E3, D3, C3, B3, A3 }, { H2, G2, F2, E2, D2, C2, B2, A2 },
			{ H1, G1, F1, E1, D1, C1, B1, A1 } };

	public static void createBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 2; j < 6; j++) {
				board[i][j] = null;
			}
		}
		for (int i = 0; i < 8; i++) {
			board[i][1] = new Pawn("White", i, 1);
		}
		for (int i = 0; i < 8; i++) {
			board[i][6] = new Pawn("Black", i, 6);
		}

		board[0][0] = new Rook("White", 0, 0);
		board[1][0] = new Knight("White", 1, 0);
		board[2][0] = new Bishop("White", 2, 0);
		board[4][0] = whiteKing = new King("White", 4, 0);
		board[3][0] = new Queen("White", 3, 0);
		board[5][0] = new Bishop("White", 5, 0);
		board[6][0] = new Knight("White", 6, 0);
		board[7][0] = new Rook("White", 7, 0);

		board[0][7] = new Rook("Black", 0, 7);
		board[1][7] = new Knight("Black", 1, 7);
		board[2][7] = new Bishop("Black", 2, 7);
		board[3][7] = new Queen("Black", 4, 7);
		board[4][7] = blackKing = new King("Black", 3, 7);
		board[5][7] = new Bishop("Black", 5, 7);
		board[6][7] = new Knight("Black", 6, 7);
		board[7][7] = new Rook("Black", 7, 7);

	}

	public static void remakeBoard(Container pane) {

		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(8, 8));
		final JPanel ChessWindow = new JPanel();
		ChessWindow.setLayout(grid);
		ChessWindow.setPreferredSize(new Dimension(700, 700));
		A1.setName("77");
		ChessWindow.add(A8).setBackground(WHITE);
		A2.setName("67");
		ChessWindow.add(A7).setBackground(BROWN);
		A3.setName("57");
		ChessWindow.add(A6).setBackground(WHITE);
		A4.setName("47");
		ChessWindow.add(A5).setBackground(BROWN);
		A5.setName("37");
		ChessWindow.add(A4).setBackground(WHITE);
		A6.setName("27");
		ChessWindow.add(A3).setBackground(BROWN);
		A7.setName("17");
		ChessWindow.add(A2).setBackground(WHITE);
		A8.setName("07");
		ChessWindow.add(A1).setBackground(BROWN);
		B1.setName("76");
		ChessWindow.add(B8).setBackground(BROWN);
		B2.setName("66");
		ChessWindow.add(B7).setBackground(WHITE);
		B3.setName("56");
		ChessWindow.add(B6).setBackground(BROWN);
		B4.setName("46");
		ChessWindow.add(B5).setBackground(WHITE);
		B5.setName("36");
		ChessWindow.add(B4).setBackground(BROWN);
		B6.setName("26");
		ChessWindow.add(B3).setBackground(WHITE);
		B7.setName("16");
		ChessWindow.add(B2).setBackground(BROWN);
		B8.setName("06");
		ChessWindow.add(B1).setBackground(WHITE);
		C1.setName("75");
		ChessWindow.add(C8).setBackground(WHITE);
		C2.setName("65");
		ChessWindow.add(C7).setBackground(BROWN);
		C3.setName("55");
		ChessWindow.add(C6).setBackground(WHITE);
		C4.setName("45");
		ChessWindow.add(C5).setBackground(BROWN);
		C5.setName("35");
		ChessWindow.add(C4).setBackground(WHITE);
		C6.setName("25");
		ChessWindow.add(C3).setBackground(BROWN);
		C7.setName("15");
		ChessWindow.add(C2).setBackground(WHITE);
		C8.setName("05");
		ChessWindow.add(C1).setBackground(BROWN);
		D1.setName("74");
		ChessWindow.add(D8).setBackground(BROWN);
		D2.setName("64");
		ChessWindow.add(D7).setBackground(WHITE);
		D3.setName("54");
		ChessWindow.add(D6).setBackground(BROWN);
		D4.setName("44");
		ChessWindow.add(D5).setBackground(WHITE);
		D5.setName("34");
		ChessWindow.add(D4).setBackground(BROWN);
		D6.setName("24");
		ChessWindow.add(D3).setBackground(WHITE);
		D7.setName("14");
		ChessWindow.add(D2).setBackground(BROWN);
		D8.setName("04");
		ChessWindow.add(D1).setBackground(WHITE);
		E1.setName("73");
		ChessWindow.add(E8).setBackground(WHITE);
		E2.setName("63");
		ChessWindow.add(E7).setBackground(BROWN);
		E3.setName("53");
		ChessWindow.add(E6).setBackground(WHITE);
		E4.setName("43");
		ChessWindow.add(E5).setBackground(BROWN);
		E5.setName("33");
		ChessWindow.add(E4).setBackground(WHITE);
		E6.setName("23");
		ChessWindow.add(E3).setBackground(BROWN);
		E7.setName("13");
		ChessWindow.add(E2).setBackground(WHITE);
		E8.setName("03");
		ChessWindow.add(E1).setBackground(BROWN);
		F1.setName("72");
		ChessWindow.add(F8).setBackground(BROWN);
		F2.setName("62");
		ChessWindow.add(F7).setBackground(WHITE);
		F3.setName("52");
		ChessWindow.add(F6).setBackground(BROWN);
		F4.setName("42");
		ChessWindow.add(F5).setBackground(WHITE);
		F5.setName("32");
		ChessWindow.add(F4).setBackground(BROWN);
		F6.setName("22");
		ChessWindow.add(F3).setBackground(WHITE);
		F7.setName("12");
		ChessWindow.add(F2).setBackground(BROWN);
		F8.setName("02");
		ChessWindow.add(F1).setBackground(WHITE);
		G1.setName("71");
		ChessWindow.add(G8).setBackground(WHITE);
		G2.setName("61");
		ChessWindow.add(G7).setBackground(BROWN);
		G3.setName("51");
		ChessWindow.add(G6).setBackground(WHITE);
		G4.setName("41");
		ChessWindow.add(G5).setBackground(BROWN);
		G5.setName("31");
		ChessWindow.add(G4).setBackground(WHITE);
		G6.setName("21");
		ChessWindow.add(G3).setBackground(BROWN);
		G7.setName("11");
		ChessWindow.add(G2).setBackground(WHITE);
		G8.setName("01");
		ChessWindow.add(G1).setBackground(BROWN);
		H1.setName("70");
		ChessWindow.add(H8).setBackground(BROWN);
		H2.setName("60");
		ChessWindow.add(H7).setBackground(WHITE);
		H3.setName("50");
		ChessWindow.add(H6).setBackground(BROWN);
		H4.setName("40");
		ChessWindow.add(H5).setBackground(WHITE);
		H5.setName("30");
		ChessWindow.add(H4).setBackground(BROWN);
		H6.setName("20");
		ChessWindow.add(H3).setBackground(WHITE);
		H7.setName("10");
		ChessWindow.add(H2).setBackground(BROWN);
		H8.setName("00");
		ChessWindow.add(H1).setBackground(WHITE);
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				buttons[i][j].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (count % 2 == 0) {
							if (isEmpty(Character.getNumericValue((((JButton) e.getSource()).getName().charAt(0))),
									Character.getNumericValue((((JButton) e.getSource()).getName().charAt(1))))) {
								return;
							}
							x1 = Character.getNumericValue((((JButton) e.getSource()).getName().charAt(0)));
							y1 = Character.getNumericValue((((JButton) e.getSource()).getName().charAt(1)));
							count++;
						} else {
							x2 = Character.getNumericValue((((JButton) e.getSource()).getName().charAt(0)));
							y2 = Character.getNumericValue((((JButton) e.getSource()).getName().charAt(1)));
							count++;
							Board.getSquare(x1, y1).move(x2, y2);
							if (isCheckmate(turn)) {
								System.out.println("Game Over");
							}
						}
					}
				});
			}
		}
		for (int j = 0; j < 8; j++) {
			for (int i = 0; i < 8; i++) {
				if (Board.isEmpty(i, j) == true) {
					buttons[i][j].setIcon(new ImageIcon(""));
					break;
				}

				buttons[i][j].setIcon(Board.getSquare(i, j).getIcon());

			}
		}
		pane.add(ChessWindow, BorderLayout.NORTH);
	}

	public static boolean isCheckmate(String color) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int m = 0; m < 8; m++) {
					for (int n = 0; n < 8; n++) {
						if (!Board.isEmpty(i, j)) {
							if (getSquare(i, j).getColor().equals(color)) {
								if (getSquare(i, j).canMove(m, n, true)) {
									return false;
								}
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	public static void moveList(int x1, int y1, int x2, int y2)
	{
		moveList+=((char)(x1+97));
		moveList+=((char)(y1+49));
		moveList+=((char)(x2+97));
		moveList+=((char)(y2+49))+" ";
		//System.out.println(moveList);
	}

	public static boolean isEmpty(int x, int y) {
		if (x > 7 || y > 7) {
			return false;
		}
		if (board[x][y] == null) {
			return true;
		} else {
			return false;
		}
	}

	public static Piece getSquare(int x, int y) {
		return board[x][y];
	}

	public static void setSquare(int x, int y, Piece piece) {
		// board[piece.getX()][piece.getY()] = null;
		board[x][y] = piece;
	}

	public static void setNull(int x, int y) {
		board[x][y] = null;
	}

	public static King getKing(String color) {
		if (color.contentEquals("White")) {
			return whiteKing;
		} else {
			return blackKing;
		}
	}
}
