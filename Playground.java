import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.*;

public class Playground extends JPanel implements ActionListener, Components, Globals
{

    protected Spaceship spaceship;
    protected Timer timer;
    protected ArrayList<Enemy> enemyList = new ArrayList<Enemy>();  

    public Playground()
    {

        this.spaceship = new Spaceship(PATH_SPACESHIP,400,600);
        timer = new Timer(100,this);
        timer.start();
        setVisible(true);
        setRequestFocusEnabled(true);
        grabFocus();
        setFocusable(true);
        addKeyListener(new Kontroller());

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        ImageIcon icon = new ImageIcon(PATH_BACKGROUND);
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image,0,0,WINDOW_SIZE_X,WINDOW_SIZE_Y,null);
        g2D.drawImage(bufferedImage,0,0,null);

        ImageIcon explosion = new ImageIcon(PATH_EXPLOSION);
        Image imageExplosion = explosion.getImage();
        BufferedImage bufferedImageExplosion = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
        bufferedImageExplosion.getGraphics().drawImage(imageExplosion,0,0,100,100,null);

        spaceship.draw(g2D, spaceship.getX(), spaceship.getY());
        g2D.setColor(new Color(255, 0, 0, 0));
        g2D.draw(spaceship.getRectangle());
        spaceship.getRectangle().move(spaceship.getX(), spaceship.getY());

        int c = 0;
        for(Enemy ga : enemyList){
            if(ga != null) {
                ga.move();
                ga.draw(g2D, ga.getX(), ga.getY());
                g2D.draw(ga.getRectangle());
                ga.getRectangle().move(ga.getX(), ga.getY());

                if(ga.getRectangle().intersects(spaceship.getRectangle())) energybar.getEnergieslider().setEnergie(ga.getDamage());

                if(ga.getY()>800) enemyList.set(c, null);
            }
            c++;
        }  

        int b = 0;
        for(Rocket ra : spaceship.getRocketList()){
            if(ra != null) {
                ra.draw(g2D, ra.getX(), ra.getY());
                ra.move();

                g2D.draw(ra.getRectangle());
                ra.getRectangle().move(ra.getX(), ra.getY());

                if(ra.getY()<0) spaceship.getRocketList().set(b, null);
                int a = 0;
                for(Enemy ga : enemyList){
                    if(ga != null && ra != null) {
                        if(ra.getRectangle().intersects(ga.getRectangle())){
                            g2D.drawImage(bufferedImageExplosion,ga.getX(),ga.getY(),null);
                            enemyList.set(a, null);
                            spaceship.getRocketList().set(b, null);
                        }

                    }
                    a++;
                }  

            }
            b++;
        } 

        if(energybar.getEnergieslider().getValue() == 0) {
            ImageIcon gameover = new ImageIcon(PATH_GAMEOVER);
            Image imageGameover = gameover.getImage();
            BufferedImage bufferedImageGameOver = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_ARGB);
            bufferedImageGameOver.getGraphics().drawImage(imageGameover,0,0,WINDOW_SIZE_X,WINDOW_SIZE_Y,null);
            g2D.drawImage(bufferedImageGameOver,0,0,null);
            timer.stop();
            energybar.getResetbutton().getButton().setEnabled(true);

        }
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        enemyList.add(Enemy.create());
        repaint();
    }

    public void reset () {
        energybar.getEnergieslider().resetEnergie(100);
        enemyList.clear();
        spaceship.setX(400);
        spaceship.setY(600);
        timer.start();

    }
}
