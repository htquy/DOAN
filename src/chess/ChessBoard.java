package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessBoard extends JFrame {
   private JButton[][] boardSquares = new JButton[8][8];
   private JLabel player1Label, player2Label;
   private JTextArea moveLogTextArea;

   public ChessBoard() {
      initializeBoard();
      initializeInfoPanel();
      setSize(750, 600);
      //setExtendedState(JFrame.MAXIMIZED_BOTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      this.setLocationRelativeTo(null);
      //getContentPane().add(chessboardPanel, BorderLayout.CENTER);
   }

   private void initializeBoard() {
      JPanel chessBoard = new JPanel(new GridLayout(8, 8));
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(75, 75));
            if ((i + j) % 2 == 0) {
               button.setBackground(Color.WHITE);
            } else {
               button.setBackground(Color.GRAY);
            }
            boardSquares[i][j] = button;
            chessBoard.add(button);
            // Set the icon white 
            if (i == 0 && (j == 0 || j == 7)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));
            } else if (i == 0 && (j == 1 || j == 6)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));
            } else if (i == 0 && (j == 2 || j == 5)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));
            } else if (i == 0 && j == 3) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));
            } else if (i == 0 && j == 4) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_king.png")));
            } else if (i == 1) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));
            }
            // Set the icon black 
            if (i == 7 && (j == 0 || j == 7)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));
            } else if (i == 7 && (j == 1 || j == 6)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));
            } else if (i == 7 && (j == 2 || j == 5)) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));
            } else if (i == 7 && j == 3) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));
            } else if (i == 7 && j == 4) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_king.png")));
            } else if (i == 6) {
               button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
            }
         }
      }
      add(chessBoard);
   }
   private void initializeInfoPanel() {
   JPanel infoPanel = new JPanel(new GridLayout(3, 1));

   // Add player labels
   JLabel player1Label = new JLabel("Player 1");
   JLabel player2Label = new JLabel("Player 2");
   infoPanel.add(player1Label);
   infoPanel.add(player2Label);

   // Add turn indicator
   JLabel turnLabel = new JLabel("Player 1's Turn");
   infoPanel.add(turnLabel);

   // Set panel properties
   infoPanel.setPreferredSize(new Dimension(150, 600));
   infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

   // Add panel to the frame
   add(infoPanel, BorderLayout.EAST);
}

   public static void main(String[] args) {
      new ChessBoard();
   }
}