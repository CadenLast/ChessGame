package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Grid extends JFrame {
    JButton applyButton = new JButton("Apply gaps");
    GridLayout experimentLayout = new GridLayout(8,8);
    Color BROWN = new Color(150,72,35);
    Color WHITE = new Color(255,255,255);
     
    public Grid(String name) {
        super(name);
        setResizable(false);
    }
     
    
    
	
	
	
	
    public void addComponentsToPane(final Container pane) throws IOException {
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(8,8));
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        
        compsToExperiment.setPreferredSize(new Dimension(700,700));
         

        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Rook.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Knight.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Bishop.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Queen.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_King.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Bishop.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Knight.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Rook.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("Black_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton("")).setBackground(BROWN);
        compsToExperiment.add(new JButton("")).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Pawn.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Rook.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Knight.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Bishop.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Queen.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_King.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Bishop.png"))))).setBackground(WHITE);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Knight.png"))))).setBackground(BROWN);
        compsToExperiment.add(new JButton(new ImageIcon(ImageIO.read(classLoader.getResourceAsStream("White_Rook.png"))))).setBackground(WHITE);
         
        
        
        pane.add(compsToExperiment, BorderLayout.NORTH);
    }
     

    
}
