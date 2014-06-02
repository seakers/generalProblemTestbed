/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.*;
import java.util.function.*;
import testbed.ITree;

/**
 *
 * @author nkner_000
 */
public abstract class absTree implements ITree{
    List<ITree> children;

    public absTree(List<ITree> children) {
        this.children = children;
    }
    public absTree() {
        this.children=new ArrayList<>(0); //create empty to avoid null pointers.
    }
    
    @Override
    public ITree[] getChildren(){
        return (ITree[]) children.toArray();
    }
    
    @Override
    public Object treeExec(Function onEach, BiFunction aggFunc){ // execectues the functor on every element in the tree
        Object holdover=onEach.apply(this);
        
        //ASSERT: Foreach loop will not execute if no children.
        for(ITree node: children) //left-side traversal.
            holdover=aggFunc.apply(holdover, node.treeExec(onEach,aggFunc));
        return holdover;
    }
    
    /**
     * Used to generate a string to represent the object.
     * Implemented instead of toString to force clients to 
     * @return A string concatenating all the toStrings.
     */
    public String thisAndChildStr(){
        return (String) this.treeExec(new strExec(), new strConcat());
    }
        protected static class strExec implements Function<absTree, String>{
            public String apply(absTree a){
                return a.toString();
            }
        }
        protected static class strConcat implements BiFunction<String, String, String>{
            public String apply(String s1, String s2){
                return s1+s2;
            }
        }
}
