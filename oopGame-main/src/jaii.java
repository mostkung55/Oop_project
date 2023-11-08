import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

    public class jaii {
    public int x,y,width,height,speed;
    private int xstart;
    public boolean hit = false;
    public jaii() {



    }
    public void reset_hit(){
        this.x = this.xstart;
        this.hit = false;
    }
    public jaii(int x,int y,int w,int h,int speed,JPanel game) {
        this.x=x;
        this.y=y;
        this.width=w;
        this.height=h;
        this.speed=speed;
        this.xstart=x;
        move(game);


    }

    private void move(JPanel game) {
        Timer timer = new Timer(70,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x-=speed;
                game.repaint();

                if(x<0) {
                    x=xstart;
                    hit = false;
                }
            }
        });
        timer.start();

    }
}
