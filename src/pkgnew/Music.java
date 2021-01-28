/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author nattachar
 */
public class Music{
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player player;
    public String fileLocation;
    public long songTotalLenght;
    
    public void Play(String path) throws JavaLayerException, IOException{
        try{
            FIS = new FileInputStream(path);
            BIS= new BufferedInputStream(FIS);
            
            player = new Player(BIS);
            songTotalLenght =FIS.available();
            fileLocation = path+" ";
        }
        catch(FileNotFoundException | JavaLayerException ex){
            
        }catch(IOException ex){
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(){
            @Override
            public void run(){
                try{
                    player.play();
                    if(player.isComplete()){
                        try {
                            Play(fileLocation);
                        } catch (IOException ex) {
                            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }  
                }catch(JavaLayerException ex){
                    
                }
            }
        }.start();
    }
    
  
    
    
    
    
    
    
    
    
    public static void main(String[] args){
        try{
            FileInputStream fileInputStream = new FileInputStream("a2.mp3");
            Player player = new Player(fileInputStream);
            player.play();
            
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(JavaLayerException e){
            e.printStackTrace();
        }
    
        
    }
    
   
}
