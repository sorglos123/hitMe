package cs2012_hitme;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class View extends JPanel implements Observer {

	Model model;

	public void initialise(Model m, Controller c) {
		this.model = m;
		this.addMouseListener(c);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
		

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		for (Target t : this.model.targets) {

			Shape el = new Ellipse2D.Double(t.position.getX() - (t.size / 2), t.position.getY() - (t.size / 2), t.size,
					t.size);
			g2d.setColor(t.fadeColour(t.age));
			g2d.fill(el);
		}
		g2d.dispose();

	}

}
