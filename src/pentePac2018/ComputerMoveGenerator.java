package pentePac2018;

import java.awt.Point;
import java.util.ArrayList;

public class ComputerMoveGenerator
{
  
  Square[][] board;
  PenteGame myGame;
  
  ArrayList<StoneGroup>redGroupList;
  ArrayList<StoneGroup> goldGroupList;
  
  
  public static final int OFFENSE = 1;
  public static final int DEFENSE = -1;
  
  
  //new idea to make Squares have priority..
  ArrayList<Square> offenseMoveList;  //this could be either red or gold
  ArrayList<Square> defenseMoveList;  //this could be either red or gold
  
  
  
  
  public ComputerMoveGenerator( Square[][] b, PenteGame game){
        board = b;
        myGame = game;
        System.out.println("Computer Move Generator is ready");
    
  }
  
  public void makeAComputerMove(int lastRow, int lastCol){
        //This is the heart of the move generator
        //Rules Based System
        //Rule1 -- go for win  (Chapin's Rule)
        //Rule2 -- stop opponent from winning (Chapin's other rule)
        // Rule 3 -- Ariah's Rule is put stone next to last move
        //Rule [last] -- Make Random Move (low priority)
    
        //busy loop to simulate thinking...
//        for(int w= 0; w < 100000; ++w)
//        {
//          System.out.println("computer is thinking...");
//        }
         
          //System.out.println("Hi, in top of make a computer move right before call to find stone groups");
    
    
        //**********************ADDED May 12-13 to check for better moves................
        //note this is being tested to its not 100% on line yet
        if(myGame.getWhoIsRed()== "Computer"){
          this.findStoneGroups(PenteGame.RED);
        } else {
          this.findStoneGroups(PenteGame.GOLD);
        }
         //***********************
        
        
        boolean didMove = makeAriahMove(lastRow, lastCol);
        if(didMove == false) 
        {
            doRandomMove();
        }
        
  }
  
  public boolean makeAriahMove( int row, int col){
    boolean didIDoMove = false;
    
              ArrayList<Point> available = new ArrayList<Point>();
              for(int r= -1; r <=1; r++)
              {
                      for(int c= -1; c<=1; c++)
                      {
                             if( row + r >=0 && row+r < 19)
                             {
                                     if( col + c >=0 && col+c< 19)
                                     {
                                            if( board[row + r][col + c].getState() == PenteGame.EMPTY){
                                              System.out.println("board[" + (row+r) + "][" + (col+c) +"] is available");
                                              available.add(new Point(row + r, col + c));
                                            }
                                     }
                             }
                      }
              }
              
              if( available.size() > 0)
              {
                      Point whichOne = available.get( (int)(Math.random() * available.size()) );
                
                      if(myGame.getWhoseTurn()==PenteGame.RED)
                      {
                        board [ (int)(whichOne.getX() ) ] [(int)(whichOne.getY()) ].setState(PenteGame.RED);
                      } else {
                        board [ (int)(whichOne.getX() ) ] [(int)(whichOne.getY()) ].setState(PenteGame.GOLD);
                      }
                      
                      myGame.checkForCaptures( (int)(whichOne.getX() ), (int)(whichOne.getY()));
                      myGame.changeTurn();
                      myGame.repaint();
                      didIDoMove = true;
                
              }
    
             
    
    
              return didIDoMove;
  }
  
  
  public void doRandomMove(){
        boolean done = false;
        int randRow = -1;
        int randCol = -1;
        int iterationCounter = 0;
        
        while(!done && iterationCounter < (19*19) + (19*19)){
            randRow = (int)(Math.random() * 19);
            randCol = (int)(Math.random() * 19);
            
            if( board[randRow][randCol].getState() == PenteGame.EMPTY)
            {
                  done = true;   
            }   
            iterationCounter++;  // This stops infinite loop...we are watching this
        }
        
        //if you are out of loop and the locations are + then put stone in
        
        if(randRow >= 0 && randCol >= 0)
        {
              if(myGame.getWhoseTurn()== PenteGame.RED ){
                board[randRow][randCol].setState(PenteGame.RED);
              } else {
                board[randRow][randCol].setState(PenteGame.GOLD);
              }
              
              myGame.checkForCaptures(randRow, randCol);
              myGame.changeTurn();
              myGame.repaint();
          
        }
    
    
  }
  
        public void makeAFirstMove(){
          
                if(myGame.getWhoseTurn()== PenteGame.RED ){
                  board[19/2][19/2].setState(PenteGame.RED);
                } else {
                  board[19/2][19/2].setState(PenteGame.GOLD);
                }
                myGame.changeTurn();
                myGame.repaint();
          
        }
        
        //************************ THIS IS NEW CODE TO FIND STONE GROUPS
        public void findStoneGroups( int whichColor )
        {
          
            System.out.println(" at top of find stone groups which color is " + whichColor);
          
            offenseMoveList = new ArrayList<Square>();
            defenseMoveList = new ArrayList<Square>();  
            clearPastRankings();
            
            System.out.println(" In find stone groups after clearPastRankings()");
               
           findHorizontalGroups( whichColor, this.OFFENSE);   
           findHorizontalGroups( whichColor * -1 , this.DEFENSE);   
            
            System.out.println("At the end of findStoneGroups --here is what is on the Offense List");
            System.out.println(offenseMoveList);
        }
        
        
        
