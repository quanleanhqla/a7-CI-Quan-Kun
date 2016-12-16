package Controllers;

import Controllers.Manager.BodyManager;
import Models.Model;
import Views.View;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class BulletController extends Controller implements Body {
    public BulletController() {
    }

    public BulletController(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0, -5);
    }


    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneEnemyController) {
            System.out.println("Oh year");
            this.model.setAlive(false);
            BodyManager.instance.remove(other);

        }
    }

}
