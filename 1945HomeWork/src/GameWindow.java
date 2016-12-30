import Controllers.*;
import Controllers.Gifts.Bomb;
import Controllers.Manager.BodyManager;
import Controllers.Manager.ControllerManager;
import Controllers.Manager.GameSetting;
import Controllers.Manager.PlaneEnemyControllerManager;
import Controllers.Scenes.GameScene;
import Controllers.Scenes.MenuScene;
import Controllers.Scenes.PlayGameScene;
import Controllers.Scenes.SceneListener;
import Models.Model;
import Utils.Utils;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Stack;
import java.util.Vector;

import static Utils.Utils.loadImage;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class GameWindow extends Frame implements Runnable, SceneListener{
    BufferedImage backBuffer;

    GameScene currentScene;

    Stack<GameScene> gameSceneStack;



    public GameWindow() {

        gameSceneStack = new Stack<>();

        this.replaceScene(new MenuScene(), false);



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


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                currentScene.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyRelease");

            }
        });
    }


    public void replaceScene(GameScene newScene, boolean addToBackStack){
        if(addToBackStack && currentScene != null){
            gameSceneStack.push(currentScene);
        }
        currentScene = newScene;
        currentScene.setSceneListener(this);
    }

    public void back(){
        if(!gameSceneStack.isEmpty()){
            currentScene = gameSceneStack.pop();
        }
    }


    @Override
    public void update(Graphics g) {
            Graphics backBufferGraphics = backBuffer.getGraphics();
            currentScene.update(backBufferGraphics);

            g.drawImage(backBuffer, 0, 0, GameSetting.instance.getWidth(), GameSetting.instance.getHeight(), null);

    }


    @Override
    public void run() {
        while(true) {
            try {
                this.repaint();
                Thread.sleep(17);
                currentScene.run();
                BodyManager.instance.run();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
