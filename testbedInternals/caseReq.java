/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class caseReq extends requirement{
    double[] mins;
    double[] maxes;
    double[] satLvls;
      
/** IGoal Overrides **/
    @Override
    public boolean isSatisfy(Collection<ICapable> c) {
        
    }
    
    private double satLvlSingle(){
        
    }

/** ISatisfy Overrides **/
    
    /**
     * finds the satisfaction level of the requirement.
     * @param t: a collection of performance attributes.
     * @return a double indicating the satisfaction level
     */
    @Override
    public Double apply(Collection<IPerf> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
