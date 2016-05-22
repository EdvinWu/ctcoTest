import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void avgMatesExpenses() {
        Calculator calc = new Calculator();
        Mate mate = new Mate("Vados");
        mate.addToExpenses("x3", 12);
        mate.addToExpenses("x2", 83);
        mate.addToExpenses("x1", 46);
        Mate mate2 = new Mate("Vados2");
        mate2.addToExpenses("x3", 22);
        mate2.addToExpenses("x2", 3);
        mate2.addToExpenses("x1", 146);
        Mate mate3 = new Mate("Vados3");
        mate3.addToExpenses("x3", 3);
        mate3.addToExpenses("x2", 123);
        mate3.addToExpenses("x1", 44);
        Mate mate4 = new Mate("Vados4");
        mate4.addToExpenses("x3", 3);
        mate4.addToExpenses("x2", 168);
        mate4.addToExpenses("x1", 14);
        Mate mate5 = new Mate("Vados5");
        mate5.addToExpenses("x3", 32);
        mate5.addToExpenses("x2", 27);
        mate5.addToExpenses("x1", 66);
        calc.getListOfMates().add(mate);
        calc.getListOfMates().add(mate2);
        calc.getListOfMates().add(mate3);
        calc.getListOfMates().add(mate4);
        calc.getListOfMates().add(mate5);
        Integer total = (12+83+46+22+3+146+3+123+44+3+168+14+32+27+66)/5;
        /*calc.allMatesExpenses();
        System.out.println(calc.avgExpense());
        assertEquals(total,calc.avgExpense());*/
        System.out.println(calc.matesExpenses());
        System.out.println(calc.avgExpense());
    }
}