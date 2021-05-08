package mypack;
import java.util.*;
import java.io.*;

public class register{
	String name;
	String  date;
	String ship_name;
	String cat;
	String destination;
	boolean hazard;
	boolean premium;
	boolean reached;
	double ph_no;
	double cost;
	double price;
	char c;
	String state;
	int j;
	String file_name;
	String update;

	protected String password;
	public void set_cost(double d)
	{
		this.cost=d;
	}
	public double send_cost()
	{
		return cost;
	}
	public void set_status(boolean st)
	{
		this.reached=st;
	}	
	public boolean send_reach()
	{
		return reached;
	}
		
		public void get_data() throws IOException, InterruptedException
		{
			int j=0;
			while(j!=1)
			{
				j=0;
				c='X';
				Scanner s=new Scanner(System.in);
				System.out.println("enter your name: ");
				name=s.nextLine();

				System.out.println("enter your contact number: ");
				ph_no=s.nextDouble();

				s.nextLine();
				System.out.println("what is your shipment? ");
				ship_name=s.nextLine();

				System.out.println("what is the category of the shipment: i.e loose or container: ");
				cat=s.nextLine();
			
				System.out.println("What is the State of your shipment i.e solid or liquid");
				state=s.nextLine();

				System.out.println("What is total cost of your items in shipments:");
				price=s.nextDouble();
				//s.nextLine();
				System.out.println("Is there any hazardous item?");
				System.out.println("If yes then write Y otherwise N: ");
			
				s.nextLine();
				while(c!='Y' && c!='N')
				{
					c=s.next().charAt(0);
					if(c=='Y')
					{hazard=true; break;}
			
					else if(c=='N')
					{hazard=false; break;}
				
					else
					{System.out.println("enter a valid answer");}
				}
				c='X';
				System.out.println("Do you need any premium: ");
				System.out.println("If yes then write Y otherwise N: ");
				while(c!='Y' && c!='N')
				{
					c=s.next().charAt(0);
					if(c=='Y')
					{premium=true;break;}
					else if(c=='N')
					{premium=false;break;}
					else
					{System.out.println("enter a valid answer");}	
				}
				s.nextLine();
				System.out.println("Where to transport: ");
				destination=s.nextLine();

				System.out.println("Date of transportation: ");
				date=s.nextLine();

				System.out.println("Are you sure, Please confirm this details.");
				System.out.println("We suggest you go through the entered data once and then if it is perfect PRESS 1 else press any key");
				j=s.nextInt();
				if(j==1)
				{	
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("Your Details have been Undertaken by us");
					this.password();
					break;
				}
				else
				{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					System.out.println("safely re directing you to re enter your data");
				}
			}

		}
		
		public void password() throws IOException, InterruptedException
		{
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				Console cnsl=null;
				cnsl=System.console();
				System.out.println("now we shall help you make a new password");
				char[] pwd = cnsl.readPassword("Enter Your chosen password with maximum length of 6 characters: ");
				password=String.valueOf(pwd);
				pwd = cnsl.readPassword("Now re-enter your current password to confirm: ");
				String recheck=String.valueOf(pwd);
				if(password.equals(recheck))
				{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
					int k=this.filemaker();
					if(k!=-1){System.out.println("New password succesfully created, Your data has been saved And the Shipment has been Booked");}
					break;
				}
				else
				{
					System.out.println("please make sure that your password matches");
				}
			}
		}

		public int filemaker()
		{
			file_name=name+".txt";
			update=name+"_status.txt";
			try{
					File f=new File(file_name);
					if(!f.exists())
					{
						f.createNewFile();
						FileWriter fr=new FileWriter(f);
						BufferedWriter br=new BufferedWriter(fr);
						br.write(password);
						br.newLine();
						//fr.write();
						br.write(name);
						String fon=Double.toString(ph_no);
						//System.out.println(fon);
						br.newLine();
						br.write(fon);
						br.newLine();
						br.write(ship_name);
						br.newLine();
						br.write(cat);
						br.newLine();
						br.write(state);
						br.flush();
						br.write(Double.toString(price));
						br.newLine();
						br.write("hazard:"+Boolean.toString(hazard));
						br.newLine();
						br.write("premium:"+Boolean.toString(premium));
						br.newLine();
						br.write(destination);
						br.newLine();
						br.write(date);
						br.flush();
						br.close();
						fr.close();
						File f2=new File(update);
						if(!f2.exists())
						{
							f2.createNewFile();
							this.reached=false;
							this.cost=(int)((price/2)+price*0.30);
						}
						FileWriter fr2=new FileWriter(f2);
						BufferedWriter br2=new BufferedWriter(fr2);

						br2.write(Boolean.toString(this.reached));
						br2.newLine();
						br2.write(Double.toString(this.cost));
						br2.flush();
						fr2.flush();
						br2.close();
						fr2.close();	


					}
					else
					{
						System.out.println("you have already registerd here");
						
						return -1;
					}
			   }catch(IOException e)
			   {
			   	e.printStackTrace();
			   	System.out.println("an error occured");
			   }
			   return 0;
		}

	}

	

