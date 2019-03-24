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
public class Poste1_7 extends Agent {
	
	private static final long serialVersionUID = 1L;

	int e7;
	float Pr_Load,Pr_Prix;
	public float getPr_Prix() 	{return Pr_Prix;}
	public float setPr_Prix(float Pr_Prix) {return this.Pr_Prix=Pr_Prix;}
protected void setup()
	{
	  	System.out.println("agent Poste 7 est deployé ");
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
						Cell a = sheet.getCell(i,20);
						Cell b = sheet.getCell(i,21);
						Cell c = sheet.getCell(i,22);
						
						
				String courant_ph1= a.getContents();
				String courant_ph2= b.getContents();
				String courant_ph3= c.getContents();
				
 //System.out.println("courant  dans le poste 7 est: "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
    double a1 = Double.parseDouble(a.getContents());
	double b1 = Double.parseDouble(b.getContents());
	double c1 = Double.parseDouble(c.getContents());
	       
	
	ACLMessage msg=receive();
	 if(msg!=null){//ACLMessage msg777 = new ACLMessage(ACLMessage.INFORM);
	 //msg777.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	// msg777.setContent("Courant dans le Poste 7 est : "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
	// send(msg777);
		 if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
				e7=1;
				ACLMessage etat7 = new ACLMessage(ACLMessage.INFORM);
				etat7.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat7.setContent("Poste7_"+e7+"");
				
				send(etat7);
			}
						    
				else if (((a1>60)&&(b1>60))||((a1>60)&&(c1>60))||((c1>60)&&(b1>60))){
				 e7=2;
				 ACLMessage etat7 = new ACLMessage(ACLMessage.INFORM);
					etat7.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat7.setContent("Poste7_"+e7+"");
					send(etat7);
					}
								
				else if ((a1>60)&&(b1>60)&&(c1>60)){
				 e7=3;
				 ACLMessage etat7 = new ACLMessage(ACLMessage.INFORM);
					etat7.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat7.setContent("Poste7_"+e7+"");
					send(etat7);
					}
						    
				else { e7=0;
				
				ACLMessage etat7 = new ACLMessage(ACLMessage.INFORM);
				etat7.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat7.setContent("Poste7_"+e7+"");
				send(etat7);}
				             
				
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

	  	

