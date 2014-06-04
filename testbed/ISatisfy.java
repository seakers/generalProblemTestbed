/*
 * A function that maps capabilities into satisfaction levels (assumed real)
 */

package testbed;
import java.util.*;
import testbedInternals.Interval;
import testbedInternals.RealOptima;
import java.util.function.Function;

/**
 *
 * @author nkner_000
 */
public interface ISatisfy extends Function<Collection<IPerf>, Double>{
    //public double apply (Collection<IPerf> c); //compute satisfaction level.
    public TreeSet<Interval> domain(); //gives a set of intervals that describe a goal.
    public RealOptima utility(double satLvl); //encodes more is better, less is better...
}