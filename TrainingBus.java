
import java.util.Scanner;

/**
 * Training Bus, a specialized type of bus with a teacher's area.
 */
public class TrainingBus extends Bus {
    private int teacherArea;
    


    /**
     * Constructs a new Training Bus object.
     * 
     * @param b           The generic Bus object.
     * @param teacherArea The size of the teacher's area.
     */
    public TrainingBus(Bus b, int teacherArea)
    {
        super(b.getName(), b.getSize(), b.getPrice(), b.getLevel(), b.getMinistry());
        this.teacherArea =     teacherArea;
     
    }

    public int getEstimate(String type)
    {
        int price = super.getPrice();
     
        //System.out.println(this.getName()+":estimate  to hold a "+type +" is "+ price);
        return price;

    }


    public int getTeacherArea()
    {
        return teacherArea;
    }




    public void setTeacherArea(int instructorArea)
    {

        this.teacherArea =teacherArea;
    }

    /**
     * Updates local data of the Training Bus based on user input
     * 
     * @param scan A Scanner object used for user input.
     */
    @Override
    public void updateLocalData(Scanner scan)       //Allows existing training bus to be updated in Bus Management menu
    {
        scan.nextLine();
        String currname = getName();
        int currsize = getSize();
        int currprice = getPrice();
        int currlev = getLevel();
        int currtarea = getTeacherArea();
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
        System.out.println("Hit enter to keep teacher area as ["+currtarea+"], or enter new teacher area:");
        String tareatry = scan.nextLine();
        int teacherArea;
        if (tareatry.equals(""))
            teacherArea = currtarea;
        else
            teacherArea = Integer.parseInt(tareatry);

        setName(name);
        setSize(size);
        setPrice(price);
        setLevel(lev);
        setTeacherArea(teacherArea);

    }

    public String toString()
    {
        return "ID:"+this.getId()+";"+this.getName() +";#Price:"+this.getPrice()+";Teacher Area:"+teacherArea+"";

    }

    public String toFile()
    {
        return ""+this.getId()+";"+this.getName() +";"+this.getPrice()+";"+teacherArea;

    }
    


}

