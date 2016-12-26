import Controllers.*;
import Controllers.Manager.BodyManager;
import Controllers.Manager.ControllerManager;
import Controllers.Manager.GameSetting;
import Controllers.Manager.PlaneEnemyControllerManager;
import Models.Model;
import Utils.Utils;
import Views.BaseView;
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
    Vector<BaseController> baseControllers;

    BufferedImage backBuffer;
    public GameWindow() {

        baseControllers = new Vector<>();

        KeySetting keySetting = new KeySetting(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_SPACE);
        //planeController = PlaneController.createPlane(300, 300, "resources/plane3.png", keySetting);
        baseControllers.add(PlaneController.instance);
        baseControllers.add(new PlaneEnemyControllerManager());
        baseControllers.add(new Bomb(new Model(300, 10, 30, 30), new View(Utils.loadImage("resources/mine.png"))));
        baseControllers.add(ControllerManager.explosion);


        setVisible(true);
        setSize(GameSetting.instance.getWidth(), GameSetting.instance.getHeight());
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
                PlaneController.instance.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyRelease");

            }
        });
    }


    @Override
    public void update(Graphics g) {
        if(PlaneController.instance.getLive() > 0) {
            Graphics backBufferGraphics = backBuffer.getGraphics();
            backBufferGraphics.drawImage(background, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
            for (BaseController baseController : this.baseControllers) {
                baseController.draw(backBufferGraphics);
            }
            g.drawImage(backBuffer, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);
        }
        else {
            g.setFont(new Font("Algerian", Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("Game Over", 250, 300);
        }
    }


    @Override
    public void run() {
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                for(BaseController baseController : this.baseControllers){
                    baseController.run();
                }
                BodyManager.instance.run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
