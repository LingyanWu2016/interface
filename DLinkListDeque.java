
public class DLinkListDeque<Item> implements Deque<Item>{
	public class Node{
		Item i;
		Node prev;
		Node next;	
	public Node(Item x,Node h,Node t){
		i = x;
	    prev = h;
	    next = t;
	}
	}
	private Node sentinel;
	private int size;
	public DLinkListDeque(){
		size = 0;
		sentinel = new Node(null,sentinel,sentinel);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	public DLinkListDeque(Item x){
		size = 1;
		sentinel = new Node(null,new Node(x,sentinel,sentinel),new Node(x,sentinel,sentinel));
		sentinel.next = new Node(x,sentinel,sentinel);
		sentinel.prev = new Node(x,sentinel,sentinel);
	}
	@Override
	public void addFirst(Item x){
		
		if(sentinel.next==null){
			sentinel.next = new Node(x,sentinel,sentinel);
			size++;
		}
		//else{
			Node oldFirst = sentinel.next;
			Node newFirst = new Node(x,sentinel,oldFirst);
			size++;
			sentinel.next = newFirst;
			oldFirst.prev = newFirst;
		//}
		
	}
	@Override
	public void addLast(Item x){
		if(sentinel.prev==null){
			sentinel.prev = new Node(x,sentinel,sentinel);
			size=1;
		}
		else{
			size++;
			Node oldLast = sentinel.prev;
			Node newLast = new Node(x,oldLast,sentinel);			
			sentinel.prev = newLast;
			oldLast.next = newLast;	
			
		}
		
	}
	@Override
	public Item removeFirst(){
		if(size==0){
			return null;
		}
		size--;
		Item first = sentinel.next.i;
		Node firstNode = sentinel.next;
		Node nextNode = firstNode.next;
		firstNode = new Node(null,null,null);
		sentinel.next =nextNode;
		return first;
	}
	@Override
	public Item removeLast(){
		if(size==0){
			return null;
		}
		size--;
		Item last = sentinel.prev.i;
		Node lastNode = sentinel.prev;
		Node prevNode = lastNode.prev;
		lastNode = new Node(null,null,null);
		sentinel.prev = prevNode;
		return last;
	}
	@Override
	public boolean isEmpty(){
		return size==0;
	}
	@Override
	public Item get(int index){
		int j = 0;
		Node p = sentinel;
		while(j<index){
			p = p.next;
			j++;
		}
		return p.i;
	}
	@Override
	public int size(){
		return size;
	}
	public Item getRecursive(int index){
		
		return getR(index).i;
	}
	public Node getR(int index){
		if(index==1){
			return sentinel.next;
		}
		return getR(index-1).next;
	}

}
