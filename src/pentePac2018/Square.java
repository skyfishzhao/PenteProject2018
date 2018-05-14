package pentePac2018;

import java.awt.Color;
import java.awt.Graphics;

public class Square
{
  
  
      private int xLoc, yLoc;
      private int sideLength;
      private int squareState;
     
      private Color bColor = new Color(253, 247, 201);
      
      private Color redStoneColor = new Color(219, 28, 95);
      private Color redDarkStoneColor = new Color(175, 8, 86);
      private Color redLightStoneColor = new Color(247, 46, 93);
      
      private Color goldStoneColor = new Color(224, 206, 87);
     // private Color goldDarkStoneColor = new Color(165, 141, 33);
      private Color goldDarkStoneColor = new Color(165, 160, 33);
      private Color goldLightStoneColor = new Color(249, 222, 14);
      
      private Color stoneShadowColor = new Color(132, 132, 116);
      
      private int nextMovePriority = -1;  //all priorities would positive.
      private int moveOorD = 0;   // Zero is neither
      
      public Square(int x, int y, int len) 
      {
          xLoc = x;
          yLoc = y;
          sideLength = len;
          squareState = PenteGame.EMPTY;
          
          
      }
      
      public void drawMe(Graphics g)
      {
        
        
            
            //Set Background
            g.setColor(bColor);
            //Draw background Square
            g.fillRect(xLoc, yLoc, sideLength, sideLength);
            
          
            //for drawing Available moves
            drawAvailableMoves(g);
            
            //if there is a stone draw a shadow
            if(squareState!= PenteGame.EMPTY)
            {
                  g.setColor(stoneShadowColor);
                  g.fillOval (
                      xLoc + (int)(sideLength * 0.1 +2),
                      yLoc + (int)(sideLength * 0.1 +2 ),
                      (int)(sideLength * 0.8),
                      (int)(sideLength * 0.8 )
                      );
                    
            }
           
          
            // line for placing stone
            g.setColor(Color.darkGray);
            //draw vertical line...
            g.drawLine(xLoc + (sideLength/2), yLoc, xLoc + (sideLength/2), yLoc + (sideLength));
            //draw horizontal line
            g.drawLine(xLoc, yLoc + (sideLength/2) , xLoc + sideLength, yLoc + (sideLength/2));
            
           // g.setColor(Color.WHITE);
           // g.drawRect(xLoc, yLoc, sideLength, sideLength);
          
            
            
            if(squareState != PenteGame.EMPTY)
            {
                    g.fillOval (
                        xLoc + (int)(sideLength * 0.1),
                        yLoc + (int)(sideLength * 0.1),
                        (int)(sideLength * 0.8),
                        (int)(sideLength * 0.8 )
                        );
            }
            
            
            if(squareState == PenteGame.RED)
            {
              
                  g.setColor(redDarkStoneColor); 
                  g.fillOval (
                      xLoc + (int)(sideLength * 0.1),
                      yLoc + (int)(sideLength * 0.1),
                      (int)(sideLength * 0.8),
                      (int)(sideLength * 0.8 )
                      );
              
                  g.setColor(redLightStoneColor); 
                  
                  g.fillOval (
                      xLoc + (int)(sideLength * 0.1),
                      yLoc + (int)(sideLength * 0.1),
                      (int)(sideLength * 0.8-3),
                      (int)(sideLength * 0.8  -3 )
                      );
            }
            
            
            if(squareState == PenteGame.GOLD)
            {
              
                  g.setColor(goldDarkStoneColor); 
                  g.fillOval (
                      xLoc + (int)(sideLength * 0.1),
                      yLoc + (int)(sideLength * 0.1),
                      (int)(sideLength * 0.8),
                      (int)(sideLength * 0.8 )
                      );
              
                  g.setColor(goldLightStoneColor); 
                  
                  g.fillOval (
                      xLoc + (int)(sideLength * 0.1),
                      yLoc + (int)(sideLength * 0.1),
                      (int)(sideLength * 0.8-3),
                      (int)(sideLength * 0.8  -3 )
                      );
            }
            

      }
      
      
      public void drawAvailableMoves(Graphics g)
      {
                if(this.nextMovePriority > -1)
                {
                  
                  if(moveOorD == ComputerMoveGenerator.OFFENSE)
                  {
                        g.setColor(Color.GREEN);
                        
                  } else {
                    
                        g.setColor(Color.BLUE);
                  }
                  
                  g.drawOval (
                      xLoc + (int)(sideLength * 0.1),
                      yLoc + (int)(sideLength * 0.1),
                      (int)(sideLength * 0.8),
                      (int)(sideLength * 0.8 )
                      );
                  String s = "NMP= " + nextMovePriority;
                  g.drawString(s, xLoc+ (int)(sideLength * 0.3), (int)(sideLength * 0.3));
                  
                }
      }
      
      
      public void setState(int newState)
      {
          squareState = newState;
      }
      
      
      
      public int getState()
      {
          return squareState;
      }
      
      public boolean thisSquareClicked(int checkX, int checkY)
      {
        //This gives each square an ability to check to see if it was clicked.
          boolean gotClicked = false;
          
          if( checkX >= xLoc &&  checkX < xLoc + sideLength)
            if( checkY >= yLoc &&  checkY < yLoc + sideLength)
              gotClicked = true;
          
          
          return gotClicked;
      }
      
     //accessor methods. 
      public void setNextMovePriority(int newP, int OorD)
      {
            nextMovePriority = newP;
            moveOorD = OorD;
      }
      
      
      public int getNextMovePriority()
      {
            return nextMovePriority;
      }
      
      public void resetNextMovePriority()
      {
            nextMovePriority = -1;
      }
      
      

}
