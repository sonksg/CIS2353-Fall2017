/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedbag;

/**
 *
 * @author etcharn1
 */
public class LinkedBag<T> implements BagInterface<T> {

    private Node first;
    private int currentSize;
    
    public LinkedBag()
    {
        first = null;
        currentSize = 0;
    }
    
    @Override
    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean add(T item) {
        Node newNode = new Node(item);
        newNode.next = first;
        first = newNode;
        currentSize++;
        return true;
    }

    @Override
    public T remove() {
        T result = null;
        if ( first != null )
        {
            result = first.data;
            first = first.next;
            currentSize--;
        }
        return result;
    }
    
    private Node getReferenceTo(T item)
    {
        boolean found = false;
        Node currentNode = first;
        
        while(!found && currentNode != null)
        {
            if ( item.equals(currentNode.data))
            {
                found = true;
            }
            else
            {
                currentNode = currentNode.next;
            }
        }
        return currentNode;
    }

    @Override
    public boolean remove(T item) {
        boolean result = false;
        Node itemNode = getReferenceTo(item);
        if ( itemNode != null )
        {
            itemNode.data = first.data;
            first = first.next;
            currentSize--;
            result = true;
        }
        return result;
    }

    @Override
    public int getFrequencyOf(T item) {
        int frequency = 0;
        Node currentNode = first;
        while ( currentNode != null )
        {
            if ( item.equals(currentNode.data))
            {
                frequency++;
            }
            currentNode = currentNode.next;
        }
        return frequency;
    }

    @Override
    public boolean contains(T item) {
        boolean found = false;
        Node currentNode = first;
        while ( !found && currentNode != null )
        {
            if ( item.equals(currentNode.data))
            {
                found = true;
            }
            currentNode = currentNode.next;
        }
        return found;
    }

    @Override
    public T[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class Node
    {
        private T data;
        private Node next;
        
        Node(T data)
        {
            this(data, null);
        }
        Node( T data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    
}
