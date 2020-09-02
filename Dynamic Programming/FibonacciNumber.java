
public class FibonacciNumber {

	public static void main(String[] args) {
		int N = 10;
		System.out.println(FibonacciNumber.getFibonacciUsingRecursion(N));
		System.out.println(FibonacciNumber.getFibonacciUsingRecursionAndMemoization(N));
		System.out.println(FibonacciNumber.getFibonacciUsingTabulation(N));
	}

	private static int getFibonacciUsingTabulation(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];

		return dp[n];
	}

	private static int getFibonacciUsingRecursionAndMemoization(int n) {
		int cache[] = new int[n + 1];
		return getFibonacciUsingRecursionAndMemoization(n, cache);
	}

	private static int getFibonacciUsingRecursionAndMemoization(int n, int[] cache) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (cache[n] != 0)
			return cache[n];

		int result = getFibonacciUsingRecursion(n - 1) + getFibonacciUsingRecursion(n - 2);
		cache[n] = result;
		return result;
	}

	private static int getFibonacciUsingRecursion(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return getFibonacciUsingRecursion(n - 1) + getFibonacciUsingRecursion(n - 2);
	}

}
