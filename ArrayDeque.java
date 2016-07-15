
public class ArrayDeque<Item> implements Deque<Item> {

	private Item[] array;
	private int size;
	private int head;
	private int tail;
	private static final int R = 3;
	public ArrayDeque(){
		array = (Item[])new Object[10];
		size = 0;
		head = array.length/2;
		tail = array.length/2-1;
	}
	public void resize(int capacity){
		int p = head;
		int n = array.length;
		int r = array.length - p;
		Item[] a = (Item[]) new Object[capacity];
		System.arraycopy(array, p, a, 0, r);
		System.arraycopy(array, 0, a, r, p);
		array = a;
		head = 0;
		tail = n;
	}
	@Override
	public void addFirst(Item x){
		if(size==array.length){
			resize(size*R);
			head = array.length-1;
			array[head] = x;
			size++;
		}
		else if(head==0){
			head = array.length-1;
			array[head] = x;
			size++;
		}
		else{
			head = head - 1;
			array[head] = x;
			size++;
		}	
	}
	@Override
	public void addLast(Item x){
		if(size==array.length){
			resize(size*R);
			
			array[tail] = x;
			tail = tail +1;
			size++;
		}
		else if(tail==array.length-1){
			tail = 0;
			array[tail] = x;
			size++;
		}
		else {
			tail = tail+1;
			array[tail] = x;
			size++;
		}		
	}
	@Override
	public Item removeFirst(){
		if(size==0){
			return null;
		}
		size--;
		Item tmp = array[head];
		array[head] = null;
		head = head+1;
		return tmp;
	}
	@Override
	public Item removeLast(){
		if(size==array.length){
			resize(size*R);
		}
		size--;
		Item tmp = array[tail];
		array[tail] = null;
		tail = tail-1;
		return tmp;
	}
	@Override
	public int size(){
		return size;
	}
	@Override
	public boolean isEmpty(){
		return size==0;
	}
	@Override
	public Item get(int index){
		return array[index];
	}
	public void printArrayDeque(){
		/*int i = head;
		while((i-head)<size()&&i<array.length){
			System.out.print(get(i)+" ");
			i++;
		}*/
		//int count = 0;
		for(int i = head;i!=tail;i++){
			if(i>=array.length){
				i = i%array.length;
				//System.out.print(get(i)+" ");
			}
			System.out.print(get(i)+" ");
		}
		System.out.println();
		}
		@Override
		public Item getRecursive(int index){
			return null;
		}
		
	

}
