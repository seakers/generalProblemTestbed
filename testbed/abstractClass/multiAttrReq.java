/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.abstractClass;

import java.util.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public abstract class multiAttrReq extends absTree implements IGoal{
    Map<IPerf,PerfLevel> threshMap;
    String name;
    String discription;
    
    public class PerfLevel{
        SortedSet<IPerf> threshes;
        double[] vals; //ASSERT: threshes+1==vals.length
    }
      
/** IGoal Overrides **/
    /**
     * ASSUMES all performances are properly hashed and can be compared as such.
     *     it is anticipated that the standard performance attribute will have some kind
     *     of name and hence a possible hash function would just be to wrap the name string
     * @param c
     * @return 
     */
    @Override
    public ISatisfy isSatisfy(Collection<ICapable> c) {
        LinkedHashSet<IPerf> perfs=new LinkedHashSet<IPerf>();
        for(ICapable cap : c)
            perfs.addAll(cap.getPerfAttr());
        return satLvlMulti(perfs);
    }
    
    protected abstract double satLvlMulti(Collection<IPerf> c);
    
    private double satLvlSingle(IPerf p){
        PerfLevel satLvls=threshMap.get(p);
        if(null==satLvls)
            throw new IllegalArgumentException("performance attribute "+p+" is not in the lookup table of caseReq "+this.toString());
        
        return satLvls.vals[satLvls.threshes.headSet(p).size()];
    }

/** ISatisfy Overrides **/
    
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
