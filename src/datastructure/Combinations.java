package datastructure;

// 1. 조합은 순서가 중요하지 않다. 이미 뽑은 값은 뽑지 않는다.
// 2. 뽑았던 값은 고려하지 않으므로 start 변수가 필요하다.
// 3. output 변수는 필요하지 않다. 그때 그때 종료해서 처리하자. (있어도된다)
//    출력할때는 방문된 배열만 뽑아내야 하기 때문에 if문으로 체크해주자.
// 조합은 output 변수가 있어도 상관없다. start 변수는 반드시 필요하다.

public class Combinations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] output = new int[2];
        boolean[] visited = new boolean[arr.length];
        combination(arr,visited,output,0,0,2);
    }

    private static void combination(int[] arr, boolean[] visited, int[] output, int start, int depth, int r) {
        if(depth == r) {
            for (int i = 0; i < output.length; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                combination(arr,visited,output,i+1,depth+1,r);
                visited[i] = false;
            }
        }
    }
}
