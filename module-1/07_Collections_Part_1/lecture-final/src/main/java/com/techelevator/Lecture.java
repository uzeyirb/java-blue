package com.techelevator;

import java.util.*;


/*
	Fully qualified name of this class: com.techelevator.Lecture

	A fully qualified name is one that contains the package.Classname to uniquely identify it
 */
public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List<String> instructors =  new ArrayList<String>();

		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Kevin");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for (int i = 0; i < instructors.size(); i++) {
			System.out.println( instructors.get(i) );
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(3, "Rachelle");

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove( 5 );

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		boolean isSteveInList = instructors.contains("Steve");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int indexOfRachelle = instructors.indexOf("Rachelle");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

		String[] instructorsAsArray = instructors.toArray( new String[instructors.size()] );

		// Can also convert an Array into an ArrayList
		List<String> instructorsAsListAgain = Arrays.asList( instructorsAsArray );

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(instructors);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(instructors);

		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		for (String name : instructors) {
			System.out.println( name );
		}

		/*  The above for-each is equivalent to this for loop:
			for (int i = 0; i < instructors.size(); i++) {
				String name = instructors.get(i);
				System.out.println( name );
			}
		 */

		double[] numbers = { 1.2, 3, 7, 92.3};

		for (double num: numbers) {
			System.out.println( num * 2 );
		}

		System.out.println("####################");
		System.out.println("       PRIMITIVE WRAPPER");
		System.out.println("####################");
		System.out.println();

		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add( 10 );
		numberList.add( 12 );
		numberList.add( 1 );
		numberList.add( new Integer(16) );

		Integer employees = new Integer(25);
		Integer piecesOfCake = new Integer("24");

		if (employees > piecesOfCake) {
			System.out.println("Not enough cake");
		}

		Integer objX = 10;
		int intY = 20;
		intY = objX + 5;
		objX = intY + 10;

		System.out.println("####################");
		System.out.println("       QUEUE");
		System.out.println("####################");
		System.out.println();

		Queue<String> tasks = new LinkedList<String>();

		// Add items using offer()
		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean counter");
		tasks.offer("Scrub ceiling");

		/*
		The while loop continues while the boolean condition is true and ends when it becomes false
		 */
		while (!tasks.isEmpty()) {
			String nextTask = tasks.poll();
			System.out.println(nextTask);
		}

		System.out.println("####################");
		System.out.println("       STACK");
		System.out.println("####################");
		System.out.println();


		Stack<Integer> numberStack = new Stack<Integer>();
		numberStack.push(10);
		numberStack.push(20);
		numberStack.push(40);
		numberStack.push(50);

		while ( !numberStack.isEmpty()) {
			Integer nextNumber = numberStack.pop();
			System.out.println(nextNumber);
		}

		int[] num = { 1, 2, 3,4, 5, 6, 7, 8};
		Stack<Integer> numsAsStack = new Stack<Integer>();
		for (int n : num) {
			numsAsStack.push( n );
		}
		while ( !numsAsStack.isEmpty() ) {
			System.out.println( numsAsStack.pop() );
		}
	}
}
