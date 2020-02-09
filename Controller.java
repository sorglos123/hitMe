package cs2012_hitme;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class Controller extends MouseAdapter implements ActionListener  {
	Model model;
	View view;
	javax.swing.Timer t;
	Rectangle box;

	public void initialise(Model m, View v, Rectangle b) {
		this.model = m;
		this.view = v;
		this.box = b;

		this.t = new Timer(1000, this);
		this.t.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// The old time.
		long o = this.model.time;
		this.model.time = System.currentTimeMillis() / this.model.frequency;
		if (this.model.time != o) {

			for (Iterator iterator = this.model.targets.iterator(); iterator.hasNext();) {
				Target t = (Target) iterator.next();

				t.ageTarget(this.model.time * this.model.frequency);

				if (t.age > t.lifespan) {

					iterator.remove();
				}
			}

		}

		Target target = new Target();
		target.initialise(this.box);
		this.model.targets.add(target);
		this.model.markChanged();
		this.model.notifyObservers();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			Point p = new Point();
			p.setLocation(e.getX(), e.getY());
			for (Iterator iterator = this.model.targets.iterator(); iterator.hasNext();) {
				Target t = (Target) iterator.next();
				if(t.containsPoint(p)) {
					this.model.score += t.score ;
					iterator.remove();
					this.model.markChanged();
					this.model.notifyObservers();
				}
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
