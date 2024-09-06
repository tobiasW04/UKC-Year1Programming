
/**
 * NightClub is modeling a software system for a company that manages nightclubs,
 * including management over occupancy, capacity and name.
 * The occupancy and name of a nightclub are specified via the constructor.
 * The system assumes that the number of people leaving the nightlcub is
 * always greater than zero.
 *
 * @author Tobias Wenner
 * @version 2023.22.10
 */
public class NightClub
{
    // The name of the nightclub
    private String name;
    // The occupancy of a nightclub
    private int occupancy;
    // The capacity of a Nightclub.
    private int capacity;
    
    /**
     * Create a nightclub that has a given capacity and name.
     * Note that the capacity must always be greater than zero, and 
     * there are no checks to ensure this.
     */
    public NightClub(String ncName, int maxCapacity)
    {
        name = ncName;
        occupancy = 0;
        capacity = maxCapacity;
    }
    
    /**
     * Returns the nightclubs Name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the nightclubs capacity.
     */
    public int getCapacity()
    {
        return capacity;
    }
    
    /**
     * Returns the nightclubs current amount of clubbers.
     */
    public int getOccupancy()
    {
        return occupancy;
    }

    /**
     * Add one new clubber to the nightlcub if there is space.
     * If the clubs is full, print a error message.
     */
    public void addOne()
    {
        if (occupancy < capacity){
            occupancy ++;
        }
        else{
            System.out.println("The club is full.");
        }
    }
    
    /**
     * Recieves an amount of people leaving the club.
     * Checks if the amount leaving is lower or equal to the current amount of clubbers.
     * Prints a error message and sets occupancy to 0 if this is not the case.
     */
    public void leaving(int leavingClub)
    {
        if (occupancy >= leavingClub){
            occupancy = occupancy - leavingClub;
        }
        else{
            System.out.println("There is an error in the number of clubbers.");
            occupancy = 0;
        }
    }
    
    /**
     * Checks if there is enough space for a given group of people.
     * Returns if there is enough space or not (True/False).
     * Given amount of people must be higher than 0.
     */
    public boolean isSpace(int groupSize)
    {
        if (groupSize <= 0){
            return false;
        }    
        else{
            if (groupSize <= capacity - occupancy){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
    /**
     * Print information about the NightClub object.
     * This includes name, occupany and capacity.
     */
    public void printDetails()
    {
        System.out.println(name + ": " + occupancy + " clubbers. Capacity " + capacity + ".");
    }
    
    /**
     * Print the user who wrote the Class. 
     */
    public void about()
    {
        System.out.println("NightClub written by TW463");
    }
}

