import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		// 3,1,2,4,3


		int A3[] = {6, 4, 4, 4, 4, 3};


//		Integer reduce = Arrays.stream(A2).reduce(2,(a, b) -> a + b);
//		System.out.println(minCoins(A2,25));
		/**
		 * 0,0,0,0,0
		 * 0,0,1,0,0
		 * 0,0,1,1,0
		 * 0,0,1,2,0
		 * 2,2,2,2,2
		 * 2,2,2,2,2
		 * 2,2,2,3,2
		 * 2,2,2,4,2
		 */
//        System.out.println(TapeEquilibrium(A3));
//        System.out.println(TapeEquilibrium(A2));
//        System.out.println(TapeEquilibrium(A1));
//        Arrays.stream(MaxCounters(5, A3)).boxed().forEach(System.out::println);
//        System.out.println("--------------");
//        Arrays.stream(MaxCounters2(5, A3)).boxed().forEach(System.out::println);

		int arr[] = {1, 3, 1, 4, 2, 3, 5, 4};
		int A2[] = {2, 5, 0};
		int A1[] = {4, 5, 6};
//		Arrays.stream(GenomicRangeQuery2("CAGCCTA", A2, A1)).forEach(System.out::println);
		int[] array = {10,2,5,1,8,20};
		System.out.println(Triangle(array));
//        System.out.println(FrogRiverOne(5,arr));
//        int A4[] = {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};
//        System.out.println(PassingCars(A4));

