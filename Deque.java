
public interface Deque<Item> {
	 void addFirst(Item x);
	 void addLast(Item x);
	 boolean isEmpty();
	 int size();
	
	 Item removeFirst();
	 Item removeLast();
	 Item get(int index);
	 Item getRecursive(int index);
	default  void printDeque(){
		for(int i = 1;i<=size();i++){
			System.out.print(get(i)+" ");
		}
		System.out.println();
	}


}
