import Controllers.*;
import Models.Model;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static Utils.Utils.loadImage;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    PlaneController planeController;
    Vector<BulletController> bulletVector;
    Vector<BulletEnemyController> bulletEVector;
    PlaneEnemyController planeEnemyController;

    BufferedImage backBuffer;
    public GameWindow() {

        Image planeImage = null;
        bulletVector = new Vector<>();
        bulletEVector = new Vector<>();
        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT);
        planeController = PlaneController.createPlane(300, 300, "resources/plane3.png", keySetting);
        planeEnemyController = PlaneEnemyController.createPlaneE(400, 100, "resources/enemy_plane_white_1.png");
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
                    int bulletX = planeController.getModel().getX() + 35 - 6;
                    int bulletY = planeController.getModel().getY() - 15;
                    BulletController bulletController = new BulletController(new Model(bulletX, bulletY, 12, 30), new View(loadImage("resources/bullet.png")));
                    bulletVector.add(bulletController);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyRelease");

            }
        });
    }


    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background, 0, 0, 800, 600, null);
        planeController.draw(backBufferGraphics);
        planeEnemyController.draw(backBufferGraphics);
        for(BulletController bullet : bulletVector)
            bullet.draw(backBufferGraphics);
        for(BulletEnemyController bullet : bulletEVector)
            bullet.draw(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 800, 600, null);
    }


    @Override
    public void run() {
        int milisecond = 0;
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for(BulletController bullet : bulletVector) {
                    bullet.run();
                }
                for(BulletEnemyController bullet : bulletEVector)
                    bullet.run();
                milisecond+=17;
                if(milisecond%510 == 0) planeEnemyController.run();
                if(milisecond%680 == 0){
                    BulletEnemyController bulletEnemyController = BulletEnemyController.createBulletE(planeEnemyController.getModel().getX() + planeEnemyController.getModel().getWidth()/2 - 10, planeEnemyController.getModel().getY() + planeEnemyController.getModel().getHeight());
                    bulletEVector.add(bulletEnemyController);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
