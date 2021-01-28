/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author nattachar
 */
public class KeyAdapt extends KeyAdapter{
    
    Person p;
    public KeyAdapt(Person person){
        p = person;
        
    }
    public void keyPressed(KeyEvent e){
        p.keyPressed(e);
    }
    public void keyReleased(KeyEvent e){
        p.keyReleased(e);
        
    }
    
}
