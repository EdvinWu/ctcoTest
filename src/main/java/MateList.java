import java.util.ArrayList;
import java.util.Collections;

public class MateList {

    private ArrayList<Mate> mateList = new ArrayList<>();

    public ArrayList<Mate> getMateList() {
        return mateList;
    }

    public void setMateList(ArrayList<Mate> mateList) {
        this.mateList = mateList;
    }

    public void addToList(Mate mate) {
        mateList.add(mate);
    }


    public Mate getByName(String name) {
        return mateList
                .stream()
                .filter(mate -> mate.getName().equals(name))
                .findFirst()
                .get();

    }

    public boolean mateExist(String name) {
        return mateList
                .stream()
                .anyMatch(mate -> mate.getName().equals(name));

    }

    public void sortByExpenses() {
        mateList.sort((o1, o2) -> o1.getTotalExpense().compareTo(o2.getTotalExpense()));
    }

}

