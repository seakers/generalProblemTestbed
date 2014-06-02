/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;
import testbed.Function;
import testbed.IGoal;
import testbed.ITree;
import testbed.ISatisfy;
import testbed.ICapable;

/**
 *
 * @author nkner_000
 */
public class caseReq extends requirement{
    double[] mins;
    double[] maxes;
    double[] satLvls;
    
    @Override
    public double satLvl() {
        
    }
    
    @Override
    public boolean isSatisfy(Collection<ICapable> c) {
        
    }
    
    private double satLvlSingle(){
    }
            
    /**
     * 
     * @return the domain [0,1] with a discrete set of values. 0 is FALSE, 1 is TRUE.
     */
    @Override
    public TreeSet<Interval> domain() {
        Interval res=new Interval(0,1);
        TreeSet<Interval> tmp=new TreeSet<>();
        tmp.add(res);
        return tmp;
    }

    @Override
    public RealOptima utility(double satLvl) {
        return new RealOptima(1);
    }
}
