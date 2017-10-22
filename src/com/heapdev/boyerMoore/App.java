package com.heapdev.boyerMoore;

public class App {

	public static void main(String[] args) {
		String text = "My name is Abhinav Singh.";
		String pattern = "Sin";
		BoyerMoore bMoore = new BoyerMoore(text, pattern);
		bMoore.preComputeMismatchTable();
		System.out.println(bMoore.search());
		System.out.println("Thats it !!");
	}

}
