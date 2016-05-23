import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private MateList listOfMates = new MateList();
    private Calculator calc = new Calculator();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Integer enterInteger() {
        Integer mateNo = 0;
        do {
            try {
                mateNo = Integer.parseInt(reader.readLine());
            } catch (IOException | java.lang.NumberFormatException e) {
                System.out.println("Something went wrong, check your entry");
                mateNo = enterInteger();
            }
        } while (mateNo < 1);
        return mateNo;
    }


    public void creatingMates() {
        Integer matesAmount = enterInteger();
        for (int i = 0; i < matesAmount; i++) {
            System.out.println("Enter mates name ");
            listOfMates.addToList(new Mate(enterString()));
        }
    }

    public String enterString() {
        try {
            return reader.readLine();
        } catch (IOException | java.lang.NumberFormatException e) {
            return enterString();
        }
    }


    public void addExpenseByName() {
        System.out.println("Enter mate's name, who you want to add expenses");
        String name = enterString();
        Mate mate;
        try {
            mate = listOfMates.getByName(name);
        } catch (NullPointerException e) {
            System.out.println("something went wrong, check if such name exist");
            addExpenseByName();
        }
    }

    public void run() {
        creatingMates();
        addExpenseByName();
        //listOfMates.showList();
        System.out.println(calc.avgExpense(listOfMates) + "$");

    }
}
