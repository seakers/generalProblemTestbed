/*
 * A function that maps capabilities into satisfaction levels (assumed real)
 */

package testbed;
import java.util.TreeSet;
import testbedInternals.Interval;
import testbedInternals.RealOptima;

/**
 *
 * @author nkner_000
 */
public interface ISatisfy extends IFunctor{
    public double satLvl();
    public TreeSet<Interval> domain(); //gives a set of intervals that describe a goal.
    public RealOptima utility(double satLvl); //encodes more is better, less is better...
}