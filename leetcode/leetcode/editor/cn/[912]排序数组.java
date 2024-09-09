//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
//
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 981 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        fastSort(nums,0,nums.length-1);
        return nums;
    }

    private void fastSort(int[] nums, int l, int r){
        if(l >= r)  return;
        int baseIndex = partition(nums,l,r);
        fastSort(nums,l,baseIndex-1);
        fastSort(nums,baseIndex+1,r);
    }

    private int partition(int[] nums, int l, int r){
        int baseIndex = l + (r - l) / 2;
        int base = nums[baseIndex];
        swap(nums,l,baseIndex);
        int start = l;
        while(l <= r){
            while(l < r && nums[r] >= base)  r--;
            while(l < r && nums[l] <= base)  l++;
            if(l == r)  break;
            swap(nums,l,r);
        }
        swap(nums,start,l);
        return l;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//堆排序,时间O(nlogn),空间O(1)
/*class Solution {
    public int[] sortArray(int[] nums) {
//        int len = nums.length;
//        for (int i = 0; i < len; i++) { //上浮
//            swim(nums,i);
//        }
        for(int i = nums.length/2-1; i >= 0; i--){
            sink(nums,i,nums.length);
        }
        for(int i = nums.length - 1; i > 0; i--){
            swap(nums,i,0);
            sink(nums,0,i);
        }
        return nums;
    }

    private void sink(int[] nums, int i, int len){
        int j = (i + 1) * 2 - 1;
        while(j < len){
            if(j + 1 < len && nums[j+1] > nums[j])  j++;
            if(nums[i] < nums[j]){
                swap(nums,i,j);
                i = j;
                j = (i + 1) * 2 - 1;
            }else{
                break;
            }
        }
    }

    private void swim(int[] nums, int i){
        while(i > 0 && nums[i] > nums[(i-1)/2]){
            swap(nums,i,(i-1)/2);
            i = (i-1) / 2;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}*/



//快速排序
/*class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r){
        if(l >= r)  return;
        int index = partition(nums,l,r);
        quickSort(nums,l,index-1);
        quickSort(nums,index+1, r);
    }

    private int partition(int[] nums, int l, int r){
        int mid = l + (r - l) / 2;
        if(nums[l] > nums[r]) swap(nums,l,r);
        if(nums[mid] > nums[l]) swap(nums,l,mid);
        if(nums[mid] > nums[r]) swap(nums,r,mid);//将中间的数放在第一个

        int base = nums[l];
        int start = l;
        while(l < r){
            while(l < r && nums[r] >= base) r--;
            while(l < r && nums[l] <= base) l++;
            if(l == r)  break;
            swap(nums,l,r);
        }
        swap(nums,start,l);
        return l;
    }

    public void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}*/

//归并排序
/*class Solution {
    int[] tmp;

    public int[] sortArray(int[] nums) {
        this.tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums,int l, int r){
        if(l >= r)  return;
        int mid = l + (r - l) / 2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);

        int i = l,j = mid + 1;
        int count = 0;
        while(i <= mid && j <= r){
            if(nums[i] < nums[j]){
                tmp[count++] = nums[i++];
            }else{
                tmp[count++] = nums[j++];
            }
        }
        while(i <= mid) tmp[count++] = nums[i++];
        while(j <= r)   tmp[count++] = nums[j++];

        for(i = 0; i <= r-l; i++){
            nums[l+i] = tmp[i];
        }
    }
}*/

//leetcode submit region end(Prohibit modification and deletion)
