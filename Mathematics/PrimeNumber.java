import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumber {

	public static void main(String[] args) {

		PrimeNumber checkPrime = new PrimeNumber();
		System.out.println("Check Prime using Naive Apprach : " + checkPrime.primeNaive(27));
		System.out.println("Check Prime using Slightly Better Approach : " + checkPrime.primeSlightlyBetter(17));
		System.out.print("Check Prime using Seive of Eratosthenes : " + checkPrime.seiveOfEratosthenes(27));
	}

	private boolean seiveOfEratosthenes(int number) {

		// Time complexity :- O(nloglog(n))

		if (number < 2)
			return false;

		int currentNumber = 2;
		boolean isPrime[] = new boolean[number + 1];
		ArrayList<Integer> listOfPrimeNumbers = new ArrayList<Integer>();

		init(isPrime);
		while (currentNumber <= Math.sqrt(number)) {
			if (isPrime[currentNumber]) {
				listOfPrimeNumbers.add(currentNumber);
				resetMultiplesOfCurrentNumber(isPrime, currentNumber);
				currentNumber = getNextCurrentNumber(isPrime, currentNumber);
			}
		}
		addRemaingPrimeToList(isPrime, currentNumber, listOfPrimeNumbers);
		showPrimeList(listOfPrimeNumbers);
		return isPrime[number];

	}

	private void addRemaingPrimeToList(boolean[] isPrime, int currentNumber, ArrayList<Integer> listOfPrimeNumbers) {
		for (; currentNumber < isPrime.length; currentNumber++) {
			if (isPrime[currentNumber])
				listOfPrimeNumbers.add(currentNumber);
		}
	}

	private void showPrimeList(ArrayList<Integer> listOfPrimeNumbers) {
		for (Integer prime : listOfPrimeNumbers)
			System.out.print(prime + " ");

		System.out.println();
	}

	private int getNextCurrentNumber(boolean[] isPrime, int currentNumber) {

		int next = currentNumber + 1;

		while (next < isPrime.length && !isPrime[next])
			next++;

		return next;

	}

	private void resetMultiplesOfCurrentNumber(boolean[] isPrime, int currentNumber) {
		for (int index = currentNumber * currentNumber; index < isPrime.length; index += currentNumber) {
			isPrime[index] = false;
		}
	}

	private void init(boolean[] isPrime) {
		Arrays.fill(isPrime, true);
	}

	private boolean primeNaive(int n) {

		// Time complexity :- O(n)

		if (n < 2)
			return false;

		for (int i = 2; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	private boolean primeSlightlyBetter(int n) {

		// Time complexity :- O(squareRoot(n))

		if (n < 2)
			return false;
		int sqrt = (int) Math.sqrt(n);
		for (int i = 2; i < sqrt; i++)
			if (n % i == 0)
				return false;

		return true;
	}

}
