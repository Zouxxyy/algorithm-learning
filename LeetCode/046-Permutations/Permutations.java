/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

/*
回溯算法
*/

class Solution {
    private List<List<Integer>> ret = new ArrayList();
    private List<Integer> oneret = new ArrayList();
    
    public List<List<Integer>> permute(int[] nums) {
        repermute(nums);
        return ret;
    }
    
    public void repermute(int[] nums) {
        if(oneret.size() == nums.length)
            ret.add(new ArrayList(oneret));
        else{
            for(int num: nums){
                if(!oneret.contains(num)) {
                    oneret.add(num);
                    repermute(nums);
                    oneret.remove(oneret.size() - 1);
                }
            }
        }
    }
}