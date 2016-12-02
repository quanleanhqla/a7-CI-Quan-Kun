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
    Image plane1;
    Image plane2;
    Image planeEnemy;
    private int plane1X = 100;
    private int plane1Y = 400;

    private int plane2X = 400;
    private int plane2Y = 400;

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
            plane1 = ImageIO.read(new File("resources/plane3.png"));
            plane2 =  ImageIO.read(new File("resources/plane4.png"));
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
                        plane1Y-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1Y+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        plane1X-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1X+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_W:
                        plane2Y-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_S:
                        plane2Y+=5;
                        repaint();
                        break;
                    case KeyEvent.VK_A:
                        plane2X-=5;
                        repaint();
                        break;
                    case KeyEvent.VK_D:
                        plane2X+=5;
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
        g.drawImage(plane1, plane1X, plane1Y, 70, 90, null);
        g.drawImage(plane2, plane2X, plane2Y, 70,90, null);
        g.drawImage(planeEnemy, planeEX, planeEY, 100, 100, null);

    }
}
