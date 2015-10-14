package oppgave2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {


    @Test
    public void insert_InsertOneObjectGetCorrectSize_1() {
        BST<Integer> tree = new BST<>();
        tree.insert(5);
        assertEquals(1, tree.size);
    }

    @Test
    public void insert_Insert5Objects_5() {
        BST<Integer> tree = new BST<>(new Integer[]{5, 2, 6, 1, 4});
        assertEquals(5, tree.size);
    }

    @Test
    public void getNode_getCorrectNode_19(){
        BST<Integer> tree = new BST<>(new Integer[]{10,5,19});
        assertEquals(19, (int)tree.testingGetNode(19).element);
    }

    @Test
    public void getNode_getCorrectNode_26(){
        BST<Integer> tree = new BST<>(new Integer[]{10,5,19,26});
        assertEquals(26, (int)tree.testingGetNode(26).element);
    }

    @Test
    public void getNode_TryToGetElementThatDoesNotExist_null(){
        BST<Integer> tree = new BST<>(new Integer[]{10,5,19,26});
        assertEquals(null, tree.testingGetNode(100));
    }

    @Test
    public void insert_Insert5ObjectsAndTheyPointToParent_5() {
        BST<Integer> tree = new BST<>(new Integer[]{5, 2, 6, 1, 4});
        assertEquals(5, (int) tree.testingGetNode(6).parent.element);
    }

    @Test
    public void insert_Insert5ObjectsAndTheyPointToParent_5Two() {
        BST<Integer> tree = new BST<>(new Integer[]{5, 2, 6, 1, 4});
        assertEquals(5, (int) tree.testingGetNode(2).parent.element);
    }

    @Test
    public void insert_Insert5ObjectsAndTheyPointToParent_2() {
        BST<Integer> tree = new BST<>(new Integer[]{5, 2, 6, 1, 4});
        assertEquals(2, (int) tree.testingGetNode(4).parent.element);
    }

    @Test
    public void insert_Insert5ObjectsAndTheyPointToParent_2Two() {
        BST<Integer> tree = new BST<>(new Integer[]{5, 2, 6, 1, 4});
        assertEquals(2, (int) tree.testingGetNode(1).parent.element);
    }

}