
public class WordUtils {
	   /** Returns the length of the longest word. */
	   public static String longest(Deque<String> list) {
	      int maxDex = 0;
	      for (int i = 0; i < list.size(); i += 1) {
	         String longestString = list.get(maxDex);
	         String thisString = list.get(i);
	         if (thisString.length() > longestString.length()) {
	            maxDex = i;
	         }
	      }
	      return list.get(maxDex);
	   }


	  public static void main(String[] args) {
	     LinkListDeque<String> someList = new LinkListDeque<String>();
	     someList.addLast("Monkey");
	     someList.addFirst("is");
	     someList.addLast("watching");
	     someList.addLast("TV");
	     //someList.removeLast();
	     System.out.println(someList.getRecursive(3));
	     //System.out.println(longest(someList));
	     someList.printDeque();
	     Deque<String> dList = new DLinkListDeque<String>();
	     dList.addLast("Jav");
	     dList.addFirst("Love");
	     dList.addFirst("I");
	     dList.addLast("Java");
	     System.out.println(dList.getRecursive(3));
	     //dList.removeLast();
	     dList.printDeque();
	     ArrayDeque<String> aList = new ArrayDeque<String>();
	     aList.addLast("1");
	     aList.addFirst("2");
	     aList.addLast("3");
	     aList.addFirst("4");
	     aList.addFirst("5");
	     aList.addFirst("6");
	     aList.addLast("7");
	     aList.addFirst("8");
	     aList.addFirst("9");
	     aList.addFirst("10");
	     aList.addFirst("11");
	     aList.addFirst("12");
	     aList.removeFirst();
	     aList.removeLast();
	     aList.printArrayDeque();
	  }
	}
