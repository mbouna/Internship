package ag2;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.io.PrintStream;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class JadeContainer2  {
	
  public static void main(String[] args) {
	  System.setErr(new PrintStream(new LoggingOutputStream(Logger.getLogger("outLog"), Level.ERROR)));
    
      try {
		Runtime rt=Runtime.instance();
		  ProfileImpl pc=new ProfileImpl(false);
		  pc.setParameter(ProfileImpl.MAIN_HOST,"localhost");
		  AgentContainer ac2=rt.createAgentContainer(pc);
		 
		      AgentController agentController1=ac2.createNewAgent("Agent Manager","ag2.Manager", null);
		      AgentController agentController2=ac2.createNewAgent("Agent Poste1.0","ag2.Depart1", null);
		      AgentController agentController3=ac2.createNewAgent("Agent Poste1.1","ag2.Poste1_1",null);
		      AgentController agentController4=ac2.createNewAgent("Agent Poste1.2","ag2.Poste1_2", null);
			  AgentController agentController5=ac2.createNewAgent("Agent Poste1.3","ag2.Poste1_3", null);
			  AgentController agentController6=ac2.createNewAgent("Agent Poste1.4","ag2.Poste1_4", null);
			  AgentController agentController7=ac2.createNewAgent("Agent Poste1.5","ag2.Poste1_5", null);
			  AgentController agentController8=ac2.createNewAgent("Agent Poste1.6","ag2.Poste1_6", null);
			  AgentController agentController9=ac2.createNewAgent("Agent Poste1.7","ag2.Poste1_7", null);
			  AgentController agentController10=ac2.createNewAgent("Agent Poste1.8","ag2.Poste1_8", null);
			  AgentController agentController11=ac2.createNewAgent("Agent Poste1.9","ag2.Poste1_9", null);
			  AgentController agentController12=ac2.createNewAgent("Agent Poste1.10","ag2.Poste1_10", null);
			  AgentController agentController13=ac2.createNewAgent("Agent Poste1.11","ag2.Poste1_11", null);
			  
			  
		     
			  agentController1.start();
			 agentController2.start(); 
			 agentController3.start();
			 agentController4.start();
			 agentController5.start();
			 agentController6.start();
			 agentController7.start();
			 agentController8.start();
			 agentController9.start();
			 agentController10.start();
			 agentController11.start();
			 agentController12.start(); 
			 agentController13.start();
			
		     
		
	} catch (StaleProxyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
   

  }

}
