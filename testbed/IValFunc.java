/*
 * A Function that takes an architecture ans scores it.
 * Defines the optimization problem
 */

package testbed;
import java.util.function.Function;

/**
 *
 * @author nkner_000
 */
public interface IValFunc extends Function<IArch, Double[]>{
	//public double[] getMetrics(IArch a);
}
