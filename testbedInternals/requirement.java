/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import testbed.ICapable;
import testbed.IFunctor;
import testbed.IGoal;
import testbed.ISatisfy;
import testbed.ITree;

/**
 *
 * @author nkner_000
 */
public abstract class requirement implements ISatisfy, IGoal{
    
    /**
     * @return null. requirements are LEAVES!!!
     */
    @Override
    public ArrayList<ITree> getChildren() {
        return null;
    }

    @Override
    public Object treeExec(IFunctor onEach, IFunctor aggregate) {
        return null;
    }
    
    /**
     * 
     * @return the domain [0,1] with a discrete set of values. 0 is FALSE, 1 is TRUE.
     */
    @Override
    public TreeSet<Interval> domain() {
        Interval res=new Interval(0,1,true);
        TreeSet<Interval> tmp=new TreeSet<>();
        tmp.add(res);
        return tmp;
    }

    @Override
    public RealOptima utility(double satLvl) {
        return new RealOptima(1);
    }

    @Override
    public Object eval(Object o) {
        return this.isSatisfy((Collection<ICapable>) o);
    }
}