
public class LinkListDeque<Item> implements Deque<Item> {
	
	public class Node{
		public Item i;
		public Node next;
		public Node(Item x,Node h){
			i = x;
			next = h;
		}
	}
	private Node sentinel;
	private int size;
	public LinkListDeque(){
		size = 0;
		sentinel = new Node(null,null);
	}
	
	public LinkListDeque(Item x){
		size = 1;
		sentinel = new Node(null,new Node(x,null));
		
	}
	@Override
	public void addFirst(Item x){
		size++;
		Node tmp = new Node(x,sentinel.next);
		sentinel.next = tmp;
	}
	public Node getLast(){
		Node p = sentinel;
		while(p.next!=null){
			p = p.next;
		}
		return p;
	}
	@Override
	public void addLast(Item x){
		size++;		
		getLast().next = new Node(x,null);
	}
	@Override
	public Item removeFirst(){		
		if(sentinel.next==null){
			return null;
		}
		Item p = sentinel.next.i;
		sentinel.next = sentinel.next.next;
		size--;
		return p;	
	}
	@Override
	public Item removeLast(){
		if(getLast()==null){
			return null;
		}
		Node tmp = getLast();
		Item p = tmp.i;
		tmp=new Node(null,null);
		size--;
		return p;
	}
	@Override
	public boolean isEmpty(){
		return size==0;
	}
	@Override
	public Item get(int index){
		Node tmp = sentinel;
		int j = 0;
		while(j<index){
			tmp = tmp.next;
			j++;
		}
		return tmp.i;
	}
	@Override
	public int size(){
		return size;
	}
	public Item getRecursive(int index){
		return helperfunction(index).i;
	}
	public Node helperfunction(int index){
		if(index==1){
			return sentinel.next;
		}
		return helperfunction(index-1).next;
	}
	
} 
