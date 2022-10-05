package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47 {
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(res, nums, new ArrayList<>(),new boolean[nums.length], 0);
        return res;

    }

    private static void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, boolean[] visited, int index) {
        //end of list?
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1] && !visited[i-1]){
                continue;
            }
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            dfs(res, nums, cur, visited, index + 1);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}
