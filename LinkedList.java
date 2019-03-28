
public class LinkedList<T> implements List<T>{
    private static Node head;
    public static int size = 0;
    
    Object[] tempArray = new Object[size];
    T[] arr = (T[]) tempArray;  
    
    public LinkedList(){
       head = new Node(null);
    }
    
    public static class Node<T>{
	T data;
	Node next;
	public Node(T data){
            this.data = data;
            next=null;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setData(T data){
            this.data = data;
        }
        public Node getNext(){
            return next;
        }
        public T getData(){
            return data;
        }
    }
    
    @Override
    public void add(T item){
        if(head==null){
            Node <T> newNode = new Node(item);
            head = newNode;
            size++;
        }
        else{
            Node prev = head;
            for(int i=0;i<size-1;i++){
                prev = prev.getNext();
            }
            Node <T> newNode = new Node(item);
            prev.setNext(newNode);
            size++;
        }
    }
    @Override
    public void add(int pos, T item){      
        if(pos<=size&&pos>=0 == false){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(pos == 0){
            Node node = new Node(item);
            node.setNext(head);	
            head = node;
	}
        Node node = new Node(null);
        node.next = head;
        Node node2 = node;
        for(int i=0;i<pos;i++){
            node2 = node2.next;
        }
        Node newNode = new Node(item);
        newNode.next = node2.next;
        node2.next = newNode;
        size++;
    }    
    @Override
    public T get(int pos){
        if(pos>=0 && pos<size == false){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node curr = new Node(null);
        if(head != null){
            curr = head.getNext();
            for(int i=0;i<pos;i++){
                if(curr.getNext()==null){
                    return null;
                }
                curr = curr.getNext();
            }
            return (T) curr.getData();
        }
        return (T) curr;
    }
    @Override
    public T remove(int pos){
        if(pos>=0 && pos<size == false){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(pos==0){
            Node curr = head;
            head = curr.getNext();
            --size;
            return (T) curr.getData();
	}
	else{
            Node prev = head;
            for(int i=0;i<pos-1;i++){
                prev = prev.getNext();
            }
            Node curr = prev.getNext();
            prev.setNext(curr.getNext());
            --size;
            return (T) curr.getData();
	}

    }
    @Override
    public int size(){
        return size;
    }
}


