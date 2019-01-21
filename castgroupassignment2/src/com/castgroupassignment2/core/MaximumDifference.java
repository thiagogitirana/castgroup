package com.castgroupassignment2.core;

/**
 * Calcula a diferença maxima em arrays
 * 
 * @author thiago.p.gitirana
 *
 */
public class MaximumDifference {

	private MaximumDifference() {
		super();
	}

	/**
	 * @param a
	 *            Array de inteiros
	 * @return Maior diferença entre os valores do array
	 */
	public static int maxDifference(int[] a) {

		int diferenca = 0;
		int valorA = 0;
		int valorB = 0;

		if (a != null && a.length > 0) {

			for (int i = 0; i < a.length; i++) {
				valorA = a[i];

				for (int j = i - 1; j >= 1; j--) {
					valorB = a[j];

					if (valorA > valorB) {

						int resultado = valorA - valorB;
						if (resultado > diferenca) {
							diferenca = resultado;
						}
					}

				}
			}
		}

		return diferenca;
	}

}
