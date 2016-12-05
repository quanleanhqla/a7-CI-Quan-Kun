import Controllers.BulletController;
import Controllers.KeySetting;
import Controllers.PlaneController;
import Models.BulletModel;
import Models.PlaneModel;
import Views.BulletView;
import Views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    PlaneController planeController;
    Vector<BulletController> bulletVector;

    BufferedImage backBuffer;
    public GameWindow() {

        Image planeImage = null;
        bulletVector = new Vector<>();

        PlaneModel planeModel = new PlaneModel(300, 300);
        PlaneView planeView = new PlaneView(loadImage("resources/plane3.png"));
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planeController = new PlaneController(planeModel, planeView, keySetting);
        setVisible(true);
        setSize(800, 600);
        backBuffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        background =  loadImage("resources/background.png");
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                planeController.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                    int bulletX = planeController.getPlaneModel().getX() + 35 - 6;
                    int bulletY = planeController.getPlaneModel().getY() - 15;
                    BulletModel bulletModel = new BulletModel(bulletX, bulletY);
                    BulletView bulletView = new BulletView(loadImage("resources/bullet.png"));
                    BulletController bulletController = new BulletController(bulletModel, bulletView);
                    bulletVector.add(bulletController);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyRelease");

            }
        });
    }

    private Image loadImage(String path){
        try {
            Image image = ImageIO.read(new File(path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        for(BulletController bullet : bulletVector)
            bullet.draw(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 800, 600, null);
    }


    @Override
    public void run() {
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for(BulletController bullet : bulletVector) {
                    bullet.getBulletModel().move(0, -5);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
