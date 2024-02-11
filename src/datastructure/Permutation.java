package datastructure;

// 순열은 순서가 중요하다 [1,2,3]과 [3,2,1]은 다른 값 이다 -> 즉, 순서가 중요!
// 순서가 중요하기 때문에 처음부터 for-loop가 시작되며 각 depth를 담기위한 output 배열이 필요하다.
// n은 배열의 길이라고 가정한다.
// https://bcp0109.tistory.com/14

public class Permutation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        boolean[] visited = new boolean[arr.length];
        int[] output = new int[3];
        permutation(arr,visited,output,0,3);
    }

    private static void permutation(int[] arr, boolean[] visited, int[] output, int depth, int r) {
        if(depth == r ) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr,visited,output,depth+1, r);
                visited[i] = false;
            }
        }
    }
}