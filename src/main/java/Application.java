import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Application {

    private MateList mateList = new MateList();
    private Calculator calc = new Calculator();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Calculator getCalc() {
        return calc;
    }

    public MateList getMateList() {
        return mateList;
    }

    public void setMateList(MateList mateList) {
        this.mateList = mateList;
    }

    public Integer enterInteger() {
        Integer mateNo = 0;
        System.out.println();
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


    public void createMate() {
        System.out.println("Enter mate's name ");
        mateList.addToList(new Mate(enterString()));
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
        if (mateList.mateExist(name)) {
            System.out.println("Enter expense name and price");
            mateList.getByName(name).addExpense(enterString(), enterInteger());
        } else {
            System.out.println("such mate does not exist");
        }
    }


    public void generate() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            mateList.addToList(new Mate("Generated Mate" + (i + 1)));
            for (int j = 1; j < 4; j++) {
                mateList.getByName("Generated Mate" + (i + 1)).addExpense("Generated Expense" + (j), random.nextInt(100) + 1);
            }
        }
    }

    public void calculate() {
    calc.calculate(mateList);
    }
}
