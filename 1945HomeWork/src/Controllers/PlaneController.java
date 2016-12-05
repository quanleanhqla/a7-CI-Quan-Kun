package Controllers;

import Models.PlaneModel;
import Views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class PlaneController {
    public PlaneModel planeModel;
    public PlaneView planeView;
    public KeySetting keySetting;

    public PlaneController(PlaneModel planeModel, PlaneView planeView, KeySetting keySetting) {
        this.planeModel = planeModel;
        this.planeView = planeView;
        this.keySetting = keySetting;
    }

    public void keyPressed(KeyEvent e){
        if(keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                planeModel.move(0, -5);
            }
            if(keyCode == keySetting.getKeyDown()){
                planeModel.move(0, 5);
            }
            if(keyCode == keySetting.getKeyLeft()){
                planeModel.move(-5, 0);
            }
            if(keyCode == keySetting.getKeyRight()){
                planeModel.move(5, 0);
            }
        }
    }
    public void draw(Graphics g){
        planeView.draw(g, planeModel);
    }

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public PlaneView getPlaneView() {
        return planeView;
    }
}
