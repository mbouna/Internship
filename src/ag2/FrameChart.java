package ag2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class FrameChart  extends JFrame{
	JFrame frame ;

	public FrameChart(DefaultPieDataset typedef, DefaultPieDataset postedef) throws HeadlessException {
		super();
		frame = new JFrame("Manager staistics");
		//frame.setPreferredSize(new Dimension(900, 500));
		JFreeChart chart1=null;
		JFreeChart chart2=null;
		chart1=ChartFactory.createPieChart3D("Type de defauts", typedef, true, true, true);
		chart2=ChartFactory.createPieChart3D("Defaut detectés", postedef, true, true, true);
		frame.setLayout(new GridLayout(2, 1));
		
		frame.getContentPane().add(new ChartPanel(chart2));
		frame.getContentPane().add(new ChartPanel(chart1));
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public void Updatechartes(DefaultPieDataset typedef, DefaultPieDataset postedef){
		frame.getContentPane().removeAll();
		frame.removeAll();
		//frame.setPreferredSize(new Dimension(900, 500));
		JFreeChart chart1= null;
		JFreeChart chart2 = null;
		//frame = new JFrame("Manager staistics");
		chart1=ChartFactory.createPieChart("Type de defauts", typedef, true, false, false);
		chart2=ChartFactory.createPieChart("Defaut detectés", postedef, true, false, false);
		frame.getContentPane().add(new ChartPanel(chart2));
		frame.getContentPane().add(new ChartPanel(chart1));
		frame.getContentPane().revalidate();
		frame.revalidate();
		frame.pack();
		frame.getContentPane().repaint();
		frame.repaint();
	    frame.setVisible(true);
		
	}
	
	
	
	

}
