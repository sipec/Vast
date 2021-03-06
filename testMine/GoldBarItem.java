package testMine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;


public class GoldBarItem extends Item
{
    Timer check;

    int amount;

    Player victem;


    public GoldBarItem( double x, double y, BufferedImage img, World world )
    {
        super( x, y, 0, img, world );
        amount = 1000;
        pickupTimer();
    }


    public void pickupTimer()
    {
        check = new Timer( 1000, new ActionListener()
        {
            @Override
            public void actionPerformed( ActionEvent e )
            {
                checkArea();
            }
        } );
        check.start();
    }


    public void checkArea()
    {
        if ( ( victem = world.detectPlayer( d.getX(), d.getY(), 1 ) ) != null )
        {
            check.stop();
            victem.addGold( amount );
            world.itemDeath( this );
            return;
        }
    }
}
