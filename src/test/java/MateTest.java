import org.junit.Test;

import static org.junit.Assert.*;

public class MateTest {
    @Test
    public void totalExpenses(){
        Mate mate = new Mate("Vados");
        mate.addExpense("x3",12);
        mate.addExpense("x3",83);
        mate.addExpense("x3",46);
        Integer total = 12+83+46;
        System.out.println(mate.totalExpense());
        assertEquals(total,mate.totalExpense());

    }

}