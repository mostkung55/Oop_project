import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class block {
	public int x, y, width, height, speed;
	private int xstart;
	public boolean hit = false;

	public block() {
	}

	public void reset_hit() {
		this.x = this.xstart;
		this.hit = false;
	}


	public block(int x, int y, int w, int h, int speed, JPanel game) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		this.speed = speed;
		this.xstart = x;
		move(game);

	}

	private void move(JPanel game) {

		Thread blocktimer = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						x -= speed;
						game.repaint();

						if (x < 0) {
							x = xstart;
							hit = false;
						}
						Thread.sleep(20);

					} catch (Exception e) {
					}

				}
			}
		});

		blocktimer.start();

	}
}
