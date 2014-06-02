/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.ArrayList;
import testbed.IFunctor;
import testbed.ITree;

/**
 *
 * @author nkner_000
 */
public abstract class absTree implements ITree{
    ArrayList<ITree> children;
    
    @Override
    public ArrayList<ITree> getChildren(){
        return children;
    }
    
    @Override
    public Object treeExec(IFunctor onEach, IFunctor aggFunc){ // execectues the functor on every element in the tree
        Object holdover=onEach.eval(this);
        
        //ASSERT: For each will no execute if no children.
        for(ITree node: children){ //left-side traversal.
            Object[] grp={holdover,node.treeExec(onEach,aggFunc)};
            holdover=aggFunc.eval(grp);
        }
        return holdover;
    }
    
    /**
     * Used to generate a string to represent the object.
     * Implemented instead of toString to force clients to 
     * @return A string concatenating all the toStrings.
     */
    public String meAndKidString(){
        return (String) this.treeExec(new strExec(), new strConcat());
    }
        protected static class strExec implements IFunctor{
            public Object eval(Object o){
                return strEval((absTree) o);
            }

            public static String strEval(absTree a){
                return a.toString();
            }
        }
        protected static class strConcat implements IFunctor{
            public Object eval(Object o){
                return concat((String[]) o);
            }
            private static String concat(String[] strs){
                return strs[1]+strs[2];
            }
        }
}
