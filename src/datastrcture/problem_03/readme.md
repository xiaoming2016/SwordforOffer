 数组中重复的数字
===========================================  
  
  
**题目一：找出数组中重复的数字**    

在一个长度为n的数组里所有的数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复
了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为9的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3.


**解题思路：**  

从头到尾一次扫描这个数组中的每个数字。当扫描到下标为*i*的数字时，我们将这个数字用m来表示，首先比较m是不是等于i。如果是，则
接着扫描下一个数字；如果不是，则拿它和第*m*个数字进行比较。如果它和第*m*个数字相等；就找到了一个重复的数字（该数字在下标为*i*
和*m*的位置都出现了）；如果它和第*m*个不相等，就把第*i*个数字和第*m*个数字交换，**把*m*放到属于它的位置**。接下来再重复比较、交换的过程，
直到我们发现一个重复的数字。

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

以数据{2,3,1,0,2,5,3}为例来分析找到重复数字的步骤。
1. 数组的第0个数字是2，它的下标为0，与它的下标不相等，于是把它和下标为2的数字1交换。
交换后的数组是{1,3,2,0,2,5,3}
2. 此时数组的第0个数字是1，仍然与它的下标不相等，继续把它和下标为1的数字3交换，得到数组{3,1,2,0,2,5,3}
3. 接下来继续交换第0个数字3和第三个数字0，得到数组{0,1,2,3,2,5,3}
4. 此时第0个数字的数值为0，接着扫描下一个数字。在接下来的几个数字中，下标为1,2,3,的三个数字分别为1,2,3,它们的下标和数值
都分别相等，因此不需要执行任何操作。
5. 接下来扫描到下标为4的数字2。由于它的数值与它的下标不相等，再比较它和下标为2的数字。注意到此时数组中下表为2的数字也是2，
也就是数字2在下标为2和下标为4的两个位置都出现了，因此找到一个重复的数字。