class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map1 = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(map1.contains(nums[i])){
                return true;
            }
            map1.add(nums[i]);
        }
        return false;
    }
}
