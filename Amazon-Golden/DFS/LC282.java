package DFS;

import java.util.List;
import java.util.ArrayList;

public class LC282 {
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(res, num, 0, 0,new StringBuilder(), target);
        return res;

    }

    private static void dfs( List<String> res, String num, long last, long curVal, StringBuilder sb, int target){
        int length = num.length();
        //success
        if(length == 0 && curVal == target) {
            res.add(sb.toString());
            return;
        }
        if(length == 0) return;

        int current; //=  num.charAt(idx);
        int size = sb.length();
        long val =0;
        for(int i=0; i < length; i++) {
            val = 10 * val + num.charAt(i) - '0'; //

            if(sb.length()!=0) {
                //+
                sb.append("+").append(val);
                dfs(res, num.substring(i + 1), val, curVal +val, sb, target);
                sb.setLength(size);

                //-
                sb.append("-").append(val);
                dfs(res, num.substring(i + 1), -val, curVal -val, sb, target);
                sb.setLength(size);

                //*
                sb.append("*").append(val);
                dfs(res, num.substring(i + 1), last * val, curVal -last +last*val, sb, target);
                sb.setLength(size);

            }else{
                dfs(res, num.substring(i + 1), val, curVal +val,  sb.append(val), target);
                sb.setLength(size);
            }
            if(val == 0) break; //what this does?
        }
    }

    public static void main(String[] args) {
        String num ="3456237490";
        addOperators(num, "9191");
    }
}
