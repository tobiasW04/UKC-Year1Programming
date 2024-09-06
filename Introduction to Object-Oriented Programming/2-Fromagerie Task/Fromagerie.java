import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * This Class is a simple model of a    Fromagerie (a cheese shop).
 * It provides basic functionality such as addition, removal, and manipulation of cheese details,
 * as well as finding the closest available cheese based on a specified price.
 * @author Tobias Wenner
 * @version 1.0.
 */
public class Fromagerie
{
    private ArrayList<Cheese> cheeses;

    /**
     * Create a Fromagerie.
     */
    public Fromagerie()
    {
        cheeses = new ArrayList<>();
    }

    /**
     * Add the given cheese to the shop.
     * @param aCheese The cheese to add.
     */
    public void addCheese(Cheese aCheese)
    {
            cheeses.add(aCheese);
    }

    /**
     * Return the number of cheeses.
     * @return The number of cheeses.
     */
    public int getNumberOfCheeses()
    {
        return cheeses.size();
    }
    /**
     * Return the number of cheeses within the given price range.
     * @param price The upper limit of the price range.
     * @return The number of cheeses within the price range.
     */
    public int getNumberOfCheeses(int price)
    {
        int amount = 0;
        for(Cheese cheese : cheeses){
            if(cheese.getPricePerKilo() <= price){
                amount++;
            }
        }
        return amount;

    }

    /**
     * Print details of all the cheeses.
     */
    public void list() {
        for(Cheese allCheeses : cheeses){
            System.out.println(allCheeses.getDetails());
        }
    }

    /**
     * Set the details of the given cheese.
     * @param name The name of the cheese.
     * @param price The price of the cheese.
     * @param available Whether it is in stock or not.
     */
    public void setDetails(String name, int price, boolean available)
    {
        for(Cheese nameCheese : cheeses){
            if(Objects.equals(name, nameCheese.getName())){
                nameCheese.setPricePerKilo(price);
                nameCheese.setInStock(available);

            }
        }
    }

    /**
     * Remove the given cheese if it is in
     * the fromagerie.
     * @param name The name of the cheese.
     * @return true if the cheese was removed, false otherwise.
     */
    public boolean removeCheese(String name)
    {
        boolean removed = false;
        Iterator<Cheese> cheeseIterator = cheeses.iterator();
        while (cheeseIterator.hasNext()){
            Cheese aCheese = cheeseIterator.next();
            if(aCheese.getName().equals(name)){
                cheeseIterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Find the cheese closest in price to the
     * given price.
     * @param price The price to find.
     * @return A cheese, if there are any available.
     */
    public Cheese findClosestAvailable(int price)
    {
        Cheese closestCheese = null;
        int minDifference = Integer.MAX_VALUE;
        for (Cheese aCheese : cheeses){
            if (aCheese.getInStock()){
                int priceDifference = Math.abs(price - aCheese.getPricePerKilo());

                if (priceDifference < minDifference ){
                    closestCheese = aCheese;
                    minDifference = priceDifference;
                }
                else if (priceDifference == minDifference && aCheese.getPricePerKilo() < closestCheese.getPricePerKilo()){
                    closestCheese = aCheese;
                }
            }
        }
        return closestCheese;
    }

}
