package Controllers.Manager;

import Controllers.BaseController;
import Controllers.Body;
import Models.Model;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by QuanLA on 12/14/2016.
 */
public class BodyManager implements BaseController {
    private Vector<Body> bodies;

    public static final BodyManager instance = new BodyManager();

    private BodyManager(){
        bodies = new Vector<>();
    }

    public void register(Body body){
        this.bodies.add(body);
    }
    public void run() {

        for(int i = 0; i < bodies.size() -  1; i++){
            for(int j = i+1; j < bodies.size(); j++){
                Body bodyi = bodies.get(i);
                Body bodyj = bodies.get(j);

                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if(modeli.intersects(modelj)){
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }

        Iterator<Body> iterator = bodies.iterator();
        while(iterator.hasNext()){
            Body body = iterator.next();
            if(!body.getModel().isAlive()){
                iterator.remove();
            }
        }
    }

    public Vector<Body> getBodies() {
        return bodies;
    }

    public void remove(Body body){
        this.bodies.remove(body);
    }

    @Override
    public void draw(Graphics g) {

    }

}
