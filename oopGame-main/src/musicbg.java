
import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class musicbg {
	Clip clip;
    public void Bgsound2(){
        try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("src/bgsound2.wav").getAbsoluteFile());
             clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error with playing sound.");
        }
    }
    
    
}
