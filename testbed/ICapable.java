/*
 * A capability of the architecture
 * Bridges between the problem and the solution, but we consider this to be part of the solution.
 * ICapableGen is the problem part--it generates the capbilities for a given architecture
 *    relevant to the problem at hand.
 */

package testbed;
import testbed.IArch;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public interface ICapable {
    public Collection<IPerf> getPerfAttr();
    public String getName();
}
