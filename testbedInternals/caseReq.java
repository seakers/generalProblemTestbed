/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.*;
import java.util.function.BiFunction;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class caseReq extends multiAttrReq{

    @Override
    protected ISatisfy satLvlMulti(Collection<IPerf> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BiFunction<IGoal, IGoal, ISatisfy> aggregation(IGoal a, IGoal b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
