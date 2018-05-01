package pentePac2018;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PenteGame extends JPanel implements MouseListener 
{
  
        public static final int SQUARES_ON_SIDE = 19;  //literal
        public static final int EMPTY = 0;
        public static final int RED = 1;
        public static final int GOLD = -1;
        
        
        
        private int width, height;
        private Color bColor = Color.MAGENTA;
        //Two new variables....for frame awesomeness...
        private JFrame myFrame;
        private int frameBorder;
        //I'm adding this for turns
        private int whoseTurn = RED;
        
        //We need variables to remember captures
        private int redCaptures = 0;
        private int goldCaptures = 0;
        
        // make and instance -- instantiate
       
        //Declaration...
        //private Square testSquare;
        //private Square[ ][testRow;
        
        // We make an array to hold all the board Squares
        private Square[ ][ ] board;
  
        
        
        
        //Constructor
        public PenteGame ( int w, int h, int b, JFrame f )
        {
              //capture info about frame and border...
              myFrame = f;
              frameBorder = b;
              
              width = w;
              height = h;
              
             // this.setSize(width, height);
              
              //Making the object....
              
              // Initializing the array to size 19
              board = new Square[SQUARES_ON_SIDE] [SQUARES_ON_SIDE];
              
              
              //now use loops to put in the squares on the board
              //This makes 361 Squares....
              int squareLength = (int)(Math.round(width/ this.SQUARES_ON_SIDE));
              
              width = (SQUARES_ON_SIDE * squareLength) + (frameBorder * 2);
              height = SQUARES_ON_SIDE * squareLength + (frameBorder * 2);
              
              myFrame.setResizable(true);
              myFrame.setSize(width*5, (height+20) *5);
            
              myFrame.repaint();
              this.setSize(width, height);
              
              int xStart = frameBorder;
              int yStart = frameBorder;
              
              // These loops generate all the squares.
              for(int c = 0; c < SQUARES_ON_SIDE; c++)
              {
                     yStart = frameBorder;
                      for(int r = 0; r < SQUARES_ON_SIDE; r++)
                      {
                         board[r][c] = new Square(xStart, yStart, squareLength);
                         yStart += squareLength;
                         // this is to test square states
                        
                           //board[r][c].setState(this.RED);
                        
                      }
                      
                         xStart += squareLength;
                
              }
              
              
              this.addMouseListener(this);
              
           

              
        }
        
        
       public void paintComponent(java.awt.Graphics g)
       {
         
           myFrame.setSize(width, height+20);
           g.setColor(bColor);
           g.fillRect(0, 0, width, height);
           
          //testSquare.drawMe(g);
           
           
           // These loops draw all the squares.
           for(int r = 0; r < SQUARES_ON_SIDE; r++)
           {
                   for(int c = 0; c < SQUARES_ON_SIDE; c++)
                   {
                      board[r][c].drawMe(g);    
                   }  
           }
           
         
       }


      public void mouseClicked(MouseEvent e)
      {
        // TODO Auto-generated method stub
        
      }


      public void mousePressed(MouseEvent e)
      {
        // TODO Auto-generated method stub
        
            //System.out.println("Hi -- I can't talk either because I have no voice");
            
            System.out.println("You clicked at " + e.getX() + ", " + e.getY() );
            
            
            this.checkClick(e.getX(), e.getY() );
        
      }
      
      public void checkClick(int mouseX, int mouseY){
        Square ClickedSquare;   //temporary square that holds a link to where you clicked
        for(int r = 0; r < SQUARES_ON_SIDE; r++)
        {
                for(int c = 0; c < SQUARES_ON_SIDE; c++)
                {
                      if(board[r][c].thisSquareClicked(mouseX, mouseY)  == true){
                        ClickedSquare = board[r][c];
                        
                        System.out.println("you clicked on Square " + r + ", " + c);
                     
                        if(ClickedSquare.getState()==EMPTY){
                            ClickedSquare.setState(whoseTurn);
                            
                            //NOW Check for Captures....
                            checkForCaptures(r, c);
                            
                            this.changeTurn();
                            this.repaint();
                        } else {
                           javax.swing.JOptionPane.showMessageDialog(null, "YOU CAN'T CLICK HERE");
                        }
                        
                      }
                }        
        }
      }
      
      
      public void checkForCaptures(int row, int col){
           checkRightHorizontal(row, col);
           
        
      }
      
      public void checkRightHorizontal(int row, int col)
      {
        repaint();
        // Step1 -- find out who we are looking for....
          int lookingFor;
          if(whoseTurn == PenteGame.RED)
          {
               lookingFor = PenteGame.GOLD;
               
          } else {
                lookingFor = PenteGame.RED;
             
          }
          
          
          
          if(col <=15)
          {
                if(board[row][col+1].getState()==lookingFor)
                  if(board[row][col+2].getState()==lookingFor)
                    if(board[row][col+3].getState()==whoseTurn)
                    {
                          System.out.println("This should be a capture");
                          
                          board[row][col+1].setState(PenteGame.EMPTY);
                          board[row][col+2].setState(PenteGame.EMPTY);
                          repaint();
                          
                          if(whoseTurn == PenteGame.GOLD)
                          {
                            goldCaptures ++;
                            String g = "Good Job, Gold!!! You have " + goldCaptures + " captures!";
                            javax.swing.JOptionPane.showMessageDialog(null, g);
                          } else {
                            redCaptures ++;
                            String r = "Good Job, Red!!! You have " + redCaptures + " captures!";
                            javax.swing.JOptionPane.showMessageDialog(null, r);
                          }
                          
                         
                     
                    }       
          }
       
      }
      
      
      
      
      
      public void changeTurn(){
        whoseTurn *= -1;
      }


      public void mouseReleased(MouseEvent e)
      {
        // TODO Auto-generated method stub
        
      }


      public void mouseEntered(MouseEvent e)
      {
        // TODO Auto-generated method stub
        
      }


      public void mouseExited(MouseEvent e)
      {
        // TODO Auto-generated method stub
        
      }
        
        
        
        
        
        
        

}
