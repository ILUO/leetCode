package iluo.levelOrder;

import iluo.util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yang Xing Luo on 2019/2/18.
 */
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Node>> nodeList = new ArrayList<>();
        if(root == null){
            return result;
        }else{
            List<Node> firstLevel = new ArrayList<>();
            firstLevel.add(root);
            nodeList.add(firstLevel);
        }
        while(nodeList.size() != 0){
            List<Node> oneLevelNode = new ArrayList<>();
            List<Node> firstLevel = nodeList.get(0);
            List<Integer> integerList = new ArrayList<>();
            for(int i = 0;i < firstLevel.size();i++){
                Node node = firstLevel.get(i);
                List<Node> childrenList = node.children;
                if(childrenList != null){
                    for(int j = 0;j < childrenList.size();j++){
                        oneLevelNode.add(childrenList.get(j));
                    }
                }
                integerList.add(node.val);
            }
            if(oneLevelNode.size() != 0){
                nodeList.add(oneLevelNode);
            }
            result.add(integerList);
            nodeList.remove(0);
        }
        return result;
    }
}
