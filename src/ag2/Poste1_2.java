package ag2;
import java.io.File;
import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jxl.Cell;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class Poste1_2 extends Agent {
	
	private static final long serialVersionUID = 1L;

	int e2;
	float Pr_Load,Pr_Prix;
	public float getPr_Prix() 	{return Pr_Prix;}
	public float setPr_Prix(float Pr_Prix) {return this.Pr_Prix=Pr_Prix;}
protected void setup()
	{
	  	System.out.println("agent Poste 2 est deployé ");
	  	addBehaviour(new Lo(this,5000));
	}
	class Lo extends TickerBehaviour 
	{
		private static final long serialVersionUID = 1L;
		public Lo(Agent a, long period) {
		super(a, period);
	}protected void onTick() 
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
						Cell a = sheet.getCell(i,45);
						Cell b = sheet.getCell(i,46);
						Cell c = sheet.getCell(i,47);
						
						
				String courant_ph1= a.getContents();
				String courant_ph2= b.getContents();
				String courant_ph3= c.getContents();
				
//	System.out.println("courant  dans le poste 2 est: "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());				//System.out.println("courant de phase1 dans le poste 9 est "+a.getContents());
				
	double a1 = Double.parseDouble(a.getContents());
	double b1 = Double.parseDouble(b.getContents());
	double c1 = Double.parseDouble(c.getContents());

	
	
	ACLMessage msg=receive();
	 if(msg!=null){//ACLMessage msg222 = new ACLMessage(ACLMessage.INFORM);
	 //msg222.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	// msg222.setContent("Courant dans le Poste 2 est : "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
	 //send(msg222);
	 
		 if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
				e2=1;
				ACLMessage etat2 = new ACLMessage(ACLMessage.INFORM);
				etat2.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat2.setContent("Poste2_"+e2+"");
				
				send(etat2);
			}
						    
				else if (((a1>60)&&(b1>60))||((a1>60)&&(c1>60))||((c1>60)&&(b1>60))){
				 e2=2;
				 ACLMessage etat2 = new ACLMessage(ACLMessage.INFORM);
					etat2.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat2.setContent("Poste2_"+e2+"");
					send(etat2);
					}
								
				else if ((a1>60)&&(b1>60)&&(c1>60)){
				 e2=3;
				 ACLMessage etat2 = new ACLMessage(ACLMessage.INFORM);
					etat2.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat2.setContent("Poste2_"+e2+"");
					send(etat2);
					}
						    
				else { e2=0;
				
				ACLMessage etat2 = new ACLMessage(ACLMessage.INFORM);
				etat2.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat2.setContent("Poste2_"+e2+"");
				send(etat2);}
				             
				
					
						 }   
	 
			     
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
				//------------ debut Phase 2 reception de prix d'electricité de l'agent GM------
				//-----------------------------------------------------------------------
				MessageTemplate mt211 = MessageTemplate.MatchConversationId("PE");
				ACLMessage msgGMPrix = receive(mt211);
				if ((msgGMPrix != null))
					{
					setPr_Prix((float) Double.parseDouble(msgGMPrix.getContent()));
				System.out.println("Agent GM informe l'agent LOAD (Prix)  <<----------------------------<<--------    =  "+getPr_Prix());
					}
				//------------ fin Phase 2 reception de prix d'electricité de l'agent GM------
				//-----------------------------------------------------------------------
			}
			//----*************************----
			//message.setContent(""+c+"");
		    // send(message);
		    // System.out.println("send charge actuel par ag.Load "+c);
			//System.out.println("c fait");	
		}}
	
	
	protected void takeDown() 
	{
		System.out .println("destruction de l'agent");	
	}}

	  	

