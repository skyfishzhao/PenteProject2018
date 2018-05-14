package pentePac2018;

import java.util.ArrayList;

public class StoneGroup
{
        private int groupColor;  //This will be either RED or GOLD
        private int oppositeColor;
        private ArrayList<Square> stonesInGroup;
        private Square leftEnd = null;
        private Square rightEnd = null;
        
        private int groupRanking;
        
      
        public StoneGroup( ArrayList<Square> stones, int color)
        {
              stonesInGroup = stones;
              groupColor = color;
        }
        
        public int  numStones()
        {
              return stonesInGroup.size();
        }
        
        public void setLeftEnd(Square l)
        {
               leftEnd = l;
        }
        
        public void setRightEnd(Square r)
        {
              rightEnd = r;
        }
        
        public void generateRanking(){
      
               groupRanking = 2*stonesInGroup.size();
                
                if( 
                    (leftEnd == null  || leftEnd.getState() == oppositeColor)
                  &&
                  (rightEnd == null  || leftEnd.getState() == oppositeColor)
                  )
                {       
                          groupRanking = 0;  //there is no need to address this one

                } else {
                  
                        if( 
                            (leftEnd.getState() == oppositeColor && rightEnd.getState() == PenteGame.EMPTY)
                            ||
                            (rightEnd.getState() == oppositeColor && leftEnd.getState() == PenteGame.EMPTY)
                            )
                        {
                              groupRanking += 2;
                              if( stonesInGroup.size() == 2)
                              {
                                  groupRanking +=2;
                              }
                        } else {
                              if(
                                  (leftEnd == null && rightEnd.getState() == PenteGame.EMPTY)
                                  ||
                                  (rightEnd == null && leftEnd.getState() == PenteGame.EMPTY)
                                  ) 
                              {
                                    groupRanking += 2;
                              }
                          
                        }
                  
                }
          
        }
  
  
}
