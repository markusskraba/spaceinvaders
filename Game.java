import javax.swing.*;
import java.awt.*;

public class Game extends JFrame implements Components, Globals
{

    private static Game game;
    private BorderLayout borderlayout = new BorderLayout();

    public Game()
    {
        setLayout(borderlayout);
        setTitle("SpaceInvaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE_X,WINDOW_SIZE_Y);
        add(energybar,BorderLayout.NORTH);
        add(playground,BorderLayout.CENTER);
        setResizable(false);
        setVisible(true);
        setFocusable(false);

    }

    public static void main(String args[]){
        try{
            game = new Game();

        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }

}