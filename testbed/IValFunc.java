/*
 * A Function that takes an architecture ans scores it.
 */

package testbed;

/**
 *
 * @author nkner_000
 */
public interface IValFunc extends IFunctor{
	public double[] getMetrics(IArch a);
}
