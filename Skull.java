
public class Skull extends Enemy
{
    public Skull(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;
        this.damage = 100;

    }
    @Override
    public void move(){

        this.y+=10;

    }
}
