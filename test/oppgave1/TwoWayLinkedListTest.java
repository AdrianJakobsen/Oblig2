package oppgave1;

import org.junit.Before;
import org.junit.Test;

import java.util.ListIterator;

import static org.junit.Assert.*;

public class TwoWayLinkedListTest {


    private TwoWayLinkedList twoWayLinkedList;
    private String[] list = {"party", "house", "kirby", "apple", "java", "tabasco", "bastion"};

    @Before
    public void setUp() {
        twoWayLinkedList = new TwoWayLinkedList(list);
    }


    @Test
    public void constructor_Add_CheckIfSizeIsCorrect_Seven() {
        assertEquals(7, twoWayLinkedList.size());
    }

    @Test
    public void get_getTheThirdObjectInList_kirby() {
        assertEquals("kirby", twoWayLinkedList.get(2));
    }

    @Test
    public void get_getTheFifthObjectInList_java() {
        assertEquals("java", twoWayLinkedList.get(4));
    }

    @Test
    public void getLast_getLastObjectInList_bastion() {
        assertEquals("bastion", twoWayLinkedList.getLast());
    }

    @Test
    public void addFirst_checkIfSizeIsCorrect_Eight() {
        twoWayLinkedList.addFirst("pen");
        assertEquals(8, twoWayLinkedList.size());
    }

    @Test
    public void addFirst_getFirstObjectInList_shark() {
        twoWayLinkedList.addFirst("shark");
        assertEquals("shark", twoWayLinkedList.getFirst());
    }

    @Test
    public void addFirst_addedObjectPointsToThePreviousFirst_party() {
        twoWayLinkedList.addFirst("pen");
        assertEquals("party", twoWayLinkedList.listIterator(0).next());
    }

    @Test
    public void addFirst_SecondObjectPointsToNewFirst_avl() {
        twoWayLinkedList.addFirst("avl");
        assertEquals("avl", twoWayLinkedList.listIterator(1).previous());
    }

    @Test(expected = NullPointerException.class)
    public void addFirst_AddedObjectsPreviusPointsToNull_Null() {
        twoWayLinkedList.addFirst("pointToNull");
        assertEquals(null, twoWayLinkedList.listIterator(0).previous());
    }

    @Test(expected = NullPointerException.class)
    public void addLast_AddedObjectsNextPointsToNull_Null() {
        twoWayLinkedList.addLast("null");
        assertEquals(null, twoWayLinkedList.listIterator(twoWayLinkedList.size() - 1).next());
    }

    @Test
    public void addLast_AddedObjectsPreviousPointsToLastTail_Bastion() {
        twoWayLinkedList.addLast("newTail");
        assertEquals("bastion", twoWayLinkedList.listIterator(twoWayLinkedList.size() - 1).previous());
    }

    @Test
    public void addLast_LastTailPointsToNewObject_newTail() {
        twoWayLinkedList.addLast("newTail");
        assertEquals("newTail", twoWayLinkedList.listIterator(twoWayLinkedList.size() - 2).next());
    }

    @Test
    public void add_AddedObjectAtIndexFive_fifth() {
        twoWayLinkedList.add(5, "fifth");
        assertEquals("fifth", twoWayLinkedList.get(5));
    }

    @Test
    public void add_AddedObjectPointsToCorrectPrevious_java() {
        twoWayLinkedList.add(5, "fifth");
        assertEquals("tabasco", twoWayLinkedList.listIterator(5).next());
    }

    @Test
    public void add_AddedObjectPointsToCorrectNext_tabasco() {
        twoWayLinkedList.add(5, "fifth");
        assertEquals("tabasco", twoWayLinkedList.listIterator(5).next());
    }

    @Test
    public void add_AddedObjectPointsToCorrectPrevious_house() {
        twoWayLinkedList.add(2, "newNode");
        assertEquals("house", twoWayLinkedList.listIterator(2).previous());
    }

    @Test
    public void add_AddedObjectPointsToCorrectNext_kirby() {
        twoWayLinkedList.add(2, "newNode");
        assertEquals("kirby", twoWayLinkedList.listIterator(2).next());
    }

    @Test
    public void remove_SizeIsCorrect_six() {
        twoWayLinkedList.remove(4);
        assertEquals(6, twoWayLinkedList.size());
    }

    @Test
    public void remove_TheThirdIndexBecomesSecondIndex_kirby() {
        twoWayLinkedList.remove(1);
        assertEquals("kirby", twoWayLinkedList.get(1));
    }

    @Test
    public void remove_ObjectBeforeTheRemoveObjectPointsTowardTheReomvedsNext_java() {
        twoWayLinkedList.remove(3);
        assertEquals("java", twoWayLinkedList.listIterator(2).next());
    }

    @Test
    public void remove_ObjectAfterTheRemoveObjectPointsTowardTheReomvedsPrevious_apple() {
        twoWayLinkedList.remove(4);
        assertEquals("apple", twoWayLinkedList.listIterator(4).previous());
    }

    @Test
    public void removedFirst_SizeIsCorrect_six(){
        twoWayLinkedList.removeFirst();
        assertEquals(6, twoWayLinkedList.size());
    }

    @Test
    public void removeFirst_FirstObjecktRemovedSecondBecomesNewFirst_party(){
        twoWayLinkedList.removeFirst();
        assertEquals("house", twoWayLinkedList.get(0));
        assertEquals("house", twoWayLinkedList.getFirst());
    }

    @Test(expected = NullPointerException.class)
    public void removeFirst_NewFirstObjectPreviouspointsToNull_Null(){
        twoWayLinkedList.removeFirst();
        assertEquals(null, twoWayLinkedList.listIterator(0).previous());
    }

    @Test
    public void removeLast_SizeIsCorrect_six(){
        twoWayLinkedList.removeLast();
        assertEquals(6, twoWayLinkedList.size());
    }

    @Test
    public void removeLast_CorrectNewLastObject_tabasco(){
        twoWayLinkedList.removeLast();
        assertEquals("tabasco", twoWayLinkedList.get(twoWayLinkedList.size() - 1));
        assertEquals("tabasco", twoWayLinkedList.getLast());
    }

    @Test(expected = NullPointerException.class)
    public void removedLast_NewLastPointsToNull_Null(){
        twoWayLinkedList.removeLast();
        assertEquals(null, twoWayLinkedList.listIterator(twoWayLinkedList.size()-1).next());
    }

    @Test
    public void set_SetirdElement_orange(){
        twoWayLinkedList.set(3, "orange");
        assertEquals("orange", twoWayLinkedList.get(3));
    }

    @Test
    public void set_setFirstElement_first(){
        twoWayLinkedList.set(0, "first");
        assertEquals("first", twoWayLinkedList.getFirst());
    }

    @Test
    public void set_setLastElement_last(){
        twoWayLinkedList.set(twoWayLinkedList.size() - 1, "last");
        assertEquals("last", twoWayLinkedList.getLast());
    }

    @Test
    public void iterator_hasNext_true(){
        ListIterator iterator = (ListIterator) twoWayLinkedList.iterator();
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void iterator_hasPrevious_false(){
        ListIterator iterator = (ListIterator) twoWayLinkedList.iterator();
        assertEquals(false, iterator.hasPrevious());
    }

    @Test
    public void iterator_nextIsHouse_house(){
        ListIterator iterator = (ListIterator) twoWayLinkedList.iterator();
        assertEquals("house", iterator.next());
    }

    @Test(expected = NullPointerException.class)
    public void iterator_PreviousIsNull_null(){
        ListIterator iterator = (ListIterator) twoWayLinkedList.iterator();
        iterator.previous();
    }
}