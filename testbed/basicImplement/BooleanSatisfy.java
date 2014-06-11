/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.basicImplement;
import java.util.TreeSet;
import testbed.*;
import testbed.abstractClass.DiscInterval;
import testbed.abstractClass.Interval;
/**
 *
 * @author nkner_000
 */
public class BooleanSatisfy implements ISatisfy{
    boolean value;

    public BooleanSatisfy(boolean value) {
        this.value = value;
    }
    
    
    @Override
    public TreeSet<Interval> domain() {
        return staticDomain();
    }

    @Override
    public double utility(double satLvl) {
        return staticUtility(satLvl);
    }

    @Override
    public double optUtilArg() {
        return staticOptUtilArg();
    }

    public static TreeSet<Interval> staticDomain() {
        TreeSet<Interval> out;
        out=new TreeSet<>();
        out.add(new DiscInterval(0));
        out.add(new DiscInterval(1));
        
        return out;
    }

    public static double staticUtility(double satLvl) {
        return satLvl;
    }

    public static double staticOptUtilArg() {
        return 1;
    }
}