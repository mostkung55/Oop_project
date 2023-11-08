
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musicclass {
	public void Bgsound() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("src/jump2.wav").getAbsoluteFile());
			Clip clip1 = AudioSystem.getClip();
			clip1.open(audioInputStream);
			clip1.start();
		} catch (Exception e) {
			System.out.println("Error with playing sound.");
		}
	}

}