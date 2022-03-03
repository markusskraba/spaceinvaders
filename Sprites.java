import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;

public class Sprites implements Globals
{

    protected int x,y;
    private BufferedImage bufferedImage;
    private Rectangle shape;

    public Sprites(String imagePath, int x, int y)
    {

        this.x = x;
        this.y = y;

        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        this.bufferedImage = new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_ARGB);
        this.bufferedImage.getGraphics().drawImage(image,0,0,SHAPE_X,SHAPE_Y,null);
        this.shape = new Rectangle(x,y,SHAPE_X,SHAPE_Y);        

    }

    public void draw(Graphics2D g, int x, int y){
        g.drawImage(bufferedImage,x,y,null);
    }

    public void draw(Graphics2D g){
        g.drawImage(bufferedImage,x,y,null);
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void move(){}

    public Rectangle getRectangle(){
        return shape;
    }
}
