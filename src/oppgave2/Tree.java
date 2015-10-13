package oppgave2;

import java.util.List;

public interface Tree<E> extends Iterable<E> {
    /** Return true if the element is in the tree */
    public boolean search(E e);

    /** Insert element o into the binary tree
     * Return true if the element is inserted successfully */
    public boolean insert(E e);

    /** Delete the specified element from the tree
     * Return true if the element is deleted successfully */
    public boolean delete(E e);

    /** Inorder traversal from the root*/
    public void inorder(List<E> returnList);

    /** Get the number of nodes in the tree */
    public int getSize();

    /** Return true if the tree is empty */
    public boolean isEmpty();
}
