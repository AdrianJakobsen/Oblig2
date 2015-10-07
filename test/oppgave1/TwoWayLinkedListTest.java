package oppgave1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TwoWayLinkedListTest {


    private TwoWayLinkedList twoWayLinkedList;
    private String[] list = {"party", "house", "kirby", "apple", "java", "tabasco", "bastion"};

    @Before
    public void setUp(){
         twoWayLinkedList = new TwoWayLinkedList(list);
    }

    @Test
    public void constructor_Add_CheckIfSizeIsCorrect_Seven(){
        assertEquals(7, twoWayLinkedList.size());
    }

    @Test
    public void get_getTheThirdObjectInList_kirby(){
        assertEquals("kirby", twoWayLinkedList.get(3));
    }

    @Test
    public void get_getTheFifthObjectInList_java(){
        assertEquals("java", twoWayLinkedList.get(5));
    }

    @Test
    public void getLast_getLastObjectInList_bastion(){
        assertEquals("bastion", twoWayLinkedList.getLast());
    }

    @Test
    public void addFirst_checkIfSizeIsCorrect_Eight(){
        twoWayLinkedList.addFirst("pen");
        assertEquals(8, twoWayLinkedList.size());
    }

    @Test
    public void addFirst_getFirstObjectInList_shark(){
        twoWayLinkedList.addFirst("shark");
        assertEquals("shark", twoWayLinkedList.getFirst());
    }

    @Test
    public void addFirst_addedObjectPointsToThePreviousFirst_party(){
        twoWayLinkedList.addFirst("pen");
        assertEquals("pen", twoWayLinkedList.listIterator().next());
    }
}