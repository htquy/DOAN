package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChessBoard extends JFrame implements ActionListener{
   static private JButton[][] boardSquares = new JButton[8][8];
   JButton w_button[][] = new JButton[1][5];
   JButton b_button[][] = new JButton[1][5];
   static float [][] value=new float[8][8]; 
   float [][] green=new float[8][8];
   boolean w_castlel,w_castler,b_castlel,b_castler;
   int row1,col1,row2,col2;
   int bcandef,wcandef;
   static float val;
   float [][] checkmateb=new float[8][8];
   float [][] checkmatew=new float[8][8];
      boolean move,movew,moveb;
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
      //count=0;
      initializeBoard();
	initializeInfoPanel();
      setSize(750, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   public ChessBoard(int i,int j,int m,int n){
       val=10;
       board(i,j,m,n);
       setSize(375, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   private void  board(int i,int j,int m,int n){
       if(m==7){
       JPanel W_Pawn = new JPanel(new GridLayout(1, 5));
      for (int t = 0; t < 5; t++) {
            JButton wpawn = new JButton();
            wpawn.setPreferredSize(new Dimension(75, 75));
            w_button[0][t] = wpawn;
            if(t==0){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
            boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_pawn.png")));
            value[m][n]=1;dispose();});}
            if(t==1){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_bishop.png")));
            value[m][n]=2;dispose();});
            }
            if(t==2){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_knight.png")));
            value[m][n]=3;dispose();});
            }
            if(t==3){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_rook.png")));
                value[m][n]=4;dispose();});}
            if(t==4){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_queen.png")));
                value[m][n]=5;dispose();});}
            System.out.println(val);
            W_Pawn.add(wpawn);
            add(W_Pawn);
      }        
   }
       else if(m==0){
       JPanel W_Pawn = new JPanel(new GridLayout(1, 5));
      for (int t = 0; t < 5; t++) {
            JButton wpawn = new JButton();
            wpawn.setPreferredSize(new Dimension(75, 75));
            w_button[0][t] = wpawn;
            if(t==0){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
            boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
            value[m][n]=-1;dispose();});}
            if(t==1){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));
            value[m][n]=-2;dispose();});
            }
            if(t==2){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));
            value[m][n]=-3;dispose();});
            }
            if(t==3){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));
                value[m][n]=-4;dispose();});}
            if(t==4){w_button[0][t].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));
            w_button[0][t].addActionListener((java.awt.event.ActionEvent e) -> {
                boardSquares[m][n].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));
                value[m][n]=-5;dispose();});}
            System.out.println(val);
            W_Pawn.add(wpawn);
            add(W_Pawn);
      }        
   }
   }
   private void initializeBoard() {
       turn=true;bcandef=0;wcandef=0;
       movew=false;moveb=false;
       w_castlel=true;w_castler=true;b_castlel=true;b_castler=true;
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
        turn=!turn;bcandef=0;wcandef=0;
        if(value[7][7]!=-4||value[7][3]!=-6)b_castler=false;
        else if(value[7][0]!=-4||value[7][3]!=-6)b_castlel=false;
        if(value[0][7]!=4||value[0][3]!=6)w_castlel=false;
        else if(value[0][0]!=4||value[0][3]!=6)w_castler=false;
          //ichess ch=new ichess();
     for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
         checkmateb[i][j]=0;
         checkmatew[i][j]=0;
         }}
      JPanel chessBoard = new JPanel(new GridLayout(8, 8));
      for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
             bKing_run(i,j);
             wKing_run(i,j);
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
            if(value[i][j]==6){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/white_king.png")));row1=i;col1=j;}
            if(value[i][j]==-1){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));}
            if(value[i][j]==-2){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_bishop.png")));}
            if(value[i][j]==-3){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_knight.png")));}
            if(value[i][j]==-4){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_rook.png")));}
            if(value[i][j]==-5){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_queen.png")));}
            if(value[i][j]==-6){boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_king.png")));row2=i;col2=j;}
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
                value[i][j]=6;row1=i;col1=j;
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
                value[i][j]=-1;row2=i;col2=j;
               boardSquares[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/black_pawn.png")));
            }
}

private void setback_wpawn(int i,int j){
setClick(false);
setClick2(false);
move=false;
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;
    q=value[i][j];
    if(getClick()&&i+1<8){
    boardSquares[i][j].setBackground(Color.GREEN);
   if(value[i+1][j]==0){
        p=value[i+1][j];
        w_run(i+1,j,i,j,p,q);
        if(fisrtw[i][j]==0&&i+2<8&&value[i+2][j]==0)
        {p=value[i+2][j];
        w_run(i+2,j,i,j,p,q);
        }
   }if(j+1<8&&i+1<8&&value[i+1][j+1]<0){
        p=value[i+1][j+1];
        w_run(i+1,j+1,i,j,p,q);}
   if(j-1>=0&&i+1<8&&value[i+1][j-1]<0){
        p=value[i+1][j-1];
        w_run(i+1,j-1,i,j,p,q);}
    for(int m=0;m<8;m++){
        for(int n=0;n<8;n++){
            if(green[m][n]==0.5f){changeIcon(m,n,i,j);
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
private void changeIcon(int m,int n,int i,int j){
    setClick2(false);
    move=false;
    
    boardSquares[m][n].addActionListener((java.awt.event.ActionEvent evt) ->{
        if(getClick2()&&green[m][n]==0.5f){
    boardSquares[i][j].setIcon(null);
   settingboard();
   if(value[i][j]==1){value[m][n]=1;value[i][j]=0;move=true;fisrtw[m][n]=fisrtw[i][j]+1;
   fisrtw[i][j]=0;
   }
else if(value[i][j]==-1){value[m][n]=-1;value[i][j]=0;fisrtb[m][n]=fisrtb[i][j]+1;
fisrtb[i][j]=0;}
else if(value[i][j]==2){value[m][n]=2;value[i][j]=0;}
else if(value[i][j]==-2){value[m][n]=-2;value[i][j]=0;}
else if(value[i][j]==3){value[m][n]=3;value[i][j]=0;}
else if(value[i][j]==-3){value[m][n]=-3;value[i][j]=0;}
else if(value[i][j]==4){value[m][n]=4;value[i][j]=0;}
else if(value[i][j]==-4){value[m][n]=-4;value[i][j]=0;}
else if(value[i][j]==5){value[m][n]=5;value[i][j]=0;}
else if(value[i][j]==-5){value[m][n]=-5;value[i][j]=0;}
else if(value[i][j]==6){
if(movew&&n==j+2){
value[i][j]=0;value[m][n-1]=4;value[m][n]=6;value[m][n+2]=0;
boardSquares[m][n+2].setIcon(null);
}
else if(movew&&n==j-2){
value[i][j]=0;value[m][n+1]=4;value[m][n]=6;value[m][n-1]=0;
boardSquares[m][n-1].setIcon(null);
}else {value[m][n]=6;value[i][j]=0;}
}
else if(value[i][j]==-6){
if(moveb&&n==j+2){
value[i][j]=0;value[m][n-1]=-4;value[m][n]=-6;value[m][n+2]=0;
boardSquares[m][n+2].setIcon(null);
}
else if(moveb&&n==j-2){
value[i][j]=0;value[m][n+1]=-4;value[m][n]=-6;value[m][n-1]=0;
boardSquares[m][n-1].setIcon(null);
}else {value[m][n]=-6;value[i][j]=0;}
}
   if(m==7&&value[m][n]==1||m==0&&value[m][n]==-1){
       value[m][n]=10;
     ChessBoard promotion=new ChessBoard(i,j,m,n);
     //value[m][n]=10;
 }
   updateBoard();
}
        else {
        settingboard();
        }
    });
    //if(move){chess.setindex(i,j);}
}
private void setback_wbishop(int i,int j){
setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    int m,n; 
    float p,q;
    q=value[i][j];
    if(getClick()){
        m=i;n=j;
        boardSquares[m][n].setBackground(Color.GREEN);
        while(m+1<8&&n+1<8){
        m++;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }
        for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }
    else {
        settingboard();
    }
  });
}
private void b_run(int m,int n,int i,int j,float t,float k){
            value[m][n]=k;
            value[i][j]=0;
            checkmateb[row2][col2]=0;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            if(checkmateb[row2][col2]==1){
            value[i][j]=k;value[m][n]=t;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            }
            else { value[i][j]=k;value[m][n]=t;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;}
}
private void b_def(int m,int n,int i,int j,float t,float k ){
            value[m][n]=k;
            value[i][j]=0;
            checkmateb[row2][col2]=0;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            if(checkmateb[row2][col2]==1){
            value[i][j]=k;value[m][n]=t;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            }
            else { value[i][j]=k;value[m][n]=t;
            bcandef++;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    bKing_run(p,q);
                }
            }
            }
}
private void w_run(int m,int n,int i,int j,float t,float k){
            value[m][n]=k;
            value[i][j]=0;
            checkmatew[row1][col1]=0;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            if(checkmatew[row1][col1]==-1){
            value[i][j]=k;value[m][n]=t;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            }
            else { value[i][j]=k;value[m][n]=t;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            boardSquares[m][n].setBackground(Color.GREEN);green[m][n]=0.5f;}
}
private void w_def(int m,int n,int i,int j,float t,float k){
            value[m][n]=k;
            value[i][j]=0;
            checkmatew[row1][col1]=0;
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            if(checkmatew[row1][col1]==-1){
            value[i][j]=k;value[m][n]=t;
            
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            }
            else { value[i][j]=k;value[m][n]=t;
            wcandef++;
            System.out.println("cong them o o"+i+j+"co gia tri "+value[i][j]+" "+m+n);
            for(int p=0;p<8;p++){
                for (int q=0;q<8;q++){
                    wKing_run(p,q);
                }
            }
            }
}
private void setback_bbishop(int i,int j){
    
setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    int m,n;
    float p,q;q=value[i][j];
    if(getClick()){
        m=i;n=j;
        boardSquares[m][n].setBackground(Color.GREEN);
        while(m+1<8&&n+1<8){
        m++;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }
        for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }

    else {
        settingboard();
    }
  });
}
private void setback_wknight(int i,int j){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;
    q=value[i][j];
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+2<8&&j+1<8){
        if(value[i+2][j+1]<=0){p=value[i+2][j+1];w_run(i+2,j+1,i,j,p,q);}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]<=0){p=value[i+2][j-1];w_run(i+2,j-1,i,j,p,q);}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]<=0){p=value[i-2][j+1];w_run(i-2,j+1,i,j,p,q);}
    }
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]<=0){p=value[i-2][j-1];w_run(i-2,j-1,i,j,p,q);}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]<=0){p=value[i+1][j+2];w_run(i+1,j+2,i,j,p,q);}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]<=0){p=value[i+1][j-2];w_run(i+1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]<=0){p=value[i-1][j-2];w_run(i-1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]<=0){p=value[i-1][j+2];w_run(i-1,j+2,i,j,p,q);}
    }
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j);
                }
            }
        }
    }
    else settingboard();
});
}
private void setback_bpawn(int i,int j){
setClick(false);
setClick2(false);
move=false;
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;
    q=value[i][j];
    if(getClick()&&i-1>=0){
    boardSquares[i][j].setBackground(Color.GREEN);
   if(value[i-1][j]==0){
       p=value[i-1][j];
        b_run(i-1,j,i,j,p,q);
        if(fisrtb[i][j]==0&&i-2>=0&&value[i-2][j]==0)
        {p=value[i-2][j];
        b_run(i-2,j,i,j,p,q);
        }
   }if(j+1<8&&value[i-1][j+1]>0){
        p=value[i-1][j+1];
        b_run(i-1,j+1,i,j,p,q);
   }
   if(j-1>=0&&value[i-1][j-1]>0){
   p=value[i-1][j-1];
   b_run(i-1,j-1,i,j,p,q);}
    for(int m=0;m<8;m++){
        for(int n=0;n<8;n++){
            if(green[m][n]==0.5f){changeIcon(m,n,i,j);
    }
   }
}
    }
    else {
        settingboard();
    }
  });
}
private void setback_bknight(int i,int j){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;q=value[i][j];
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
    if(i+2<8&&j+1<8){
        if(value[i+2][j+1]>=0){
        p=value[i+2][j+1];
        b_run(i+2,j+1,i,j,p,q);}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]>=0){
            p=value[i+2][j-1];
        b_run(i+2,j-1,i,j,p,q);}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]>=0){p=value[i-2][j+1];b_run(i-2,j+1,i,j,p,q);
    }}
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]>=0){p=value[i-2][j-1];b_run(i-2,j-1,i,j,p,q);}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]>=0){p=value[i+1][j+2];b_run(i+1,j+2,i,j,p,q);}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]>=0){p=value[i+1][j-2];b_run(i+1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]>=0){p=value[i-1][j-2];b_run(i-1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]>=0){p=value[i-1][j+2];b_run(i-1,j+2,i,j,p,q);}
    }
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j);
                }
            }
        }
    }
    else settingboard();
});
}
private void setback_wrook(int i,int j){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        float p,q;
        q=value[i][j];
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n+1<8){
            n++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }n=j;
        while(m-1>=0){
            m--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n-1>=0){
            n--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }else settingboard();
});
}
private void setback_brook(int i,int j){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        float p,q;
        q=value[i][j];
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }else settingboard();
});
}
private void setback_wqueen(int i,int j){
    setClick(false);
    boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        float p,q;
        int m,n;m=i;n=j;
        q=value[i][j];
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n+1<8){
            n++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }n=j;
        while(m-1>=0){
            m--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n-1>=0){
            n--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }n=j;
        while(m+1<8&&n+1<8){
        m++;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_run(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }else settingboard();
});
}
private void setback_bqueen(int i,int j){
    setClick(false);
    boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    if(getClick()){
        int m,n;m=i;n=j;
        float p,q;
        q=value[m][n];
        boardSquares[i][j].setBackground(Color.GREEN);
        while(m+1<8){
            m++;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;p=value[m][n];
            if(value[m][n]>=0){
                b_run(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }
        m=i;n=j;
        boardSquares[m][n].setBackground(Color.GREEN);
        while(m+1<8&&n+1<8){
        m++;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_run(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;}
        for(int t=0;t<8;t++){
            for(int k=0;k<8;k++){
                if(green[t][k]==0.5f){
                    changeIcon(t,k,i,j);
                }
            }
        }
    }else settingboard();
});
}
private void setback_wking(int i,int j){
setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;
    q=value[i][j];
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
     if(i+1<8&&checkmatew[i+1][j]!=-0.5f){
        if(value[i+1][j]<=0){p=value[i+1][j];w_run(i+1,j,i,j,p,q);}}
    if(j+1<8&&checkmatew[i][j+1]!=-0.5f){
        if(value[i][j+1]<=0){p=value[i][j+1];w_run(i,j+1,i,j,p,q);}
    }
    if(j+2<8&&value[i][j+1]==0&&value[i][j+2]==0&&value[i][j+3]==0&&w_castlel&&checkmatew[i][j]!=-1&&checkmatew[i][j+1]!=-0.5f&&checkmatew[i][j+2]!=-0.5f&&checkmatew[i][j+3]!=-0.5f){
            p=value[i][j+2];
         w_run(i,j+2,i,j,p,q);
         movew=true;
     }; 
    if(i+1<8&&j+1<8&&checkmatew[i+1][j+1]!=-0.5f){
        if(value[i+1][j+1]<=0){p=value[i+1][j+1];w_run(i+1,j+1,i,j,p,q);;}}
    if(i-1>=0&&checkmatew[i-1][j]!=-0.5f){
        if(value[i-1][j]<=0){p=value[i-1][j];w_run(i-1,j,i,j,p,q);}}
    if(j-1>=0&&checkmatew[i][j-1]!=-0.5f){
        if(value[i][j-1]<=0){p=value[i][j-1];w_run(i,j-1,i,j,p,q);}
    }
    if(j-2>=0&&value[i][j-1]==0&&value[i][j-2]==0&&w_castler&&checkmatew[i][j]!=-1&&checkmatew[i][j-1]!=-0.5f&&checkmatew[i][j-2]!=-0.5f){
            p=value[i][j-2];
         w_run(i,j-2,i,j,p,q);
         movew=true;
     };   
    if(i-1>=0&&j-1>=0&&checkmatew[i-1][j-1]!=-0.5f){
        if(value[i-1][j-1]<=0){p=value[i-1][j-1];w_run(i-1,j-1,i,j,p,q);}}
    if(i+1<8&&j-1>=0&&checkmatew[i+1][j-1]!=-0.5f){
        if(value[i+1][j-1]<=0){p=value[i+1][j-1];w_run(i+1,j-1,i,j,p,q);}}
    if(i-1>=0&&j+1<8&&checkmatew[i-1][j+1]!=-0.5f){
        if(value[i-1][j+1]<=0){p=value[i-1][j+1];w_run(i-1,j+1,i,j,p,q);}}
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j);
                }
            }
        }
    }
    else settingboard();
});}
private void setback_bking(int i,int j){
    setClick(false);
boardSquares[i][j].addActionListener((java.awt.event.ActionEvent evt) -> {
    float p,q;
    q=value[i][j];
    if(getClick()){
        boardSquares[i][j].setBackground(Color.GREEN);
     if(i+1<8&&checkmateb[i+1][j]!=0.5f){
        if(value[i+1][j]>=0){p=value[i+1][j];b_run(i+1,j,i,j,p,q);}}
    if(j+1<8&&checkmateb[i][j+1]!=0.5f){
        if(value[i][j+1]>=0){p=value[i][j+1];b_run(i,j+1,i,j,p,q);}
    }
    if(j+2<8&&value[i][j+1]==0&&value[i][j+2]==0&&value[i][j+3]==0&&b_castler&&checkmateb[i][j]!=1&&checkmateb[i][j+1]!=0.5f&&checkmateb[i][j+2]!=0.5f&&checkmateb[i][j+3]!=0.5f){
            p=value[i][j+2];
         b_run(i,j+2,i,j,p,q);
         moveb=true;
     }; 
    if(i+1<8&&j+1<8&&checkmateb[i+1][j+1]!=0.5f){
        if(value[i+1][j+1]>=0){p=value[i+1][j+1];b_run(i+1,j+1,i,j,p,q);;}}
    if(i-1>=0&&checkmateb[i-1][j]!=0.5f){
        if(value[i-1][j]>=0){p=value[i-1][j];b_run(i-1,j,i,j,p,q);}}
    if(j-1>=0&&checkmateb[i][j-1]!=0.5f){
        if(value[i][j-1]>=0){p=value[i][j-1];b_run(i,j-1,i,j,p,q);}
    }
    if(j-2>=0&&value[i][j-1]==0&&value[i][j-2]==0&&b_castlel&&checkmateb[i][j]!=1&&checkmateb[i][j-1]!=0.5f&&checkmateb[i][j-2]!=0.5f){
            p=value[i][j-2];
         b_run(i,j-2,i,j,p,q);
         moveb=true;
     };    
    if(i-1>=0&&j-1>=0&&checkmateb[i-1][j-1]!=0.5f){
        if(value[i-1][j-1]>=0){p=value[i-1][j-1];b_run(i-1,j-1,i,j,p,q);}}
    if(i+1<8&&j-1>=0&&checkmateb[i+1][j-1]!=0.5f){
        if(value[i+1][j-1]>=0){p=value[i+1][j-1];b_run(i+1,j-1,i,j,p,q);}}
    if(i-1>=0&&j+1<8&&checkmateb[i-1][j+1]!=0.5f){
        if(value[i-1][j+1]>=0){p=value[i-1][j+1];b_run(i-1,j+1,i,j,p,q);}}
    for(int m=0;m<8;m++){
            for(int n=0;n<8;n++){
                if(green[m][n]==0.5f){
                    changeIcon(m,n,i,j);
                }
            }
        }
    }
    else settingboard();
});
}public void actionPerformed(ActionEvent e) {
   for(int i=0;i<8;i++){
       for(int j=0;j<8;j++){
            playchess(i,j);
       }
   }
   if(checkmateb[row2][col2]==1&&bcandef==0){
    int option = JOptionPane.showOptionDialog(null, "White win!!!", "ENDGAME", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, null);
        
        if (option == JOptionPane.OK_OPTION) {
            // Nút "OK" được nhấn
            new Home().setVisible(true);       
        dispose();
        }
    }
if(checkmatew[row1][col1]==-1&&wcandef==0){
    int option = JOptionPane.showOptionDialog(null, "Black win!!!", "ENDGAME", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"OK"}, null);
        
        if (option == JOptionPane.OK_OPTION) {
            // Nút "OK" được nhấn
            new Home().setVisible(true);       
        dispose();
        }
    }
}
private void playchess(int i,int j){
    if(turn==true){
         if(checkmatew[row1][col1]==-1){wcan_Def(i,j);System.out.println(wcandef);}
        if(value[i][j]==1){
        setback_wpawn(i,j); 
    }
        else if(value[i][j]==5){
        setback_wqueen(i,j);
    }
        else if(value[i][j]==6){
        setback_wking(i,j);
    }
        else if(value[i][j]==4){
        setback_wrook(i,j);
    }
        else if(value[i][j]==3){
        setback_wknight(i,j);
    }
        else if(value[i][j]==2){
        setback_wbishop(i,j);
    }
    }
    else{
    if(checkmateb[row2][col2]==1){bcan_Def(i,j);}
    if(value[i][j]==-1){
        setback_bpawn(i,j);   
    }
    
    else if(value[i][j]==-2){
        setback_bbishop(i,j);
    }
    
    else if(value[i][j]==-3){
        setback_bknight(i,j);
    }else if(value[i][j]==-4){
        setback_brook(i,j);
    }
    
    else if(value[i][j]==-5){
        setback_bqueen(i,j);
    }
    
    else if(value[i][j]==-6){
        setback_bking(i,j);
    }}
}
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

