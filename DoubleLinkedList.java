package HW4;

import LinkedListClassG.LinkedListNode;

public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> 
{ 
    //Double linked list node class 
    public class DoubleLinkedListNode<T>  
    { 
        T info; 
        DoubleLinkedListNode<T> next; 
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode() 
        { 
            info = null; 
            back = null;
            next = null; 
        }
        
        public DoubleLinkedListNode(T elem, DoubleLinkedListNode<T> atr, DoubleLinkedListNode<T> ptr) 
        { 
            info = elem;
            back = ptr; 
            next = atr; 
           
        }
        public String toString() 
        { 
            return info.toString(); 
        } 
    }

    protected int count;  //number of nodes 
    protected DoubleLinkedListNode<T> first; //reference to first node 
    protected DoubleLinkedListNode<T> last;  //reference to last node 
   
  //Default constructor 
    public DoubleLinkedList() { 
        first = null; 
        last = null; 
        count = 0; 
    }

    public boolean isEmptyList() { 
        return (first == null); 
    }

    public void initializeList() 
    { 
        first = null; 
        last = null; 
        count = 0; 
    }

    public void print()  { 
        DoubleLinkedListNode<T> current; //variable to traverse the list 
        current = first; 
        while (current != null) {//while more data to print 
            System.out.print(current.info + " "); 
            current = current.next; 
        } 
    }

    public int length() { 
        return count; 
    }

    public T front()   { 
        return first.info; 
    }

    public T back()  { 
        return last.info; 
    }

    public boolean search(T searchItem)  { 
        DoubleLinkedListNode<T> current; //variable to traverse the list 
        current = first; 
        while (current != null) 
            if (current.info == searchItem) 
                return true; 
            else 
               current = current.next; 
        return false; 
    }

    public void insertNode(T newItem) { 
    	DoubleLinkedListNode<T> current; //reference variable to traverse the list
    	DoubleLinkedListNode<T> trailCurrent=null; //reference variable just before current
    	boolean found;
        DoubleLinkedListNode<T> newNode;  //variable to create the new node 
        //create and insert newNode before first 
        newNode = new DoubleLinkedListNode<T>(newItem, null, null);
        if (first==null)
        {
        	first=newNode;
        	last=newNode;
        	count++;
        }
        else
        {
        	found=false;
        	current=first;
        	while (current!=null&&!found)
        	{
        		Comparable<T> temp=(Comparable<T>) current.info;
        		if (temp.compareTo(newItem)>=0)
        			found=true;
        		else
        		{
        			trailCurrent=current;
        			current=current.next;
        		}
        	}//end while
        	
        	if (current==first) //insert new node before first
        	{
        		first.back=newNode;
        		newNode.next=first;
        		first=newNode;
        		count++;
        	}
        	else
        	{
        		//insert newNode between trailCurrent and current
        		if (current!=null)
        		{
        			trailCurrent.next=newNode;
        			newNode.back=trailCurrent;
        			newNode.next=current;
        			current.back=newNode;
        		}
        		else
        		{
        			trailCurrent.next=newNode;
        			newNode.back=trailCurrent;
        			last=newNode;
        		}
        		count++;
        	}//end else
     
        }//end else
    }//end DeleteNode
  

    public void deleteNode(T deleteItem) { 
        DoubleLinkedListNode<T> current; //variable to traverse the list 
        DoubleLinkedListNode<T> trailCurrent; //variable just before current 
        boolean found; 
        //Case 1; the list is empty 
        if ( first == null) 
            System.err.println("Cannot delete from an empty list."); 
        else { 
            //Case 2: the node to be deleted is first 
            if (first.info == deleteItem) { 
                first = first.next;
                
                if (first == null)  //the list had only one node 
                    last = null; 
                count--; 
            } 
            else {  //search the list for the given info 
                found = false; 
                trailCurrent = first; //trailCurrent points to first node 
                current = first.link; //current points to second node 
                while (current != null && !found) { 
                    if (current.info == deleteItem) 
                        found = true; 
                    else { 
                        trailCurrent = current; 
                        current = current.link; 
                    } 
                } 
                //Case 3; if found, delete the node 
                if (found) { 
                    count--; 
                    trailCurrent.link = current.link; 
                    if (last == current)  //node to be deleted was the last node 
                       last = trailCurrent; 
                } 
                else 
                   System.out.println("Item to be deleted is not in the list."); 
            } 
        } 
    } 
  }	
}