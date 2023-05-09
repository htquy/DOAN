package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessBoard extends JFrame implements ActionListener{
   private JButton[][] boardSquares = new JButton[8][8];
   float [][] value=new float[8][8]; 
   float [][] green=new float[8][8];
   float [][] checkmate=new float[8][8];
      boolean move;
      boolean turn;
   int[][] fisrtw=new int[8][8];
   int[][] fisrtb=new int[8][8];
   private boolean isClick;
   private boolean isClick2;   
   int a;int b;
   private void setClick(boolean isclick){
       isClick=isclick;
   }
   private boolean getClick(){
       isClick= !isClick;
       return isClick;
   }
   private void setClick2(boolean isclick){
       isClick2=isclick;
   }
   private boolean getClick2(){
       isClick2= !isClick2;
       return isClick2;
   }
   public ChessBoard() {
      //count=1;
      initializeBoard();
	initializeInfoPanel();
      setSize(750, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }

   private void initializeBoard() {
       turn=true;
      JPanel chessBoard = new JPanel(new GridLayout(8, 8));
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
             fisrtw[i][j]=0;
          fisrtb[i][j]=0;
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
            setBoard(i,j);
            boardSquares[i][j].addActionListener(this);
                }
            
      add(chessBoard);
   }}
    private void updateBoard() {
        turn=!turn;
     ichess ch=new ichess();
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
            chessBoard.add(boardSquares[i][j]);
            if(value[i][j]==1){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));}
            if(value[i][j]==2){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));}
            if(value[i][j]==3){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));}
            if(value[i][j]==4){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));}
            if(value[i][j]==5){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));}
            if(value[i][j]==6){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_king.png")));}
            if(value[i][j]==-1){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));}
            if(value[i][j]==-2){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));}
            if(value[i][j]==-3){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));}
            if(value[i][j]==-4){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));}
            if(value[i][j]==-5){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));}
            if(value[i][j]==-6){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_king.png")));}
            ActionListener[] listeners = boardSquares[i][j].getActionListeners();
for (ActionListener listener : listeners) {
    boardSquares[i][j].removeActionListener(listener);
}
            boardSquares[i][j].addActionListener(this);
            
      add(chessBoard);
   }}}
private void setBoard(int i,int j){
            if (i == 0 && (j == 0 || j == 7)) {
                value[i][j]=4;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));
            } else if (i == 0 && (j == 1 || j == 6)) {
                value[i][j]=3;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));
            } else if (i == 0 && (j == 2 || j == 5)) {
                value[i][j]=2;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));
            } else if (i == 0 && j == 4) {
                value[i][j]=5;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));
            } else if (i == 0 && j == 3) {
                value[i][j]=6;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_king.png")));
            } else if (i == 1) {
                value[i][j]=1;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));
            }
            // Set the icon black 
            if (i == 7 && (j == 0 || j == 7)) {
                value[i][j]=-4;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));
            } else if (i == 7 && (j == 1 || j == 6)) {
                value[i][j]=-3;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));
            } else if (i == 7 && (j == 2 || j == 5)) {
                value[i][j]=-2;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));
            } else if (i == 7 && j == 4) {
                value[i][j]=-5;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));
            } else if (i == 7 && j == 3) {
                value[i][j]=-6;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_king.png")));
            } else if (i == 6) {
                value[i][j]=-1;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
            }
}

private void setback_wpawn(int i,int j,ichess chess){
setClick(false);
setClick2(false);
move=false;
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()&&i+1<8){
    boardSquares[i][j].setBackground(Color.GREEN);
   if(value[i+1][j]==0){
        boardSquares[i+1][j].setBackground(Color.GREEN);  
        green[i+1][j]=0.5f;
        if(value[i+2][j]==0&&fisrtw[i][j]==0&&i+2<8)
        {boardSquares[i+2][j].setBackground(Color.GREEN);
        green[i+2][j]=0.5f;
        //fisrtw[j]=1;
        }
   }if(j+1<8&&i+1<8&&value[i+1][j+1]<0){
       
   boardSquares[i+1][j+1].setBackground(Color.GREEN);  
        green[i+1][j+1]=0.5f;}
   if(j-1>=0&&i+1<8&&value[i+1][j-1]<0){
   boardSquares[i+1][j-1].setBackground(Color.GREEN);  
        green[i+1][j-1]=0.5f;}
    for(int m=0;m<8;m++){
        for(int n=0;n<8;n++){
            if(green[m][n]==0.5f){changeIcon(m,n,i,j,chess);
            //settingboard();
    }
   }
}
  
    }
    else {
        settingboard();
    }
  });
