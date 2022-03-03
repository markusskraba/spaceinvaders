
public abstract class Enemy extends Sprites
{

    protected int damage;
    
    public Enemy(String imagePath, int x, int y)
    {

        super(imagePath, x, y);
        this.x = x;
        this.y = y;

    }

    private static int random(int lowerLimit, int upperLimit){
        return lowerLimit + (int) (Math.random()*(upperLimit-lowerLimit)); 
    }

    public static Enemy create(){

        int chance = random(0,30);

        switch(chance){

            case 0: return new Skull(PATH_SKULL, random(0,WINDOW_SIZE_X), 0);
            case 15: return new Ufo1(PATH_UFO1,random(0,WINDOW_SIZE_X), 0);
            case 29: return new Ufo2(PATH_UFO2,random(0,WINDOW_SIZE_X), 0);
            default : return null;

        }

    }
    
    public int getDamage(){
        return damage;
    }

}
