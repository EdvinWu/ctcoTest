import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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


    public void mateDiff(MateList mateList) {
        mateList.getMateList()
                .stream()
                .forEach(mate -> mate.setDiff(mate.getTotalExpense() - avgExpense(mateList)));

    }

    private void diffCalc(MateList mateList, int currentMate) {
        int nextMateIndex = 0;
        int listSize = mateList.getMateList().size();
        while ((nextMateIndex != listSize) || (mateList.getMateList().get(currentMate).getDiff() != 0 )) {
            if (mateList.getMateList().get(nextMateIndex).getDiff() < 0) {
                if (mateList.getMateList().get(currentMate).getDiff() > Math.abs(mateList.getMateList().get(nextMateIndex).getDiff())) {
                    moneyTransfer(mateList, currentMate, nextMateIndex, true);
                } else {
                    moneyTransfer(mateList, currentMate, nextMateIndex, false);
                }
            }
            nextMateIndex++;
        }
    }
//mateList.getMateList().get(currentMate).getDiff() != 0 ||

    public void calculate(MateList mateList) {
        mateDiff(mateList);
        for (int i = 0; i < mateList.getMateList().size(); i++) {
            if (mateList.getMateList().get(i).getDiff() > 0) {
                diffCalc(mateList, i);
            }
        }
    }

    private void moneyTransfer(MateList mateList, int currentMate, int nextMate, boolean isCurrentBigger) {
        int whichMatesDiff = 0;
        if (isCurrentBigger) {
            whichMatesDiff = nextMate;
        } else {
            whichMatesDiff = currentMate;
        }
        int diff = Math.abs(mateList.getMateList().get(whichMatesDiff).getDiff());
        mateList.getMateList().get(currentMate).setTotalExpense(mateList.getMateList().get(currentMate).getTotalExpense() - mateList.getMateList().get(whichMatesDiff).getDiff());
        mateList.getMateList().get(currentMate).setDiff(mateList.getMateList().get(currentMate).getDiff() - mateList.getMateList().get(whichMatesDiff).getDiff());
        mateList.getMateList().get(nextMate).setTotalExpense(mateList.getMateList().get(nextMate).getTotalExpense() - mateList.getMateList().get(whichMatesDiff).getDiff());
        mateList.getMateList().get(nextMate).setDiff(mateList.getMateList().get(nextMate).getDiff() - mateList.getMateList().get(whichMatesDiff).getDiff());
        System.out.println(mateList.getMateList().get(currentMate).getName() + "->" + mateList.getMateList().get(nextMate).getName() + ":" + diff + "$");

    }
}
    /*
берет дифф первого чувака и смотрит ему не хватает или у него перебор

[7:25]
если у него перебор, то она снимает перебор и ищет у кого недобор и бросает ему

[7:25]
когда у первого норм

[7:25]
берет второго vse.
    *
    *
    * */


