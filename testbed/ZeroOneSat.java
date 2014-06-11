/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed;

import java.util.TreeSet;
import testbed.abstractClass.Interval;
import testbed.abstractClass.RealOptima;

/**
 * A basic satisfaction space and utility on the real line between 0 and 1
 * We assume a linear utility of slope 1 and intersect 0
 * @author nkner_000
 */
public class ZeroOneSat implements ISatisfy{

    @Override
    public TreeSet<Interval> domain() {
        TreeSet<Interval> out=new TreeSet<>();
        out.add(new Interval(0,1));
        return out;
    }

    @Override
    public double utility(double satLvl) {
        return satLvl;
    }
    
    @Override
    public double optUtilArg(){
        return 1; // can also consider Double.POSITIVE_INFINITY
    }
}
