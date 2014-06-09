/*
 * An object in "satisfaction space" which is basically a number.
 * for booleans, use a discrete domain (like {0,1}) and adjust the functions accordingly.
 */

package testbed;
import java.util.*;
import testbedInternals.Interval;
import testbedInternals.RealOptima;
// import java.util.function.Function;

/**
 *
 * @author nkner_000
 */
//public interface ISatisfy extends Function<Collection<IPerf>, Double>{
public interface ISatisfy {
    //public double apply (Collection<IPerf> c); //compute satisfaction level.
    public TreeSet<Interval> domain(); //gives a set of intervals that describe a goal.
    public double utility(double satLvl); 
    public double optUtilArg(); //encodes more is better, less is better...
}