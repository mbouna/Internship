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
public class Poste1_8 extends Agent {
	
	private static final long serialVersionUID = 1L;
	
	int e8;
	float Pr_Load,Pr_Prix;
	public float getPr_Prix() 	{return Pr_Prix;}
	public float setPr_Prix(float Pr_Prix) {return this.Pr_Prix=Pr_Prix;}
protected void setup()
	{
	  	System.out.println("agent Poste 8 est deployé ");
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
						Cell a = sheet.getCell(i,15);
						Cell b = sheet.getCell(i,16);
						Cell c = sheet.getCell(i,17);
						
						
				String courant_ph1= a.getContents();
				String courant_ph2= b.getContents();
				String courant_ph3= c.getContents();
				
  //System.out.println("courant  dans le poste 8 est: "+"       ph1="+a.getContents()+"   ph2="+b.getContents()+"  ph3="+c.getContents());
    double a1 = Double.parseDouble(a.getContents());
	double b1 = Double.parseDouble(b.getContents());
	double c1 = Double.parseDouble(c.getContents());
	
	ACLMessage msg=receive();
	 if(msg!=null){   
	
	
	 if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
			e8=1;
			ACLMessage etat8 = new ACLMessage(ACLMessage.INFORM);
			etat8.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
			etat8.setContent("Poste8_"+e8+"");
			
			send(etat8);
		}
					    
			else if (((a1>60)&&(b1>60))||((a1>60)&&(c1>60))||((c1>60)&&(b1>60))){
			 e8=2;
			 ACLMessage etat8 = new ACLMessage(ACLMessage.INFORM);
				etat8.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat8.setContent("Poste8_"+e8+"");
				send(etat8);
				}
							
			else if ((a1>60)&&(b1>60)&&(c1>60)){
			 e8=3;
			 ACLMessage etat8 = new ACLMessage(ACLMessage.INFORM);
				etat8.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
				etat8.setContent("Poste8_"+e8+"");
				send(etat8);
				}
					    
			else { e8=0;
			
			ACLMessage etat8 = new ACLMessage(ACLMessage.INFORM);
			etat8.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
			etat8.setContent("Poste8_"+e8+"");
			send(etat8);}
			             
			
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

	  	

