import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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
                    check.remove(check.size()-1);
                }
            } else if (chars[i] == '0') {
                count++;
            }
        }
        return max;
    }

    public static int[] CyclicRotation(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length==0)
            return A;

        for(int i=0;i<K;i++){

            int last =A[A.length-1];

            for(int j=A.length-1;j>0;j--){
                A[j] = A[j-1];
                // A[j]=A[j+1];
            }
            A[0] = last;
        }

        return A;
    }

    public static  int OddOccurrencesInArray(int[] A){
        boolean ispaired=false;
        int unpairedValue=0;
        List<Integer> list=new ArrayList<>();

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

}
