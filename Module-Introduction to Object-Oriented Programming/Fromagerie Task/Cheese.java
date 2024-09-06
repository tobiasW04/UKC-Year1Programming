
/**
 * Store details of a type of cheese, its price per Kilo
 * and whether it is in stock.
 * @author Tobias Wenner
 * @version 1.0
 */
public class Cheese {

    private String name;
    private int pricePerKilo;
    private  boolean inStock;

    /**
     * Create a Cheese object.
     * @param name The name of the cheese.
     * @param price The price per Kilo.
     */
    public Cheese(String name, int price){
        this.name = name;
        pricePerKilo = price;
        inStock = true;
    }

    /**
     * Returns the name of the Cheese
     * @return the name of the Cheese
     */
    public String getName() {
        return name;
    }

    /**
     * Return the Price per Kilo of the Cheese
     * @return the Price per Kilo
     */
    public int getPricePerKilo() {
        return pricePerKilo;
    }

    /**
     * Returns whether the cheese is currently in stock.
     * @return True if the cheese is in stock, false otherwise.
     */
    public boolean getInStock() {
        return inStock;
    }

    /**
     * Sets the price per kilo of the cheese.
     * Assumes that parameter is Positive
     * @param pricePerKilo The new price per kilo.
     */
    public void setPricePerKilo(int pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    /**
     * Sets the availability status of the cheese.
     * @param inStock True if the cheese is in stock, false otherwise.
     */
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    /**
     * Returns a string representation of the cheese details.
     * @return A string containing the name and price per kilo of the cheese.
     */
    public String getDetails(){
        return name + " costs " + pricePerKilo + " pence per Kilo";
    }

}
