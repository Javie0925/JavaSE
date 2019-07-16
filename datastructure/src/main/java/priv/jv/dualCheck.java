package priv.jv;

/**
 * @author javie
 * @date 2019/7/2 15:19
 */
public class dualCheck {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int check = check(arr, 10);
        System.out.println(check);
    }

    public static int check(int[] arr,int a){

        int start = 0;
        int mid = arr.length/2;
        int end = arr.length-1;
        while (end>=start){
            if (arr[mid]==a){
                return mid;
            }else if (arr[mid]>a){
                end = mid-1;
                mid = (end+start)/2;
            }else {
                start = mid+1;
                mid = (end+start)/2;
            }
        }
        return -1;
    }
}
