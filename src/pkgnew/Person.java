/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 *
 * @author nattachar
 */
public class Person extends Entity {
    
    private Enemy en;
    int velx=0,vely=0;
    int speed = 10;
   
    public Person(int x, int y) {
        super(x, y);
      
    }
    public void update(){
        x+=velx;
    
    }
    public void draw(Graphics2D g){
        g.drawImage(loadImage.motor,x,y,280,180, null);
        g.setColor(Color.RED);
        //g.draw(getBounds());
        
    }
    public BufferedImage getPlayerImg(){
        
        return loadImage.motor;
    }
    public int getx(){
        return x;
    }
    
    
    public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            
                if(key == KeyEvent.VK_LEFT){
                    velx = -speed;
                }
                if(key == KeyEvent.VK_RIGHT){
                    velx = speed;
            
                }

        
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
            if(key == KeyEvent.VK_LEFT){
                velx = 0;
            }
            if(key == KeyEvent.VK_RIGHT){
                velx = 0;
            }
        
        
    }
 
    public Rectangle getBounds(){
       return new Rectangle(getx()+120,175,35,40);
   }
}
