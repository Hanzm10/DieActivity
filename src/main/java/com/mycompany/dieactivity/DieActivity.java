
package com.mycompany.dieactivity;

import java.util.ArrayList;
import java.util.Arrays;


public class DieActivity {

	public static void main(String[] args) {
		CustomDie die = new CustomDie();
		UnfairDie unfairDie = new UnfairDie(new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5")),
				new ArrayList<Double>(Arrays.asList(0.1, 0.1, 0.5, 0.1, 0.2)));

		System.out.println("\n----- Custom Die -----\n");

		System.out.println("Initial faces: " + die.getFaces());
		System.out.println("Rolling the die: " + die.roll());

		die.addFace("Custom Face 1");
		System.out.println("After adding a face: " + die.getFaces());
		System.out.println("Rolling the die: " + die.roll());

		die.removeFace("Custom Face 1");
		System.out.println("After removing a face: " + die.getFaces());

		System.out.println("Rolling the die: " + die.roll());

		System.out.println("\n----- Unfair Die -----\n");

		System.out.println("Initial faces: " + unfairDie.getFaces());
		System.out.println("Initial chances: " + unfairDie.getChances());

		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		unfairDie.addFace("Custom Face 2");
		System.out.println("After adding a face: " + unfairDie.getFaces() + " " + unfairDie.getChances());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
		System.out.println("Rolling the unfair die: " + unfairDie.weightedRoll());
	}
}
