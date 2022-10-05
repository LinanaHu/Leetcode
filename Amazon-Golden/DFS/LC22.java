package DFS;

import com.intellij.codeInsight.daemon.impl.quickfix.IgnoreExtResourceAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LC22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs( res, new StringBuilder(), n, 0,0, 0);
        return res;
    }
    private static void dfs(List<String> res, StringBuilder sb, int n, int step, int left, int right){
        //success
        if(step == n*2 && left == right){
            String s= sb.toString();
            res.add(s);
            return;
        }
        //fail
        if (step > n*2  || left > n || left < right) {
            return;
        }
//How to improve the code efficiency?
//        if( left < n ){

        sb.append("(");
        dfs(res, sb, n, step + 1, left + 1, right);
        sb.setLength(sb.length()-1);

//        if (left > right);
        sb.append(")");
        dfs(res, sb, n, step+1, left, right+1);
        sb.setLength(sb.length()-1);

    }



}