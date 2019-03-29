
public class LinkedList<T> implements List<T>{
    private Node head;
    public int size;
 
    public LinkedList(){
       head = null;
       size = 0;
    }
    
    class Node{
	T data;
	Node next;
	Node(T data){
            this.data = data;
            next=null;
        }
    }
    
    @Override
    public void add(T item){    
        if(size==0){
            Node newNode = new Node(item);
            head = newNode; 
        }
        else{
            Node prev = head;
            for(int i=0;i<size-1;i++){
                prev = prev.next;
            }
            Node newNode = new Node(item);
            prev.next = newNode;
        }
        size++;
    }
    @Override
    public void add(int pos, T item){
        if(!(pos<=size&&pos>=0)){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(pos == 0){
            Node node = new Node(item);
            node.next = head;	
            head = node;
            
	}
        else{
            Node node = new Node(null);
            node.next = head;
            Node node2 = node;
            for(int i=0;i<pos;i++){
                node2 = node2.next;
            }
            Node newNode = new Node(item);
            newNode.next = node2.next;
            node2.next = newNode;
            }
        size++;
    }    
    @Override
    public T get(int pos){
        if(pos>=0 && pos<size == false){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node curr = head;           
        for(int i=0;i<pos;i++){
            curr = curr.next;
        }
        return curr.data;
    }
    @Override
    public T remove(int pos){
        if(pos>=0 && pos<size == false){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(pos==0){
            Node curr = head;
            head = curr.next;
            --size;
            return curr.data;
	}
	else{
            Node prev = head;
            for(int i=0;i<pos-1;i++){
                prev = prev.next;
            }
            Node curr = prev.next;
            prev.next = curr.next;
            --size;
            return curr.data;
	}

    }
    @Override
    public int size(){
        return size;
    }
}


