/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed;

import java.util.*;
import testbedInternals.Interval;
import testbedInternals.RealOptima;

/**
 * A simple satisfaction space where the 
 * @author nkner_000
 */
public class DiscSat implements ISatisfy{
    private SortedSet<Double> domainArr;
    private double[] utilsArr; //ASSERT: utilsArr.length==domainArr.size()
    
    @Override
    public TreeSet<Interval> domain() {
        return new TreeSet<Interval>(domainArr);
    }

    @Override
    public double utility(double satLvl) {
        
    }

    @Override
    public double optUtilArg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
