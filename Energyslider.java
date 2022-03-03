import javax.swing.*;

public class Energyslider extends JPanel
{
    JLabel text;
    JSlider slider;

    public Energyslider(String labeltext, int min, int max, int init)
    {
        this.text = new JLabel(labeltext);
        this.slider = new JSlider(min, max, init);

        add(text);
        add(slider);
        setVisible(true);
        setFocusable(false);
        slider.setFocusable(false);
        slider.setEnabled(false);

    }

    public void setEnergie(int damage){

        slider.setValue(slider.getValue()-damage);
    }

    public int getValue(){

        return slider.getValue();
    }

    public void resetEnergie(int reset){
        slider.setValue(reset);

    }
}
