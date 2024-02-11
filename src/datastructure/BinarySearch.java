package datastructure;

/**
 * 정렬된 배열에서 특정 값을 찾는 알고리즘 이다.
 * 탐색 범위를 절반씩 줄여가기 때문에 빠른 속도를 보장한다. -> 시간복잡도 o(logN)
 * 단, 데이터가 정렬되어 있어야 한다.
 * 자바 기본 라이브러리로 Arrays.binarySearch를 지원한다.
 *
 * https://adjh54.tistory.com/187
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {3,5,6,7,9};
        int findIdx = binarySearch(array, 7);
        System.out.println("findIndex = " + findIdx);

        int findRecurIdx = binarySearchRecursive(array,0, array.length-1, 7);
        System.out.println("recursive Index = " + findRecurIdx);

    }

    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int mid = 0;
        int right =  array.length-1;

        while(left <= right) {

            mid = (left + right) / 2;

            if(array[mid] == target) {
                return mid;
            }

            if(target < array[mid]) {
                right = mid - 1;
            } else if(target > array[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] array, int left, int right, int target) {
        if(left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if(target == array[mid]) {
            return mid;
        }

        if(target > array[mid]) {
            return binarySearchRecursive(array,mid+1,right,target);
        }else if(target < array[mid]) {
            return binarySearchRecursive(array,left,mid-1,target);
        }
        return -1;
    }
}
