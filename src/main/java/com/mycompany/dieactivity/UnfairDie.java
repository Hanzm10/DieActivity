
package com.mycompany.dieactivity;

import java.util.ArrayList;
import java.util.List;

public class UnfairDie extends Die {
	private List<Double> chances;

	public UnfairDie() {
		super();
		this.chances = new ArrayList<>();
		assignEqualChances();
	}

	public UnfairDie(List<String> faces) {
		this.faces = faces;
		assignEqualChances();
	}

	public UnfairDie(List<String> faces, List<Double> chances) {
		if (chances == null) {
			System.err.println("Chances not provided. Assigning equal chances.");
			assignEqualChances();
		} else if (chances.size() != faces.size()) {
			System.err.println("Chances size does not match faces size. Assigning equal chances.");
			assignEqualChances();
		} else {
			double totalChance = 0.0;

			for (double chance : chances) {
				totalChance += chance;
			}

			if (totalChance != 1.0) {
				System.err.println("Total chance must be equal to 1.0. Assigning equal chances.");
				assignEqualChances();
			} else {
				this.chances = new ArrayList<>(chances);
			}
		}

		this.faces = faces;
	}

	public void addFace(String customFace) {
		faces.add(customFace);
		assignEqualChances();
	}

	private void assignEqualChances() {
		if (faces.isEmpty()) {
			throw new IllegalStateException("No faces available to assign chances.");
		}

		chances = new ArrayList<>();
		double totalChance = 0.0;
		double equalChance = 1.0 / faces.size();

		for (int i = 0; i < faces.size() - 1; i++) {
			totalChance += equalChance;
			chances.add(equalChance);
		}

		chances.add(1.0 - totalChance); // Ensure the last chance makes total 1.0
	}

	public List<Double> getChances() {
		return chances;
	}

	public void removeFace(String customFace) {
		if (faces.removeIf(face -> face.equals(customFace))) {
			System.out.println("Face " + customFace + " removed successfully.");
			assignEqualChances();
		} else {
			System.out.println("Face " + customFace + " not found.");
		}
	}

	public void setChances(List<Double> newChances) throws IllegalArgumentException {
		if (newChances.size() != faces.size()) {
			throw new IllegalArgumentException("New chances size must match faces size.");
		}

		double totalChance = 0.0;
		for (double chance : newChances) {
			totalChance += chance;
		}

		if (totalChance != 1.0) {
			throw new IllegalArgumentException("Total chance must equal 1.0.");
		}

		this.chances = new ArrayList<>(newChances);
	}

	public String weightedRoll() {
		double r = rand.nextDouble();
		double cumulativeChance = 0.0;

		for (int i = 0; i < chances.size(); i++) {
			cumulativeChance += chances.get(i);

			if (r <= cumulativeChance) {
				return faces.get(i);
			}
		}

		return faces.get(faces.size() - 1); // Fallback in case of rounding errors
	}

}
