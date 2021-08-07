package com.techelevator;

import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		List <String> instructors = new ArrayList<String>();
		instructors.add("John");
		instructors.add("Steve");
		instructors.add("Matt");
		instructors.add("Kevin");

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");
		for(int i = 0; i < instructors.size(); i++){
			System.out.println(instructors.get(i));
		}


		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		instructors.add("John");

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		instructors.add(3,"Rachelle");


		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		instructors.remove(4);

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

		String[] instructorsAsArray = instructors.toArray(new String[instructors.size()]);

		//Can also convert an Array into an ArrayList

		List<String> instructorsAsListAgain = Arrays.asList(instructorsAsArray);

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

		for(String lastName: instructors){
			System.out.println(lastName);
		}

		double[] numbers = {1.2, 3, 6, 7, 7 , 9};
		for(double num: numbers){
			System.out.println(num * 2);
		}

		System.out.println("####################");
		System.out.println("  Primitive Wrappers");
		System.out.println("####################");

		List<Integer> numberList = new ArrayList<Integer>();
		numberList.add(10);
		numberList.add(12);
		numberList.add(1);


		System.out.println("####################");
		System.out.println("  QUEUE");
		System.out.println("####################");

		Queue<String> tasks = new LinkedList<String>();
		//Add items using offer()
		tasks.offer("Clean dishes");
		tasks.offer("Sweep floor");
		tasks.offer("Clean counter");
		tasks.offer("Scrub ceiling");

		while(!tasks.isEmpty()){
			String nextTask = tasks.poll();
			System.out.println(nextTask);
		}

	}
}
