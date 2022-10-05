package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);//Why sort candidates?
        dfs(res, new ArrayList<Integer>(), candidates, 0, 0, target);
        return res;
    }

    private static void dfs(List<List<Integer>> res,List<Integer> cur,int[] candidates,
                                           int curSum, int idx, int target ){
        //success
        if(curSum == target){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        //fail
        if(idx> candidates.length ||curSum>target)
            return;

        for(int i = idx; i < candidates.length; i++){ // why i=idx? not i =0? only find letter after
            cur.add(candidates[i]);
            dfs(res, cur,candidates,curSum+candidates[i], i,target);
            cur.remove(cur.size()-1);// does this change curSum? nope
        }

    }

    public static void main(String[] args) {

    }
}
