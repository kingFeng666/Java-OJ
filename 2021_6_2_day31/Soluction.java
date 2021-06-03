输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public String[] permutation(String s) {
        //结果集合。这里之所有用set不用list。
        //主要原因是使用set可以主动去重，避免使用list每次判断是否存在某个元素。
        //其次题目不要求顺序。
        Set<String> res = new HashSet<>();
        //访问记录，便于过滤选择，做剪枝使用。
        boolean[] visited = new boolean[s.length()];
        //开始遍历
        dfs(s.toCharArray(), "", res, visited);

        //将结果修改返回格式。
        String[] realRes = new String[res.size()];
        int i = 0;
        for(String value : res) {
            realRes[i] = value;
            i++;
        }
        return realRes;
    }
    private void dfs(char[] chars, String path, Set<String> res, boolean[] visited) {
        //结束条件，如果当前选择字符串和题目给定字符串的长度一致则结束。
        if(path.length() == chars.length) {
            res.add(path);
            return;
        }
        //遍历所有可以选择的条件
        for(int i = 0; i < chars.length; i++) {
            //过滤掉已经选择的。
            if(visited[i]) {  
                continue;
            }
            //做出选择
            visited[i] = true;
            //递归进入下一层。
            dfs(chars, path + chars[i], res, visited);
            //回退选择
            visited[i] = false;
        }
    }
}