import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Game extends JPanel implements ActionListener, KeyListener {

	player P1 = new player(50, 465, 90);
	block b1 = new block();
	block b2 = new block();

	long LastPress = 0;
	int hp = 200;
	int score = 0;
	boolean hit = false;

	private ImageIcon bg1 = new ImageIcon(this.getClass().getResource("bg3.jpg"));
	private ImageIcon bg2 = new ImageIcon(this.getClass().getResource("5.jpg"));
	private ImageIcon bg3 = new ImageIcon(this.getClass().getResource("6.jpg"));
	private ImageIcon bg4 = new ImageIcon(this.getClass().getResource("7.jpg"));
	private ImageIcon player1 = new ImageIcon(this.getClass().getResource("p3.png"));
	private ImageIcon land = new ImageIcon(this.getClass().getResource("stone.png"));
	private ImageIcon heal = new ImageIcon(this.getClass().getResource("heart.png"));
	// private ImageIcon pbullet = new ImageIcon(this.getClass().getResource("bullet.png"));
	// private ImageIcon d1 = new ImageIcon(this.getClass().getResource("d4.png"));
	private ImageIcon gameoverBG = new ImageIcon(this.getClass().getResource("bgover.jpg"));
	private ImageIcon btrestart = new ImageIcon(this.getClass().getResource("btrestart.png"));

	JButton Backtomanu = new JButton(btrestart);

	private block[] blockset = makeblockset(1);
	private block[] healset = makeblockset2(2);
	// private block[] devilset = makeblockset2(3);
	
	public ArrayList<bullett> bullet1 = new ArrayList<bullett>();
	public ArrayList<devile> de = new ArrayList<devile>();

	public Game() {

		this.setBounds(0, 0, 1000, 600);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setLayout(null);

	}


	public void reset_game() {
		this.LastPress = 0;
		this.hp = 200;

		remove(Backtomanu);
	}

	@Override
	public void paint(Graphics g) {
		try {
			super.paint(g);
			Graphics2D g2 = (Graphics2D) g;
			if (hp > 20) {
				if (score >= 0) {
					g2.drawImage(bg1.getImage(), 0, 0, 1000, 600, this);
				}
				if (score >= 100) {
					g2.drawImage(bg2.getImage(), 0, 0, 1000, 600, this);
				}
				if (score >= 150) {
					g2.drawImage(bg3.getImage(), 0, 0, 1000, 600, this);
				}
				if (score >= 200) {
					g2.drawImage(bg4.getImage(), 0, 0, 1000, 600, this);
				}

				g2.drawImage(player1.getImage(), P1.x, P1.y, P1.playersize, P1.playersize, this);
				g2.setFont(new Font("2005_iannnnnTKO", Font.CENTER_BASELINE, 20));
				g2.setColor(Color.white);
				g2.drawString("HP : ", 10, 30);
				g2.setColor(Color.RED);
				g2.fillRect(55, 15, hp, 20);
				g2.setColor(Color.white);
				g2.drawString("Score : " + score, 850, 30);

				for (block b1 : blockset) {

					g2.drawImage(land.getImage(), b1.x, b1.y, b1.width = 50, 50, this);

					if (event.checkHit(P1, b1) && !b1.hit) {
						g2.setStroke(new BasicStroke(10.0f));
						hp -= 50;
						b1.hit = true;
						b1.reset_hit();
					}

				}
				for (int i = 0; i < de.size(); i++) {
					if (P1.checkHit(de.get(i)) && !de.get(i).isHit()) {
						hp -= 1;
						de.get(i).resetHit();
					}
				}


				
				
				
				for (block b1 : healset) {

					g2.drawImage(heal.getImage(), b1.x, b1.y, b1.width = 30, 30, this);

					if (event.checkHit(P1, b1) && !b1.hit) {
						g2.setStroke(new BasicStroke(10.0f));

						if (hp < 200) {
							hp += 20;
							score = score + 2;
						}
						b1.hit = true;
						score = score + 2;
						b1.reset_hit();
						System.out.println(score);

					}

				}

				for (int i = 0; i < bullet1.size(); i++) {
					bullett ba = bullet1.get(i);
					g.drawImage(ba.imfire[ba.count % 5].getImage(), ba.x, ba.y, 20, 20, null);
					ba.move();

					if (ba.x > 1000) {
						bullet1.remove(i);
					}

				}

				for (int i = 0; i < de.size(); i++) {
					g.drawImage(de.get(i).getImage(), de.get(i).getX(), de.get(i).getY(), 80, 80, this);
					if (de.get(i).getX() <= 0) {

						de.remove(i);
					}
				}

				for (int i = 0; i < bullet1.size(); i++) {
					for (int j = 0; j < de.size(); j++) {
						if (Intersect(bullet1.get(i).getbound(), de.get(j).getbound())) {

							de.remove(j);
							bullet1.remove(i);
							score += 10;
						}
					}
				}

				adde.start();

			}

			else {

				g2.drawImage(gameoverBG.getImage(), 0, 0, 1000, 600, this);
				g2.setColor(Color.white);
				g2.setFont(new Font("2005_iannnnnTKO", Font.CENTER_BASELINE, 40));
				g2.drawString("Score : " + score, 380, 325);
				this.Backtomanu.setBounds(340, 350, 330, 100);
				this.add(Backtomanu);

				g2.drawImage(btrestart.getImage(), 330, 330, 350, 140, this);

			}
		} catch (Exception e) {

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (System.currentTimeMillis() - LastPress > 600) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// Musicclass s1 = new Musicclass();
				// s1.Bgsound();
				System.out.println("jump");
				P1.jump(this);
				this.repaint();
			}

			LastPress = System.currentTimeMillis();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			bullet1.add(new bullett(115, P1.y+40));

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	private block[] makeblockset(int blocknumber) {//devile
		block[] blockset = new block[blocknumber];
		for (int i = 0; i < blocknumber; i++) {
			double blocklocation = 1000 + Math.floor(Math.random() * 1000);
			blockset[i] = new block((int) blocklocation, 510, 60, 20, 15, this);
		}
		return blockset;

	}

	private block[] makeblockset2(int blocknumber) {//heart
		block[] blockset = new block[blocknumber];
		for (int i = 0; i < blocknumber; i++) {
			double blocklocation = 1000 + Math.floor(Math.random() * 1000);
			blockset[i] = new block((int) blocklocation, 510, 70, 30, 10, this);
		}
		return blockset;

	}

	Thread adde = new Thread(new Runnable() {
		public void run() {
			while (true) {
				try {
					de.add(new devile());
					Thread.sleep(2000);

				} catch (Exception e) {
				}
				repaint();
			}
		}
	});

	public boolean Intersect(Rectangle2D a, Rectangle2D b) {
		return (a.intersects(b));
	}

}
