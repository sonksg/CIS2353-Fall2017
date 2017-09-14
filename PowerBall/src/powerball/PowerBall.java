/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerball;

import java.util.Random;

/**
 *
 * @author etcharn1
 */
public class PowerBall {
    static final int TICKET_PRICE = 2;
    
    private int[] whiteBalls;
    private int redBall;
    
    public PowerBall()
    {
        Random random = new Random();
        whiteBalls = new int[5];
        redBall = random.nextInt(26) + 1;
        
        int[] bucket = new int[69];
        for( int number = 0; number < bucket.length; number++)
        {
            bucket[number] = number+1;
        }
        
        for ( int whiteBallIndex = 0; whiteBallIndex < whiteBalls.length; whiteBallIndex++ )
        {
            int randomBall = random.nextInt( bucket.length );
            while ( bucket[randomBall] == 0 )
            {
                randomBall = random.nextInt( bucket.length );
            }
            
            whiteBalls[whiteBallIndex] =  bucket[randomBall];
            bucket[randomBall] = 0;
        }
    }
    
    public PowerBall(int[] whiteBalls, int redBall)
    {
        // TODO - this is bad - we should check for dupes
        for ( int index = 1; index < whiteBalls.length; index++ )
        {
            for ( int ballToCheck = 0; ballToCheck < index; ballToCheck++ )
            {
                if (whiteBalls[ballToCheck] == whiteBalls[index])
                {
                    // do something here
                }
            }
        
        }
        
        this.whiteBalls = whiteBalls;
        this.redBall = redBall;
    }
    
    public int getWinnings( PowerBall winningTicket )
    {
        int winnings = 0;
        
        boolean redMatches = winningTicket.redBall == this.redBall;
        
        int whiteMatches = 0;
        
        for ( int myWhiteBall : whiteBalls )
        {
            for ( int winningWhiteBall : winningTicket.whiteBalls )
            {
                if (myWhiteBall == winningWhiteBall)
                {
                    whiteMatches++;
                }
            }
        }
        
        if ( whiteMatches == 5 && redMatches )
        {
            winnings = 1000000000;
        }
        else if ( whiteMatches == 5 )
        {
            winnings = 1000000;
        }
        else if ( whiteMatches == 4 && redMatches )
        {
            winnings = 50000;
        }
        else if ( whiteMatches == 4 || ( whiteMatches == 3 && redMatches ) )
        {
            winnings = 100;
        }
        else if ( whiteMatches == 3 || ( whiteMatches ==2 && redMatches ) )
        {
            winnings = 7;
        }
        else if ( redMatches )
        {
            winnings = 4;
        }
        
        return winnings;
    }
    
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for ( int whiteBall : whiteBalls )
        {
            builder.append(whiteBall);
            builder.append(" ");
        }
        builder.append("PowerBall: ");
        builder.append( redBall );
        
        return builder.toString();
    }

}
