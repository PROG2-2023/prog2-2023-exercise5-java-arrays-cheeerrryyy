package prog2.exercise5.flight.booking.system;
import java.time.LocalDate;
import java.util.Scanner;

public class FlightBooking {
private String flightCompany = "Flights-of-Fancy";
private String flightID = "rdytvf68tr6";
//private String passengerFullName;
private double departingTicketPrice;
private double returnTicketPrice;
private double totalTicketPrice;
//private String ticketNumber;
private LocalDate departureDate;
private LocalDate returnDate2;
private int childPassengers;
private int adultPassengers;
private int totalPassengers;
private LocalDate oldDate;
private BookingClass Bookingclass;
private TripSource Tripsource;
private SourceAirport sourair;
private DestinationAirport desair;
private TripType Triptype;
private TripDestination Tripdestination;
private String [] passengerFullName;
private String [] passengerGender ;
private int [] passengerAge ;
private String [] ticketNumber;
private int number;

public static String usingMath(int length) {
    String alphabetsInUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String numbers = "0123456789";
    String allCharacters = alphabetsInUpperCase + numbers;
    StringBuilder a = new StringBuilder();
    for (int i = 0; i < length; i++) {
        int randomIndex = (int) (Math.random() * allCharacters.length());
        a.append(allCharacters.charAt(randomIndex));
    }
    return a.toString();
}

    public enum BookingClass {
        FIRST, BUSINESS, ECONOMY;
    }

    public enum  TripType{
        ONE_WAY, RETURN;
    }

    public enum TripSource {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;
    }

    public enum TripDestination {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;;
    }

