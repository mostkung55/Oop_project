import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class event {
	public static boolean checkHit(player player, block block) {
		if (player.x + player.playersize > block.x && player.x < block.x) {
			if (player.y + player.playersize >= block.y - block.height) {

				return true;
			}
		}

		return false;
	}
	public static boolean checkHit(player p, devil d) {
        Rectangle2D playerBounds = new Rectangle(p.x, p.y, p.playersize, p.playersize);
        Rectangle2D devileBounds = new Rectangle(d.getX(), d.getY(), 80, 80);
        return playerBounds.intersects(devileBounds);
    }

	public static boolean checkHit1(bullett fire, block block) {
		if (fire.x > block.x) {
			if (fire.y > block.y) {
				System.out.println("Point");
				return true;
			}
		}
		return false;
	}

}