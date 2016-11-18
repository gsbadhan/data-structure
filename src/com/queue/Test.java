package com.queue;

public class Test {

	public static void main(String[] args) {
		Queue<Integer> queue=new Queue<>();
		//add into queue
		queue.add(11);
		queue.add(22);
		queue.add(8);
		
		//show all
		queue.printQueue();
		
		//remove one by one
		Integer data=queue.remove();
		System.out.println(data);
		data=queue.remove();
		System.out.println(data);
		data=queue.remove();
		System.out.println(data);
		
		queue.printQueue();
		
	}

}
