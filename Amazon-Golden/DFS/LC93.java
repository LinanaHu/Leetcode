package DFS;

import java.util.ArrayList;
import java.util.List;

class LC93 {
    public List<List<Integer>> permute(int[] nums) {

    }
    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] nums, int level) {
        if(level == nums.length) {
            res.add(cur);
            return;
        }
        if(level>nums.length) return;

        for (int i = 0; i< nums.length; i++) {
            if()
        }
    }

}
    public static void main(String[] args) {
        List<String> result = restoreIpAddresses("25525511135");
        System.out.println(String.join(", ", result));
    }
}
