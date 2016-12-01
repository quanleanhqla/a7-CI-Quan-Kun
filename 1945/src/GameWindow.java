import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by QuanLA on 11/30/2016.
 */
public class GameWindow extends Frame{
    Image background;
    Image plane;
    Image planeAlly;
    Image planeEnemy;
    private int planeX = 100;
    private int planeY = 400;

    private int planeAX = 400;
    private int planeAY = 400;

    private int planeEX = 250;
    private int planeEY = 100;



    public GameWindow(){
        setVisible(true);
        setSize(800, 600);
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
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane = ImageIO.read(new File("resources/plane3.png"));
            planeAlly =  ImageIO.read(new File("resources/plane3.png"));
            planeEnemy = ImageIO.read(new File("resources/enemy_plane_yellow_1.png"));
        } catch (IOException e) {
            System.out.println("load image failed");
            e.printStackTrace();
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        planeY-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        planeX+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_W:
                        planeAY-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_S:
                        planeAY+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_A:
                        planeAX-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_D:
                        planeAX+=5;
                        repaint();
                        break;

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyRelease");

            }
        });
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawImage(plane, planeX, planeY, 70, 90, null);
        g.drawImage(planeAlly, planeAX, planeAY, 70,90, null);
        g.drawImage(planeEnemy, planeEX, planeEY, 100, 100, null);

    }
}
