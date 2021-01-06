
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Non-recursive code to find all local minimums of a given an N-by-N array
 * 
 * @author Nadeesha Maduranga (nadeesham332@gmail.com)
 *
 */

public class LocalMinOfAMatrix {

	/**
	 * printing local minimum values in the matrix
	 * 
	 * @param a - array
	 * @param i - row index of local minimum
	 * @param j - column index of local minimum
	 */

	public static void print(int[][] a, int i, int j) {
		System.out.print(a[i][j] + " ");
	}

	/**
	 * find the local minimum values
	 * 
	 * @param a - input array
	 * @param n - array size (Number of columns or rows)
	 */
	public static void localMin(int[][] a, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0 && a[i][j] < a[i + 1][j] && a[i][j] < a[i][j + 1]) {
					print(a, i, j);
				} else if (i == 0 && j == n - 1 && a[i][j] < a[i + 1][j] && a[i][j] < a[i][j - 1]) {
					print(a, i, j);
				}

				else if (i == n - 1 && j == n - 1 && a[i][j] < a[i - 1][j] && a[i][j] < a[i][j - 1]) {
					print(a, i, j);
				}

				else if (i == n - 1 && j == 0 && a[i][j] < a[i - 1][j] && a[i][j] < a[i][j + 1]) {
					print(a, i, j);
				}

				else if (i == 0 && j != 0 && j != n - 1 && a[i][j] < a[i + 1][j] && a[i][j] < a[i][j + 1]
						&& a[i][j] < a[i][j - 1]) {
					print(a, i, j);
				}

				else if (i == n - 1 && j != 0 && j != n - 1 && a[i][j] < a[i][j + 1] && a[i][j] < a[i - 1][j]
						&& a[i][j] < a[i][j - 1]) {
					print(a, i, j);
				} else if (j == 0 && i != 0 && i != n - 1 && a[i][j] < a[i + 1][j] && a[i][j] < a[i][j + 1]
						&& a[i][j] < a[i - 1][j]) {
					print(a, i, j);
				} else if (j == n - 1 && i != 0 && i != n - 1 && a[i][j] < a[i + 1][j] && a[i][j] < a[i - 1][j]
						&& a[i][j] < a[i][j - 1]) {
					print(a, i, j);
				} else if ((j != 0 && j != n - 1 && i != 0 && i != n - 1 && a[i][j] < a[i + 1][j]
						&& a[i][j] < a[i][j + 1] && a[i][j] < a[i - 1][j] && a[i][j] < a[i][j - 1])) {
					print(a, i, j);
				}

			}
		}

	}

	/**
	 * driver code
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.print("This program will find all local minimum values from the given N-by-N array.\n"
				+ "n - Size of the array (Number of columns or rows)\n" + "Enter input array size(n): ");

		// Getting input size from user
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		int arr[][] = new int[n][n];
		int inputSize = 0;
		String input;

		int k = 0; // k counts the row number
		// getting input integers from user
		for (int i = 0; i < n; i++) {
			k++;
			do {
				System.out.print(
						"Enter " + n + " integers of row " + k + ", separated using space, to sort (n1 n2 n3 ...): ");
				input = reader.readLine();
				inputSize = input.split(" ").length;
			} while (inputSize != n);

			String[] numbers = input.split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(numbers[j]);
			}
		}

		System.out.print("\nLocal minimum values are: ");

		localMin(arr, n);

	}

}
