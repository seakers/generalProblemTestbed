/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed;
import java.util.ArrayList;

/**
 *
 * @author nkner_000
 */
public interface ITree {
    public ArrayList<ITree> getChildren();
    
    /**
     * 
     * @param onEach: A function to execute on each node
     * @param aggregate: A function to execute between calls to aggregate results.
     *        Should take a 2 element array of objects where the 1st is a cumulative 
     *        result and the 2nd is to be included.
     * @param Params: Constant parameters.
     * @return The result of all the aggregations.
     */
    public Object treeExec(IFunctor onEach, IFunctor aggregate);
}
