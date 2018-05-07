package pentePac2018;
import javax.swing.JFrame;

public class PenteMain
{
  public static void main(String[] args)
  {
 
            // TODO Auto-generated method stub
            int width = 610;
            int height = 620;
            
            int border = 20;  // 20px border
                
                
            JFrame f =  new JFrame("Play Pente All the Time");
            
            PenteGame g = new PenteGame(width, height-20, border, f);
            //f.add(g);
          
            //f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            //f.setSize(width, height);
          
            //f.setVisible(true);

  }
  

}
