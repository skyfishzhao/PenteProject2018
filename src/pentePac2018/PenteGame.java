package pentePac2018;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PenteGame extends JPanel
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
              for(int r = 0; r < SQUARES_ON_SIDE; r++)
              {
                     yStart = frameBorder;
                      for(int c = 0; c < SQUARES_ON_SIDE; c++)
                      {
                         board[r][c] = new Square(xStart, yStart, squareLength);
                         yStart += squareLength;
                         // this is to test square states
                        
                           board[r][c].setState(this.RED);
                        
                      }
                      
                         xStart += squareLength;
                
              }
              
              
         
           

              
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
        
        
        
        
        
        
        

}
