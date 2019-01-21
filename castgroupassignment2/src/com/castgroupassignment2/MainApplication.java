package com.castgroupassignment2;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.castgroupassignment2.core.MaximumDifference;

public class MainApplication {
	private static final Logger LOGGER = Logger.getLogger("MainApplication");

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		int[] a = { 7, 2, 3, 10, 2, 4, 8, 1 };
		builder.append("Array a: ").append(MaximumDifference.maxDifference(a)).append(" - ");

		int[] b = { 6, 7, 9, 5, 6, 3 };
		builder.append("Array b: ").append(MaximumDifference.maxDifference(b)).append(" - ");

		Scanner scan = new Scanner(System.in);
		LOGGER.log(Level.INFO, "Digite a quantidade de itens do array");

		int valor = scan.nextInt();

		int[] c = new int[valor];

		for (int i = 0; i < valor; i++) {
			LOGGER.log(Level.INFO, "Digite o valor {0}", i + 1);
			c[i] = scan.nextInt();
		}

		builder.append("Array c: ").append(MaximumDifference.maxDifference(c));

		scan.close();

		LOGGER.log(Level.INFO, "Maximum Difference: {0}", builder.toString());
	}

}
