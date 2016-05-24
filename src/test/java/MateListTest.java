import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MateListTest {

    @Test
    public void existTest(){
        Mate mate = new Mate("Henry");
        MateList mateList = new MateList();
        mateList.addToList(mate);
        System.out.println(mateList.mateExist("Henry"));
    }

}