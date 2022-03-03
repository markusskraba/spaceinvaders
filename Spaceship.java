import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.*;
import java.awt.Rectangle;

public class Spaceship extends Sprites
{

    private ArrayList<Rocket> rocketList = new ArrayList<Rocket>();  
    public Spaceship(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;
    }

    public void moveLeft(){
        if (this.x>0) this.x -= 40;
    
    }

    public void moveRight(){
        if (this.x<720) this.x += 40;

    }

    public void moveUp(){
        if (this.y>0) this.y -= 40;

    }

    public void moveDown(){
        if (this.y<620) this.y += 40;

    }

    public void shoot(){
        rocketList.add(new Rocket("Bilder/Rakete.png", this.x,this.y));
    }

    public ArrayList<Rocket> getRocketList(){
        return rocketList;
    }
    
    

}

