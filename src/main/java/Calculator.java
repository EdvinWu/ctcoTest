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
        while ((nextMateIndex != mateList.getMateList().size()) && (mateList.getMateList().get(currentMate).getDiff() != 0)) {
            mateDiff(mateList);
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
        if (diff > 0) {
            mateList.getMateList().get(currentMate).setTotalExpense(mateList.getMateList().get(currentMate).getTotalExpense() - diff);
            mateList.getMateList().get(nextMate).setTotalExpense(mateList.getMateList().get(nextMate).getTotalExpense() + diff);
            System.out.println(mateList.getMateList().get(currentMate).getName() + "->" + mateList.getMateList().get(nextMate).getName() + ":" + diff + "$");
        }


    }
}



