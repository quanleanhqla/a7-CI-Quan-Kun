package Views;

import Models.Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by QuanLA on 12/24/2016.
 */
public class Animation implements BaseView {
    private Vector<BufferedImage> bufferedImages;
    private int count = 0;
    private boolean animationReachEnd = false;

    public Animation(Vector<BufferedImage> bufferedImages) {
        this.bufferedImages = bufferedImages;
    }

    public boolean isAnimationReachEnd() {
        return animationReachEnd;
    }

    @Override
    public void draw(Graphics g, Model model) {
        BufferedImage bufferedImage = bufferedImages.get(count);
        g.drawImage(bufferedImage, model.getX(), model.getY(),
                model.getWidth(), model.getHeight(),
                null);
        count++;
        if(count == bufferedImages.size()){
            animationReachEnd = true;
            count = 0;
        }

    }

    @Override
    public void setImage(Image image) {

    }
}
