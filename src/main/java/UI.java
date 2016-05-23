public class UI {


    public void printSum(Integer sum) {
        System.out.println("Total: " + sum + "$");
    }

    public void printAvg(Integer avg){
        System.out.println("Average: " + avg + "$ to be paid by mate.");
    }

    public void printMateData(Mate mate){
        System.out.println(mate.getName() + ": " + mate.totalExpense() + "$");
    }

    public void printMateExpenses(Mate mate){
        mate.getListOfExpenses().forEach( (k,v) -> System.out.println("name: " + k + ": " + v+"$"));
    }

    public void printListOfExpenses(MateList mateList) {
        mateList.getMateList().forEach(this::printMateData);
    }

    public void printMates(MateList mateList){
        mateList.getMateList().forEach(System.out::println);
    }
}
