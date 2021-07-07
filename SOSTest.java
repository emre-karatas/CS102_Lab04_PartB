import cs101.sosgame.SOS;

import javax.swing.*;

import java.awt.*;

/**
 * Test class for SOS Game
 * @author Emre Karatas-22001641
 * @version v1.0 - 07.07.2021
 */
public class SOSTest
{

    public static void main(String[] args)
    {
        SOS newSOS = new SOS(5);
        JFrame frame = new JFrame("SOS GAME");
        SOSGUIPanel newPanel = new SOSGUIPanel(newSOS,"George", "Gerald");
        frame.add(newPanel);
        frame.setSize(new Dimension(600,600));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

}
