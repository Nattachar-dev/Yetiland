/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

/**
 *
 * @author nattachar
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;








public class Rungame extends javax.swing.JFrame{


    private BufferStrategy bs;
    private Graphics2D g;
    private Rungame manager;
    private Person person;
    public Enemy enemies;
    static ArrayList<Enemy>yeti = new ArrayList<Enemy>();
    boolean collision = false;
   
    
    
    public static void init(){
        loadImage.init();
        
        
    }
        
    
    public Rungame() {
 
        
        initComponents();
        setLocation (400,100);

        person = new Person(-140,60);
        addKeyListener(new KeyAdapt(person));
        
         
        
        setSize(800,600);
        
        createBufferStrategy(3);
        bs = getBufferStrategy();
        g = (Graphics2D) bs.getDrawGraphics();
        init();
        
        Thread roadLoop = new Thread(new Roadloop());
        (roadLoop).start();
        
       
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rungame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rungame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rungame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rungame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rungame().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
   private class Roadloop implements Runnable{
       public  int totalScore;

        @Override
        public void run() {
            
            while (collision == false) { 
                g = (Graphics2D) bs.getDrawGraphics(); 
                update();
                draw(g);
                checkCollision();
                person.update();
                bs.show();
                g.dispose();
                manager.init();     
                
            }
             totalScore = score;
             End end = new End();
             end.init(totalScore);
             end.setVisible(true);
             setVisible(false); 
            
           
        }
  
   }
   
   int track =0;
   int score = 25;
   double a=0;
   double cf =0;
   double ha =0;
   double backgroundx=0;
   
   
   
   public void update(){
       a +=0.2d;
       if (a>=1) {
            a=0;
            track++;
            score+=3;
        }
       backgroundx=backgroundx+(cf * 0.05);
        ha = 0.5d;
        if (ha >= 0) {
            ha = 0;
        }
        
       
       
   }
   public void draw(Graphics2D g) {
     
        g.scale(2, 2.5);
        g.drawImage(loadImage.background, (int) -backgroundx,5, null);
        
        g.scale(0.5, 1/2.2);
        g.translate(getWidth() /2, getHeight() / 2);
        
        Point previous = null;
        int previousCurve = 0;
        for (int z = 159; z > 0; z--) {
            int x = (int) (300 / (z - a));
            int y = (int) ((250 - (z - a) * ha) / (z - a));
            int curva = (int) ((z - a) * cf);
            if (previous == null) {
                previous = new Point(x, y);
                
            }
            else {
                Polygon poly = new Polygon();
                poly.addPoint(-previous.x + previousCurve, previous.y);
                poly.addPoint(previous.x + previousCurve, previous.y);
                poly.addPoint(x + curva, y);
                poly.addPoint(-x + curva, y);
                
                if ((z+track) % 2 == 0) {
                    g.setColor(new Color(211, 217,222));
                }
                else {
                    g.setColor(new Color(211, 217, 222));
                }
                
                g.fillRect(-getWidth()/2, previous.y, getWidth(), y-previous.y);
                
                if ((z+track) % 2 == 0) {
                    g.setColor(new Color(239, 239, 239));
                }
                else {
                    g.setColor(new Color(239, 239, 239));
                }
                g.fillPolygon(poly);
                previous.setLocation(x, y);
                    
                    
                     if ((z+track) % 4 == 0) {
                         
                         int xtree = (int) (150/ (z - a)); 
                         int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                         int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                         Enemy r = new Enemy( xtree + curva, previous.y - heightTree,widthTree, heightTree);
                         r.draw(g);
                         yeti.add(r);
 
                        }
                     if ((z+track) % 7 == 0) {
                         
                         int xtree = (int) (150/ (z - a)); 
                         int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                         int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                         Enemy r = new Enemy( - xtree - widthTree + curva, previous.y - heightTree,widthTree, heightTree);
                         r.draw(g);
                         yeti.add(r);
 
                        }
                     if ((z+track) % 9 == 0) {
                         
                         int xtree = (int) (100/ (z - a)); 
                         int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                         int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                         Enemy r = new Enemy( - xtree - widthTree + curva, previous.y - heightTree,widthTree, heightTree);
                         r.draw(g);
                         yeti.add(r);
                           
                           
                        }
                    if ((z+track) % 20 ==3) {
                        int xtree = (int) (170/ (z - a)); 
                        int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 3);
                        int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) *3);
                        Enemy r = new Enemy( xtree + curva, previous.y - heightTree,widthTree, heightTree);
                        r.draw(g);
                        yeti.add(r);
                       
                    }
                    if ((z+track) % 25 == 0) {
                        int xtree = (int) (50/ (z - a)); 
                        int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                        int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                        Enemy r = new Enemy( xtree + curva, previous.y - heightTree,widthTree, heightTree);
                        r.draw(g);
                        yeti.add(r);
                        
                        
                    }
                    if ((z+track) % 52 == 0) {
                        int xtree = (int) (-80/ (z - a)); 
                        int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                        int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                        Enemy r = new Enemy( xtree + curva, previous.y - heightTree,widthTree, heightTree);
                        r.draw(g);
                        yeti.add(r);

                    }
                    if ((z+track) % 26 == 5) {
                        int xtree = (int) (80/ (z - a)); 
                        int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                        int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                        Enemy r = new Enemy(  - xtree - widthTree + curva, previous.y - heightTree,widthTree, heightTree);
                        r.draw(g);
                        yeti.add(r);

                    }
                    if ((z+track) % 70 == 8) {
                        int xtree = (int) (80/ (z - a)); 
                        int widthTree = (int) (loadImage.enemy.getWidth() / (z-a) * 2);
                        int heightTree = (int) (loadImage.enemy.getHeight() / (z-a) * 2);
                        Enemy r = new Enemy( - xtree - widthTree + curva, previous.y - heightTree,widthTree, heightTree);
                        r.draw(g);
                        yeti.add(r);
                        
                    }
                    if ((z+track) % 5 == 0) {
                        int xtree = (int) (200 / (z - a)); 
                        int widthTree = (int) (loadImage.tree.getWidth() / (z-a) * 10);
                        int heightTree = (int) (loadImage.tree.getHeight() / (z-a) * 10);
                        g.drawImage(loadImage.tree, xtree + curva, (int) previous.y - heightTree, widthTree, heightTree,null);
                        g.drawImage(loadImage.tree, - xtree - widthTree + curva, (int) previous.y - heightTree, widthTree, heightTree, null);
                        
                        
                    }

                    if ((z+track) % 25 == 0) {
                        int xtree = (int) (4000 / (z - a)); 
                        int widthTree = (int) (loadImage.tree.getWidth() / (z-a) * 20);
                        int heightTree = (int) (loadImage.tree.getHeight() / (z-a) *10);
                        g.drawImage(loadImage.enemy1, xtree + curva, (int) previous.y - heightTree, widthTree, heightTree, null);
                        g.drawImage(loadImage.enemy1, - xtree - widthTree + curva, (int) previous.y - heightTree, widthTree, heightTree, null);
                    }
                    if ((z+track) % 10 == 0) {
                        int xtree = (int) (2000 / (z - a)); 
                        int widthTree = (int) (loadImage.snow.getWidth() / (z-a) * 8);
                        int heightTree = (int) (loadImage.snow.getHeight() / (z-a) *6);
                        g.drawImage(loadImage.snow, xtree + curva, (int) previous.y - heightTree, widthTree, heightTree, null);
                        g.drawImage(loadImage.snow, - xtree - widthTree + curva, (int) previous.y - heightTree, widthTree, heightTree, null);
                    }
                    
            }
            
            previousCurve = curva;
        }
        
        person.draw(g);
        
        int fontSize = 20;
        g.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
        g.setColor(Color.RED);
        g.drawString("SCORE: "+score, 50-getWidth()/2, 50-getHeight()/2);
        
       
   }
  
   
  
    public void checkCollision(){
        
        for(int i=0;i<yeti.size();i++){
            Enemy temp = yeti.get(i);
            if(person.getBounds().intersects(temp.getBounds())){
                collision = true;   
            }
            else{
                collision = false;
            }
        }
    }
   
 
 
   
}

