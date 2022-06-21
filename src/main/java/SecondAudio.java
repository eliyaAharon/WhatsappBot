import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SecondAudio {

    private Clip clip;

    public SecondAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File file = new File("וואצאפ הזנת נתונים.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public void stopAudio() {
        this.clip.stop();
    }

    public void StartAudio() {
        this.clip.start();
    }

}
