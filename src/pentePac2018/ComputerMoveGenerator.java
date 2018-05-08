package pentePac2018;

public class ComputerMoveGenerator
{
  
  Square[][] board;
  PenteGame myGame;
  
  
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
        
        boolean didMove = makeAriahMove();
        if(didMove == false) 
        {
            doRandomMove();
        }
        
  }
  
  public boolean makeAriahMove(){
    boolean didIDoMove = false;
    
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
  
  

}
