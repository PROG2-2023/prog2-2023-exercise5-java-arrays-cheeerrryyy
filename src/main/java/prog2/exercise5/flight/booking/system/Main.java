package prog2.exercise5.flight.booking.system;

/**
 * Hello world!
 *
 */
//import java.time.LocalDate;
import java.util.Scanner;

public class Main
{
   

    public static void main( String[] args)
    {
        Scanner myscanner = new Scanner(System.in);
        //FlightBooking fb = new FlightBooking("null", depart, returnDate, 2, 3); 
        System.out.println("Please enter how many tickets you want to book:");
        int number = myscanner.nextInt();
        FlightBooking cr = new FlightBooking(number);
        cr.reserveTickets(number);
        myscanner.close();
        cr.content();
      

            
            
            }
    //    
       }
        
    
