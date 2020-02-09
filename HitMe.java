package cs2012_hitme;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class HitMe {

	public static void main(String[] args) {
		Model m = new Model();
		m.initialise();
		View v = new View();
		ScoreBoard sb = new ScoreBoard();
		sb.initialise(m);
		
		Controller c = new Controller();
		
		v.initialise(m,c);

		JFrame jf = new JFrame();
		jf.add(sb, BorderLayout.NORTH);
		jf.add(v);
		

		m.addObserver(v);
		m.addObserver(sb);

		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.initialise(m, v, jf.getBounds());

	}

}
