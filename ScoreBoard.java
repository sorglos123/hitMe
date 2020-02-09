package cs2012_hitme;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ScoreBoard extends JPanel implements Observer {
	Model model;
	JLabel jl; 
	JDialog jd;
	
	public void initialise(Model m) {
		jd = new JDialog();
		jd.add(this);
		
		this.model = m;
		jl = new JLabel("Score" + model.getScore());
		
		this.add(jl);
		
	
	}
	

	@Override
	public void update(Observable arg0, Object arg1) {
		
		this.repaint();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		jl.setText("Score" + model.getScore());
		//jd.add(jl);
		//jd.setVisible(true);
		super.paintComponent(g);
	}
	

}
