import cs101.sosgame.SOS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI panel for SOS game
 * @author Emre Karatas-22001641
 * @version v1.0 - 7.07.2021
 */
public class SOSGUIPanel extends JPanel
{
    SOS ourGame;
    SOSCanvas myCanvas;
    JLabel nameplayer1;
    JLabel nameplayer2;
    JLabel scoreplayer1;
    JLabel scoreplayer2;
    JPanel labelPanel;
    JComboBox ourBox;
    String player1;
    String player2;
    JPanel comboPanel = new JPanel();
    MouseListener canvasListener;
    String winner;

    //Constructor
    public SOSGUIPanel( SOS ourGame, String player1 , String player2 )
    {
        this.ourGame = ourGame;
        this.player1 = player1;
        this.player2 = player2;
        winner = null;

        myCanvas = new SOSCanvas(ourGame);
        labelPanel = new JPanel();
        ourBox = new JComboBox();

        ourBox.addItem('s');
        ourBox.addItem('o');

         nameplayer1 = new JLabel();
         nameplayer1.setForeground(Color.GREEN);
         nameplayer2 = new JLabel();
         scoreplayer1 = new JLabel();
         scoreplayer2 = new JLabel();


        nameplayer1.setText(player1 + " ");
        nameplayer1.setFont(new Font("Comic Sans",Font.BOLD,20));
        scoreplayer1.setText(ourGame.getPlayerScore1() + "  -  ");
        scoreplayer1.setFont(new Font("Comic Sans",Font.BOLD,20));
        scoreplayer2.setText(ourGame.getPlayerScore2() + "  ");
        scoreplayer2.setFont(new Font("Comic Sans",Font.BOLD,20));
        nameplayer2.setText(player2 + "");
        nameplayer2.setFont(new Font("Comic Sans",Font.BOLD,20));
        labelPanel.add(nameplayer1);
        labelPanel.add(scoreplayer1);
        labelPanel.add(scoreplayer2);
        labelPanel.add(nameplayer2);

        setLayout(new BorderLayout());
        labelPanel.setAlignmentX(SwingConstants.CENTER);
        add(labelPanel,BorderLayout.NORTH);
        add(myCanvas,BorderLayout.CENTER);
        add(comboPanel,BorderLayout.SOUTH);
        comboPanel.add(ourBox,SwingConstants.CENTER);

        canvasListener = new SOSCanvasListener();
        myCanvas.addMouseListener(canvasListener);



    }

    /**
     * Listener class as Inner class
     * @author Emre Karatas-22001641
     * @version v1.0 -07.07.2021
     */
    public class SOSCanvasListener extends MouseAdapter
    {

        @Override
        /**
         * MouseCliked method
         */
        public void mouseClicked(MouseEvent e)
        {
            int row = 0;
            int column = 0;
            Point p = new Point();
            p = e.getPoint();
            for ( int i = myCanvas.getTOP_LEFT_X(); i < 510; i++)
            {
                if ( p.getX() == i)
                {
                    row = (i-myCanvas.getTOP_LEFT_X()) / myCanvas.getSIDE_LENGTH();
                    row++;
                    break;
                }
            }

            for ( int k = myCanvas.getTOP_LEFT_Y(); k < 480; k++)
            {
                if ( p.getY() == k)
                {
                    column = (k- myCanvas.getTOP_LEFT_Y()) / myCanvas.getSIDE_LENGTH();
                    column++;
                    break;
                }
            }

            char c = (char) ourBox.getSelectedItem();
            // calling play method
            ourGame.play(c,row,column);
            scoreplayer1.setText(ourGame.getPlayerScore1() + " - ");
            scoreplayer2.setText(ourGame.getPlayerScore2()+ " ");
            if ( !ourGame.isGameOver())
            {
                myCanvas.repaint();
                if ( ourGame.getTurn() == 1)
                {
                    nameplayer1.setForeground(Color.GREEN);
                    nameplayer2.setForeground(Color.BLACK);
                }
                else if ( ourGame.getTurn() == 2)
                {
                    nameplayer2.setForeground(Color.GREEN);
                    nameplayer1.setForeground(Color.BLACK);
                }

            }
            else
            {
                if ( ourGame.getPlayerScore1() > ourGame.getPlayerScore2())
                {
                    winner = player1 + " is the winner!";
                }
                else if ( ourGame.getPlayerScore2() > ourGame.getPlayerScore1())
                {
                    winner = player2 + " is the winner!";
                }
                else
                {
                    winner = "it is a draw!";
                }
                //JOptionPane
                JOptionPane.showInternalMessageDialog(null, winner, "Game is Over!", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }


}
