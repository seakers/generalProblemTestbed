/*
 * represents a real valued satisfaction level on a continuous interval [-\infty, +\infty]
 * which prefers to get as large as possible.
 */

package testbed.basicImplement;
import testbed.*;
import testbed.abstractClass.*;

/**
 *
 * @author nkner_000
 */
public class realSatisfy implements ISatisfy{

    @Override
    public RealSet domain() {
        return new Interval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
    }

    @Override
    public double utility(double satLvl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double optUtilArg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
