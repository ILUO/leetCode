package iluo.util;

import java.util.List;

/**
 * Created by Yang Xing Luo on 2019/2/18.
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
