import java.awt.*;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.*;
public class v3
{
	int d = 0;
	int n =0 ;
	//declaring frame
	JFrame frame;
	//declaring array of 9 button
        JButton[] button = new JButton[10];
	//declaring panel
	JPanel panel;
	UIManager UI=new UIManager();
	public static void main(String args[])//main function
	{
		v3 s = new v3();//creating the object of the same class
		s.create();//calling create function
		s.add_event_to_X_and_O();//calling add_X_and_O function
	}
	public void create()//body of create function
	{
		try
	        {
		 UI.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");//adding GTK theme to the GUI
	       	}//handling all the Exception for GTK theme
                catch (ClassNotFoundException a){}
		catch (UnsupportedLookAndFeelException e) {}
		catch (InstantiationException a){}
		catch (IllegalAccessException e) {}
		// adding tthe frame and naming it as TIC-TAC-TOE by \"Manu KJ\"
		frame  = new JFrame("TIC-TAC-TOE by \"Manu KJ\"");
		// creating the instant of panel
		panel = new JPanel();
		//declaring grid layout
		GridLayout g = new GridLayout(3,3,0,0);
		panel.setLayout(g);//setting grid layout for panel
		for(int i = 0;i < 9 ; i++)//adding all the 9 button
		{
			button[i] = new JButton(" ");
			panel.add(button[i]);//adding each button to the panel
		}
		frame.add(panel);//adding panel to the frame
		frame.setSize(500,500);//setting the frame Size
		frame.setVisible(true);// seeting Visible for frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// seeting the default close button
		frame.setLocationRelativeTo(null);// no idea what is this
	}
	public void add_event_to_X_and_O()// body of add_X_and_O
	{
		for(int i = 0;i < 9 ; i++)
		{
			button[i].setFont(new Font("TimesRoman", Font.PLAIN, 30));
			button[i].addActionListener(new ADDING(i));// setting ActionListener for each button
		}
	}

	class ADDING implements ActionListener// Listener class that handles the event
	{

