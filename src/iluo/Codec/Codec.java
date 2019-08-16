package iluo.Codec;

import iluo.util.TreeNode;

import java.util.*;

/**
 * Created by Yang Xing Luo on 2019/8/15.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        return serializeCore(root,res);
    }


    private String serializeCore(TreeNode root,String res){
        if(root == null) res = res + "," + "null";
        else{
            res = res + "," +root.val;
            res = serializeCore(root.left,res);
            res = serializeCore(root.right,res);
        }
        return res;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.split(",");
        List<String> dataNums = new ArrayList<>(Arrays.asList(nums));
        return deserializeCore(dataNums);
    }

    private TreeNode deserializeCore(List<String> dataNums){
        if(dataNums.get(0).equals("null")){
            dataNums.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataNums.get(0)));
        dataNums.remove(0);
        root.left = deserializeCore(dataNums);
        root.right = deserializeCore(dataNums);
        return root;
    }

    public static void main(String[] args){
        Codec codec = new Codec();
        TreeNode node = new TreeNode(0);
        int[] pre = {1};
        int[] in = {1};
        TreeNode root = node.reConstructBinaryTree(pre,in);
        System.out.println(codec.serialize(root));
        TreeNode res = codec.deserialize("5,2,null,null,3,2,3,null,null,1,null,null,4,null,null");
        System.out.println(res);
    }
}
