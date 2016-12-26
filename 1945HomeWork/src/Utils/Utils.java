package Utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class Utils {
    public static BufferedImage loadImage(String path){
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void playSound(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static Vector<BufferedImage> loadSpriteSheet(String url, int w, int h, int count, int border){
        BufferedImage image = Utils.loadImage(url);
        Vector<BufferedImage> bufferedImages = new Vector<>();
        for(int i = 0; i < count; i++){
            BufferedImage bufferedImage = image.getSubimage(w*i+border*(i+1), border, w, h);
            bufferedImages.add(bufferedImage);
        }
        return bufferedImages;
    }
}