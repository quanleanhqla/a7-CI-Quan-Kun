package Views;

import Models.Model;

import java.awt.*;

/**
 * Created by QuanLA on 12/8/2016.
 */
public interface BaseView {
    void draw(Graphics g, Model model);
    void setImage(Image image);

//    private Image image;
//
//    public BaseView(Image image) {
//        this.image = image;
//    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
//
//    public void draw(Graphics g, Model model){
//        g.drawImage(image, model.getX(), model.getY(), model.getWidth(), model.getHeight(), null);
//    }
}
