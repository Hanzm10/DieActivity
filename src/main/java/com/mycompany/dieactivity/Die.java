package com.mycompany.dieactivity;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Die {
	protected List<String> faces = new ArrayList<>();
	protected Random rand = new Random();

	public Die() {
		for (int i = 1; i <= 6; i++) {
			faces.add(String.valueOf(i));
		}
	}

	public List<String> getFaces() {
		return faces;
	}

	public String roll() {
		return faces.get(rand.nextInt(faces.size()));
	}
}
