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
public class Poste1_4 extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	int e4;
	float Pr_Load,Pr_Prix;
	public float getPr_Prix() 	{return Pr_Prix;}
	public float setPr_Prix(float Pr_Prix) {return this.Pr_Prix=Pr_Prix;}
protected void setup()
	{
	  	System.out.println("agent Poste 4 est deploy� ");
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
						Cell a = sheet.getCell(i,35);
						Cell b = sheet.getCell(i,36);
						Cell c = sheet.getCell(i,37);
						
				String courant_ph1= a.getContents();
				String courant_ph2= b.getContents();
				String courant_ph3= c.getContents();
				
 //System.out.println("courant  dans le poste 4 est: "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
    double a1 = Double.parseDouble(a.getContents());
	double b1 = Double.parseDouble(b.getContents());
	double c1 = Double.parseDouble(c.getContents());
	
       
	ACLMessage msg=receive();
	 if(msg!=null){//ACLMessage msg444 = new ACLMessage(ACLMessage.INFORM);
	 //msg444.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	 //msg444.setContent("Courant dans le Poste 4 est : "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
	// send(msg444);
	 
		 if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
				e4=1;
				ACLMessage etat4 = new ACLMessage(ACLMessage.INFORM);
				etat4.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat4.setContent("Poste4_"+e4+"");
				
				send(etat4);
			}
						    
				else if (((a1>60)&&(b1>60))||((a1>60)&&(c1>60))||((c1>60)&&(b1>60))){
				 e4=2;
				 ACLMessage etat4 = new ACLMessage(ACLMessage.INFORM);
					etat4.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat4.setContent("Poste4_"+e4+"");
					send(etat4);
					}
								
				else if ((a1>60)&&(b1>60)&&(c1>60)){
				 e4=3;
				 ACLMessage etat4 = new ACLMessage(ACLMessage.INFORM);
					etat4.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
					etat4.setContent("Poste4_"+e4+"");
					send(etat4);
					}
						    
				else { e4=0;
				
				ACLMessage etat4 = new ACLMessage(ACLMessage.INFORM);
				etat4.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat4.setContent("Poste4_"+e4+"");
				send(etat4);}
				             
				
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
					/* On ferme le worbook pour lib�rer la m�moire */
					workbook.close(); 
				}
				//------------ debut Phase 2 reception de prix d'electricit� de l'agent GM------
				//-----------------------------------------------------------------------
				MessageTemplate mt211 = MessageTemplate.MatchConversationId("PE");
				ACLMessage msgGMPrix = receive(mt211);
				if ((msgGMPrix != null))
					{
					setPr_Prix((float) Double.parseDouble(msgGMPrix.getContent()));
				System.out.println("Agent GM informe l'agent LOAD (Prix)  <<----------------------------<<--------    =  "+getPr_Prix());
					}
				//------------ fin Phase 2 reception de prix d'electricit� de l'agent GM------
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

	  	

