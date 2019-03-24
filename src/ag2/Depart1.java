package ag2;

import java.io.File;
import java.io.IOException;

import jade.core.AID;
import jade.core.Agent;
import jade.core.BehaviourID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Depart1 extends Agent{
private static final long serialVersionUID = 1L;
	
	int e0 ;
	
	      protected void setup()
	      {
		  System.out.println("agent Depart1 est deployee");
          addBehaviour(new lo(this,5000)) ; 
          }//un cyclic Behaviour exécute sa tâche d'une manière répétitive.
	   
		class lo extends TickerBehaviour 
	  {
		private static final long serialVersionUID = 1L;
		public lo(Agent a,long period) {
		super(a,period);}
		public void onTick(){ //action() :qui désigne les opérations à exécuter par le Behaviour
				{Workbook workbook = null;
				try {
					workbook = Workbook.getWorkbook(new File("RADEEF.xls"));
					
					try {
						Thread.sleep(2); //le Manager entraine dans le mode sleep pour traiter les msg arrivant d'autre agent
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
					int i=Colone.getColone();
					Sheet sheet = workbook.getSheet(0);
					
					
					        Cell a = sheet.getCell(i,55);
							Cell b = sheet.getCell(i,56);
							Cell c = sheet.getCell(i,57);
							
							
					String courant_ph1= a.getContents();
					String courant_ph2= b.getContents();
					String courant_ph3= c.getContents();
					
					
					double a1 = Double.parseDouble(a.getContents());
					double b1 = Double.parseDouble(b.getContents());
					double c1 = Double.parseDouble(c.getContents());
				
				
				
	           ACLMessage msg=receive();
	           if(msg!=null){   //System.out.println("Depart1---->----Reçoit un offre ----->---MANAGER:" +msg.getContent());
				
	        	  // ACLMessage msg0 = new ACLMessage(ACLMessage.INFORM);
	        	  // msg0.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	        	  // msg0.setContent(""+a1+b1+c1+"");
	        	 //  send(msg0);

	        	
	        	   
	if (  ((a1>60)&&(b1<=60)&&(c1<=60))||((a1<=60)&&(b1>60)&&(c1<=60))||((a1<=60)&&(b1<=60)&&(c1>60))  ){ 
	e0=1;
	ACLMessage etat0 = new ACLMessage(ACLMessage.INFORM);
	etat0.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	etat0.setContent("Depart1_"+e0+"_"+a1+"_"+b1+"_"+c1+""); 
	send(etat0); 
	
	System.out.println("  Send -----------HOMO-------->---------:"+e0+"");}
			    
	else if (((a1>60)&&(b1>60)&&(c1<=60))||((a1>60)&&(c1>60)&&(b1<=60))||((c1>60)&&(b1>60)&&(a1<=60))){
	 e0=2;
	 ACLMessage etat0 = new ACLMessage(ACLMessage.INFORM);
		etat0.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
		etat0.setContent("Depart1_"+e0+"_"+a1+"_"+b1+"_"+c1+"");
		send(etat0);
		System.out.println("  Send ---------BI---------->---------:"+e0+"");}
					
	else if ((a1>60)&&(b1>60)&&(c1>60)){
	 e0=3;
	 ACLMessage etat0 = new ACLMessage(ACLMessage.INFORM);
		etat0.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
		etat0.setContent("Depart1_"+e0+"_"+a1+"_"+b1+"_"+c1+"");
		send(etat0);
		System.out.println("  Send ---------TRI---------->---------:"+e0+"");}
			    
	else { e0=0;
	
	ACLMessage etat0 = new ACLMessage(ACLMessage.INFORM);
	etat0.addReceiver(new AID("Agent Manager", AID.ISLOCALNAME));
	etat0.setContent("Depart1_"+e0+"_"+a1+"_"+b1+"_"+c1+"");
	send(etat0);
	System.out.println("  Send -----------PAS-------->---------:"+e0+"");  }              
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
			}
			
		}
		
	}}}
