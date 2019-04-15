package miniGame.model.utils;

import javafx.scene.effect.ImageInput;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Effects {


    public Effects(String musicFile) {
        InputStream music;
        try {
            music = new FileInputStream(new File(musicFile));
            AudioStream audioStream = new AudioStream(music);
            AudioPlayer.player.start(audioStream);

        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }



}
