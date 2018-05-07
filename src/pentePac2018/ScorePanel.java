package pentePac2018;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ScorePanel extends JPanel
{
  
      private int width, height;
      
      private Color redStoneColor = new Color(219, 28, 95);  
      private Color goldStoneColor = new Color(224, 206, 87);
      private Color goldDarkStoneColor = new Color(165, 160, 33);
 
      private JLabel RPNameLabel = new JLabel("Red Stone Player: ");
     // private JLabel RPColorLabel = new JLabel("Color: ");
      private JLabel RPCaptureLabel = new JLabel("Captures: ");
      private JTextField RPName = new JTextField(6);
     // private JTextField RPColor = new JTextField(8);
      private JTextField RPCaptures= new JTextField(8);
      
      
      private JLabel GPNameLabel = new JLabel("Gold Stone Player: ");
      //private JLabel GPColorLabel = new JLabel("Color: ");
      private JLabel GPCaptureLabel = new JLabel("Captures: ");
      private JTextField GPName = new JTextField(6);
      //private JTextField GPColor = new JTextField(8);
      private JTextField GPCaptures= new JTextField(8);
      
      //Extra fields and Labels for current Move
      private JLabel whoseTurnLabel = new JLabel("Current Turn: ");
      private JTextField whoseTurnField = new JTextField(8);
     
      
      private JPanel redPlayerInfo;
      private JPanel RPNameInfo;
      //private JPanel RPColorInfo;
      private JPanel RPCaptureInfo;
      
      private JPanel goldPlayerInfo;
      private JPanel GPNameInfo;
      //private JPanel GPColorInfo;
      private JPanel GPCaptureInfo;
      
      
      private JPanel whoseTurnInfo;
      private JPanel turnInfo;
      
  
  
      public ScorePanel (int w, int h){
      
          width = w;
          height = h;
          
          int fontSize = 18;
          
          this.setSize(width, height);
          this.setBackground(Color.GREEN);
          this.setLayout(new GridLayout(1, 2));
          

          this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
          
          redPlayerInfo = new JPanel();
          //player1Info.setOpaque(true);
          redPlayerInfo.setMinimumSize(new Dimension(  width, (int)(height* 0.4)  ));
          redPlayerInfo.setMaximumSize(new Dimension( width, (int)(height *0.4)  ));
          redPlayerInfo.setBackground(redStoneColor);
          
          //Container p1InfoBox = player1Info;
         // player1Info.setLayout(new BoxLayout(p1InfoBox, BoxLayout.Y_AXIS));
          
          //Adding the Name Information
                    RPNameInfo = new JPanel(); 
                    RPNameInfo.setSize( new Dimension(  width-10, (int)(height ) ));
                    //p1NameInfo.setLayout(new BoxLayout(p1NameInfo, BoxLayout.X_AXIS));
                    //p1NameInfo.setLayout(new BorderLayout());
                    RPNameInfo.setLayout(new GridLayout(1, 2, 10, 10));
                    RPNameInfo.setOpaque(false);
                    RPNameInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
                    RPNameInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));
 
                          RPNameLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                          RPNameLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                          RPNameLabel.setHorizontalAlignment(JLabel.CENTER);
                          //RPNameLabel.setText("Player1: ");
                          RPNameLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                          RPNameLabel.setOpaque(false);
                          RPNameLabel.setForeground(goldStoneColor);
                          
                          RPName.setEditable(false);
                          RPName.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                          RPName.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
                          RPName.setHorizontalAlignment(JTextField.LEFT);
                          RPName.setVisible(true);
                          RPName.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                          RPName.setForeground(redStoneColor);
                          RPName.setBackground(Color.WHITE);
                          
                    
                    RPNameInfo.add(RPNameLabel, BorderLayout.WEST);
                    RPNameInfo.add(RPName, BorderLayout.EAST);
                  
          redPlayerInfo.add(RPNameInfo);
          
  /*        
          //Adding the Color Information
          RPColorInfo = new JPanel(); 
          RPColorInfo.setSize( new Dimension(  width-10, (int)(height ) ));
          //p1ColorInfo.setLayout(new BoxLayout(p1ColorInfo, BoxLayout.X_AXIS));
          //p1ColorInfo.setLayout(new BorderLayout());
          RPColorInfo.setLayout(new GridLayout(1, 2, 10, 10));
          RPColorInfo.setOpaque(false);
          RPColorInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
          RPColorInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));

                RPColorLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPColorLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPColorLabel.setHorizontalAlignment(JLabel.CENTER);
                RPColorLabel.setText("Color: ");
                RPColorLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                RPColorLabel.setOpaque(false);
                RPColorLabel.setForeground(goldStoneColor);
                
                RPColor.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPColor.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
                RPColor.setHorizontalAlignment(JTextField.LEFT);
                RPColor.setVisible(true);
                RPColor.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                RPColor.setForeground(Color.BLACK);
          
          RPColorInfo.add(RPColorLabel);
          RPColorInfo.add(RPColor);
        
          redPlayerInfo.add(RPColorInfo);
  */        
          //Adding Capture Information
          RPCaptureInfo = new JPanel(); 
          RPCaptureInfo.setSize( new Dimension(  width-10, (int)(height ) ));
          //p1CaptureInfo.setLayout(new BoxLayout(p1CaptureInfo, BoxLayout.X_AXIS));
          RPCaptureInfo.setLayout(new GridLayout(1, 2, 10, 10));
          RPCaptureInfo.setOpaque(false);
          RPCaptureInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
          RPCaptureInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));

                RPCaptureLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPCaptureLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPCaptureLabel.setHorizontalAlignment(JLabel.CENTER);
                RPCaptureLabel.setText("Captures: ");
                RPCaptureLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                RPCaptureLabel.setOpaque(false);
                RPCaptureLabel.setForeground(goldStoneColor);
                
                RPCaptures.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                RPCaptures.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
                RPCaptures.setHorizontalAlignment(JTextField.LEFT);
                RPCaptures.setVisible(true);
                RPCaptures.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                RPCaptures.setForeground(Color.BLACK);
          
          RPCaptureInfo.add(RPCaptureLabel);
          RPCaptureInfo.add(RPCaptures);
        
          redPlayerInfo.add(RPCaptureInfo);
  

     
