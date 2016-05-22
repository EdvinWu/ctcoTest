import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Calculator {

    private ArrayList<Mate> listOfMates = new ArrayList<>();

    public ArrayList<Mate> getListOfMates() {
        return listOfMates;
    }

    public void setListOfMates(ArrayList<Mate> listOfMates) {
        this.listOfMates = listOfMates;
    }

    public void allMatesExpenses() {
        listOfMates.forEach(Mate::expensesList);
    }

    public Integer avgExpense() {
        Integer total = 0;
        for (Mate mate : listOfMates) {
            total += mate.totalExpense();
        }
        return total / listOfMates.size();
    }

    public List<Integer> matesExpenses() {
        ArrayList<Integer> expensesByMate = new ArrayList<>();
        ArrayList<Integer> owe = new ArrayList<>();
        for (Mate mate : listOfMates) {
            expensesByMate.add(mate.totalExpense());
        }
        Collections.sort(expensesByMate);
        for (Mate mate : listOfMates) {
            expensesByMate.add(mate.totalExpense());
        }
        return expensesByMate;
    }

}
