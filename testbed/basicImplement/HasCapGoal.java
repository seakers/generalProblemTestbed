/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.basicImplement;
import testbed.basicImplement.BooleanSatisfy;
import java.util.Collection;
import java.util.TreeSet;
import testbed.*;
import testbed.abstractClass.Interval;
import testbed.abstractClass.Requirement;

/**
 *
 * @author nkner_000
 */
public class HasCapGoal extends Requirement{
    ICapable want;
    String name;

    public HasCapGoal(ICapable want, String name) {
        this.want = want;
        this.name = name;
    }

    public HasCapGoal(ICapable want) {
        this.want = want;
        name=want.getName();
    }
    
    
    /**
     * satisfy our goal iff the desired capability is in the collection of capabilities c
     * @param c
     * @return 
     */
    @Override
    public ISatisfy isSatisfy(Collection<ICapable> c) {
        if(null==c) return new BooleanSatisfy(false);
        return new BooleanSatisfy(c.contains(want));
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RealSet domain() {
        return BooleanSatisfy.staticDomain();
    }

    @Override
    public double utility(double satLvl) {
        return BooleanSatisfy.staticUtility(satLvl);
    }

    @Override
    public double optUtilArg() {
        return BooleanSatisfy.staticOptUtilArg();
    }
    
}
