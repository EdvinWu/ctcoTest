import java.util.ArrayList;

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
        for (Mate mate : mateList) {
            if (mate.getName().equals(name)) {
                return mate;
            }
        }
        return null;
    }

}

