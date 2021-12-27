import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // 3,1,2,4,3

        int A2[] = {1, 2, 3, 4, 2};
        int A1[] = {3, 1, 2, 4, 3};
        int A3[] = {1,1,3};
//        System.out.println(TapeEquilibrium(A3));
//        System.out.println(TapeEquilibrium(A2));
//        System.out.println(TapeEquilibrium(A1));

        int arr[]={1,3,1,4,2,3,5,4};
        System.out.println(FrogRiverOne(5,arr));
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

    public static int FrogRiverOne(int x,int[] A){
        Set<Integer> sequance=new HashSet<>();
        for (int i = 1; i <= x; i++) {
            sequance.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if(sequance.contains(A[i])){
                sequance.remove(Integer.valueOf(A[i]));
            }
            if(sequance.size()==0){
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
}
