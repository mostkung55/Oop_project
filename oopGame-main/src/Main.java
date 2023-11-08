import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main extends JFrame implements ActionListener {
	Display mg = new Display();
	Game all = new Game();

	Main() {
		this.setSize(1000, 600);
		this.add(mg);

		mg.BStart.addActionListener(this);
		all.Backtomanu.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mg.BStart) {
			click s2 = new click();
			s2.sound2();
			this.setLocationRelativeTo(null);
			this.setSize(1000, 600);
			this.remove(mg);
			this.add(all);
			all.requestFocusInWindow();
		} else if (e.getSource() == all.Backtomanu) {
			this.remove(all);
			this.add(mg);
			all.reset_game();
			all.requestFocusInWindow();
			all.score = 0;
			this.revalidate();
			this.repaint();
		}
		this.repaint();

	}

	public static void main(String[] args) {
		JFrame jf = new Main();
		jf.setSize(1000, 600);
		jf.setTitle("Adventure of drake ");
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);

	}
}