package DFS;

import java.util.List;
import java.util.ArrayList;

public class LC46 {
    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();

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
            if (visited[i]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            dfs(res, nums, cur, visited, index + 1);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}
