package oppgave2;

import org.junit.Test;

import static org.junit.Assert.*;
public class TreeNodeTest {


    @Test
    public void insert_InsertOneObjectGetCorrectSieze_1(){
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        assertEquals(1, tree.size);
    }

    @Test
    public void insert_Insert5Objects_5(){
        BST<Integer> tree = new BST<>(new Integer[]{5,2,6,1,4});
        assertEquals(5, tree.size);
    }

}