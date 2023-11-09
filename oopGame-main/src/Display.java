import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Display extends JPanel implements KeyListener
{	
    private ImageIcon bg = new ImageIcon(this.getClass().getResource("bgplay.jpg"));
    private ImageIcon start = new ImageIcon(this.getClass().getResource("btplay2.png"));
    public JButton BStart = new JButton(start);
    Display(){
    	// musicbg s2 = new musicbg();
    	// s2.Bgsound2();
    	
        setLayout(null);
		BStart.setBounds(330, 290, 350, 150);
        BStart.setOpaque(false); 
        BStart.setContentAreaFilled(false); 
        BStart.setBorderPainted(false); 
        add(BStart);
       
      
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(bg.getImage(),0,0,1000,600,this);
        // g.setColor(Color.BLACK);
        // g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));
        

    }
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

