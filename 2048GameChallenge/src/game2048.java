import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.Random;

public class game2048 extends JFrame implements KeyListener,ActionListener{
	JLabel background = new JLabel();
	JPanel button_panel = new JPanel();
	JPanel panel = new JPanel();
	JLabel score = new JLabel();
	JLabel highScore = new JLabel();
	JTextField lose = new JTextField();
	JTextField win = new JTextField();
	JTextField next = new JTextField();
	JButton[] Buttons = new JButton[16];
	JButton buttonOne = new JButton();
	JButton newGame = new JButton();
	JButton quit = new JButton();
    Border thickBorder = new LineBorder(new Color(140,140,140), 10);
	ImageIcon img1= new ImageIcon("C:\\Users\\DELL\\eclipse-workspace\\2048GameChallenge\\src\\unnamed.jpg");
	Random random= new Random();
	int x=random.nextInt(2)+1,inum;
	int scoreGame=0;
	int highScoreGame=0;
	String str1="";
	String str2="";
	public game2048() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(600,800);
	this.getContentPane().setBackground(Color.white);
	this.setLayout(null);
	this.setResizable(false);		
	
	buttonOne.setBounds(250,600,100,100);
	buttonOne.setFont(new Font("MV Boli",Font.BOLD,20));
	buttonOne.setFocusable(false);
	buttonOne.addActionListener(this);
	buttonOne.setText("PLAY!");
	buttonOne.setBackground(Color.white);
	buttonOne.setForeground(Color.gray);
	
	background.setBounds(0,-100,600,800);
    background.setIcon(img1);		
    this.add(background);
    this.add(buttonOne);

