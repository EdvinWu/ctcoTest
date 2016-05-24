import java.util.Collections;

public class UI {

    private Application app = new Application();

    private void printSum(MateList mateList, Calculator calc) {
        System.out.println("Total: " + calc.totalExpense(mateList) + "$");
    }

    private void printAvg(MateList mateList, Calculator calc) {
        System.out.println("Average: " + calc.avgExpense(mateList) + "$ to be paid by mate.");
    }

  /*  private void printMateData(Mate mate) {
        System.out.println(mate.getName() + ": " + mate.getTotalExpense() + "$");
    }

    private void printMateExpenses(Mate mate) {
        mate.expensesList();
    }*/

    private void printAllMateExpenses(MateList mateList){
        mateList.getMateList().sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        mateList.getMateList()
                .stream()
                .forEach(Mate::expensesList);
    }

    /*private void printListOfExpenses(MateList mateList) {
        mateList.getMateList().forEach(this::printMateData);
    }*/

    private void printMates(MateList mateList) {
        mateList.getMateList().sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        mateList.getMateList().forEach(System.out::println);
    }

    public void printData(MateList mateList,Calculator calc){
        printMates(mateList);
        System.out.println("------------------------");
        printAllMateExpenses(mateList);
        System.out.println("------------------------");
        printSum(mateList,calc);
        System.out.println("------------------------");
        printAvg(mateList,calc);
    }

    public void printDescription() {
        System.out.println("Could be unlimited amount of mates and expenses");
        System.out.println("Expenses with the same name will be shown as 1 expense(value is summed)");
        System.out.println("1 - Manually enter mates and expenses");
        System.out.println("2 - 5 mates each with 3 random expenses");
        System.out.println("3 - Exit");
    }

    public void printManualDescription(){
        System.out.println("1 - Create mate");
        System.out.println("2 - Add expense");
        System.out.println("3 - Calculate");
    }



    public void menu() {
        printDescription();
        String entry;
        boolean noneOptionChosen = true;
        do {

            entry = app.enterString();

            switch (entry) {
                case "1":
                    noneOptionChosen = false;
                    manual();
                    break;

                case "2":
                    noneOptionChosen = false;
                    app.generate();
                    printData(app.getMateList(),app.getCalc());
                    app.calculate();
                    break;

                case "3":
                    System.out.println("Bye");
                    noneOptionChosen = false;
                    break;

                default:
                    System.out.println("Wrong entry");
                    menu();

            }
        }
        while (noneOptionChosen);
    }


    public void manual(){
        printManualDescription();
        String entry;
        boolean noneOptionChosen = true;
        do {

            entry = app.enterString();

            switch (entry) {
                case "1":
                    app.createMate();
                    printManualDescription();
                    break;

                case "2":
                    app.addExpenseByName();
                    printManualDescription();
                    break;

                case "3":
                    app.calculate();
                    printData(app.getMateList(),app.getCalc());
                    noneOptionChosen = false;
                    break;
                default:
                    System.out.println("Wrong entry");
                    menu();

            }
        }
        while (noneOptionChosen);
    }

}
