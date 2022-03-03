
public class Ufo1 extends Enemy
{

    boolean flag = true;

    public Ufo1(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;
        this.damage = 5;

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
