//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes

public class Solution_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // if(root == null)
        //     return result;

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);
        // while(!q.isEmpty()){
        //     int currLevelNodes = q.size();
        //     List<Integer> li = new ArrayList<>();
        //     for(int i = 0; i < currLevelNodes; i++){
        //         TreeNode curr = q.remove();
        //         li.add(curr.val);
        //         if(curr.left != null)
        //             q.add(curr.left);
        //         if(curr.right != null)
        //             q.add(curr.right);
        //     }
        //     result.add(li);
        // }
        // return result;
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;

        if(level == result.size())
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level+1, result);
        dfs(root.right, level+1, result);
    }

}
