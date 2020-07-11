package org.ygy.study.javacore.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器
 * 
 * @author Yegenyao
 *
 */
public class IteratorDemo {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "c");
		for (String each : list) {
			System.out.println(each);
		}

		// 上述写法会被Java编译器吧for each循环通过Iterator改写为了普通的for循环：
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String each = iterator.next();
			System.out.println(each);

		}

		/*
		 * 我们把这种通过Iterator对象遍历集合的模式称为迭代器。使用迭代器的好处在于，调用方总是以统一的方式遍历各种集合类型，
		 * 而不必关系他们内部的存储结构,如遍历ArrayList时，可以使用get(index)来遍历；而遍历LinkedList时如果使用get(index)
		 * 来遍历的话,get方法执行时间会随index值增大而变长。而遍历Set时，根本就没有索引值。 <p>
		 * 
		 * 而用Iterator来遍历则没有上述问题，因为Iterator对象是由集合对象自己内部创建的，它自己知道如何高效遍历内部的数据集合，
		 * 调用方获得了统一的代码，编译器才能把标准的for each循环自动转化为Iterator遍历。
		 */
		
		ReverseList<Integer> revList = new ReverseList<>();
		
		revList.add(1);
		revList.add(2);
		revList.add(3);
		for (Iterator<Integer> iterator = revList.iterator(); iterator.hasNext();) {
			Integer each = iterator.next();
			System.out.println(each);
		}
	}

}



class ReverseList<T> implements Iterable<T>{
	
	private List<T>  list = new ArrayList<>();
	
	public void add(T t) {
		list.add(t);
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ReverseIterator(list.size());
	}
	
	class ReverseIterator implements Iterator<T>{  //非静态内部类会自动使用外部泛型,所以这里ReverseIterator后面不用跟上<T>
		
		int index;
		public ReverseIterator(int index) {
			this.index = index;
		}
		
		@Override
		public boolean hasNext() {
			return index > 0;
		}
		
		@Override
		public T next() {
			index--;
			return  ReverseList.this.list.get(index);
		}
		
	}
	
}