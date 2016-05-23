import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {


    public Integer avgExpense(MateList listOfMates) {
        return totalExpense(listOfMates) / listOfMates.getMateList().size();
    }

    public List<Integer> matesExpenses(MateList listOfMates) {

        return listOfMates.getMateList()
                .stream()
                .map(Mate::totalExpense)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> diff(MateList listOfMates) {
        return matesExpenses(listOfMates)
                .stream()
                .map(i -> i - avgExpense(listOfMates))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Integer totalExpense(MateList listOfMates){
        Integer total = 0;
        for (Mate mate : listOfMates.getMateList()) {
            total += mate.totalExpense();
        }
        return total;
    }


}