//		System.out.println(CountDiv1(0, 2000000000, 1));
//		System.out.println(CountDiv2(0, 2000000000, 1));

	}

	public static int BinaryGap(int N) {
		// write your code in Java SE 8
		String binaryString = Integer.toBinaryString(N);
		System.out.println(binaryString);
		int max = 0;
		char[] chars = binaryString.toCharArray();
		ArrayList<Character> check = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '1') {
				check.add('1');
				if (check.size() == 2) {
					if (count > max) {
						max = count;

					}
					count = 0;
					check.remove(check.size() - 1);
				}
			} else if (chars[i] == '0') {
				count++;
			}
		}
		return max;
	}

	public static int[] CyclicRotation(int[] A, int K) {
		// write your code in Java SE 8
		if (A.length == 0)
			return A;

		for (int i = 0; i < K; i++) {

			int last = A[A.length - 1];

			for (int j = A.length - 1; j > 0; j--) {
				A[j] = A[j - 1];
				// A[j]=A[j+1];
			}
			A[0] = last;
		}

		return A;
	}

	public static int OddOccurrencesInArray(int[] A) {
		boolean ispaired = false;
		int unpairedValue = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
//            if(!list.contains(A[i])){
//                list.add(A[i]);
//            }else{
//                list.remove(Integer.valueOf(A[i]));
//            }
			unpairedValue ^= A[i];
		}
		return unpairedValue;
	}

	public static int FrogJmp(int X, int Y, int D) {
		int distance = Y - X;
		double result = (double) distance / (double) D;
		System.out.println(result);
		return (int) Math.ceil(result);
	}

	public static int PermMissingElem(int[] A) {
		Set<Integer> intArray = Arrays.stream(A).
				boxed().collect(Collectors.toSet());
		int N = 0;
		while (true) {
			if (intArray.contains(N)) {
				N = N + 1;
				continue;
			}
			return N;
		}
	}

	public static int TapeEquilibrium(int[] A) {
		int sumAllElement = Arrays.stream(A).sum();
		int minDiff = Integer.MAX_VALUE;
		int currentDifference;
		int sumFirstPart = 0;
		int sumSecondPart = 0;
		for (int i = 0; i < A.length; i++) {
			sumFirstPart += A[i];
			sumSecondPart = sumAllElement - sumFirstPart;
			currentDifference = Math.abs(sumSecondPart - sumFirstPart);
			minDiff = Math.min(currentDifference, minDiff);
		}
		return minDiff;
	}

	public static int FrogRiverOne(int x, int[] A) {
		Set<Integer> sequance = new HashSet<>();
		for (int i = 1; i <= x; i++) {
			sequance.add(i);
		}
		for (int i = 0; i < A.length; i++) {
			if (sequance.contains(A[i])) {
				sequance.remove(Integer.valueOf(A[i]));
			}
			if (sequance.size() == 0) {
				return i;
			}
		}
		/**
		 * 5,4,3,2,1
		 * [1,3,1,4,2,3,5,4]
		 * 1,1,2,3,3,4,5
		 */
		return -1;
	}

	public static int PermCheck(int[] A) {
		Set<Integer> integerSet = Arrays.stream(A).boxed().collect(Collectors.toSet());
		for (int i = 0; i < A.length; i++) {
			if (!integerSet.contains(i + 1)) {
				return 0;
			}
		}
		return 1;
	}

	// Correctence 100% performance 100%
	public static int[] MaxCounters(int N, int[] A) {
		int[] result = new int[N];
		int max = 0;
		int lastMax = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				if (result[A[i] - 1] < lastMax) {
					result[A[i] - 1] = lastMax + 1;
				} else {
					result[A[i] - 1] += 1;
				}

				if (result[A[i] - 1] > max)
					max = result[A[i] - 1];
			} else if (A[i] == N + 1) {
				lastMax = max;
			}
		}

		for (int i = 0; i < result.length; i++) {
			if (result[i] <= lastMax) {
				result[i] = lastMax;
			}
		}
		return result;
	}

	// soultion2
	// Correctence 100% performance 0%
	public static int[] MaxCounters2(int N, int[] A) {
		int[] result = new int[N];
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= 1 && A[i] <= N) {
				if (result[A[i] - 1] < max) {
					result[A[i] - 1] = max + 1;
				} else {
					result[A[i] - 1] += 1;
				}
			} else {
				max = Arrays.stream(result).max().getAsInt();

			}

		}
		for (int i = 0; i < result.length; i++) {
			if (result[i] < max)
				result[i] = max;
		}
		return result;
	}

	public static int MissingInteger(int[] A) {
		HashSet<Integer> seen = new HashSet<Integer>();
		int min = 1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) seen.add(A[i]);
		}

		for (int i = 1; i < Integer.MAX_VALUE; i++) {
			if (!seen.contains(i)) return i;
		}
		return min;
	}

	// Correctence 100% performance 100%
	public static int PassingCars(int[] A) {
		int zeroCountBefore1s = 0;
		int counter = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				zeroCountBefore1s++;
			} else {
				counter = counter + zeroCountBefore1s;
			}
			if (counter > 1000000000)
				return -1;
		}

		return counter;
	}

	public static int CountDiv1(int A, int B, int K) {
		int count = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0)
				count++;
		}
		return count;
	}

	public static int CountDiv2(int A, int B, int K) {
//        int start=A;
//        int count=0;


//
//        while(start<=B){
//            if(start%K==0){
//                start+=K;
//                count++;
//            }else{
//                start++;
//            }
//
//        }
//        return count;
		if (K == 1)
			return B - A;
		if (A == B)
			return 1;
		int xx = 0;
		for (int i = A; i <= B; i++) {
			if (i % K == 0) {
				xx = i;
				break;
			}
		}
		int x = B - xx;
		return (int) Math.ceil((float) x / (float) K);
	}

	public static int minCoins(int coins[], int V) {
		// base case
		if (V == 0) return 0;

		// Initialize result
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= V) {
				int sub_res = minCoins(coins, V - coins[i]);

				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res)
					res = sub_res + 1;
			}
		}
		return res;
	}

	public static int[] GenomicRangeQuery2(String str, int[] p, int[] q) {
		char[] chars = str.toCharArray();
		int[] array = new int[chars.length];
		List<Integer> result = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			int x = 0;
			if (chars[i] == 'A') {
				x = 1;
			} else if (chars[i] == 'C') {
				x = 2;
			} else if (chars[i] == 'G') {
				x = 3;
			} else if (chars[i] == 'T') {
				x = 4;
			}
			array[i] = x;
		}
		for (int i = 0; i < p.length; i++) {
			if (p[i] - q[i] == 0) {
				result.add(array[p[i]]);
			} else if (p[i] < q[i]) {
				int startIndex = p[i];
				int endIndex = q[i];
				while (startIndex <= endIndex) {
					result2.add(array[startIndex]);
					startIndex++;
				}
				result.add(result2.stream().mapToInt(k -> k).min().getAsInt());
				result2.clear();
			} else {
				int startIndex = q[i];
				int endIndex = p[i];
				int min = 0;
				while (startIndex <= endIndex) {
					result2.add(array[startIndex]);
					startIndex++;
				}
				result.add(result2.stream().mapToInt(k -> k).min().getAsInt());
				result2.clear();
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static int MinAvgTwoSlice(int[] A) {
		int minAvgIdx = 0;
		double minAvgVal = (A[0] + A[1]) / 2; //At least two elements in A.
		double currAvg;
		for (int i = 0; i < A.length - 2; i++) {
			/**
			 * We check first the two-element slice
			 */
			currAvg = ((double) (A[i] + A[i + 1])) / 2;
			if (currAvg < minAvgVal) {
				minAvgVal = currAvg;
				minAvgIdx = i;
			}
			/**
			 * We check the three-element slice
			 */
			currAvg = ((double) (A[i] + A[i + 1] + A[i + 2])) / 3;
			if (currAvg < minAvgVal) {
				minAvgVal = currAvg;
				minAvgIdx = i;
			}
		}
		/**
		 * Now we have to check the remaining two elements of the array
		 * Inside the for we checked ALL the three-element slices (the last one
		 * began at A.length-3) and all but one two-element slice (the missing
		 * one begins at A.length-2).
		 */
		currAvg = ((double) (A[A.length - 2] + A[A.length - 1])) / 2;
		if (currAvg < minAvgVal) {
			minAvgVal = currAvg;
			minAvgIdx = A.length - 2;
		}
		return minAvgIdx;
	}

	public static int Distinct(int[] A) {
		Set<Integer> collect = Arrays.stream(A).boxed().collect(Collectors.toSet());
		return collect.size();
	}

	public static int MaxProductOfThree(int[] A) {
		Arrays.sort(A);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length - 3; i++) {
			int temp = A[i] * A[i + 1] * A[i + 2];
			if (temp > max)
				max = temp;
		}

		int temp = A[A.length - 3] * A[A.length - 2] * A[A.length - 1];
		if (temp > max)
			max = temp;

		int temp2 = A[0] * A[1] * A[A.length - 1];

		if(temp2>max)
			max=temp2;

		return max;
	}

	public static int Triangle(int [] A){
		//10,2,5,1,8,20
		//1,2,5,8,10,20
		//20,10,8,5,2,1
		if(A.length<3)
			return 0;

		Arrays.sort(A);
		for(int i=A.length-1;i>=2;i--){
			if(A[i-1]+A[i-2]>A[i])
				return 1;
		}
		return 0;
	}
}
