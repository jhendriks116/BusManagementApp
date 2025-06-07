 

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *Bus, a generic Bus.
 **/
public class Bus implements Comparable<Bus> {
    private String name;
    private int size;
    private int price;
    private ArrayList<Trip> approvedTrips;
    private int level; // 1,2,3 for low,medium, high repectively;
    private int id;
    private static int nextId=0;
    private Ministry mny;
    protected String tripTypes;
    
    private int getNextId(){
       return ++nextId; 
       }
    
    public Bus(){
        approvedTrips=new ArrayList<Trip>();
        }
        /**
         * Constructs new Bus object.
         * 
         * @param name  Sets the name of the bus.
         * @param size  Sets the size of the bus.
         * @param price Sets the price of the bus.
         * @param level Sets the level of the bus, being low, medium or high.
         * @param mny   Sets the Ministry object for Transport regulations.
         *  */    
        public Bus( String name, int size, int price, int lev, Ministry mny) {
            approvedTrips=new ArrayList<Trip>();
            this.name = name;
            this.size =size;
            this.price = price;
            this.level = lev;
            this.id = getNextId();
            this.mny = mny;
            tripTypes = "BASICTRANSPORT";
        
        }
        public int compareTo(Bus other)
        {
            return this.getId() - other.getId();
        }
       
        public boolean available(Date date){
            boolean retval = true;
            for (Trip t:approvedTrips)
               if  (t.getDate().getDay() == date.getDay())
                   retval = false;
            return retval;
        }
        
        public int getPrice(){
            return price;
        }
        public int getId(){
            return id;
        }
        
        public String getName(){
            return name;
        }
        
        public int getSize(){
            return size;
        }
        
        public int getLevel(){
            return level;
        }
        
        public Ministry getMinistry(){
            return mny;
        }
        

        
        public void setName(String name){
            this.name = name;
        }
                
        public void setPrice(int price){
            this.price = price;
        }
        public void setSize(int size){
            this.size = size;
        }
        
        public void setLevel(int level){
            this.level = level;
        }
        
        
        
        
        public boolean isSuitable(String type){
            return tripTypes.contains(type);
        }
        
        public int getEstimate(String type, int numPassengers, int comfortLevel){              
            return price;
        }
        
        public boolean canHold(int numPassengers, int comfortLevel){
            int capacity = (int)(size / mny.getSeparation(comfortLevel));
            return numPassengers <=capacity;
            
        }
        
        
        
        public void promoteTrips(){
          System.out.println();
          System.out.println("TRIPS ON " +getName());
          System.out.println("===================");
          for (Trip t:approvedTrips)
              System.out.println(t);
                            
        }
        
        public int reserve(Trip trip,  Ministry mny){
            int retval = -1;
            ApprovalRequest ar = new ApprovalRequest(trip, this);
            int result = mny.checkApproval(ar);
            if (result >=0){
                int est = getEstimate(trip.getType(), trip.getNumPeople(), trip.getComfortLevel());
                  if (trip.getPlanner().getBudget() >= getEstimate(trip.getType(), trip.getNumPeople(), trip.getComfortLevel())){
                    approvedTrips.add(trip);
                    trip.setBus(this);
                    retval = result;
                }
            }
            return retval;
             
            
            
        }


        
    public void promoteTrips(PrintStream outStream)
    {
        outStream.println("TRIPS ON "+getName());
        outStream.println("===================");
        for(Trip t:approvedTrips)
           outStream.println(t);
        outStream.println("--------------------");
           
    }
    
    public ArrayList<Trip> getApprovedTrips()
    {
        
        return approvedTrips;
    }
    
    /**
     * Updates local data of the Bus based on user input.
     * 
     * @param scan A Scanner object used for user input.
     */
    public void updateLocalData(Scanner scan)       //Allows existing bus to be updated in Bus Management menu
    {
        scan.nextLine();
        String currname = getName();
        int currsize = getSize();
        int currprice = getPrice();
        int currlev = getLevel();
        System.out.println("Hit enter to keep name as ["+currname+"], or enter new name:");
        String name = scan.nextLine();
        if (name.equals(""))
            name = currname;
        System.out.println("Hit enter to keep size at ["+currsize +"], or enter new budget:");
        String sizetry=scan.nextLine();
        int size;
        if (sizetry.equals(""))
            size = currsize;
        else
            size = Integer.parseInt(sizetry);
        System.out.println("Hit enter to keep price as ["+currprice+"], or enter new price:");
        String pricetry = scan.nextLine();
        int price;
        if (pricetry.equals(""))
            price = currprice;
        else
            price = Integer.parseInt(pricetry);
        System.out.println("Hit enter to keep level as ["+currlev+"], or enter new level:");
        String levtry = scan.nextLine();
        int lev;
        if (levtry.equals(""))
            lev = currlev;
        else
            lev = Integer.parseInt(levtry);

        setName(name);
        setSize(size);
        setPrice(price);
        setLevel(lev);

    }

    public String toString()
    {
        return "ID:"+this.getId()+";"+this.name +";#Price:"+this.getPrice()+";Area:"+this.getSize();
        
    }
    
    public String toFile()
    {
        return ""+this.getId()+";"+this.name +";"+this.getPrice()+";"+this.getSize();
        
    }
      
    
    
    public static void resetId()
    {
        
        nextId=0;
    }
    
   

    
    
        
}