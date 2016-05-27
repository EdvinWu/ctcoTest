import java.util.HashMap;
import java.util.Map;

public class Mate {
    private String name;
    private Integer totalExpense = 0;
    private Integer diff = 0;
    private Map<String, Integer> listOfExpenses = new HashMap<>();

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }


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

    public Integer getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Integer totalExpense) {
        this.totalExpense = totalExpense;
    }

    private void addToExpense(Integer amount) {
        totalExpense += amount;
    }

    public void addExpense(String service, Integer price) {
        if (listOfExpenses.containsKey(service)) {
            Integer existPrice = listOfExpenses.get(service);
            listOfExpenses.put(service, price + existPrice);
            addToExpense(price);
        } else {
            addToExpense(price);
            listOfExpenses.put(service, price);
        }
    }

    public void expensesList() {
        System.out.println(name);
        listOfExpenses.forEach((k, v) -> System.out.println("           name: " + k + ": " + v + "$"));
    }

    /*public Integer totalExpense() {
        return listOfExpenses
                .values()
                .stream()
                .reduce(0, (x, y) -> x + y);
    }*/


    @Override
    public String toString() {
        return name;

    }
}
