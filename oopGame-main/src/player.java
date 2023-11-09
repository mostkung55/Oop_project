import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class player {
	public int x, y, playersize, score = 0;
	public int jumphigh = 150;
	// private boolean hitDevile = false; // ตัวแปรสถานะการชนกับ devile

	// static AudioStream as;
	public player(int x, int y, int playersize) {

		this.x = x;
		this.y = y;
		this.playersize = playersize;
	}

	public void jump(JPanel game) {
		this.y -= jumphigh;
		// game.repaint();
		game.repaint();
		Timer timer = new Timer(400, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				y += jumphigh;
				game.repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}



	public boolean checkHit(devil d) {
        Rectangle2D playerBounds = new Rectangle2D.Double(x, y, playersize, playersize);
        Rectangle2D devileBounds = d.getbound();
        return playerBounds.intersects(devileBounds);
    }
}
