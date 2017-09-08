/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powerball;

import javax.swing.JOptionPane;

/**
 *
 * @author etcharn1
 */
public class PowerBallSimulator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int totalSpent = 0;
        int totalWon = 0;
        
        int numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        
        while ( numberOfTicketsToPurchase != 0 )
        {
            totalSpent += numberOfTicketsToPurchase * PowerBall.TICKET_PRICE;
            PowerBall winningTicket = new PowerBall();
            
            for ( int ticketNumber = 0; ticketNumber < numberOfTicketsToPurchase; ticketNumber++ )
            {
                PowerBall myTicket = new PowerBall();
                totalWon += myTicket.getWinnings( winningTicket );
                if ( myTicket.getWinnings(winningTicket ) == 1000000000 )
                {
                    JOptionPane.showMessageDialog(null, "JACKPOT");
                }
            }
            String message = String.format("Total Spent: %d - Total Won: %d - Net Loss: %d", 
                    totalSpent, totalWon, totalWon - totalSpent );
            JOptionPane.showMessageDialog(null, message);
            
            numberOfTicketsToPurchase = Integer.parseInt(
                JOptionPane.showInputDialog(
                "Please enter the number of tickets you want to buy, or 0 to quit") );
        }
    }
}
