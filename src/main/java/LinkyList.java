/**
 * Our version of a linked-list
 *
 * @author Austin Benedicto
 * @version 12/14/2025
 */
public class LinkyList <T>
{
    private class Node
    {
        public T data;
        public Node next;

        public Node( T data )
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    /**
     * Constructor for LinkyList
     */
    public LinkyList()
    {
        head = null;    
    }

    /**
     * True if the LinkyList is empty, false otherwise
     * 
     * @return if the LinkyList is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    public void clear()
    {
        head = null;
    }

    /**
     * Returns the number of elements in this list
     * 
     * @return the number of elements in this list
     */
    public int size()
    {
        int counter = 0;

        for( Node temp = head; temp != null; temp = temp.next)
        {
            counter++;
        }

        return counter;
    }

    /**
     * Returns true if this list contains the specified element. More formally, returns true if and only if this list contains at least one element e such that Objects.equals(obj, e).
     * 
     * @param obj element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains( Object obj )
    {
        Node current = head;
        
        while( current != null )
        {
            if( (obj == null && current.data == null) || (obj != null && obj.equals(current.data)) )
                return true;
            current = current.next;
        }
        
        return false;
    }

    /**
     * Returns the element at the specified position in this list
     * 
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get( int index )
    {
        if( index < 0 || index >= size() )
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        
        Node current = head;
        for( int i = 0; i < index; i++ )
        {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     * 
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T set( int index, T element )
    {
        if( index < 0 || index >= size() )
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        
        Node current = head;
        for( int i = 0; i < index; i++ )
        {
            current = current.next;
        }
        T oldData = current.data;
        current.data = element;
        return oldData;
    }

    /**
     * Appends the specified element to the end of this list.
     * 
     * @param element the element to be appended
     * @return true if the addition was successful, false otherwise
     */
    public boolean add( T element )
    {
        if( head == null )
        {
            head = new Node(element);
            return true;
        }

        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
            
        temp.next = new Node( element );
        return true;
    }

    /**
     * Inserts the specified element at the specified position in this list. Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * 
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add( int index, T element )
    {
        if( index < 0 || index > size() )
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        
        if( index == 0 )
        {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node current = head;
            for( int i = 0; i < index - 1; i++ )
            {
                current = current.next;
            }
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Removes the element at the specified position in this list
     * 
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove( int index )
    {
        if( index < 0 || index >= size() )
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        
        T removedData;
        if( index == 0 )
        {
            removedData = head.data;
            head = head.next;
        }
        else
        {
            Node current = head;
            for( int i = 0; i < index - 1; i++ )
            {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        return removedData;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     * 
     * @param obj element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove( Object obj )
    {
        if( head == null )
            return false;
        
        if( (obj == null && head.data == null) || (obj != null && obj.equals(head.data)) )
        {
            head = head.next;
            return true;
        }
        
        Node current = head;
        while( current.next != null )
        {
            if( (obj == null && current.next.data == null) || (obj != null && obj.equals(current.next.data)) )
            {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that Objects.equals(o, get(i)), or -1 if there is no such index.
     * 
     * @param obj element to search for
     * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int indexOf( Object obj )
    {
        int index = 0;
        for( Node current = head; current != null; current = current.next )
        {
            if( (obj == null && current.data == null) || (obj != null && obj.equals(current.data)) )
                return index;
            index++;
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the highest index i such that Objects.equals(o, get(i)), or -1 if there is no such index.
     * 
     * @param obj element to search for
     * @return the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf( Object obj )
    {
        int index = 0;
        int lastFound = -1;
        for( Node current = head; current != null; current = current.next )
        {
            if( (obj == null && current.data == null) || (obj != null && obj.equals(current.data)) )
                lastFound = index;
            index++;
        }
        return lastFound;
    }
    
    /**
     * Compares the specified object with this list for equality
     * 
     * @param obj the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    public boolean equals(Object obj)
    {
        if( obj == this )
            return true;
        
        if( obj == null || !(obj instanceof LinkyList) )
            return false;
        
        LinkyList list = (LinkyList) obj;
        
        Node thisCurrent = this.head;
        Node otherCurrent = list.head;
        
        while( thisCurrent != null && otherCurrent != null )
        {
            if( thisCurrent.data == null && otherCurrent.data != null )
                return false;
            if( thisCurrent.data != null && !thisCurrent.data.equals(otherCurrent.data) )
                return false;
            
            thisCurrent = thisCurrent.next;
            otherCurrent = otherCurrent.next;
        }
        
        return thisCurrent == null && otherCurrent == null;
    }
    
    /**
     * Returns a String representation of this LinkyList. The String representation consists of a
     * list of the collection's elements in the order they are returned by its iterator, enclosed
     * in square brackets("[]"). Adjacent elements are separated by the character ", " (comma and space).
     * Elements are converted to Strings as by String.valueOf( Object).
     * 
     * @return a String representation of this collection
     */
    public String toString()
    {
        StringBuffer printList = new StringBuffer( "[" );
        
        return printList.append("]").toString();
    }
}
