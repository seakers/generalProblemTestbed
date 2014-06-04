/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import testbed.ICapable;
import testbed.IGoal;
import testbed.ISatisfy;
import testbed.ITree;

/**
 *
 * @author nkner_000
 */
public abstract class requirement implements ISatisfy, IGoal{
    
    /**
     * @return empty list. requirements are LEAVES!!!
     */
    @Override
    public ITree[] getChildren() {
        return new ITree[0];
    }
    
    /**
     * applies the function onEach to this requirement.
     * This is a LEAF so there is no use of the aggregate function.
     * @param onEach
     * @param aggregate
     * @return 
     */
    @Override
    public Object treeExec(Function onEach, BiFunction aggregate){
        return onEach.apply(this);
    }
}