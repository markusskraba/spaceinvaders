
public class Rocket extends Sprites
{

    public Rocket(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void move(){

        this.y-=30;

    }
}
