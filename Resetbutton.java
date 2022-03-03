import javax.swing.*;
import java.awt.event.*;

public class Resetbutton extends JPanel implements MouseListener, Components
{

    private JButton button;

    public Resetbutton(String buttontext)
    {
        this.button = new JButton(buttontext);
        add(button);
        setFocusable(false);
        button.addMouseListener(this);
        button.setFocusable(false);
        button.setEnabled(false);

    }
    
    public JButton getButton(){
        
        return button;
    }
    
    @Override
    public void mouseClicked(MouseEvent e){

        playground.reset();

    }

    @Override public void mousePressed(MouseEvent e){}

    @Override public void mouseReleased(MouseEvent e){}

    @Override public void mouseEntered(MouseEvent e){}

    @Override public void mouseExited(MouseEvent e){} 
}
