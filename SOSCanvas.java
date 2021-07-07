import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;

/**
 * SOS Canvas for SOS Game
 * @author Emre Karatas-22001641
 * @version v1.0-07.07.2021
 */
public class SOSCanvas extends JPanel
{
    private final int SIDE_LENGTH = 90;

    private final int TOP_LEFT_X = 60;

    private final int TOP_LEFT_Y = 30;


    SOS ourGame;

    //construcot
    public SOSCanvas(SOS game)
    {
        ourGame = game;
    }

    /**
     * Paint method
     * @param g graphics
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

       for ( int i = 0; i < ourGame.getDimension(); i++)
       {
           for (int k = 0; k < ourGame.getDimension(); k++)
           {
               g.drawRect(TOP_LEFT_X + (i * SIDE_LENGTH), TOP_LEFT_Y+ (k * SIDE_LENGTH), SIDE_LENGTH, SIDE_LENGTH);
               if ( ourGame.getCellContents(i,k) == 's')
               {
                   g.drawString("S",TOP_LEFT_X + (i * SIDE_LENGTH)+ SIDE_LENGTH/2,TOP_LEFT_Y+ (k * SIDE_LENGTH)+SIDE_LENGTH/2);
               }
               else if (  ourGame.getCellContents(i,k) == 'o')
               {
                   g.setColor(Color.RED);
                   g.drawString("O",TOP_LEFT_X + (i * SIDE_LENGTH)+ SIDE_LENGTH/2,TOP_LEFT_Y+ (k * SIDE_LENGTH)+SIDE_LENGTH/2);
                   g.setColor(Color.BLACK);
               }
               else
               {
                   g.drawString(".",TOP_LEFT_X + (i * SIDE_LENGTH)+ SIDE_LENGTH/2,TOP_LEFT_Y+ (k * SIDE_LENGTH)+SIDE_LENGTH/2);
               }

           }

       }

    }

    //GETTERS

    public int getSIDE_LENGTH() {
        return SIDE_LENGTH;
    }

    public int getTOP_LEFT_X() {
        return TOP_LEFT_X;
    }

    public int getTOP_LEFT_Y() {
        return TOP_LEFT_Y;
    }
}
