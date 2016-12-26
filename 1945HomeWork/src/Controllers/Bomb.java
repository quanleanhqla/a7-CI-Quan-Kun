package Controllers;

import Controllers.Enemies.PlaneEnemyController;
import Controllers.Manager.BodyManager;
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
            for(int i = 0; i < BodyManager.instance.getBodies().size(); i++){
                if(BodyManager.instance.getBodies().get(i) instanceof PlaneEnemyController) {
                    BodyManager.instance.getBodies().get(i).getModel().setAlive(false);
                }
            }
            this.getModel().setAlive(false);
            Utils.playSound("resources/Explosion35.wav", false);
        }
    }
}
