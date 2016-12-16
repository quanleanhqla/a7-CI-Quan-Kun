package Controllers;

import Controllers.Manager.BodyManager;
import Models.Model;
import Utils.Utils;
import Views.View;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/8/2016.
 */
public class PlaneEnemyController extends Controller implements Body {
    private Vector<BulletEnemyController> bulletE;
    private int timeCounter = 0;

    public PlaneEnemyController(Model model, View view) {
        super(model, view);
        bulletE = new Vector<>();
        BodyManager.instance.register(this);
    }

    public void draw(Graphics g){
        super.draw(g);
        for(BulletEnemyController bullet : this.bulletE){
            bullet.draw(g);
        }
    }

    public void shoot(){
        BulletEnemyController bulletEnemyController = BulletEnemyController.createBulletE(this.getModel().getX() + this.model.getWidth()/2 - 10, this.model.getY()+ this.model.getHeight());
        this.bulletE.add(bulletEnemyController);
    }


    public void run(){
        super.run();
        timeCounter++;
        this.model.move(-8, 6);
        if(timeCounter > 30) {
            shoot();
            timeCounter = 0;
        }

        for(int i=0; i<bulletE.size(); i++){
            bulletE.get(i).run();
            if(!bulletE.get(i).getModel().isAlive()){
                bulletE.remove(i);
            }
        }
    }

    public static PlaneEnemyController createPlaneE(int x, int y, String path){
        PlaneEnemyController planeEnemyController = new PlaneEnemyController(new Model(x, y, 70, 30), new View(Utils.loadImage(path)));
        return planeEnemyController;
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof BulletController) {
            System.out.println("Hu hu");
            this.model.setAlive(false);
            BodyManager.instance.remove(other);
        }
    }
}
