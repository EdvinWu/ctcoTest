import org.junit.Test;

import static javax.swing.text.html.HTML.Tag.I;
import static org.junit.Assert.*;

public class MateTest {
    @Test
    public void totalExpenses(){
        Mate mate = new Mate("Vados");
        mate.addToExpenses("x3",12);
        mate.addToExpenses("x3",83);
        mate.addToExpenses("x3",46);
        Integer total = 12+83+46;
        System.out.println(mate.totalExpense());
        assertEquals(total,mate.totalExpense());

    }

}