private void bKing_run(int i,int j){
    int m,n;
    if(value[i][j]==1){
        if(j+1<8&&i+1<8){ 
            if(value[i+1][j+1]==-6){checkmateb[i+1][j+1]=1;}
            else checkmateb[i+1][j+1]=0.5f;}
   if(j-1>=0&&i+1<8){
       if(value[i+1][j-1]==-6){checkmateb[i+1][j-1]=1;}
       else checkmateb[i+1][j-1]=0.5f;}
    }
    else if(value[i][j]==2||value[i][j]==5){
        m=i;n=j;
        
        while(m+1<8&&n+1<8){
        m++;n++;
        if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
    }    m=i;n=j;
        m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]==0){
       checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]==0){
       checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
    }}
    if(value[i][j]==4||value[i][j]==5){
        m=i;n=j;
        while(m+1<8){
            m++;
            if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
            }
        m=i;
        while(n+1<8){
            n++;
            if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
          
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]==0){
        checkmateb[m][n]=0.5f;}
        else if(value[m][n]==-6){
            checkmateb[m][n]=1;
        }
            else {checkmateb[m][n]=0.5f;break;}
        }}
    
     else if(value[i][j]==3){
        if(i+2<8&&j+1<8){
            if(value[i+2][j+1]<=0){checkmateb[i+2][j+1]=0.5f;
            if(value[i+2][j+1]==-6){checkmateb[i+2][j+1]=1;}
           }
        }
        if(i+2<8&&j-1>=0){
            if(value[i+2][j-1]<=0){checkmateb[i+2][j-1]=0.5f;
            if(value[i+2][j-1]==-6){checkmateb[i+2][j-1]=1;}}
        }
        if(i-2>=0&&j+1<8){
            if(value[i-2][j+1]<=0){checkmateb[i-2][j+1]=0.5f;
            if(value[i-2][j+1]==-6){checkmateb[i-2][j+1]=1;}}
        }
        if(i-2>=0&&j-2>=0){
            if(value[i-2][j-1]<=0){checkmateb[i-2][j-1]=0.5f;
            if(value[i-2][j-1]==-6){checkmateb[i-2][j-1]=1;}}
        }
        if(i+1<8&&j+2<8){
            if(value[i+1][j+2]<=0){checkmateb[i+1][j+2]=0.5f;
            if(value[i+1][j+2]==-6){checkmateb[i+1][j+2]=1;}}
        }
        if(i+1<8&&j-2>=0){
            if(value[i+1][j-2]<=0){checkmateb[i+1][j-2]=0.5f;
            if(value[i+1][j-2]==-6){checkmateb[i+1][j-2]=1;}}
        }
        if(i-1>=0&&j-2>=0){
            if(value[i-1][j-2]<=0){checkmateb[i-1][j-2]=0.5f;
            if(value[i-1][j-2]==-6){checkmateb[i-1][j-2]=1;}}
        }
        if(i-1>=0&&j+2<8){
            if(value[i-1][j+2]<=0){checkmateb[i-1][j+2]=0.5f;
            if(value[i-1][j+2]==-6){checkmateb[i-1][j+2]=1;}}
        }
     }
}
private void wKing_run(int i,int j){
    int m,n;
    if(value[i][j]==-1){
        if(j+1<8&&i-1>=0){ 
        if(value[i-1][j+1]==6){checkmatew[i-1][j+1]=-1;}
        else checkmatew[i-1][j+1]=-0.5f;}
   if(j-1>=0&&i-1>=0){
        if(value[i-1][j-1]==6){checkmatew[i-1][j-1]=-1;}
            else checkmatew[i-1][j-1]=-0.5f;}
    }
    if(value[i][j]==-2||value[i][j]==-5){
        m=i;n=j;
        
        while(m+1<8&&n+1<8){
            m++;n++;
        if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
    }   m=i;n=j;
        while(m-1>=0&&n-1>=0){
        m--;n--;
        if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
    }}
    if(value[i][j]==-4||value[i][j]==-5){
        m=i;n=j;
        while(m+1<8){
            m++;
            if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
            }
        m=i;
        while(n+1<8){
            n++;
            if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
        }n=j;
        while(m-1>=0){
            m--;
            if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
          
        }m=i;
        while(n-1>=0){
            n--;
            if(value[m][n]==0){
        checkmatew[m][n]=-0.5f;}
        else if(value[m][n]==6){
            checkmatew[m][n]=-1;
        }
            else {checkmatew[m][n]=-0.5f;break;}
        }}
     else if(value[i][j]==-3){
        if(i+2<8&&j+1<8){
            if(value[i+2][j+1]>=0){checkmatew[i+2][j+1]=-0.5f;
            if(value[i+2][j+1]==6){checkmatew[i+2][j+1]=-1;}
        }
        if(i+2<8&&j-1>=0){
            if(value[i+2][j-1]>=0){checkmatew[i+2][j-1]=-0.5f;
            if(value[i+2][j-1]==6){checkmatew[i+2][j-1]=-1;}}
        }
        if(i-2>=0&&j+1<8){
            if(value[i-2][j+1]>=0){checkmatew[i-2][j+1]=-0.5f;
            if(value[i-2][j+1]==6){checkmatew[i-2][j+1]=-1;}}
        }
        if(i-2>=0&&j-1>=0){
            if(value[i-2][j-1]>=0){checkmatew[i-2][j-1]=-0.5f;
            if(value[i-2][j-1]==6){checkmatew[i-2][j-1]=-1;}}
        }
        if(i+1<8&&j+2<8){
            if(value[i+1][j+2]>=0){checkmatew[i+1][j+2]=-0.5f;
            if(value[i+1][j+2]==6){checkmatew[i+1][j+2]=-1;}}
        }
        if(i+1<8&&j-2>=0){
            if(value[i+1][j-2]>=0){checkmatew[i+1][j-2]=-0.5f;
            if(value[i+1][j-2]==6){checkmatew[i+1][j-2]=-1;}}
        }
        if(i-1>=0&&j-2>=0){
            if(value[i-1][j-2]>=0){checkmatew[i-1][j-2]=-0.5f;
            if(value[i-1][j-2]==6){checkmatew[i-1][j-2]=-1;}}
        }
        if(i-1>=0&&j+2<8){
            if(value[i-1][j+2]>=0){checkmatew[i-1][j+2]=-0.5f;
            if(value[i-1][j+2]==6){checkmatew[i-1][j+2]=-1;}}
        }
     }}
}
private void bcan_Def(int i,int j){
    float p,q;
    int m,n;m=i;n=j;
    q=value[i][j];
    if(value[i][j]==-1){
        if(value[i-1][j]==0){
       p=value[i-1][j];
        b_def(i-1,j,i,j,p,q);
        if(value[i-2][j]==0&&fisrtb[i][j]==0&&i-2>=0)
        {p=value[i-2][j];
        b_def(i-2,j,i,j,p,q);
        }
   }if(j+1<8&&value[i-1][j+1]>0){
        p=value[i-1][j+1];
        b_def(i-1,j+1,i,j,p,q);
   }
   if(j-1>=0&&value[i-1][j-1]>0){
   p=value[i-1][j-1];
   b_def(i-1,j-1,i,j,p,q);}
    }
    else if(value[i][j]==-2||value[i][j]==-5){
        m=i;n=j;
        while(m+1<8&&n+1<8){
        m++;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_def(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_def(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;p=value[m][n];
        if(value[m][n]>=0){
            b_def(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;p=value[m][n];
        if(value[m][n]>=0){
            b_def(m,n,i,j,p,q);
        if(value[m][n]>0)break;}else break;
    }
    }
    else if(value[i][j]==-3){
        if(i+2<8&&j+1<8){
        if(value[i+2][j+1]>=0){
        p=value[i+2][j+1];
        b_def(i+2,j+1,i,j,p,q);}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]>=0){
            p=value[i+2][j-1];
        b_def(i+2,j-1,i,j,p,q);}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]>=0){p=value[i-2][j+1];b_def(i-2,j+1,i,j,p,q);
    }}
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]>=0){p=value[i-2][j-1];b_def(i-2,j-1,i,j,p,q);}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]>=0){p=value[i+1][j+2];b_def(i+1,j+2,i,j,p,q);}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]>=0){p=value[i+1][j-2];b_def(i+1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]>=0){p=value[i-1][j-2];b_def(i-1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]>=0){p=value[i-1][j+2];b_def(i-1,j+2,i,j,p,q);}
    }
    }
    if(value[i][j]==-5||value[i][j]==-4){
        m=i;n=j;
        while(m+1<8){
            m++;p=value[m][n];
            if(value[m][n]>=0){
                b_def(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n+1<8){
            n++;p=value[m][n];
            if(value[m][n]>=0){
                b_def(m,n,i,j,p,q);
                if(value[m][n]>0)break;
            }else break;
        }n=j;
        while(m-1>=0){
            m--;p=value[m][n];
            if(value[m][n]>=0){
                b_def(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }m=i;
        while(n-1>=0){
            n--;p=value[m][n];
            if(value[m][n]>=0){
                b_def(m,n,i,j,p,q);
            if(value[m][n]>0)break;
            }else break;
        }
    }
    if(value[i][j]==-6){
         if(i+1<8&&checkmateb[i+1][j]!=0.5f){
        if(value[i+1][j]>=0){p=value[i+1][j];b_def(i+1,j,i,j,p,q);}}
    if(j+1<8&&checkmateb[i][j+1]!=0.5f){
        if(value[i][j+1]>=0){p=value[i][j+1];b_def(i,j+1,i,j,p,q);}}
    if(i+1<8&&j+1<8&&checkmateb[i+1][j+1]!=0.5f){
        if(value[i+1][j+1]>=0){p=value[i+1][j+1];b_def(i+1,j+1,i,j,p,q);;}}
    if(i-1>=0&&checkmateb[i-1][j]!=0.5f){
        if(value[i-1][j]>=0){p=value[i-1][j];b_def(i-1,j,i,j,p,q);}}
    if(j-1>=0&&checkmateb[i][j-1]!=0.5f){
        if(value[i][j-1]>=0){p=value[i][j-1];b_def(i,j-1,i,j,p,q);}}
    if(i-1>=0&&j-1>=0&&checkmateb[i-1][j-1]!=0.5f){
        if(value[i-1][j-1]>=0){p=value[i-1][j-1];b_def(i-1,j-1,i,j,p,q);}}
    if(i+1<8&&j-1>=0&&checkmateb[i+1][j-1]!=0.5f){
        if(value[i+1][j-1]>=0){p=value[i+1][j-1];b_def(i+1,j-1,i,j,p,q);}}
    if(i-1>=0&&j+1<8&&checkmateb[i-1][j+1]!=0.5f){
        if(value[i-1][j+1]>=0){p=value[i-1][j+1];b_def(i-1,j+1,i,j,p,q);}}
    }
}
private void wcan_Def(int i,int j){
    int m,n;m=i;n=j;
    float p,q;
    q=value[m][n];
    if(value[i][j]==1){
        if(value[i+1][j]==0){
        p=value[i+1][j];
        w_def(i+1,j,i,j,p,q);
        if(value[i+2][j]==0&&fisrtw[i][j]==0&&i+2<8)
        {p=value[i+2][j];
        w_def(i+2,j,i,j,p,q);
        }
   }if(j+1<8&&i+1<8&&value[i+1][j+1]<0){
        p=value[i+1][j+1];
        w_def(i+1,j+1,i,j,p,q);}
   if(j-1>=0&&i+1<8&&value[i+1][j-1]<0){
        p=value[i+1][j-1];
        w_def(i+1,j-1,i,j,p,q);}    }
    else if(value[i][j]==2||value[i][j]==5){
        m=i;n=j;
        while(m+1<8&&n+1<8){
        m++;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }   m=i;n=j;
        
        while(m-1>=0&&n-1>=0){
        m--;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }     m=i;n=j;
        while(m+1<8&&n-1>=0){
        m++;n--;
        p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }m=i;n=j;
        while(m-1>=0&&n+1<8){
        m--;n++;
        p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
    }
    }
    else if(value[i][j]==3){
        if(i+2<8&&j+1<8){
        if(value[i+2][j+1]<=0){p=value[i+2][j+1];w_def(i+2,j+1,i,j,p,q);}
    }
    if(i+2<8&&j-1>=0){
        if(value[i+2][j-1]<=0){p=value[i+2][j-1];w_def(i+2,j-1,i,j,p,q);}
    }
    if(i-2>=0&&j+1<8){
        if(value[i-2][j+1]<=0){p=value[i-2][j+1];w_def(i-2,j+1,i,j,p,q);}
    }
    if(i-2>=0&&j-1>=0){
        if(value[i-2][j-1]<=0){p=value[i-2][j-1];w_def(i-2,j-1,i,j,p,q);}
    }
    if(i+1<8&&j+2<8){
        if(value[i+1][j+2]<=0){p=value[i+1][j+2];w_def(i+1,j+2,i,j,p,q);}
    }
    if(i+1<8&&j-2>=0){
        if(value[i+1][j-2]<=0){p=value[i+1][j-2];w_def(i+1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j-2>=0){
        if(value[i-1][j-2]<=0){p=value[i-1][j-2];w_def(i-1,j-2,i,j,p,q);}
    }
    if(i-1>=0&&j+2<8){
        if(value[i-1][j+2]<=0){p=value[i-1][j+2];w_def(i-1,j+2,i,j,p,q);}
    }
    }
    if(value[i][j]==4||value[i][j]==5){
        m=i;n=j;
        while(m+1<8){
            m++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n+1<8){
            n++;
            p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }n=j;
        while(m-1>=0){
            m--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }m=i;
        while(n-1>=0){
            n--;
            p=value[m][n];
        if(value[m][n]<=0){
            w_def(m,n,i,j,p,q);
        if(value[m][n]<0)break;}else break;
        }
    }
    else if(value[i][j]==6){
        if(i+1<8&&checkmatew[i+1][j]!=-0.5f){
        if(value[i+1][j]<=0){p=value[i+1][j];w_def(i+1,j,i,j,p,q);}}
    if(j+1<8&&checkmatew[i][j+1]!=-0.5f){
        if(value[i][j+1]<=0){p=value[i][j+1];w_def(i,j+1,i,j,p,q);}}
    if(i+1<8&&j+1<8&&checkmatew[i+1][j+1]!=-0.5f){
        if(value[i+1][j+1]<=0){p=value[i+1][j+1];w_def(i+1,j+1,i,j,p,q);}}
    if(i-1>=0&&checkmatew[i-1][j]!=-0.5f){
        if(value[i-1][j]<=0){p=value[i-1][j];w_def(i-1,j,i,j,p,q);}}
    if(j-1>=0&&checkmatew[i][j-1]!=-0.5f){
        if(value[i][j-1]<=0){p=value[i][j-1];w_def(i,j-1,i,j,p,q);}}
    if(i-1>=0&&j-1>=0&&checkmatew[i-1][j-1]!=-0.5f){
        if(value[i-1][j-1]<=0){p=value[i-1][j-1];w_def(i-1,j-1,i,j,p,q);}}
    if(i+1<8&&j-1>=0&&checkmatew[i+1][j-1]!=-0.5f){
        if(value[i+1][j-1]<=0){p=value[i+1][j-1];w_def(i+1,j-1,i,j,p,q);}}
    if(i-1>=0&&j+1<8&&checkmatew[i-1][j+1]!=-0.5f){
        if(value[i-1][j+1]<=0){p=value[i-1][j+1];w_def(i-1,j+1,i,j,p,q);}}
    }
}
   public static void main(String[] args) {
      new ChessBoard();
   }
}