package iluo.javaCoreTech.Unit5;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.TreeSet;

public class ClassEqual {
    public static void main(String[] args){
        AbstractSet<Integer> abstractSet = new HashSet<>();
        AbstractSet<Integer> abstractSet1 = new TreeSet<>();
        System.out.println(abstractSet.equals(abstractSet1));
    }
}
