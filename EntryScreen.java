 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class EntryScreen {

    public EntryScreen() {}

    public ArrayList<Planner> managePlanners(Scanner scan,ArrayList<Planner> plans, Ministry mny, ArrayList<Bus> buses) throws NumberFormatException
    {
        ReportScreen r = new ReportScreen();
        char mchoice = 'c';
        String menu="";
        while (mchoice!='X')
        {
            String menuOptions = "[A]dd/Create planner\n[E]dit/Update planner\n";
            menuOptions+="[L]ist/Read planner\n[D]elete planner\nE[x]it\n";
            System.out.println(menuOptions);
            menu = scan.next().toUpperCase();
            mchoice = menu.charAt(0);
            switch(mchoice)
            {
            case 'A':{
                Planner p = createPlanner(scan, mny, buses);
                if (p!=null)
                    plans.add(p);
                break;
            }
            case 'L':{
                Collections.sort(plans); 
                r.listPlanners(plans, System.out);
                break;
            }
            case 'E':{
                System.out.println("Please enter the ID of the planner to be updated:");
                int pid = Integer.parseInt(scan.next());
                int pdx = findPlanner(plans,pid);
                if (pdx>=0)
                    plans.get(pdx).updateLocalData(scan);
                else
                    System.out.println("Planner with id "+pid+ " not found.");
                break;
            }
            case 'D':{
                System.out.println("Please enter the ID of the planner to be deleted:");
                int pid = Integer.parseInt(scan.next());
                int pdx = findPlanner(plans,pid);

                if (pdx>=0)
                    plans.remove(pdx);
                else
                    System.out.println("Planner with id "+pid+ " not found.");
                break;
            }


            }

        }
        return plans;
    }



    public Planner createPlanner( Scanner scan, Ministry mny, ArrayList<Bus> buses)
    {
        Planner p = null;
        try
        {
        System.out.println("Please enter Planner Name:");
        String name = scan.next();
        System.out.println("Please enter Planner Budget:");
        int budget = Integer.parseInt(scan.next());
        p = new Planner(name, budget, mny, buses);
        }
        catch(NumberFormatException nfe)
        {}
        return p;
    }

    public int findPlanner(ArrayList<Planner> plans, int pid)
    {
        int pdx =-1;
        int currdx=0;
        while ((currdx<plans.size())&&(pdx==-1))
        {
            if (plans.get(currdx).getId()==pid)
                pdx = currdx;
            currdx++;

        }

        return pdx;

    }


    public ArrayList<Bus> manageBuses(Scanner scan, Ministry mny, ArrayList<Bus> buses) throws NumberFormatException        //Adds menu options to update buses
    {
        ReportScreen r = new ReportScreen();
        char mchoice = 'c';
        String menu="";
        while (mchoice!='X')
        {
            String menuOptions = "[A]dd bus\n[E]dit/Update bus\n";
            menuOptions+="[L]ist/Read bus\n[D]elete bus\nE[x]it\n";
            System.out.println(menuOptions);
            menu = scan.next().toUpperCase();
            mchoice = menu.charAt(0);
            switch(mchoice)
            {
            case 'A':{
                Bus b = createBus(scan, mny);
                if (b!=null)
                    buses.add(b);
                break;
            }
            case 'L':{
                Collections.sort(buses); 
                r.listBuses(buses, System.out);
                break;
            }
            case 'E':{
                System.out.println("Please enter the ID of the bus to be updated:");
                int bid = Integer.parseInt(scan.next());
                int bdx = findBus(buses,bid);
                if (bdx>=0)
                    buses.get(bdx).updateLocalData(scan);
                else
                    System.out.println("Bus with id "+bid+ " not found.");
                break;
            }
            case 'D':{
                System.out.println("Please enter the ID of the bus to be deleted:");
                int bid = Integer.parseInt(scan.next());
                int bdx = findBus(buses,bid);

                if (bdx>=0)
                    buses.remove(bdx);
                else
                    System.out.println("Bus with id "+bid+ " not found.");
                break;
            }


            }

        }
        return buses;
    }



    public Bus createBus( Scanner scan, Ministry mny)       //Creates bus through EntryScreen
    {
        Bus b = null;
        try
        {
        System.out.println("Please enter Bus Name:");
        String name = scan.next();
        System.out.println("Please enter Bus Size:");
        int size = Integer.parseInt(scan.next());
        System.out.println("Please enter Bus Price:");
        int price = Integer.parseInt(scan.next());
        System.out.println("Please enter Bus Level:");
        int lev = Integer.parseInt(scan.next());
        b = new Bus(name, size, price, lev, mny);
        }
        catch(NumberFormatException nfe)
        {}
        return b;
    }      

    public int findBus(ArrayList<Bus> buses, int bid)       //Returns index of matching bus ID
    {
        int bdx =-1;
        int currdx=0;
        while ((currdx<buses.size())&&(bdx==-1))
        {
            if (buses.get(currdx).getId()==bid)
                bdx = currdx;
            currdx++;
        }
        return bdx;
    }



}

