/*
 * A class indicating the location of an optima of a real valued funciotn
 * use loc=Double.POSITIVE_INFINITY or loc=Double.NEGATIVE_INFINITY for unboud optima.
 * use val=Double.Inf will create a best possible optima. Usually can ignore actual value.
 */

package testbedInternals;

/**
 *
 * @author nkner_000
 */
public class RealOptima {
    double loc;
    double val;

    public RealOptima(double loc, double val) {
        this.loc = loc;
        this.val = val;
    }

    public RealOptima(double loc) {
        this.loc = loc;
        this.val=Double.POSITIVE_INFINITY;
    }    
    
}
