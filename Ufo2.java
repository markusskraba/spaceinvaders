
public class Ufo2 extends Enemy
{

    boolean flag = true;

    public Ufo2(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;
        this.damage = 10;

    }
    @Override
    public void move(){

        if (this.x<=720 && flag) {
            this.x+=10;
            this.y+=10;
        } else {

            flag = false;

        }

        if (this.x>=0 && !flag) {
            this.x-=10;
            this.y+=10;
        } else {

            flag = true;

        }

    }
}
