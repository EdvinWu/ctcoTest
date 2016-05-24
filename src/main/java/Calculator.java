import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {


    public Integer avgExpense(MateList mateList) {
        return totalExpense(mateList) / mateList.getMateList().size();
    }

    public List<Integer> matesExpenses(MateList mateList) {

        return mateList.getMateList()
                .stream()
                .map(Mate::getTotalExpense)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Integer> diff(MateList mateList) {
        return matesExpenses(mateList)
                .stream()
                .map(i -> i - avgExpense(mateList))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Integer totalExpense(MateList mateList) {
        return mateList.getMateList()
                .stream()
                .mapToInt(Mate::getTotalExpense)
                .sum();
    }


    /*sortirnutj list po name
    * sortirnutj list po totalexpensu
    * poshitatj kto komu skoljko dolzhen
    * sortirnutj po name
    *
    *
    * */


}
