package Controllers.Gifts;

import Controllers.BaseController;
import Controllers.Body;
import Controllers.Controller;
import Controllers.Enemies.PlaneEnemyController;
import Controllers.Manager.BodyManager;
import Controllers.Notifications.EventType;
import Controllers.Notifications.NotificationCenter;
import Controllers.PlaneController;
import Models.Model;
import Utils.Utils;
import Views.BaseView;
import Views.View;

import java.awt.*;

/**
 * Created by QuanLA on 12/22/2016.
 */
public class Bomb extends Controller implements Body, BaseController {

    public Bomb(Model model, View baseView) {
        super(model, baseView);
        BodyManager.instance.register(this);
    }

    public void run(){
        this.model.move(0, 1);
    }

    public void draw(Graphics g){
        if(this.model.isAlive()) super.draw(g);
    }

    @Override
    public void onContact(Body other) {
        if(other instanceof PlaneController){
            this.getModel().setAlive(false);
            Utils.playSound("resources/Explosion35.wav", false);
            NotificationCenter.instance.onEvent(EventType.BOMB_EXPLOSION, model);
        }
    }

    public static Bomb create(int x, int y){
        return new Bomb(new Model(x, y, 30, 30), new View(Utils.loadImage("resources/bomb.png")));
    }
}
