/*******************************************************************
 * AUTHOR : MOHAMMAD ABUBAKAR
 * *
 * *
 * FIRST CLASS:	TicTacToe
 * *
 * MAIN CLASS: test_tic
 * ****************************************************************/

import java.util.Scanner;													//IMPORTING SCANNER CLASS
import java.util.Random;													//IMPORTING RANDOM CLASS

/********************************************TicTacToe CLASS***********************************************************/

class TicTacToe
{ 
	Scanner scan=new Scanner(System.in);									//OBJECT OF SCANNER
	private String[][] array=new String[3][3];								//STRING 2-D ARRAY FOR STORING EACH CELL VALUE
	private String remain[]= {"1","2","3","4","5","6","7","8","9"};			//STRING ARRAY FOR SHOWING REMAINING EMPTY CELLS
	private enum cells{X,O,EMPTY }											//ENUMERATION WITH POSSIBLE CELL VALUES
	
	/************************************************
	 * Constructor
	 * *
	 * with no parameters
	 * *
	 * initialize 3d array's each cell to empty
	 * *
	 *************************************************/
	public TicTacToe()														
	{		
		for(int x=0;x<array.length;x++)
			for(int y=0;y<array[x].length;y++)
			{
				array[x][y]=cells.EMPTY.toString()+"\t";
			}	
	}
	/************************************************
	 * METHOD
	 * *
	 * 2 parameters
	 * *
	 * if a is odd returns X otherwise returns O
	 * *
	 * stores X or O in given no of cell which is b
	 *************************************************/
	
	public void getchoice(int a, int b)			
	{	
		cells c1 = null;
	
		if (a%2==1)							
			{
				c1=cells.X;
			}
		if (a%2==0) 							
		{
			 	c1=cells.O;
		}
		
		int quotient=(b-1)/3  ;	
		int reminder=(b-1)%3 ;
		array[quotient][reminder]=c1.toString()+ "\t";
	} 
	/************************************************
	 * METHOD
	 * *
	 * no parameters
	 * *
	 * displays board with values stored in 3d array
	 * *
	 *************************************************/
	
	public void getboard()		
	{
		for(int i=0;i<array.length;i++)
		{
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("|	"+"\t"+"	|	"+"\t"+"	|	"+"\t"+"	|");
				System.out.println("|	"+array[i][0]+"	|	"+array[i][1]+"	|	"+array[i][2]+"	|");
				System.out.println("|	"+"\t"+"	|	"+"\t"+"	|	"+"\t"+"	|");
		}
		System.out.println("-------------------------------------------------------------------------");	 
	}
	/************************************************
	 * METHOD
	 * *
	 * no parameters
	 * *
	 * displays empty cells stored in array remain
	 * *
	 * conditions for already filled cell or out of range cell
	 * * 
	 * returns choice user choose to fill
	 *************************************************/
	public int  remain()
	{
		int choice;
		while(true)
		{
			System.out.println("enter choice: ");
			System.out.println(remain[0] + "\t" +  remain[1] + "\t" + remain[2]+ "\t \n"
						 + remain[3] + "\t" +  remain[4] + "\t" + remain[5]+ "\t \n"
						 + remain[6] + "\t" +  remain[7] + "\t" + remain[8]);
			choice=scan.nextInt();
			if(choice<1 ||choice>9)
			{
				System.out.println("please enter no between 1-9");
				continue;
			}
			
			if(remain[choice-1]=="")
			{
				System.out.println("this box is already filled");
				continue;
			}
			
			break;
		}
		
		remain[choice-1]="";
		return choice;
	}
	/************************************************
	 * METHOD
	 * *
	 * choose random cell which is empty
	 * *
	 * returns no of cell
	 * *
	 *************************************************/
	public int computer()
	{
		int num;
		Random rand=new Random();
		
		while(true)
		{
			num=rand.nextInt(9)+1;
			if(remain[num-1]!="")
				break;
		}
		
	    remain[num-1]="";
		return num;
	}
	/************************************************
	 * METHOD
	 * *
	 * check for winner or draw
	 * *
	 * displays winner and returns true otherwise returns false
	 * *
	 *************************************************/
	public boolean status()
	{	
		{
			String a=cells.X.toString()+"\t";
			if((array[0][0].equals(a)&&array[0][1].equals(a)&&array[0][2].equals(a))||(array[1][0].equals(a)&&array[1][1].equals(a)&&array[1][2].equals(a))||(array[2][0].equals(a)&&array[2][1].equals(a)&&array[2][2].equals(a))||(array[0][0].equals(a)&&array[1][0].equals(a)&&array[2][0].equals(a))||(array[0][1].equals(a)&&array[1][1].equals(a)&&array[2][1].equals(a))||(array[0][2].equals(a)&&array[1][2].equals(a)&&array[2][2].equals(a))||(array[0][0].equals(a)&&array[1][1].equals(a)&&array[2][2].equals(a))||(array[0][2].equals(a)&&array[1][1].equals(a)&&array[2][0].equals(a)))
			{
				System.out.println("X is winner");
				return true;
			}
		}
		
		{
			String a=cells.O.toString()+"\t";
			if((array[0][0].equals(a)&&array[0][1].equals(a)&&array[0][2].equals(a))||(array[1][0].equals(a)&&array[1][1].equals(a)&&array[1][2].equals(a))||(array[2][0].equals(a)&&array[2][1].equals(a)&&array[2][2].equals(a))||(array[0][0].equals(a)&&array[1][0].equals(a)&&array[2][0].equals(a))||(array[0][1].equals(a)&&array[1][1].equals(a)&&array[2][1].equals(a))||(array[0][2].equals(a)&&array[1][2].equals(a)&&array[2][2].equals(a))||(array[0][0].equals(a)&&array[1][1].equals(a)&&array[2][2].equals(a))||(array[0][2].equals(a)&&array[1][1].equals(a)&&array[2][0].equals(a)))
			{
					System.out.println("O is winner");
					return true;
			}
		}
		
		return false;
	}
}
//******************************************************MAIN CLASS******************************************************//

public class Test_tic
{
	public static void main(String[] args)
    {
		Scanner scan=new Scanner(System.in); 
	
		int b=1;												//passing as argument to getchoice
		int choice;												//no of cell to be filled
		int a=1;												//for checking for computer choice for cell
		int players;											//no players in game
		int fl;													//first or second in game
		
		System.out.println("1-Payer\t\t\t2-Players");
		System.out.print("\t\t");
		while(true)												//checking for correct choice of no of players 1-2
		{
			players=scan.nextInt();
			if(players==1 || players==2)
				break;
			else
				System.out.println("please enter correct choice.");
		}
		if(players==1)											//getting choice for going first or second if game is of 1 player
		{
			System.out.println("1-first\t\t\t2-second");
			System.out.print("\t\t");
			while(true)
			{
				fl=scan.nextInt();
				if(fl==1 || fl==2)
					break;
				else
					System.out.println("please enter correct choice.");
			}
			
			if(fl==2)
				a=2;
		}
		
		TicTacToe obj=new TicTacToe();
		for(int k=0;k<9;k++)									//for loop for filling cells 9 times 
		{
			if(players==1  && a%2==0 )
			{
				choice=obj.computer();
				
			}
			else
				choice=obj.remain();
			
			obj.getchoice(b, choice);
			obj.getboard();
			boolean option=obj.status();
			if(option==true)
			{
				return;
			}
			a=a+1;
			b++;	
		}
		
		System.out.println("draw");	
    }
}
