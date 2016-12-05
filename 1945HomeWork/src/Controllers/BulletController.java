package Controllers;

import Models.BulletModel;
import Models.PlaneModel;
import Views.BulletView;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by QuanLA on 12/5/2016.
 */
public class BulletController {
    private BulletModel bulletModel;
    private BulletView bulletView;


    public BulletController(BulletModel bulletModel, BulletView bulletView) {
        this.bulletModel = bulletModel;
        this.bulletView = bulletView;
    }




    public void draw(Graphics g){
        bulletView.draw(g, bulletModel);
    }

    public BulletModel getBulletModel() {
        return bulletModel;
    }

    public BulletView getBulletView() {
        return bulletView;
    }
}
