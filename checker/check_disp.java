package checker;
import java.io.*;

public class check_disp{
	public int check(String p,String n)
	{	
		int i=0;
		String namer="";
		String temp="C:\\java_files\\java_project\\"+n+".txt";
		try{
				System.out.println(temp);
				File f=new File(temp);
				if(!f.exists())
				{
					System.out.println("you havent registered yet! try registering at our system!");
					return 0;
				}
				else
				{
					File fy=new File(temp);
					FileReader fr=new FileReader(fy);
					BufferedReader br=new BufferedReader(fr);
					String tempo=br.readLine();
					if(p.equals(tempo))
					{
						String sw;
						System.out.println("Welcome back!!");
						System.out.println("here is The Information that you entered");
						while((sw=br.readLine())!=null)
						{
							i++;
							System.out.println(sw);
							if(i==1)
							{
								namer="C:\\java_files\\java_project\\"+sw+"_status.txt";
							}
						}
						//System.out.println(namer);
						//File fs=new File(namer);
						
						sw="";
						i=0;
						
						System.out.println("for the status of your shipment:");
						File fs=new File(namer);
						if(!fs.exists())
						{
							System.out.println("Sorry, Your Shipment Status could not be Fetched, Please Try Again Later");
						}
						FileReader frs=new FileReader(fs);
						BufferedReader brs=new BufferedReader(frs);
						while((sw=brs.readLine())!=null)
						{
							i++;
							//System.out.println("value of i"+i+"   "+sw);
							if(i==1)
							{	if(sw.equals("false"))
								{
									System.out.println("your package has not yet reached");
								}
								else if(sw.equals("true"))
								{
									System.out.println("your package has successfuly reached");
								}
							}
							else if(i==2)
							{
								System.out.println("the cost of your shipment is:"+sw);
							}
						}
						brs.close();
						frs.close();
						return 0;
					}
					else
					{
						System.out.println("incorrect password!!");
						return -1;
					}
				}
			
			}catch(IOException e)
			{System.out.println("An error occured while processing, try again later");}
 		return 1;
	}
}