package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int idx ){
        res.add(new ArrayList<>(cur));
        for(int i = idx; i < nums.length; i++){
            //保证只能在开头（i=index)时， 选择连续重复的数字
            if(i> idx && nums[i] ==nums[i-1]) continue;//remove duplicate
            cur.add(nums[i]);
            dfs(res, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
