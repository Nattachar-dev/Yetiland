package pkgnew;


import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nattachar
 */
public class loadImage {
    public static BufferedImage motor,background,enemy,enemy1,enemy2;
    public static BufferedImage tree,snow;
    
    
    
    public static void init(){
        Player p1 = new Player();
        background = imageLoader("/pkgnew/b7.jpg"); 
        enemy = imageLoader("/pkgnew/Yeti_son_50.png"); 
        enemy1 = imageLoader("/pkgnew/Yeti_complete_64.png");
        tree = imageLoader("/pkgnew/tree_64.png");
        snow = imageLoader("/pkgnew/snow1_64.png");
        motor =  p1.getimag();
   
        
    }
    
    

    
    public static BufferedImage imageLoader(String path){
        try{
            return ImageIO.read(loadImage.class.getResource(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    
   
    
}
