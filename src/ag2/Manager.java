package ag2;

import java.text.BreakIterator;
import java.util.HashMap;

import org.jfree.data.general.DefaultPieDataset;

import GUI.DefautFrame;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class Manager extends Agent {
int dhomo=0; int dbi=0; int dtri=0; int pdf=0;	
int p1=0, p1p2=0,p2p3=0,p3p4=0,p4p5=0,p5p6=0,p6p7=0,p7p8=0,p8p9=0,p9p10=0,p10p11=0;
DefaultPieDataset typedef = new DefaultPieDataset();
DefaultPieDataset postedef = new DefaultPieDataset();
FrameChart chart;
DefautFrame defautFrame = new DefautFrame();
int a1;public int geta1() {return a1;}public void seta1(int a1) {a1 = a1;}	
int b1;public int getb1() {return b1;}public void setb1(int b1) {b1 = b1;}
int c1;public int getc1() {return c1;}public void setc1(int c1) {c1 = c1;}
int e0;public int gete0() {return e0;}public void sete0(int e0) {e0 = e0;}
int e1;public int gete1() {return e1;}public void sete1(int e1) {e1 = e1;}
int e2;public int gete2() {return e2;}public void sete2(int e2) {e2 = e2;}
int e3;public int gete3() {return e3;}public void sete3(int e3) {e3 = e3;}
int e4;public int gete4() {return e4;}public void sete4(int e4) {e4 = e4;}
int e5;public int gete5() {return e5;}public void sete5(int e5) {e5 = e5;}
int e6;public int gete6() {return e6;}public void sete6(int e6) {e6 = e6;}
int e7;public int gete7() {return e7;}public void sete7(int e7) {e7 = e7;}
int e8;public int gete8() {return e8;}public void sete8(int e8) {e8 = e8;}
int e9;public int gete9() {return e9;}public void sete9(int e9) {e9 = e9;}
int e10;public int gete10() {return e10;}public void sete10(int e10) {e10 = e10;}
int e11;public int gete11() {return e11;}public void sete11(int e11) {e11 = e11;}

private static final long serialVersionUID = 1L;
	
	protected void setup(){
  System.out.println("agent MANAGER est deployee");
  Colone.setColone(2);
	 addBehaviour(new TickerBehaviour(this,5000) //un cyclic Behaviour exécute sa tâche d'une manière répétitive.
	   {
		 
		protected void onTick(){
		  //if (Colone.getColone()==28) Colone.setColone(2);
			
			/*	   
			try {
				Thread.sleep(2); //le Manager entraine dans le mode sleep pour traiter les msg arrivant d'autre agent
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}*/
			
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		    for (int j = 0; j<=11 ; j++)
			msg.addReceiver(new AID("Agent Poste1."+j, AID.ISLOCALNAME));
			//msg.addReceiver(new AID("Agent Poste1.0", AID.ISLOCALNAME));
			msg.setContent("defaut");
			send(msg);
				
			
			
			
			
//ACLMessage msg0=receive();ACLMessage msg111=receive();ACLMessage msg222=receive();ACLMessage msg333=receive();
//ACLMessage msg444=receive();ACLMessage msg555=receive();ACLMessage msg666=receive();ACLMessage msg777=receive();
//ACLMessage msg888=receive();ACLMessage msg999=receive();ACLMessage msg10=receive();ACLMessage msg1111=receive();
			String courant1 = new String();
			String courant2 = new String();
			String courant3 = new String();
			HashMap<String, Integer> map_etats= new HashMap<String, Integer >();
			do{
				ACLMessage etat=receive();
				if(etat!=null && etat.getContent().contains("_")){
				  String post=etat.getContent().split("_")[0];
				  int e= Integer.parseInt(etat.getContent().split("_")[1]);
				  map_etats.put(post, e);
				  System.out.println("reception de msg de "+post+" valeur "+e);
				  if (etat.getContent().split("_").length > 2) {
					courant1 = etat.getContent().split("_")[2];
				  courant2 = etat.getContent().split("_")[3];
				  courant3 = etat.getContent().split("_")[4];
				} 
				  
				  
				  
				}
				
			}while(map_etats.size()<12);
			
//ACLMessage msg0=receive();
//ACLMessage etat1=receive();ACLMessage etat2=receive();ACLMessage etat3=receive();
//ACLMessage etat4=receive();ACLMessage etat5=receive();ACLMessage etat6=receive();ACLMessage etat7=receive();
//ACLMessage etat8=receive();ACLMessage etat9=receive();ACLMessage etat10=receive();ACLMessage etat11=receive();

			 
			
			
  if (map_etats.size()==12){
	  Colone.increment();
    	int e0 = map_etats.get("Depart1");	
    	int e1 = map_etats.get("Poste1");	
    	int e2 = map_etats.get("Poste2");	int e3 = map_etats.get("Poste3");
    	int e4 = map_etats.get("Poste4");	int e5 = map_etats.get("Poste5");	
    	int e6 = map_etats.get("Poste6");	int e7 = map_etats.get("Poste7");
    	int e8 = map_etats.get("Poste8");	int e9 = map_etats.get("Poste9");	
    	int e10 = map_etats.get("Poste10");  int e11 = map_etats.get("Poste11");
    	System.out.println("*******e0="+e0);
    	System.out.println("*******e1="+e1);
    	System.out.println("*******e2="+e2);
    	System.out.println("*******e3-"+e3);
    	System.out.println("*******e4-"+e4);
    	System.out.println("*******e5="+e5);
    	System.out.println("*******e6="+e6);
    	System.out.println("*******e7="+e7);
    	System.out.println("*******e8="+e8);
    	System.out.println("*******e9="+e9);
    	System.out.println("*******e10="+e10);
    	System.out.println("*******e11="+e11);
        ACLMessage msg00=receive();
    				if(msg00!=null){ System.out.println("-----"+msg00.getContent());}
    	
    	
    //-------------------------------------Partie de traitement -------------------------------------
    

	String  type = new  String();
    String  localisation= new String();
   if ((e0==1)){ System.out.println("  Défaut Homopolaire  :"+e0+""); dhomo=dhomo+1;  type ="  Défaut Homopolaire";}
   else if ((e0==2)){ System.out.println("  Défaut Biphasé  :"+e0+""); dbi=dbi+1; type ="  Défaut Biphasé";}
   else if ((e0==3)) {System.out.println("  Défaut Triphasé  :"+e0+""); dtri= dtri+1; type ="  Défaut Triphasé";}
   else if ((e0==0)) { System.out.println(" Pas de defaut  :"+e0+""); pdf=pdf+1; type ="  Pas de defaut";}
   
 
   
 if ((e0!=0)&&(e1==0)&&(e2==0)&&(e3==0)&&(e4==0)&&(e5==0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre depart et le poste 1"); p1=p1+1; localisation=" Defaut entre depart et le poste 1"; }
 else  if ((e0!=0)&&(e1!=0)&&(e2==0)&&(e3==0)&&(e4==0)&&(e5==0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste1 et le poste 2");p1p2++; localisation=" Defaut entre poste1 et le poste 2";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3==0)&&(e4==0)&&(e5==0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste2 et le poste 3");p2p3++; localisation=" Defaut entre poste2 et le poste 3";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4==0)&&(e5==0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste3 et le poste 4");p3p4++; localisation=" Defaut entre poste3 et le poste 4";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5==0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste4 et le poste 5");p4p5++; localisation=" Defaut entre poste4 et le poste 5";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6==0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste5 et le poste 6");p5p6++; localisation=" Defaut entre poste5 et le poste 6";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6!=0)&&(e7==0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste6 et le poste 7");p6p7++; localisation=" Defaut entre poste6 et le poste 7";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6!=0)&&(e7!=0)&&(e8==0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste7 et le poste 8");p7p8++; localisation=" Defaut entre poste7 et le poste 8";} 
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6!=0)&&(e7!=0)&&(e8!=0)&&(e9==0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste8 et le poste 9");p8p9++; localisation=" Defaut entre poste8 et le poste 9";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6!=0)&&(e7!=0)&&(e7!=0)&&(e9!=0)&&(e10==0)&&(e11==0)){ System.out.println(" Defaut entre poste9 et le poste 10");p9p10++; localisation=" Defaut entre poste9 et le poste 10";}
 else  if ((e0!=0)&&(e1!=0)&&(e2!=0)&&(e3!=0)&&(e4!=0)&&(e5!=0)&&(e6!=0)&&(e7!=0)&&(e8!=0)&&(e9!=0)&&(e10!=0)&&(e11!=0)){ System.out.println(" Defaut entre poste10 et le poste 11");p10p11++; localisation=" Defaut entre poste10 et le poste 11";}
 //else block();
 typedef.setValue("Défaut Homopolaire", dhomo); typedef.setValue("Défaut Biphasé", dbi); 
 typedef.setValue("Défaut Triphasé", dtri); typedef.setValue("Pas de defaut", pdf); 
 
 
 postedef.setValue("Defaut entre depart et le poste 1", p1);  postedef.setValue("Defaut entre poste 1 et le poste 2", p1p2);
 postedef.setValue("Defaut entre poste 2 et le poste 3", p2p3); postedef.setValue("Defaut entre poste 3 et le poste 4", p3p4);
 postedef.setValue("Defaut entre poste 4 et le poste 5", p4p5); postedef.setValue("Defaut entre poste 5 et le poste 6", p5p6);
 postedef.setValue("Defaut entre poste 6 et le poste 7", p6p7); postedef.setValue("Defaut entre poste 7 et le poste 8", p7p8);
 postedef.setValue("Defaut entre poste 8 et le poste 9", p8p9); postedef.setValue("Defaut entre poste 9 et le poste 10", p9p10);
 postedef.setValue("Defaut entre poste 10 et le poste 11", p10p11); //postedef.setValue("Defaut entre poste 3 et le poste 4", p3p4);
 if (chart==null) {
	 chart= new FrameChart(typedef, postedef);
	 }
 else{
	 chart.frame.dispose();;
	 chart=new FrameChart(typedef, postedef);
	 if (type.equals("  Pas de defaut")) {
		defautFrame.getTypeText().setText(type+"  (DJ : FERME)");
	} else {
		defautFrame.getTypeText().setText(type+"  (DJ : OUVERT)");
	}
	 
	 defautFrame.getLocalisation().setText(localisation);
	 defautFrame.getCourant1().setText(courant1);
	 defautFrame.getCourant2().setText(courant2);
	 defautFrame.getCourant3().setText(courant3);
	 defautFrame.setVisible(true);
	 defautFrame.setSize(550, 250);
	 defautFrame.setLocation(700, 10);
	 

 }
 //if (Colone.getColone()==252) takeDown();
 
  }// ferme if de l'etat0

  //else block();
		}// pour femee on tick
		
 

}); //pour ferme le behaviour
	 
				
}

	

	
	protected void takeDown() 
	{
		chart= new FrameChart(typedef, postedef);
		
		System.out .println("destruction de l'agent Manager");	
		
	}
	
}// ------------------------la fin de setup-----------------------------------------------