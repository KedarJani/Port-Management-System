import java.util.*;
import java.io.*;
import mypack.*;
import checker.*;

public class main_tab{

	public static  String check_pass,check_name,uid,cust,tuss;
	public static int b;
	public static  boolean boo;
	public static void print_box()
	{
		for(int g=1;g<=20;g++)
			System.out.print("* ");
		System.out.println("*                                       *");
		System.out.println("*                                       *");
		System.out.println("*                                       *");
		System.out.println("*  Welcome to Shipment Management       *");
		System.out.println("*  1.Register Your Shipment             *");
		System.out.println("*  2.Track Your Shipment                *");
		System.out.println("*  3.Update the Shipment Status         *");
		System.out.println("*                                       *");
		System.out.println("*                                       *");
		for(int g=1;g<=21;g++)
			System.out.print("* ");
	}
	public static double temp_cost;
	public static void main(String args[]) throws IOException, InterruptedException
	{
		int j=-1;
		while(!(j<=3 && j>=1))
		{
			
			main_tab.print_box();
			Scanner sc=new Scanner(System.in);
			j=sc.nextInt();
			if(j>3 || j<1)
			System.out.println("enter a valid argument");
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		if(j==1)
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println("Registering your Shipment:");
			register r=new register();
			r.get_data();
		}
		if(j==2)
		{
			
			while(true)
			{
				int l=65;
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
				System.out.println(" ");
				Scanner w=new Scanner(System.in);
				//System.out.println(l);
				if(l==-1)
				{
					System.out.println("the password that you entered was incorrect, try again");
				}
				Console con=null;
				con=System.console();
				char[] pws = con.readPassword("To Track your Shipment, Enter your Password And name:");
				main_tab.check_name=w.nextLine();
				main_tab.check_pass=String.valueOf(pws);
				check_disp c=new check_disp();
				l=c.check(main_tab.check_pass,main_tab.check_name);
				if(l==0)
				return;
				
			}

		}
		if(j==3)
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			Scanner scaa = new Scanner(System.in);
			System.out.println("Enter The Unique ID to login and Update");
			uid=scaa.nextLine();
			if(main_tab.uid.equals("SB221") || main_tab.uid.equals("SPD1") || main_tab.uid.equals("K2J2"))
			{
				register rc=new register();
				System.out.println("Login Successful, Enter Customer's name");
				cust="C:\\java_files\\java_project\\"+scaa.nextLine()+"_status.txt";
				main_tab.b=0;
				try{
				    	b=1;
				    	
				    	File fc=new File(cust);
				    	FileWriter frc=new FileWriter(fc);
						BufferedWriter brc=new BufferedWriter(frc);
						System.out.println("Enter the status of thier Shipment in Only true or false:");
						main_tab.tuss=scaa.nextLine();
						if(b==1)
						{	
							if(main_tab.tuss.equals("true") || main_tab.tuss.equals("True") || main_tab.tuss.equals("TRUE") )
							{
								main_tab.boo=true;
								rc.set_status(main_tab.boo);
								brc.write(Boolean.toString(rc.send_reach()));	
								brc.flush();
							}
							else if(main_tab.tuss.equals("false") || main_tab.tuss.equals("False") || main_tab.tuss.equals("FALSE") )
							{
								main_tab.boo=false;
								rc.set_status(main_tab.boo);
								brc.write(Boolean.toString(rc.send_reach()));
								brc.flush();	
							}
							b=2;
						}
						if(b==2)
						{
							System.out.println("enter the shipment transport cost");
							main_tab.temp_cost=scaa.nextDouble();
							rc.set_cost(main_tab.temp_cost);
							brc.newLine();
							brc.write(Double.toString(rc.send_cost()));
							brc.flush();
							new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
							System.out.println("the status has been successfully updated!");
						}
						brc.close();
						frc.close();
					}catch(IOException e)
					{System.out.println("sorry the status wont be able to update right now, please try again later");}
			}
			
		}
	}
}