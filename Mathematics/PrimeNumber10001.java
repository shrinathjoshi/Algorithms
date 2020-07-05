import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumber10001 {

	// https://www.hackerrank.com/contests/projecteuler/challenges/euler007/problem

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrimeNumber10001 primeChecker = new PrimeNumber10001();

		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			System.out.println(primeChecker.getPrime(n));
		}
	}

	private long getPrime(int number) {

		long currentNumber = 2;
		int primeNumberCount = 1;
		long primeNumber[] = new long[number + 1];

		while (primeNumberCount <= number) {
			if (isPrime(currentNumber)) {
				primeNumber[primeNumberCount++] = currentNumber;
			}
			currentNumber += currentNumber == 2 ? 1 : 2;
		}

		return primeNumber[number];

	}

	private boolean isPrime(long currentNumber) {
		// return seiveOfEratosthenes(currentNumber);
		return checkIfPrime(currentNumber);
	}

	private boolean checkIfPrime(long num) {

		if (num < 2)
			return false;
		if (num == 2 || num == 3)
			return true;
		if (num % 2 == 0)
			return false;
		for (int i = 3; i <= Math.sqrt(num); i += 2)
			if (num % i == 0)
				return false;
		return true;
	}

	private boolean seiveOfEratosthenes(long number) {

		// Time complexity :- O(nloglog(n))

		if (number < 2)
			return false;

		int currentNumber = 2;
		boolean isPrime[] = new boolean[(int) (number + 1)];

		init(isPrime);
		while (currentNumber <= Math.sqrt(number)) {
			if (isPrime[currentNumber]) {
				resetMultiplesOfCurrentNumber(isPrime, currentNumber);
				currentNumber = getNextCurrentNumber(isPrime, currentNumber);
			}
		}
		return isPrime[(int) number];

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

}