    this.setVisible(true);
}
 public void Play(){
		
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(565,687);
	 this.getContentPane().setBackground(Color.white);
	 this.setLayout(null);
	 this.setResizable(true);
		
		score.setBounds(5,5,100,50);
		score .setText("Score: ");
		score.setFont(new Font("Ink Free",Font.BOLD,20));
		score.setForeground(Color.black);
		score.setBackground(Color.black);
		
		highScore.setBounds(5,60,120,50);
		highScore .setText("High Score: ");
		highScore.setFont(new Font("Ink Free",Font.BOLD,20));
		highScore.setForeground(Color.black);
//		highScore.setBackground(new Color(150,150,150));
	//	highScore.setBorder(thickBorder);	
		
		newGame.setBounds(350,5,150,40);
		newGame .setText("New Game");
		newGame.setFont(new Font("Ink Free",Font.BOLD,17));
		newGame.setForeground(Color.white);
		newGame.setBackground(new Color(150,150,150));
		newGame.setFocusable(false);
		newGame.addActionListener(this);
		
		quit.setBounds(350,58,150,40);
		quit .setText("Quit");
		quit.setFont(new Font("Ink Free",Font.BOLD,20));
		quit.setForeground(Color.white);
		quit.setBackground(new Color(150,150,150));
		quit.setFocusable(false);
		quit.addActionListener(this);
		
		button_panel.setBounds(0,100,550,550);
		button_panel.setBorder(thickBorder);	
		button_panel.setLayout(new GridLayout(4,4));
		for(int i=0;i<16;i++) {
			Buttons[i] = new JButton();
			button_panel.add(Buttons[i]);
			Buttons[i].setFont(new Font("MV Boli",Font.BOLD,35));
			Buttons[i].setFocusable(false);
			Buttons[i].addActionListener(this);
			Buttons[i].setBorder(thickBorder);	
			Buttons[i].setForeground(new Color(100,100,100));	
			Buttons[i].setBackground(new Color(150,150,150));	
		}
        newGame();	
		this.add(button_panel);
		this.add(score);
		this.add(highScore);
		this.add(newGame);
		this.add(quit);
		this.setVisible(true);
		this.addKeyListener(this);
 }
 public void Congratulations(){
		win.setBounds(200,40,150,100);
		win .setText("You Won!");
		win.setFont(new Font("Ink Free",Font.BOLD,30));
		win.setForeground(Color.green);

		this.add(win);
}
public void GameOver(){
		lose.setBounds(250,200,140,100);
		lose.setText("You Lose!");
		lose.setFont(new Font("Ink Free",Font.BOLD,30));
		lose.setForeground(Color.red);
		
		this.add(lose);
		}

 void newGame() {
     	 for(int i=0;i<16;i++) {
			Buttons[i].setText("");
     	 }
     	for(int i=0;i<16;i++) {
			drawColor(i) ;
		}
        while(true) {
	        int a=random.nextInt(16);
	     	int b=random.nextInt(16);
	     	if (a!=b) {
		    	Buttons[a].setText(2*x+"");
		    	x=random.nextInt(2)+1;
			    Buttons[b].setText(2*x+"");
			    drawColor(a);
			    drawColor(b);
			    break;
	     	}
		}
		
 }
 void randomGame() {
	 while (true) {
		 int a=random.nextInt(16);
		 if (Buttons[a].getText()=="") {
			 x=random.nextInt(2)+1;
			 Buttons[a].setText(2*x+"");
			 break;
		 }
	 }
 }
 void drawColor(int a) {
	// Buttons[a].setBackground(new Color(200,200,200));	
	 if (Buttons[a].getText().equals("2")) {
		 Buttons[a].setBackground(new Color(200,200,200));	
         return;
	 }
	 else if (Buttons[a].getText().equals("4")) {
		 Buttons[a].setBackground(new Color(220,220,170));	
         return;
	 }
	 else if (Buttons[a].getText().equals("8")) {
		 Buttons[a].setBackground(new Color(200,200,140));	
         return;
	 }
	 else if (Buttons[a].getText().equals("16")) {
		 Buttons[a].setBackground(new Color(220,169,60));	
         return;
	 }
	 else if (Buttons[a].getText().equals("32")) {
		 Buttons[a].setBackground(new Color(220,200,120));	
         return;
	 }
	 else if (Buttons[a].getText().equals("64")) {
		 Buttons[a].setBackground(new Color(220,100,100));	
         return;
	 }
	 else if (Buttons[a].getText().equals("128")) {
		 Buttons[a].setBackground(new Color(220,220,60));	
         return;
	 }
	 else if (Buttons[a].getText().equals("256")) {
		 Buttons[a].setBackground(new Color(200,166,140));	
	 }
	 else if (Buttons[a].getText().equals("512")) {
		 Buttons[a].setBackground(new Color(100,200,100));	
	 }
	 else if (Buttons[a].getText().equals("1024")) {
		 Buttons[a].setBackground(new Color(30,200,200));	
	 }
	 else if (Buttons[a].getText().equals("2048")) {
		 Buttons[a].setBackground(Color.yellow);	
	 }
	 else {
			Buttons[a].setBackground(new Color(150,150,150));	
	 }
	 
 }
 @Override
	public void keyTyped(KeyEvent e) {
		//keyTyped = Invoked when a key is typed. Uses KeyChar, char output
		switch(e.getKeyChar()) {
			case 'a':
				int i,flag=0;
				for( i=0;i<16;i++) {
					if ((Buttons[i].getText()!="") && (i%4!=0)) {
				      	int j=i-1;
			            while (true) {
			        	     if ((Buttons[j].getText()!="") && (Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j].setText(""+( Integer.parseInt (Buttons[i].getText())+Integer.parseInt (Buttons[j].getText())));
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 if (Buttons[j].getText()!="") {
			        	    	     scoreGame=scoreGame+2*Integer.parseInt (Buttons[j].getText());
			        	    	     score.setText("Score: "+scoreGame);
			        	    	 }
			        	    	 
			        	    	 break;
			        	     }
			        	     else if ((Buttons[j].getText()!="") && (!Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j+1].setText(Buttons[i].getText());
			        	    	 if (i!=j+1) {
			        	    	     Buttons[i].setText("");
			        	    	     flag=1;
			        	    	 }
			        	    	 break;
			        	     }	
			        	     if ((Buttons[j].getText()=="") && (j%4==0)) {
			        	    	 Buttons[j].setText(Buttons[i].getText());
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 break;
			        	     }
			        	     if (j%4==0) {
			        	    	 break;
			        	     }
			        	     j--;			        	     
			        	}
			      
			        }
				}
				if (flag==1) {
			    	randomGame();
			   	 int count=0;
				 for ( i=0;i<16;i++) {
					 if (Buttons[i].getText()!="") {
						 count++;
					 }
				 }
				  if (count==16) {
					 GameOver();
					 return;
				 }
				}
				for( i=0;i<16;i++) {
					drawColor(i) ;
				}
				for( i=0;i<16;i++) {
					if (Buttons[i].getText().equals("2048")) {
						 Congratulations();

					}
				}
				break;
				case 'w': 	
					int index=0;
					flag=0;
					while(index<=3) {
					 for( i=index;i<16;i=i+4) {
						if ((Buttons[i].getText()!="") && (i-4)>=0){
					      	int j=i-4;
				            while (true) {
				        	    if ((Buttons[j].getText()!="") && (Buttons[j].getText().equals(Buttons[i].getText()))) {
				        	    	 Buttons[j].setText(""+( Integer.parseInt (Buttons[i].getText())+Integer.parseInt (Buttons[j].getText())));
				        	    	 Buttons[i].setText("");
				        	    	 flag=1;
				        	    	 break;
				        	     }
				        	     else if ((Buttons[j].getText()!="") && (!Buttons[j].getText().equals(Buttons[i].getText()))) {
				        	    	 Buttons[j+4].setText(Buttons[i].getText());
				        	    	 if (j+4!=i) {
				        	    	      Buttons[i].setText("");
				        	    	      flag=1;
				        	    	 }
				        	    	 break;
				        	     }	
				        	     if ((Buttons[j].getText()=="") && (j<=3 )) {
				        	    	 Buttons[j].setText(Buttons[i].getText());
				        	    	 Buttons[i].setText("");
				        	    	 flag=1;
				        	    	 break;
				        	     }
				        	     if (j<=3 ) {
				        	    	 break;
				        	     }
				        	     j=j-4;			
				        	}		            
				        }
					  }
					
					index++;
					}
					if (flag==1) {
				    	randomGame();
				   	 int count=0;
					 for ( i=0;i<16;i++) {
						 if (Buttons[i].getText()!="") {
							 count++;
						 }
					 }
					  if (count==16) {
						 GameOver();
						 return;
					 }
					}
					for( i=0;i<16;i++) {
						drawColor(i) ;
					}
					for( i=0;i<16;i++) {
						if (Buttons[i].getText().equals("2048")) {
							 Congratulations();

						}
					}
				break;
			case 's': 
			    index=15;
			    flag=0;
				while(index>=12) {
				 for( i=index;i>=0;i=i-4) {
					if ((Buttons[i].getText()!="") && (i+4<16)){
				      	int j=i+4;
			            while (true) {
			        	    if ((Buttons[j].getText()!="") && (Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j].setText(""+( Integer.parseInt (Buttons[i].getText())+Integer.parseInt (Buttons[j].getText())));
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 break;
			        	     }
			        	     else if ((Buttons[j].getText()!="") && (!Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j-4].setText(Buttons[i].getText());
			        	    	 if (j-4!=i) {
			        	    	      Buttons[i].setText("");
			        	    	      flag=1;
			        	    	 }
			        	    	 break;
			        	     }	
			        	     if ((Buttons[j].getText()=="") && (j>=12 )) {
			        	    	 Buttons[j].setText(Buttons[i].getText());
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 break;
			        	     }
			        	     if (j>=12 ) {
			        	    	 break;
			        	     }
			        	     j=j+4;			
			        	  //   break;
			        	}		            
			        }
				  }
				index--;
				}
				if (flag==1) {
			    	randomGame();
			   	 int count=0;
				 for ( i=0;i<16;i++) {
					 if (Buttons[i].getText()!="") {
						 count++;
					 }
				 }
				  if (count==16) {
					 GameOver();
					 return;
				 }
				}
				for( i=0;i<16;i++) {
					drawColor(i) ;
				}
				for( i=0;i<16;i++) {
					if (Buttons[i].getText().equals("2048")) {
						 Congratulations();

					}
				}
				break;
			case 'd': 
				flag=0;
				for( i=15;i>=0;i--) {
					if ((Buttons[i].getText()!="") && ((i+1)%4!=0)) {
				      	int j=i+1;
			            while (true) {
			        	     if ((Buttons[j].getText()!="") && (Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j].setText(""+( Integer.parseInt (Buttons[i].getText())+Integer.parseInt (Buttons[j].getText())));
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 break;
			        	     }
			        	     else if ((Buttons[j].getText()!="") && (!Buttons[j].getText().equals(Buttons[i].getText()))) {
			        	    	 Buttons[j-1].setText(Buttons[i].getText());
			        	    	 if (i!=j-1) {
			        	    	      Buttons[i].setText("");
			        	    	      flag=1;
			        	    	 }
			        	    	 break;
			        	     }	
			        	     if ((Buttons[j].getText()=="") && ((j+1)%4==0)) {
			        	    	 Buttons[j].setText(Buttons[i].getText());
			        	    	 Buttons[i].setText("");
			        	    	 flag=1;
			        	    	 break;
			        	     }
			        	     if ((j+1)%4==0) {
			        	    	 break;
			        	     }
			        	     j++;			        	     
			        	}
			      
			        }
				}
				if (flag==1) {
			    	randomGame();
			   	 int count=0;
				 for ( i=0;i<16;i++) {
					 if (Buttons[i].getText()!="") {
						 count++;
					 }
				 }
				  if (count==16) {
					 GameOver();
					 return;
				 }
				}
				for( i=0;i<16;i++) {
					drawColor(i) ;
				}
				for( i=0;i<16;i++) {
					if (Buttons[i].getText().equals("2048")) {
						 Congratulations();

					}
				}
				break;
		}		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
		switch(e.getKeyCode()) {
		case 37: for(int i=0;i<16;i++) {
			}
			break;
		case 38: for(int i=0;i<16;i++) {
			}
			break;
		case 39: for(int i=0;i<16;i++) {
			}
			break;
		case 40: for(int i=0;i<16;i++) {
			}
			break;
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//keyReleased = called whenever a button is released
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonOne.setEnabled(false);
	    if(e.getSource()==buttonOne ) {
	    	 Play();
	    	this.remove(buttonOne);
	    	this.remove(background);
		}
	    if(e.getSource()==newGame ) {
	    	newGame();
	    	}
	    if(e.getSource()==quit ) {
	    	new game2048();
		}
	    for(int i=11;i>=0;i--) {
	    	if(e.getSource()==Buttons[i]  ) {
				
	    	}
		}
	}
}