        //************************ THIS IS NEW CODE TO CLEAN UP AFTER YOU HAVE FOUND MOVES
        public void clearPastRankings()
        {
          
            for(int r = 0; r < 19; r++)
            {
                    for(int c = 0; c < 19; c++)
                    {
                            board[r][c].resetNextMovePriority();
                      
                    }
              
            }
          
          
        }
        
        //**************** THIS IS THE FIRST PART OF FINDING MOVES ***** FINDING HORIZONTAL MOVES.
        
        public void findHorizontalGroups( int whichColor, int OorD )
        {    
              for(int row = 0; row < 19; row++)
              {
                    //look for stone combinations
                    boolean done = false;
                    int col = 0;
                    
                    while(!done && col < 19)
                    {
                            if( board[row][col].getState()==whichColor )
                            {
                                 int stoneGroupLength = 1;
                                 col++;
                                 while( col < 19 && board[row][col].getState()==whichColor )
                                 {
                                         stoneGroupLength++;
                                         col++;
                                 }
                                 
                                 int end1 = 0, end2 = 0;
                                 int priorityRanking = stoneGroupLength;
                                 
                                  //we will do edge2 first:
                                  if(col < 19)
                                  {
                                      end2 = board[row][col].getState();
                                   } else {
                                       end2 = PenteGame.EDGE;
                                    }
                               
                                   //now we do end1
                                   if( (col - stoneGroupLength - 1 ) >= 0 )
                                   {
                                       end1 = board[row][col - stoneGroupLength - 1].getState();
                                 } else {
                                       end1 = PenteGame.EDGE;
                                 }
                               
    
                                       //Now Evaluate the move
                               
                                       if(end1 == PenteGame.GOLD)
                                       {
                                                       if( end2 == PenteGame.EMPTY)
                                                       {
                                                            priorityRanking += stoneGroupLength +1;
                                                            placeStoneOnList(row, col , priorityRanking, OorD);
                                                       }
                                         
                                       } else if ( end1 == PenteGame.EMPTY){
                                                         priorityRanking += stoneGroupLength +1;
                                                         placeStoneOnList(row, col - stoneGroupLength - 1, priorityRanking, OorD);
                                             
                                                           if(end2 == PenteGame.EMPTY)
                                                           {
                                                             priorityRanking += stoneGroupLength +1;
                                                             placeStoneOnList(row, col, priorityRanking, OorD);  
                                                           }
                                             
                                       } else {
                                         
                                                       if(end2 == PenteGame.EMPTY)
                                                       {
                                                         priorityRanking += stoneGroupLength +1;
                                                         placeStoneOnList(row, col, priorityRanking, OorD);     
                                                       }
                                       }
                           
                            } else {
                              col++;
                            }
                    
                    }
              }
          
            myGame.repaint();
        }
        
        
        //**************  THIS IS NEW CODE TO ADD A POTENTIAL MOVE TO EITHER AN OFFENSE OR DEFENSE LIST
        
        public void placeStoneOnList(int r, int c, int p, int OorD)
        {
          
              board[r][c].setNextMovePriority(p, OorD);
              
              if(OorD == OFFENSE)
              {
                
                 this.offenseMoveList.add(board[r][c]);
              } else {
                
                this.defenseMoveList.add(board[r][c]);
              }
          
        }
        
        
        
        
  
  /*   NOT IN USE
         public void findStoneGroups2(int whichColor)
         {
                   redGroupList = new ArrayList<StoneGroup>();
                   goldGroupList = new ArrayList<StoneGroup>();
           
                   for(int r = 0; r< 19; r++)
                   {
                       if(whichColor == PenteGame.RED)
                       {
                             processHorizontalRow( r, whichColor, redGroupList );
                       } else {
                         
                             processHorizontalRow( r, whichColor, goldGroupList );                       
                       }
                       
                   }
           
           
         }
         
         */
        
        /* NOT IN USE
            
         public void processHorizontalRow(int whichRow, int whichColor, ArrayList<StoneGroup> whichList)
         {
           
                int col = 0;
                while(col < 19)
                {
                      if(  board[whichRow][col].getState()== whichColor )
                      {
                            ArrayList<Square> group = new ArrayList<Square>();
                            Square leftOne, rightOne;
                             group.add(  board[whichRow][col]  );
                             
                              if(col -1 < 0) {
                                    leftOne  = null;
                             } else {
                                 leftOne = board[whichRow][col-1] ;
                             }
              
                            col++;
                           boolean  done = false;
                            while(!done && col < 19)
                            {
                                  if(  board[whichRow][col].getState()== whichColor )
                                  {
                                    group.add(  board[whichRow][col]  );
                                    col++;
                                  } else {
                                    done = true;
                                  }
                                  
                                  if(col >= 19)
                                  {
                                    done = true;
                                  }
                                  
                            }
                            
                          StoneGroup s = new StoneGroup( group, whichColor );
                          s.setLeftEnd(leftOne);
                          if(col +1 >= 19) {
                              rightOne  = null;
                          } else {
                              rightOne = board[whichRow][col+1] ;
                          }
                          s.setRightEnd(rightOne);
                          s.generateRanking();
                          if(whichColor == PenteGame.RED)
                          {
                                redGroupList.add(s);
                          } else {
                                goldGroupList.add(s);
                          }
                         
                        
                      } else {
                            col++;
                      }
                  
                  
                }
           
           
           
         }
    
*/

}
