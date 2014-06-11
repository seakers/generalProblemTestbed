/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.Collection;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Function;
import testbed.*;
import testbedInternals.*;

/**
 *
 * @author nkner_000
 */
public class HasCapGoal extends requirement{
    ICapable want;
    String name;
    
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
    public TreeSet<Interval> domain() {
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
