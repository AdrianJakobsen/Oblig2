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

    @Test
    public void isLeaf_checkIfRootIsLeaf_true(){
        BST<Integer> tree = new BST<>(new Integer[]{5});
        assertEquals(true, tree.testingIsLeaf(5));
    }

    @Test
    public void is_leaf_checkIfANodeWithChildToRight_false(){
        BST<Integer> tree = new BST<>(new Integer[]{10,7,12,8,4,9});
        assertEquals(false, tree.testingIsLeaf(8));
    }

    @Test
    public void isLeaf_checkIfANodeWithChildToLeft_false(){
        BST<Integer> tree = new BST<>(new Integer[]{10,7,12,8,4,9,11});
        assertEquals(false, tree.testingIsLeaf(12));
    }

    @Test
    public void isLeaf_checkIfANodeWithoutChildren_true(){
        BST<Integer> tree = new BST<>(new Integer[]{10,7,12,8,4,9,11});
        assertEquals(true, tree.testingIsLeaf(11));
    }

    @Test
    public void isLeaf_checkANodeWithBothChildren_false(){
        BST<Integer> tree = new BST<>(new Integer[]{10,7,12,8,4,9,11});
        assertEquals(false, tree.testingIsLeaf(7));
    }

    @Test
    public void delete_sizeIsCorrect_7(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,68});
        tree.delete(68);
        assertEquals(7, tree.getSize());
    }

    @Test
    public void delete_removeObjectCase1Part1_false(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,68});
        tree.delete(68);
        assertEquals(false, tree.search(68));
    }

    @Test
    public void delete_removeObjectCase1Part2_false(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,70,68,69});
        tree.delete(69);
        assertEquals(false, tree.search(69));
    }

    @Test
    public void delete_removeObjectCase2_false(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,64});
        tree.delete(65);
        assertEquals(false, tree.search(65));
    }

    @Test
    public void delete_removeObjectCase2RightMostTakeDeletedsPlace_64(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,64});
        tree.delete(65);
        assertEquals(64, (int)tree.testingGetNode(64).element);
    }

    @Test
    public void delete_removeObjectCase2RightMostTakeDeletedsPlaceParentIsRight_64(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,64});
        tree.delete(65);
        assertEquals(tree.getRoot(), tree.testingGetNode(64).parent);
    }

    @Test
    public void delete_removeObjectSpecialCaseParentOfDeletetpointsToDeletedsLeft_64(){
        BST<Integer> tree = new BST<>(new Integer[]{50,30,20,40,65,60,70,69});
        tree.delete(70);
        assertEquals(tree.testingGetNode(69), tree.testingGetNode(65).right);
    }



}