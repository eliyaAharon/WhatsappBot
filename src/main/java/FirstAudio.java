import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class FirstAudio {

    private Clip clip;

    public FirstAudio() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File file = new File("פתיח וואצאפ נסוי 2.wav");
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
