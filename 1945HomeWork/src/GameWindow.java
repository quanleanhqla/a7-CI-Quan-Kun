import Controllers.*;
import Controllers.Manager.BodyManager;
import Controllers.Manager.PlaneEnemyControllerManager;
import Models.Model;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Vector;

import static Utils.Utils.loadImage;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    PlaneController planeController;
    PlaneEnemyControllerManager planeEnemyControllerManager;

    BufferedImage backBuffer;
    public GameWindow() {

        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE);
        planeController = PlaneController.createPlane(300, 300, "resources/plane3.png", keySetting);
        planeEnemyControllerManager = new PlaneEnemyControllerManager();


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
        if(planeController.getModel().isAlive())
            planeController.draw(backBufferGraphics);
        planeEnemyControllerManager.draw(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 800, 600, null);
    }


    @Override
    public void run() {
        planeEnemyControllerManager.spawn();
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                planeEnemyControllerManager.run();
                planeController.run();
                BodyManager.instance.checkContact();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