    public enum SourceAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    public enum DestinationAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    public FlightBooking(String passengerFullName, LocalDate depart, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = new String[1];
        this.passengerFullName[0] = passengerFullName;
        this.departureDate = depart;
        this.returnDate2 = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
         
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getFlightID()  {
        return flightID;
    }

    public void setPassengerFullName(int index,String passengerFullName) {
        this.passengerFullName [index] = passengerFullName;
    }
    public String getPassengerFullName(int index) {
        return passengerFullName[index];
    }

    public void setPassengerGender(int index,String passengerGender) {
        this.passengerGender[index] = passengerGender;
    }
    public String getPassengerGender(int index) {
        return passengerGender[index];
    }
    
    public void setPassengerAge(int index,int passengerAge) {
        this.passengerAge[index] = passengerAge;
    }
    public int getPassengerAge(int index) {
        return passengerAge[index];
    }

    public FlightBooking(int number){
        this.passengerFullName = new String[number];
        this.passengerGender = new String[number];
        this.passengerAge = new int[number];
        this.ticketNumber = new String[number];
        this.number = number;
        }
        
    public void reserveTickets(int number){
    Scanner myscanner = new Scanner(System.in);
    for (int numb = number;numb > 0; --numb) {
    System.out.println("Dear passenger please input some messages for the No."+(number+1-numb)+"passenger");
    System.out.println("Please input Your FullName:");
    this.passengerFullName[number-numb] = myscanner.nextLine();
    System.out.println("Please input Your gender(Male, Female or Other):");
    this.passengerGender[number-numb]= myscanner.nextLine();
    System.out.println("Please input Your age:");
    this.passengerAge[number-numb] = myscanner.nextInt();
    }

    System.out.println("\nPlease input some message for people");
    System.out.println("Please input your date of departure:");
    String sta = myscanner.nextLine();
    LocalDate departure = LocalDate.parse(sta);
    setDepartureDate(departure);
    
    System.out.println("Please input your date of returning:");
    String sta2 = myscanner.nextLine();
    LocalDate returningDate = LocalDate.parse(sta2);
    setOldDate(returningDate);
    setReturnDate(returningDate);
    

    System.out.println("Dear passenger please input the number of childpassengers:");
    this.childPassengers = myscanner.nextInt();
    System.out.println("Dear passenger please input the number of adultpassengers:");
    this.adultPassengers = myscanner.nextInt();
    
    System.out.println("Please pick the number of class you would like to travel in " );
    System.out.println("1." + "First");
    System.out.println("2." + "Business");
    System.out.println("3." + "Economy");
    String num1 = myscanner.nextLine();
    setBookingClass(num1);
        
    System.out.println("Please pick the choice(number) of 1.One way \n 2.Return ");
    String num2 = myscanner.nextLine();
    setTripType(num2);

    System.out.println("Please pick the number of tripsouce you would like to travel" );
    System.out.println("1." + "Nanjing");
    System.out.println("2." + "Beijing");
    System.out.println("3." + "Oulu");
    System.out.println("4." + "Helsinki");
    System.out.println("5." + "Shanghai");
    System.out.println("6." + "Paris");
    String num = myscanner.nextLine();
    setTripSource(num);
    FlightBooking.TripSource result = getTripSource();
    setSourceAirport(num);

    System.out.println("Please pick the number of tripdestination you would like to go" );
    System.out.println("1." + "Nanjing");
    System.out.println("2." + "Beijing");
    System.out.println("3." + "Oulu");
    System.out.println("4." + "Helsinki");
    System.out.println("5." + "Shanghai");
    System.out.println("6." + "Paris");
    String num3 = myscanner.nextLine();
    setTripDestination(num,num3);
    FlightBooking.TripDestination result2 = getTripDestination();
    setDestinationAirport(num,num3);

    for (int numb =number;numb>0;--numb){
    setTicketNumber(number-numb);
    myscanner.close();
    }
}
    
    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }
    public int getChildrenPassengers() {
        return childPassengers;
    }
    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }
    public int getAdultPassengers() {
        return adultPassengers;
    }


    public void setTotalPassengers(int adultPassengers,int childPassengers){
        this.totalPassengers = adultPassengers + childPassengers;
        }
    public int getTotalPassengers() {
        return totalPassengers;
    }

   
   public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getDepartingDate() {
        return departureDate;
    }
    public void setOldDate(LocalDate returnDate) {
        this.oldDate = returnDate;
    }
    public LocalDate getOldDate() {
        return oldDate;
    }
    public void setReturnDate(LocalDate returnDate) {
         long between = returnDate.toEpochDay()-departureDate.toEpochDay();
         if(between >= 2){
         this.returnDate2 = returnDate;
         }else{
         this.returnDate2 = departureDate.plusDays(2);
         }
        }
    public LocalDate getReturnDate() {
        return returnDate2;
    }

    public void setBookingClass(String num1) {;
        switch(num1) {
            case "1":
            Bookingclass = BookingClass.FIRST;
            break;
            case "2":
            Bookingclass = BookingClass.BUSINESS;
            break;
            case "3":
            Bookingclass = BookingClass.ECONOMY;
            break;
            default :
            System.out.println("Error input.");
        }
    }
    public BookingClass getBookingclass() {
        return Bookingclass;
    }


    public void setTripType(String num2) {    
        switch(num2) {
            case "1":
            Triptype = TripType.ONE_WAY;
            break;
            case "2":
            Triptype = TripType.RETURN;
            break;
            default :
            System.out.println("Error input.");
        }
    }
    public TripType getTriptype() {
        return Triptype;
    }


    public void setTripSource(String num) {   //Only one parameter
        switch(num) {
            case "1":
            Tripsource = TripSource.NANJING;
            break;
            case "2":
            Tripsource = TripSource.BEIJING;
            break;
            case "3":
            Tripsource = TripSource.OULU;
            break;
            case "4":
            Tripsource = TripSource.HELSINKI;
            break;
            case "5":
            Tripsource = TripSource.SHANGHAI;
            break;
            case "6":
            Tripsource = TripSource.PARIS;
            break;
            default :
            System.out.println("Error input.");
        }
    }
    public TripSource getTripSource() {
        return Tripsource;
    }

    public void setSourceAirport(String num) {
        switch(num) {
            case "1":
            this.sourair = SourceAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.sourair = SourceAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.sourair = SourceAirport.Oulu_Airport;
            break;
            case "4":
            this.sourair = SourceAirport.Helsinki_Airport;
            break;
            case "5":
            this.sourair = SourceAirport.Shanghai_Pudong_International_Airport;
            break;
            case "6":
            this.sourair = SourceAirport.Paris_Charles_de_Gaulle_Airport;
            break;
            default :
            System.out.println("Error input.");
        }
         }
    public SourceAirport getSourceAirport() {
        return sourair;
    }


    public void setTripDestination(String num, String num3) {
        if(!num.equals(num3)) {
            switch(num3) {
            case "1":
            Tripdestination = TripDestination.NANJING;
            break;
            case "2":
            Tripdestination = TripDestination.BEIJING;
            break;
            case "3":
            Tripdestination = TripDestination.OULU;
            break;
            case "4":
            Tripdestination = TripDestination.HELSINKI;
            break;
            case "5":
            Tripdestination = TripDestination.SHANGHAI;
            break;
            case "6":
            Tripdestination = TripDestination. PARIS;
            break;
            default :
            System.out.println("Error input.");
            }
        } else {
            System.out.println("The trip source and the trip destination should not be the same!");
        }
    }
    public TripDestination getTripDestination() {
        return Tripdestination;
    }


    public void setDestinationAirport(String num,String num3) {
        if(!num.equals(num3)) {
        switch(num3) {
            case "1":
            this.desair = DestinationAirport.Nanjing_Lukou_International_Airport;
            break;
            case "2":
            this.desair = DestinationAirport.Beijing_Capital_International_Airport;
            break;
            case "3":
            this.desair = DestinationAirport.Oulu_Airport;
            break;
            case "4":
            this.desair = DestinationAirport.Helsinki_Airport;
            break;
            case "5":
            this.desair = DestinationAirport.Shanghai_Pudong_International_Airport;
            break;
            case "6":
            this.desair = DestinationAirport.Paris_Charles_de_Gaulle_Airport;
            break;
            default :
            System.out.println("Error input.");
        }
    } else {
            System.out.println("The  source airport and the  destination airport should not be the same!");}
    }
    public DestinationAirport getDestinationAirport() {
        return desair;
    }


    public void setTicketNumber(int index) {
        String Ticketnumber;
        String a = usingMath(4);
        if(Triptype == (TripType.ONE_WAY)) {
            Ticketnumber = "11";
            if(Bookingclass == (BookingClass.FIRST)){
                Ticketnumber = Ticketnumber + "F" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            } else if(Bookingclass == BookingClass.BUSINESS) {
                Ticketnumber = Ticketnumber + "B" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            } else if(Bookingclass == BookingClass.ECONOMY) {
                Ticketnumber = Ticketnumber + "E" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            }
        } else {
            Ticketnumber = "22";
            if(Bookingclass == BookingClass.FIRST){
                Ticketnumber = Ticketnumber + "F" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            } else if(Bookingclass == BookingClass.BUSINESS) {
                Ticketnumber = Ticketnumber + "B" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            } else if(Bookingclass == BookingClass.ECONOMY) {
                Ticketnumber = Ticketnumber + "E" + a;
                if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
                    Ticketnumber = Ticketnumber + "DOM"; 
                } else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)) {
                    Ticketnumber = Ticketnumber + "DOM";
                } else {
                    Ticketnumber = Ticketnumber + "INT";
                }
            }
        }
        this.ticketNumber[index] = Ticketnumber;
        }

    public String getTicketNumber(int index) {
        setTicketNumber(index);
        return ticketNumber[index];
}
    
    
    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        double dt = 0.0;
        if((Tripsource == TripSource.OULU || Tripsource == TripSource.PARIS || Tripsource == TripSource.HELSINKI) && (Tripdestination == TripDestination.PARIS || Tripdestination == TripDestination.OULU || Tripdestination == TripDestination.HELSINKI)) {
            dt = 345;
        }else if((Tripsource == TripSource.NANJING || Tripsource == TripSource.BEIJING || Tripsource == TripSource.SHANGHAI) && (Tripdestination == TripDestination.NANJING || Tripdestination == TripDestination.BEIJING || Tripdestination == TripDestination.SHANGHAI)){
            dt = 345;
        }
        else {
            dt = 375;
        }
        if(Bookingclass == BookingClass.FIRST) {
            this.departingTicketPrice = (dt + 250) * (childPassengers + adultPassengers);
        } else if(Bookingclass == BookingClass.BUSINESS) {
            this.departingTicketPrice = (dt + 150) * (childPassengers + adultPassengers);
        } else if(Bookingclass == BookingClass.ECONOMY) {
            this.departingTicketPrice = (dt + 50) * (childPassengers + adultPassengers);
        }
    }

    public void setReturnTicketPrice() {
        if(Triptype == TripType.ONE_WAY) {
            this.returnTicketPrice = 0;
        } else {
            this.returnTicketPrice = this.departingTicketPrice;
        }
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }
    public void content(){
        String tent = "Thank you for booking your flight with "+ flightCompany+"\nYou reserved a total of" + number +"tickets."+"\n\n";
        System.out.println(tent);
        if (oldDate != returnDate2){
        for (int repeat=number;repeat>0;--repeat){
        System.out.println("Here are the trip details for Passenger No."+(number-repeat+1)+"\n\nPassenger's Ticket Number: "+
        ticketNumber[number-repeat]+"\nPassenger's Full Name:"+passengerFullName[number-repeat]+
        "\nPassenger's Age:"+passengerAge[number-repeat]+"\nPassenger's Gender:"+passengerGender[number-repeat]+
        "\nFrom:"+ Tripsource +"("+sourair+")"+"\nTo:"+Tripdestination+"("+desair+")"+"\nThe flight departs on:"+
        departureDate+"(Changed from old "+oldDate+" to new "+returnDate2+")"+"\nAnd the return flight is on:"+ returnDate2+"\n\n");
        }
        System.out.println("\nThe total ticket price is:"+totalTicketPrice+"\n\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was \n" +
        "less than two days apart from your departure date.");
        
        }else{
        for (int repeat=number;repeat>0;--repeat){
        System.out.println("Here are the trip details for Passenger No."+(number-repeat+1)+"\n\nPassenger's Ticket Number: "+
        ticketNumber[number-repeat]+"\nPassenger's Full Name:"+passengerFullName[number-repeat]+
        "\nPassenger's Age:"+passengerAge[number-repeat]+"\nPassenger's Gender:"+passengerGender[number-repeat]+
        "\nFrom:"+Tripsource+"("+sourair+")"+"\nTo:"+Tripdestination+"("+desair+")"+"\nThe flight departs on:"+
        departureDate+"\nAnd the return flight is on:"+ returnDate2+"\n\n");
        }
        System.out.println("\nThe total ticket price is:"+totalTicketPrice);
        }
        
        }


}
