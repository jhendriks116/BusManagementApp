 

import java.util.Scanner;
/**
 * Party Bus, a specialized Sports Bus with a Bar Area.
 */
public class PartyBus extends SportsBus{
     int barArea;
    

    /**
     * Constructs a new Party Bus object.
     * 
     * @param s         The Sports Bus object.
     * @param barArea   The size of the Bar Area.
     */
    public PartyBus(SportsBus s, int barArea)
    {
        super( s.getBus(), s.getCompetitorArea(), s.getNumSecurity());
        this.barArea = barArea;      
        
        
    }
    
  
    public int getBarArea()
    {
        return barArea;
    }


    public void setBarArea(int barArea)
    {
        
        this.barArea =barArea;
    }    
    
    /**
     * Updates local data of the Party Bus based on user input.
     * 
     * @param scan A Scanner object used for user input.
     */
    @Override
    public void updateLocalData(Scanner scan)       //Allows existing party bus to be updated in Bus Management menu
    {
        scan.nextLine();
        String currname = getName();
        int currsize = getSize();
        int currprice = getPrice();
        int currlev = getLevel();
        int currcomparea = getCompetitorArea();
        int currnumsec = getNumSecurity();
        int currbararea = getBarArea();
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
        System.out.println("Hit enter to keep competitor area as ["+currcomparea+"], or enter new competitor area:");
        String compareatry = scan.nextLine();
        int competitorArea;
        if (compareatry.equals(""))
            competitorArea = currcomparea;
        else
            competitorArea = Integer.parseInt(compareatry);
        System.out.println("Hit enter to keep number of security as ["+currnumsec+"], or enter new number of security:");
        String numsectry = scan.nextLine();
        int numSecurity;
        if (numsectry.equals(""))
            numSecurity = currnumsec;
        else
            numSecurity = Integer.parseInt(numsectry);
        System.out.println("Hit enter to keep bar area as ["+currbararea+"], or enter new bar area:");
        String barareatry = scan.nextLine();
        int barArea;
        if (barareatry.equals(""))
            barArea = currbararea;
        else
            barArea = Integer.parseInt(barareatry);

        setName(name);
        setSize(size);
        setPrice(price);
        setLevel(lev);
        setCompetitorArea(competitorArea);
        setNumSecurity(numSecurity);
        setBarArea(barArea);

    }
    
       public String toString()
       {
           return "ID:"+this.getId()+";"+this.getName() +";#Price:"+this.getPrice()+";Bar Area:"+barArea+";#Sec:"+getNumSecurity();
           
       }
       public String toFile()
       {
               return ""+this.getId()+";"+this.getName() +";"+this.getPrice() + ";"+barArea+";"+getNumSecurity();
               
           }   
           
 
}
