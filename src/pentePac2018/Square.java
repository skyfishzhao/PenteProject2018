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
      private Color goldStoneColor = new Color(224, 206, 87);
      private Color stoneShadowColor = new Color(132, 132, 116);
      
      
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
            
           
          
            // line for placing stone
            g.setColor(Color.darkGray);
            //draw vertical line...
            g.drawLine(xLoc + (sideLength/2), yLoc, xLoc + (sideLength/2), yLoc + (sideLength));
            //draw horizontal line
            g.drawLine(xLoc, yLoc + (sideLength/2) , xLoc + sideLength, yLoc + (sideLength/2));
            
           // g.setColor(Color.WHITE);
           // g.drawRect(xLoc, yLoc, sideLength, sideLength);
          
           
            
            if(squareState == PenteGame.GOLD)
                g.setColor(goldStoneColor);
            
          
            
            if(squareState == PenteGame.RED)
                 g.setColor(redStoneColor);
            
            
            if(squareState != PenteGame.EMPTY)
            {
                    g.fillOval (
                        xLoc + (int)(sideLength * 0.1),
                        yLoc + (int)(sideLength * 0.1),
                        (int)(sideLength * 0.8),
                        (int)(sideLength * 0.8 )
                        );
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
      
      

}
