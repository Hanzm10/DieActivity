package com.mycompany.dieactivity;

import java.util.List;

public class CustomDie extends Die {
	public CustomDie() {
		super();
	}

	public CustomDie(List<String> initialFaces) {
		this.faces = initialFaces;
	}

	public void addFace(String customFace) {
		faces.add(customFace);
	}

	public void removeFace(String customFace) {
		if (faces.removeIf(face -> face.equals(customFace))) {
			System.out.println("Face " + customFace + " removed successfully.");
		} else {
			System.out.println("Face " + customFace + " not found.");
		}
	}
}
