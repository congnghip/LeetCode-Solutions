
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Codec {
    String X ="X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //Nếu là null thì truyển vào x
        if (root == null)
        {
            return X;
        }
        //dfs
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }
    String[] arr;
    int index = 0;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // chuyển dạng chuổi thành dạng có thể gọi các kí thự theo index
        arr = data.split(",");
        return dfs();
    }
    private TreeNode dfs()
    {
        //nếu gặp X thì rả về null
        if (arr[index].equals(X))
        {
            index++;
            return null;
        }
        //tạo các node mới và đưu vào cây
        TreeNode node = new TreeNode(Integer.parseInt(arr[index++]));
        //tiếp tục tạo 2 node con cho node chính
        node.left = dfs();
        node.right = dfs();
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));