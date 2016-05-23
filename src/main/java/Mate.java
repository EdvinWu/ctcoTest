import java.util.HashMap;
import java.util.Map;

public class Mate {
    private String name;
    private Map<String, Integer> listOfExpenses = new HashMap<>();

    public Map<String, Integer> getListOfExpenses() {
        return listOfExpenses;
    }

    public void setListOfExpenses(Map<String, Integer> listOfExpenses) {
        this.listOfExpenses = listOfExpenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mate(String name) {
        this.name = name;
    }

    public void addExpense(String service, int price) {
        if (listOfExpenses.containsKey(service)) {
            int existPrice = listOfExpenses.get(service);
            listOfExpenses.put(service, price + existPrice);
        } else {
            listOfExpenses.put(service, price);
        }
    }

    public void expensesList() {
        listOfExpenses.forEach((k, v) -> System.out.println("name: " + k + ": " + v + "$"));
    }

    public Integer totalExpense() {
        return listOfExpenses
                .values()
                .stream()
                .reduce(0, (x, y) -> x + y);
    }

    @Override
    public String toString() {
        return name;

    }
}
