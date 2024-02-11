package datastructure;

public class Combination2 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        boolean[] visited = new boolean[array.length];
        int r = 2;
        combination(array,visited,0,0,r);
    }

    private static void combination(int[] array, boolean[] visited, int start, int depth, int r) {
        if(depth == r) {
            for (int i = 0; i < array.length; i++) {
                if(visited[i]) {
                    System.out.print(array[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(array,visited,i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

}
