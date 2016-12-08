package Controllers;

import Models.Model;
import Utils.Utils;
import Views.View;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class PlaneController extends Controller {
    private KeySetting keySetting;

    public PlaneController(Model model, View view, KeySetting keySetting) {
        super(model, view);
        this.keySetting = keySetting;
    }

    public void keyPressed(KeyEvent e){
        if(keySetting != null){
            int keyCode = e.getKeyCode();
            if(keyCode == keySetting.getKeyUp()){
                model.move(0, -5);
            }
            if(keyCode == keySetting.getKeyDown()){
                model.move(0, 5);
            }
            if(keyCode == keySetting.getKeyLeft()){
                model.move(-5, 0);
            }
            if(keyCode == keySetting.getKeyRight()){
                model.move(5, 0);
            }
        }
    }

    public KeySetting getKeySetting() {
        return keySetting;
    }

    public void setKeySetting(KeySetting keySetting) {
        this.keySetting = keySetting;
    }

    public static PlaneController createPlane(int x, int y, String path, KeySetting keySetting){
        PlaneController planeController = new PlaneController(new Model(x, y, 70, 50), new View(Utils.loadImage(path)), keySetting);
        return planeController;
    }
}