//if(move){chess.setindex(m,n);}
}
private void changeIcon(int m,int n,int i,int j,ichess chess){
    setClick2(false);
    move=false;
    
    boardSquares[m][n].addActionListener((java.awt.event.ActionEvent evt) ->{
        if(getClick2()&&green[m][n]==0.5f){
    boardSquares[i][j].setIcon(null);
   settingboard();
   if(value[i][j]==1){value[m][n]=1;value[i][j]=0;move=true;fisrtw[m][n]=fisrtw[i][j]+1;
   fisrtw[i][j]=0;
   }
else if(value[i][j]==-1){value[m][n]=-1;value[i][j]=0;move=true;fisrtw[m][n]=fisrtw[i][j]+1;
fisrtw[i][j]=0;}
else if(value[i][j]==2){value[m][n]=2;value[i][j]=0;move=true;}
else if(value[i][j]==-2){value[m][n]=-2;value[i][j]=0;move=true;}
else if(value[i][j]==3){value[m][n]=3;value[i][j]=0;move=true;}
else if(value[i][j]==-3){value[m][n]=-3;value[i][j]=0;move=true;}
else if(value[i][j]==4){value[m][n]=4;value[i][j]=0;move=true;}
else if(value[i][j]==-4){value[m][n]=-4;value[i][j]=0;move=true;}
else if(value[i][j]==5){value[m][n]=5;value[i][j]=0;move=true;}
else if(value[i][j]==-5){value[m][n]=-5;value[i][j]=0;move=true;}
else if(value[i][j]==6){value[m][n]=6;value[i][j]=0;move=true;}
else if(value[i][j]==-6){value[m][n]=-6;value[i][j]=0;move=true;}

   updateBoard();
}
        else {
        settingboard();
    }
        for (int row=0;row<8;row++){
            for (int col=0;col<8;col++){
            if(boardSquares[row][col]==evt.getSource()){
                if(move){chess.setindex(row,col);}
                System.out.println(chess.a);
                System.out.println(chess.b);
                System.out.println(value[m][n]);
                System.out.println(value[i][j]);
            }
            }
        }
    });
    //if(move){chess.setindex(i,j);}
}
private void setback_wbishop(int i,int j,ichess chess){
    
setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    int m,n; 
    if(getClick()){
        m=i;n=j;
        boardSquares[m][n].setBackground(Color.GREEN);
        while(m+1<8&&n+1<8){
        m++;n++;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }
        for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }
    else {
        settingboard();
    }
  });
}
private void setback_bbishop(int i,int j,ichess chess){
    
setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    int m,n;   
    if(getClick()){
        m=i;n=j;
        boardSquares[m][n].setBackground(Color.GREEN);
        while(m+1<8&&n+1<8){
        m++;n++;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }
        for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }

    else {
        settingboard();
    }
  });
}
private void setback_wknight(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+2<8&&j+1<8){
        if(value[i+2][j+1]<=0){boardSquares[i+2][j+1].setBackground(Color.GREEN);green[i+2][j+1]=0.5f;}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]<=0){boardSquares[i+2][j-1].setBackground(Color.GREEN);green[i+2][j-1]=0.5f;}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]<=0){boardSquares[i-2][j+1].setBackground(Color.GREEN);green[i-2][j+1]=0.5f;}
    }
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]<=0){boardSquares[i-2][j-1].setBackground(Color.GREEN);green[i-2][j-1]=0.5f;}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]<=0){boardSquares[i+1][j+2].setBackground(Color.GREEN);green[i+1][j+2]=0.5f;}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]<=0){boardSquares[i+1][j-2].setBackground(Color.GREEN);green[i+1][j-2]=0.5f;}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]<=0){boardSquares[i-1][j-2].setBackground(Color.GREEN);green[i-1][j-2]=0.5f;}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]<=0){boardSquares[i-1][j+2].setBackground(Color.GREEN);green[i-1][j+2]=0.5f;}
    }
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j,chess);
                }
            }
        }
    }
    else settingboard();
});
}
private void setback_bpawn(int i,int j,ichess chess){
setClick(false);
setClick2(false);
move=false;
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()&&i-1>=0){
    boardSquares[i][j].setBackground(Color.GREEN);
   if(value[i-1][j]==0){
        boardSquares[i-1][j].setBackground(Color.GREEN);  
        green[i-1][j]=0.5f;
        if(value[i-2][j]==0&&fisrtb[i][j]==0&&i-2>=0)
        {boardSquares[i-2][j].setBackground(Color.GREEN);
        green[i-2][j]=0.5f;
        //fisrtw[j]=1;
        }
   }if(j+1<8&&value[i-1][j+1]>0){
       
   boardSquares[i-1][j+1].setBackground(Color.GREEN);  
        green[i-1][j+1]=0.5f;}
   if(j-1>=0&&value[i-1][j-1]>0){
   boardSquares[i-1][j-1].setBackground(Color.GREEN);  
        green[i-1][j-1]=0.5f;}
    for(int m=0;m<8;m++){
        for(int n=0;n<8;n++){
            if(green[m][n]==0.5f){changeIcon(m,n,i,j,chess);
            //settingboard();
    }
   }
}
  
    }
    else {
        settingboard();
    }
  });
}
private void setback_bknight(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+2<8&&j+1<8){
        if(value[i+2][j+1]>=0){boardSquares[i+2][j+1].setBackground(Color.GREEN);green[i+2][j+1]=0.5f;}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]>=0){boardSquares[i+2][j-1].setBackground(Color.GREEN);green[i+2][j-1]=0.5f;}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]>=0){boardSquares[i-2][j+1].setBackground(Color.GREEN);green[i-2][j+1]=0.5f;}
    }
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]>=0){boardSquares[i-2][j-1].setBackground(Color.GREEN);green[i-2][j-1]=0.5f;}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]>=0){boardSquares[i+1][j+2].setBackground(Color.GREEN);green[i+1][j+2]=0.5f;}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]>=0){boardSquares[i+1][j-2].setBackground(Color.GREEN);green[i+1][j-2]=0.5f;}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]>=0){boardSquares[i-1][j-2].setBackground(Color.GREEN);green[i-1][j-2]=0.5f;}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]>=0){boardSquares[i-1][j+2].setBackground(Color.GREEN);green[i-1][j+2]=0.5f;}
    }
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j,chess);
                }
            }
        }
    }
    else settingboard();
});
}
private void setback_wrook(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]<0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]<0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]<0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]<0)break;
            }else break;
        }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }else settingboard();
});
}
private void setback_brook(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]>0)break;
            }else break;
        }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }else settingboard();
});
}
private void setback_wqueen(int i,int j,ichess chess){
    setClick(false);
    boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]<0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]<0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]<0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]<=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]<0)break;
            }else break;
        }n=j;
        while(m+1<8&&n+1<8){
        m++;n++;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]<=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]<0)break;}else break;
    }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }else settingboard();
});
}
private void setback_bqueen(int i,int j,ichess chess){
    setClick(false);
    boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
                if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]>=0){
                boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
            if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m+1<8&&n+1<8){
        m++;n++;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]>=0){
        boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;
        if(value[m][n]>0)break;}else break;
    }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j,chess);
                }
            }
        }
    }else settingboard();
});
}
private void setback_wking(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+1<8){
        if(value[i+1][j]<=0){boardSquares[i+1][j].setBackground(Color.GREEN);green[i+1][j]=0.5f;}}
    if(j+1<8){
        if(value[i][j+1]<=0){boardSquares[i][j+1].setBackground(Color.GREEN);green[i][j+1]=0.5f;}}
    if(i+1<8&&j+1<8){
        if(value[i+1][j+1]<=0){boardSquares[i+1][j+1].setBackground(Color.GREEN);green[i+1][j+1]=0.5f;}}
    if(i-1>=0){
        if(value[i-1][j]<=0){boardSquares[i-1][j].setBackground(Color.GREEN);green[i-1][j]=0.5f;}}
    if(j-1>=0){
        if(value[i][j-1]<=0){boardSquares[i][j-1].setBackground(Color.GREEN);green[i][j-1]=0.5f;}}
    if(i-1>=0&&j-1>=0){
        if(value[i-1][j-1]<=0){boardSquares[i-1][j-1].setBackground(Color.GREEN);green[i-1][j-1]=0.5f;}}
    if(i+1<8&&j-1>=0){
        if(value[i+1][j-1]<=0){boardSquares[i+1][j-1].setBackground(Color.GREEN);green[i+1][j-1]=0.5f;}}
    if(i-1>=0&&j+1<8){
        if(value[i-1][j+1]<=0){boardSquares[i-1][j+1].setBackground(Color.GREEN);green[i-1][j+1]=0.5f;}}
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j,chess);
                }
            }
        }
    }
    else settingboard();
});
}
private void setback_bking(int i,int j,ichess chess){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+1<8){
        if(value[i+1][j]>=0){boardSquares[i+1][j].setBackground(Color.GREEN);green[i+1][j]=0.5f;}}
    if(j+1<8){
        if(value[i][j+1]>=0){boardSquares[i][j+1].setBackground(Color.GREEN);green[i][j+1]=0.5f;}}
    if(i+1<8&&j+1<8){
        if(value[i+1][j+1]>=0){boardSquares[i+1][j+1].setBackground(Color.GREEN);green[i+1][j+1]=0.5f;}}
    if(i-1>=0){
        if(value[i-1][j]>=0){boardSquares[i-1][j].setBackground(Color.GREEN);green[i-1][j]=0.5f;}}
    if(j-1>=0){
        if(value[i][j-1]>=0){boardSquares[i][j-1].setBackground(Color.GREEN);green[i][j-1]=0.5f;}}
    if(i-1>=0&&j-1>=0){
        if(value[i-1][j-1]>=0){boardSquares[i-1][j-1].setBackground(Color.GREEN);green[i-1][j-1]=0.5f;}}
    if(i+1<8&&j-1>=0){
        if(value[i+1][j-1]>=0){boardSquares[i+1][j-1].setBackground(Color.GREEN);green[i+1][j-1]=0.5f;}}
    if(i-1>=0&&j+1<8){
        if(value[i-1][j+1]>=0){boardSquares[i-1][j+1].setBackground(Color.GREEN);green[i-1][j+1]=0.5f;}}
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j,chess);
                }
            }
        }
    }
    else settingboard();
});
}public void actionPerformed(ActionEvent e) {
    ichess chess=new ichess();
    
   for(int i=0;i<8;i++){
       for(int j=0;j<8;j++){
           //ichess chess=new ichess();
           //chess.setindex(i, j);
            playchess(i,j,chess);
       }
   }
}
private void playchess(int i,int j,ichess chess){
    if(turn==true){
        if(value[i][j]==1){
        setback_wpawn(i,j,chess); 
    }
        else if(value[i][j]==6){
        setback_wking(i,j,chess);
    }
        else if(value[i][j]==4){
        setback_wrook(i,j,chess);
    }
        else if(value[i][j]==3){
        setback_wknight(i,j,chess);
    }
        else if(value[i][j]==2){
        setback_wbishop(i,j,chess);
    }
    }
    else{
    if(value[i][j]==-1){
        setback_bpawn(i,j,chess);   
    }
    
    else if(value[i][j]==-2){
        setback_bbishop(i,j,chess);
    }
    
    else if(value[i][j]==-3){
        setback_bknight(i,j,chess);
    }else if(value[i][j]==-4){
        setback_brook(i,j,chess);
    }
    
    else if(value[i][j]==-5){
        setback_bqueen(i,j,chess);
    }
    
    else if(value[i][j]==-6){
        setback_bking(i,j,chess);
    }}}
private void settingboard(){
    for (int m = 0; m < 8; m++) {
         for (int n = 0; n < 8; n++) {
            if(green[m][n]==0.5f){
                green[m][n]=0;
            }
            if ((m + n) % 2 == 0) {
               boardSquares[m][n].setBackground(Color.WHITE);
            } else {
               boardSquares[m][n].setBackground(Color.GRAY);
            }}
}}
private void setIcon(int i,int j){
    if(value[i][j]==1){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));
    }
    else if(value[i][j]==2){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));
    }
    else if(value[i][j]==3){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));
    }
    else if(value[i][j]==4){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));
    }
    else if(value[i][j]==6){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_king.png")));
    }
    else if(value[i][j]==5){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));
    }
    else if(value[i][j]==-1){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
    }
    else if(value[i][j]==-2){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));
    }
    else if(value[i][j]==-3){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));
    }
    else if(value[i][j]==-4){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));
    }
    else if(value[i][j]==-6){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_king.png")));
    }
    else if(value[i][j]==-5){
    boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));
    }
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
class ichess{
    int a;int b;
    public void setindex(int c,int d){
       a=c;b=d;
   }
}

   public static void main(String[] args) {
      new ChessBoard();
   }
}