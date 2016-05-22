import java.util.HashMap;
import java.util.Map;

public class Mate {
    private String name;
    private Map<String, Integer> listOfExpenses = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToExpenses(String service, int price) {
        if (listOfExpenses.containsKey(service)){
            int existPrice = listOfExpenses.get(service);
            listOfExpenses.put(service,price + existPrice);
        }else{
            listOfExpenses.put(service, price);
        }

    }

    public Mate(String name) {
        this.name = name;
    }

    public void expensesList() {
        for (Map.Entry<String, Integer> pair : listOfExpenses.entrySet()) {
            String key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(name + ": " + key + " - " + value + "$");
        }
    }

    public Integer totalExpense(){
        return listOfExpenses
                .values()
                .stream()
                .reduce(0, (x,y) -> x+y);

    }

}
