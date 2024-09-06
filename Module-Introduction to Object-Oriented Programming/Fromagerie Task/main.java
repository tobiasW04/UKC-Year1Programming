import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        //Create Cheese objects
        Cheese cheese1 = new Cheese("Cheddar", 1000);
        Cheese cheese2 = new Cheese("Feta", 2000);
        Cheese cheese3 = new Cheese("Camembert", 3000);
        Cheese cheese4 = new Cheese("Parmesan" , 500);

        //Testing Cheese Methods
        System.out.println("Test getName, getPricePerKilo and getInStock for cheese1");
        System.out.println(cheese1.getName()); //Should print Cheddar
        System.out.println(cheese1.getPricePerKilo()); //Should print 1000
        System.out.println(cheese1.getInStock()); //Should print ture
        System.out.println("");

        System.out.println("Test setPricePerKilo and setInStock for cheese1");
        cheese1.setPricePerKilo(1500);
        System.out.println(cheese1.getPricePerKilo()); //Should print 1500
        cheese1.setInStock(false);
        System.out.println(cheese1.getInStock()); //Should print false
        System.out.println("");

        System.out.println("Test getDetails for cheese1");
        System.out.println(cheese1.getDetails()); //Should print Cheddar costs 1500 pence per Kilo
        System.out.println("");


        //Create Fromagerie
        Fromagerie fromagerie = new Fromagerie();

        //Testing Fromagerie Methods
        System.out.println("Test addCheese and getNumberOfCheeses()");
        fromagerie.addCheese(cheese1);
        fromagerie.addCheese(cheese2);
        fromagerie.addCheese(cheese3);
        fromagerie.addCheese(cheese4);
        System.out.println(fromagerie.getNumberOfCheeses()); //Should print 4
        System.out.println("");

        System.out.println("Test getNumberOfCheeses(price)");
        System.out.println(fromagerie.getNumberOfCheeses(2500)); //Should print 3
        System.out.println("");

        System.out.println("Test list");
        fromagerie.list(); //Should print all Cheese objects in the fromagerie
        System.out.println("");

        System.out.println("Test setDetails");
        fromagerie.setDetails("Cheddar" , 1000 , true); //Reverts Cheddar back creation state
        System.out.println(cheese1.getName()); //Should print Cheddar
        System.out.println(cheese1.getPricePerKilo()); //Should print 1000
        System.out.println(cheese1.getInStock()); //Should print true
        System.out.println("");

        System.out.println("Test removeCheese for current list");
        fromagerie.removeCheese("Cheddar");
        fromagerie.list(); //Should print a list without Cheddar
        System.out.println("");

        System.out.println("Test removeCheese when there are multiple objects with the same name");
        fromagerie.addCheese(cheese1);
        Cheese cheese5 = new Cheese("Gouda" , 999); // Add a cheese so that index of Cheddas is not in succession
        Cheese cheese6 = new Cheese("Cheddar" , 888);
        fromagerie.addCheese(cheese5);
        fromagerie.addCheese(cheese6);
        fromagerie.list(); //List with all 6 Cheeses
        System.out.println("");
        fromagerie.removeCheese("Cheddar");
        fromagerie.list();
        fromagerie.addCheese(cheese1);
        System.out.println("");

        System.out.println("Test findClosestCheese");
        System.out.println("Scenario 1: Cheese with same value as @param available");
        Cheese closestCheese = fromagerie.findClosestAvailable(999);
        System.out.println(closestCheese.getName());
        System.out.println("");

        System.out.println("Scenario 2: Return the Cheese with the smallest price difference to @param");
        cheese2.setPricePerKilo(4000);
        cheese3.setPricePerKilo(1000);
        closestCheese = fromagerie.findClosestAvailable(3000);
        System.out.println(closestCheese.getName()); // Should return cheese2 (Feta) since its closest
        System.out.println("");

        System.out.println("Scenario 3: Two cheeses have the same distance to @param, return cheapest");
        cheese1.setPricePerKilo(8000);
        cheese2.setPricePerKilo(10000);
        closestCheese = fromagerie.findClosestAvailable(8000);
        System.out.println(closestCheese.getName()); // Should print cheese1(Cheddar), since its cheaper than cheese2
        System.out.println("");

        System.out.println("Scenario 4: Cheese prices = @param, return lowest index");
        cheese3.setPricePerKilo(1234);
        cheese5.setPricePerKilo(1234);
        cheese6.setPricePerKilo(1234);
        closestCheese = fromagerie.findClosestAvailable(1234);
        System.out.println(closestCheese.getName()); //Should print cheese3(Camembert), since it has the lowest index
        System.out.println("");

        System.out.println("Scenario 5: No cheese available, return null");
        cheese1.setInStock(false);
        cheese2.setInStock(false);
        cheese3.setInStock(false);
        cheese4.setInStock(false);
        cheese5.setInStock(false);
        cheese6.setInStock(false);
        System.out.println(fromagerie.findClosestAvailable(1000)); //Should print null since no cheese available

    }

}