		int s;
		ADDING(int m)//parameter constructor
		{
			//System.out.println("s = "+m);
			s = m; // getting the which button is pressed and storing in variable s
		}
		public void check_win()
		{

			if(checking(0,1) == 'X' ||
				 checking(3,1) == 'X' ||
				 checking(6,1) == 'X' ||
				 checking(0,3) == 'X' ||
				 checking(1,3) == 'X' ||
				 checking(2,3) == 'X' ||
				 checking(0,4) == 'X' ||
				 checking(2,2) == 'X' )
			{
				ClassNameHere.infoBox("Player 1 won","WINNER",1);
				System.exit(0);
			}
			else if(checking(0,1) == 'O' ||
				 checking(3,1) == 'O' ||
				 checking(6,1) == 'O' ||
				 checking(0,3) == 'O' ||
				 checking(1,3) == 'O' ||
				 checking(2,3) == 'O' ||
				 checking(0,4) == 'O' ||
				 checking(2,2) == 'O' )
			{
				ClassNameHere.infoBox("Player 2 won","WINNER",1);
				System.exit(0);
			}

		}
		public char checking(int k, int j)
		{
			//System.out.println("checking and k ="+k+"j ="+j);
			int f = 0,s = 0,d=0;
			for(int m =0;m<3;m++)
			{
				//System.out.println("value of the button["+(k+d)+"] = "+button[k+d].getText().charAt(0)+"and i = "+m);
				if(button[k+d].getText().charAt(0) == 'X')f++;
				if(button[k+d].getText().charAt(0) == 'O')s++;
				//System.out.println("f = "+f+" s ="+s);
				d = d + j;
			}
			if(f == 3)
			{

			return 'X';
			}
			if(s == 3)
			{

			return 'O';
		 }

		 return 'A';
		}
		public boolean isfree(int a)
		{
			if((button[a].getText().charAt(0) == 'X')||(button[a].getText().charAt(0) == 'O'))
				return false;
			else
				return true;
		} 
		public boolean isthere(int f,int s)
		{
			boolean ff =   ((button[f].getText().charAt(0) == 'X'));
			boolean ss =   (button[s].getText().charAt(0) != 'X')&&(button[s].getText().charAt(0) != 'O');
			//System.out.println("button "+s+" "+button[])
			//System.out.println("is "+f+" not free "+ff+"  and "+s+" free  "+ss);
			//if  "f" button is not free and  "s" button is free .... if it is then enter enter the if condition .. and return true else return false
			if(ff&&ss)
				{
					//System.out.println("true");
					return true;
				}
			else {
				return false;
			}
		}
		public void computer(int s)
		{
			
			// if n ==1 i.e if this is the first turn of the computer 
			if(n == 1)
			{
				if(button[4].getText().charAt(0) == 'X')//checking weither middle button is free  or not ...if not enter the loop
				{
					button[0].setText("O");// if it is then set the first (0) button as "O"

				}
				else
				{
					button[4].setText("O");// else i.e if middle buttothe  is free then set thr middle button as "O" 
				}
				n++;
			}
			else
			{
				if(s == 2)//if the second turn of the user is 2 then
				{
					System.out.println("insidde"+s);
					if(isthere(4,6))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[6].setText("O");
					else 
						if(isthere(6,4))
							button[4].setText("O");				
						else
							if(isthere(0,1))
								button[1].setText("O");
							else
								if (isthere(1,0))
									button[0].setText("O");
								else
									if(isthere(5,8))
										button[8].setText("O");
									else
										if (isthere(8,5))
											button[5].setText("O");
					n++;
				}
				else if(s == 6)
				{
					System.out.println("insidde"+s);
					if(isthere(4,2))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[2].setText("O");
					else 
						if(isthere(2,4))
							button[4].setText("O");				
						else
							if(isthere(0,3))
								button[3].setText("O");
							else
								if (isthere(3,0))
									button[0].setText("O");
								else
									if(isthere(7,8))
										button[8].setText("O");
									else
										if (isthere(8,7))
											button[7].setText("O");
					n++;

				}
				else if (s == 8) {
					System.out.println("insidde"+s);
					if(isthere(4,0))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[0].setText("O");
					else 
						if(isthere(0,4))
							button[4].setText("O");				
						else
							if(isthere(5,2))
								button[2].setText("O");
							else
								if (isthere(2,5))
									button[5].setText("O");
								else
									if(isthere(6,7))
										button[7].setText("O");
									else
										if (isthere(7,6))
											button[6].setText("O");
					n++;
				}
				else if (s == 0) {
					System.out.println("insidde"+s);
					if(isthere(4,8))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[8].setText("O");
					else 
						if(isthere(8,4))
							button[4].setText("O");				
						else
							if(isthere(1,2))
								button[2].setText("O");
							else
								if (isthere(2,1))
									button[1].setText("O");
								else
									if(isthere(6,3))
										button[3].setText("O");
									else
										if (isthere(3,6))
											button[6].setText("O");
				n++;
				}
				else if (s == 1) {
					System.out.println("insidde"+s);
					if(isthere(2,0))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[0].setText("O");
					else 
						if(isthere(0,2))
							button[2].setText("O");				
						else
							if(isthere(4,7))
								button[7].setText("O");
							else
								if (isthere(7,4))
									button[4].setText("O");
								else
								{
									if (isfree(2)) 
										button[2].setText("O");
									else
										if(isfree(0))
											button[0].setText("O");
								}
				n++;
				}
				else if (s == 7) {
					System.out.println("insidde"+s);
					if(isthere(4,1))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[1].setText("O");
					else 
						if(isthere(1,4))
							button[4].setText("O");				
						else
							if(isthere(6,8))
								button[8].setText("O");
							else
								if (isthere(8,6))
									button[6].setText("O");
								else
								{
									if (isfree(6)) 
										button[6].setText("O");
									else
										if(isfree(8))
											button[8].setText("O");
								}
				n++;	
				}
				else if (s == 3) {
					System.out.println("insidde"+s);
					if(isthere(4,5))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[5].setText("O");
					else 
						if(isthere(5,4))
							button[4].setText("O");				
						else
							if(isthere(0,6))
								button[6].setText("O");
							else
								if (isthere(6,0))
									button[0].setText("O");
								else
								{
									if (isfree(0)) 
										button[0].setText("O");
									else
										if(isfree(6))
											button[6].setText("O");
								}
				n++;	
				}
				else if (s == 5) {
					System.out.println("insidde"+s);
					if(isthere(4,3))// checking weither 4 is not free and 6 is free if it is then set 6 button as "O"
						button[3].setText("O");
					else 
						if(isthere(3,4))
							button[4].setText("O");				
						else
							if(isthere(2,8))
								button[8].setText("O");
							else
								if (isthere(8,2))
									button[2].setText("O");
								else
								{
									if (isfree(2)) 
										button[2].setText("O");
									else
										if(isfree(8))
											button[8].setText("O");
								}
				n++;	
				}
			}
		}
		public void actionPerformed(ActionEvent ae)// overriding the actionPreformed function
		{

			//button[s].setFont(new Font("TimesRoman", Font.PLAIN, 30));//seetng fornt for the button
			if(n % 2 == 0)//if n%2 = 0 means asking the first palyer to play
			{
				//System.out.println(button[s].getText());
				if(!(ae.getActionCommand().equals("O") || ae.getActionCommand().equals("X") ))//checking weither the button is already used
				{
					d = s;
				button[s].setForeground(Color.red);
				button[s].setText("X");
			        n++;
				}
				else// if not then calling the info and displaying the erroe message
				{
					ClassNameHere.infoBox("BOSS USE OTHER GRID, this one is already filled", "ERROR",0);
				}
			}
			System.out.println("hello "+n);
			//calling the computer function .... telling computer to make the next move 
			computer(s);
			
			if(n >= 4 && n <= 9)// for n >4 we are checking weither any number is same or not
			check_win();
			if(n == 10)
			{
				ClassNameHere.infoBox("Draw Match","DRAW",2);
				System.exit(0);
			}
		}
	}
}
class ClassNameHere
{

	 public static void infoBox(String infoMessage, String titleBar,int m)
 	 {
		final ImageIcon icon = new ImageIcon("index.jpeg");
		if(m == 0)
		JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE);//this is to display the pop up message when the user clicks on the same button which is used
		else if(m == 1)
		JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE,icon);//setting winner pop up message
		else
		{
			final ImageIcon icon1 = new ImageIcon("index1.jpeg");
			JOptionPane.showMessageDialog(null, infoMessage,titleBar, JOptionPane.INFORMATION_MESSAGE,icon1);//setting draw icon
		}
	 }
}