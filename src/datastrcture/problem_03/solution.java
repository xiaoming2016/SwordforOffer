package datastrcture.problem_03;

public class solution {
    public boolean duplicate(int [] arr){
        // 判断数组是否为空
        if(arr == null || arr.length <= 0){
            return false;
        }
        // 题目要求
        for(int i = 0;i<arr.length;i++){
            if(arr[i] < 0 || arr[i] > arr.length - 1){
                return false;
            }
        }
        for (int i = 0;i < arr.length; i++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    return true;
                }
                int temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        solution test = new solution();
        System.out.println(test.duplicate(arr));
    }
}
