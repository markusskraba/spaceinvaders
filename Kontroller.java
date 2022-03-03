import java.awt.event.*;

public class Kontroller extends KeyAdapter implements Components{

    @Override
    public void keyReleased(KeyEvent e) {
        //spaceShip.keyReleased(e);
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) playground.spaceship.moveLeft();
        if (key == KeyEvent.VK_RIGHT) playground.spaceship.moveRight();
        if (key == KeyEvent.VK_UP) playground.spaceship.moveUp();
        if (key == KeyEvent.VK_DOWN) playground.spaceship.moveDown();
        if (key == KeyEvent.VK_SPACE) playground.spaceship.shoot();

    }
}

