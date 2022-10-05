package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC78 {
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>>  res =  new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private static void dfs( List<List<Integer>> res, List<Integer> cur, int[] nums, int idx ){
        //success
        res.add(new ArrayList<Integer> (cur));


        for(int i = idx; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(res, cur, nums, i+1);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] test= {1,2,3};
        List<List<Integer>> result = subsets(test);
        System.out.println(result);

    }
}