// ***************  Now Adding Player 2 Information          
          
          
          
          
          goldPlayerInfo = new JPanel();
          goldPlayerInfo.setOpaque(true);
          goldPlayerInfo.setMinimumSize(new Dimension(  width, (int)(height*0.4)  ));
          goldPlayerInfo.setMaximumSize(new Dimension( width, (int)(height*0.4)  ));
          goldPlayerInfo.setBackground(goldStoneColor);
          
        //Adding the Name Information
          GPNameInfo = new JPanel(); 
          GPNameInfo.setSize( new Dimension(  width-10, (int)(height ) ));
          //p2NameInfo.setLayout(new BoxLayout(p2NameInfo, BoxLayout.X_AXIS));
          GPNameInfo.setLayout(new GridLayout(1, 2, 10, 10));
          GPNameInfo.setOpaque(false);
          GPNameInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
          GPNameInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));

                GPNameLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                GPNameLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                GPNameLabel.setHorizontalAlignment(JLabel.CENTER);
                //GPNameLabel.setText("Player2: ");
                GPNameLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                GPNameLabel.setOpaque(false);
                GPNameLabel.setForeground(redStoneColor);
                
                GPName.setEditable(false);
                GPName.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
                GPName.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
                GPName.setHorizontalAlignment(JTextField.LEFT);
                GPName.setVisible(true);
                GPName.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
                GPName.setForeground(goldDarkStoneColor);
          
          GPNameInfo.add(GPNameLabel);
          GPNameInfo.add(GPName);
        
goldPlayerInfo.add(GPNameInfo);        
          
          
        //Color
