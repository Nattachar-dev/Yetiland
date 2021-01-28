/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author nattachar
 */
public class Enemy{
    
    public Graphics2D enemy;
    public BufferedImage enemyImg;
    private int x,y,width,height;
   
    public Enemy(int x, int y,int width,int height) {

        this.x=x;
        this.y=y;
        this.width =width;
        this.height = height;
        
    }
    public int getx(){
         return x;
    }
    public int gety(){
        return y;
    }
    
    public void draw(Graphics2D g){
        g.drawImage(loadImage.enemy,x,y,width,height, null);
    }
 
    public BufferedImage getEnemyImg(){
        return loadImage.enemy;
    }
    
    public Rectangle getBounds(){
       return new Rectangle(getx(),gety(),width,height);
   }

}
