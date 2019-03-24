package ag2;
import java.io.File;
import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class Poste1_1 extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	int e1 ;
	float Pr_Load,Pr_Prix;
	public float getPr_Prix() 	{return Pr_Prix;}
	public float setPr_Prix(float Pr_Prix) {return this.Pr_Prix=Pr_Prix;}
   protected void setup()
	{
	  	System.out.println("agent Poste 1 est deployé ");
	  	addBehaviour(new Lo(this,5000));
	}
	class Lo extends TickerBehaviour 
	{
		private static final long serialVersionUID = 1L;
		public Lo(Agent a, long period) {
		super(a,period);
	}public void onTick() 
		{Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File("RADEEF.xls"));
				try {
					Thread.sleep(5); //le Manager entraine dans le mode sleep pour traiter les msg arrivant d'autre agent
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				int i=Colone.getColone();
				//if (i==252){ takeDown(); this.stop();}
				Sheet sheet = workbook.getSheet(0);
						Cell a = sheet.getCell(i,50);
						Cell b = sheet.getCell(i,51);
						Cell c = sheet.getCell(i,52);
						
						
				String courant_ph1= a.getContents();
				String courant_ph2= b.getContents();
				String courant_ph3= c.getContents();
				
//	System.out.println("courant  dans le poste 1 est: "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
	double a1 = Double.parseDouble(a.getContents());
	double b1 = Double.parseDouble(b.getContents());
	double c1 = Double.parseDouble(c.getContents());
	
	 ACLMessage msg=receive();
     if(msg!=null){ 
	if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
		e1=1;
		ACLMessage etat1 = new ACLMessage(ACLMessage.INFORM);
		etat1.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
		etat1.setContent("Poste1_"+e1+"");
		
		send(etat1);
	}
				    
		else if (((a1>60)&&(b1>60))||((a1>60)&&(c1>60))||((c1>60)&&(b1>60))){
		 e1=2;
		 ACLMessage etat1 = new ACLMessage(ACLMessage.INFORM);
			etat1.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
			etat1.setContent("Poste1_"+e1+"");
			send(etat1);
			}
						
		else if ((a1>60)&&(b1>60)&&(c1>60)){
		 e1=3;
		 ACLMessage etat1 = new ACLMessage(ACLMessage.INFORM);
			etat1.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
			etat1.setContent("Poste1_"+e1+"");
			send(etat1);
			}
				    
		else { e1=0;
		
		ACLMessage etat1 = new ACLMessage(ACLMessage.INFORM);
		etat1.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
		etat1.setContent("Poste1_"+e1+"");
		send(etat1);}
		             
		
			
				 } // ferme l'accolade de if (msg!=null)
				 
				 //System.out.println("*************************************** i ="+i);
			    
			     }
			 
			catch (BiffException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if(workbook!=null){
					/* On ferme le worbook pour libérer la mémoire */
					workbook.close(); 
				}
				
			}
			
		}}
	
	
	protected void takeDown() 
	{
		System.out .println("destruction de l'agent");	
	}}

	  	