/*
        //Adding the Color Information
        GPColorInfo = new JPanel(); 
        GPColorInfo.setSize( new Dimension(  width-10, (int)(height ) ));
        //p2ColorInfo.setLayout(new BoxLayout(p2ColorInfo, BoxLayout.X_AXIS));
        GPColorInfo.setLayout(new GridLayout(1, 2, 10, 10));
        GPColorInfo.setOpaque(false);
        GPColorInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
        GPColorInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));
        
              GPColorLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPColorLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPColorLabel.setHorizontalAlignment(JLabel.CENTER);
              GPColorLabel.setText("Color: ");
              GPColorLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              GPColorLabel.setOpaque(false);
              GPColorLabel.setForeground(redStoneColor);
              
              GPColor.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPColor.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
              GPColor.setHorizontalAlignment(JTextField.LEFT);
              GPColor.setVisible(true);
              GPColor.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              GPColor.setForeground(Color.BLACK);
        
        GPColorInfo.add(GPColorLabel);
        GPColorInfo.add(GPColor);
        
        goldPlayerInfo.add(GPColorInfo);
   */     
        //Adding Capture Information
        GPCaptureInfo = new JPanel(); 
        GPCaptureInfo.setSize( new Dimension(  width-10, (int)(height ) ));
        //p2CaptureInfo.setLayout(new BoxLayout(p2CaptureInfo, BoxLayout.X_AXIS));
        GPCaptureInfo.setLayout(new GridLayout(1, 2, 10, 10));
        GPCaptureInfo.setOpaque(false);
        GPCaptureInfo.setMinimumSize(new Dimension(  width-20, (int)(height/3)   ));
        GPCaptureInfo.setMaximumSize(new Dimension(  width-20, (int)(height/3)   ));
        
              GPCaptureLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPCaptureLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPCaptureLabel.setHorizontalAlignment(JLabel.CENTER);
              GPCaptureLabel.setText("Captures: ");
              GPCaptureLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              GPCaptureLabel.setOpaque(false);
              GPCaptureLabel.setForeground(redStoneColor);
              
              GPCaptures.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) ));
              GPCaptures.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height/3 ) )); 
              GPCaptures.setHorizontalAlignment(JTextField.LEFT);
              GPCaptures.setVisible(true);
              GPCaptures.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              GPCaptures.setForeground(Color.BLACK);
        
        GPCaptureInfo.add(GPCaptureLabel);
        GPCaptureInfo.add(GPCaptures);
        
        goldPlayerInfo.add(GPCaptureInfo);
                  
          //Turn Information
        
        whoseTurnInfo = new JPanel();
        whoseTurnInfo.setMinimumSize(new Dimension(  width, (int)(height* 0.2)  ));
        whoseTurnInfo.setMaximumSize(new Dimension( width, (int)(height *0.2)  ));
        whoseTurnInfo.setBackground(Color.GRAY);
         
        
        //Adding Specific Turn Information
        //Adding the Name Information
        turnInfo = new JPanel(); 
        turnInfo.setSize( new Dimension(  width-10, (int)(height * 0.2 ) ));
        //p2NameInfo.setLayout(new BoxLayout(p2NameInfo, BoxLayout.X_AXIS));
        turnInfo.setLayout(new GridLayout(1, 2, 10, 10));
        turnInfo.setOpaque(false);
        turnInfo.setMinimumSize(new Dimension(  width-10, (int)(height*0.2)   ));
        turnInfo.setMaximumSize(new Dimension(  width-10, (int)(height*0.2)   ));

              whoseTurnLabel.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height*0.2 ) ));
              whoseTurnLabel.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height*0.2 ) ));
              whoseTurnLabel.setHorizontalAlignment(JLabel.CENTER);
            
              whoseTurnLabel.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              whoseTurnLabel.setOpaque(false);
              whoseTurnLabel.setForeground(Color.WHITE);
              
              whoseTurnField.setEditable(false);
              whoseTurnField.setMinimumSize(new Dimension(  (int)(width/2)-2, (int)(height*0.2) ));
              whoseTurnField.setMaximumSize(new Dimension(  (int)(width/2)-2, (int)(height*0.2) )); 
              whoseTurnField.setHorizontalAlignment(JTextField.LEFT);
              whoseTurnField.setVisible(true);
              whoseTurnField.setFont(new java.awt.Font("Arial", Font.ITALIC, fontSize));
              whoseTurnField.setForeground(Color.BLACK);
        
              turnInfo.add(whoseTurnLabel);
              turnInfo.add(whoseTurnField);
      
              whoseTurnInfo.add(turnInfo);        
        
        
        
        
        
         
          this.add(redPlayerInfo);
          this.add(goldPlayerInfo);
          this.add(whoseTurnInfo);
    
      }
      
      
      public void setRedPlayerName(String name)
      {
              RPName.setText(name);
              this.repaint();
      }
      
      public void setGoldPlayerName(String name)
      {
              GPName.setText(name);
              this.repaint();
      }
      
      //N.B. I want the Pente Game to know and deal with the amount of captures
      //These methods just report...
      public void setRedCaptures(int totalCaptures)
      {
          RPCaptures.setText(Integer.toString(totalCaptures));
          this.repaint();
      }
      
      public void setGoldCaptures(int totalCaptures)
      {
          GPCaptures.setText(Integer.toString(totalCaptures));
          this.repaint();
      }
   
      
      public void setCurrentTurn(int whichTurn)
      {
        
                  if(whichTurn == PenteGame.RED)
                  {       
                    whoseTurnField.setText(RPName.getText());
                    whoseTurnField.setBackground(redStoneColor);
                    whoseTurnField.setForeground(Color.WHITE);

                  } else {
                    whoseTurnField.setText(GPName.getText());
                    whoseTurnField.setBackground(goldStoneColor);
                    whoseTurnField.setForeground(Color.BLACK);                  
                    
                  }
        
                  this.repaint();
      }
      
}