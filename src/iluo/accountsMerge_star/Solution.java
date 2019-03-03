package iluo.accountsMerge_star;
import java.lang.reflect.Array;
import java.util.*;

/**
 * HashMap<email,email>
 * HashMap<email,owner>
 * HashMap<root,set<email>>
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String,String> root = new HashMap<>();
        HashMap<String,String> owner = new HashMap<>();
        HashMap<String, Set<String>> m = new HashMap<>();

        for(List<String> emailList:accounts){
            for(int i = 1; i< emailList.size();i++){
                root.put(emailList.get(i),emailList.get(i));
                owner.put(emailList.get(i),emailList.get(0));
            }
        }

        for(List<String> emailList:accounts){
            String p = find(emailList.get(1),root);
            for(int i = 2;i < emailList.size();i++){
                root.put(find(emailList.get(i),root),p);
            }
        }

        for(List<String> emailList:accounts){
            for(int i = 1; i< emailList.size();i++){
                String key = find(emailList.get(i),root);
                Set<String> tempM = new HashSet<>();
                if(m.containsKey(key)){
                    tempM = m.get(key);
                }
                tempM.add(emailList.get(i));
                m.put(key,tempM);
            }
        }

        for(String key:m.keySet()){
            Set<String> emailSet = m.get(key);
            String[] list = emailSet.toArray(new String[emailSet.size()]);
            Arrays.sort(list);
            List<String> reslist = new ArrayList<>(Arrays.asList(list));
            String own = owner.get(reslist.get(0));
            reslist.add(0,own);
        }

        return res;
    }

    private String find(String s,HashMap<String,String> root){
        return root.get(s).equals(s) ? s : find(root.get(s),root);
    }

    public static void main(String[] args){
        Solution solution = new Solution();
    }



}
