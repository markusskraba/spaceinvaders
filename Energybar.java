import javax.swing.*;

public class Energybar extends JPanel implements Globals
{
    private Energyslider energieslider; 
    private Resetbutton resetbutton;

    public Energybar()
    {
        energieslider = new Energyslider("Energie: ", ENERGY_MIN, ENERGY_MAX, ENERGY_INIT);
        resetbutton = new Resetbutton("START");

        add(energieslider);
        add(resetbutton);
        setVisible(true);
        setFocusable(false);

    }

    public Energyslider getEnergieslider(){
        return energieslider;   
    }

    public Resetbutton getResetbutton(){
        return resetbutton;   
    }

}
