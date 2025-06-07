
import java.util.Scanner;

/**
 * Sports Bus, a specialized bus with a Competitor Area and Security personnel.
 */
public class SportsBus extends  Bus {
    private int competitorArea;
    private int numSecurity;
    private Bus bus;

    /**
     * Constructs a new Sports Bus object.
     * 
     * @param b                 The generic bus object.
     * @param competitorArea    The size of the Competitor Area.
     * @param numSecurity       The number of Security personnel.
     */
    public SportsBus(Bus b, int competitorArea, int numSecurity)
    {
        super(b.getName(), b.getSize(), b.getPrice(), b.getLevel(), b.getMinistry()); 
        bus = b;
        this.competitorArea =     competitorArea;
        this.numSecurity=numSecurity;

    }

    public int getCompetitorArea()
    {
        return competitorArea;
    }

    public int getNumSecurity()
    {
        return numSecurity;
    }

    public Bus getBus(){
        return bus;
    }

    public void setCompetitorArea(int competitorArea)
    {

        this.competitorArea =competitorArea;
    }

    public void setNumSecurity(int numSecurity)
    {

        this.numSecurity =numSecurity;
    }

    /**
     * Updates local data of the Sports Bus based on user input.
     * 
     * @param scan A Scanner object used for user input.
     */
    @Override
    public void updateLocalData(Scanner scan)       //Allows existing sports bus to be updated in Bus Management menu
    {
        scan.nextLine();
        String currname = getName();
        int currsize = getSize();
        int currprice = getPrice();
        int currlev = getLevel();
        int currcomparea = getCompetitorArea();
        int currnumsec = getNumSecurity();
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

        setName(name);
        setSize(size);
        setPrice(price);
        setLevel(lev);
        setCompetitorArea(competitorArea);
        setNumSecurity(numSecurity);

    }

    public String toString()
    {
        return "ID:"+this.getId()+";"+this.getName() +";#Price:"+this.getPrice()+";Compet Area:"+competitorArea+";#Sec:"+numSecurity;

    }

    public String toFile()
    {
        return ""+this.getId()+";"+this.getName() +";"+this.getPrice()+";"+competitorArea+";"+numSecurity;

    }

               

}