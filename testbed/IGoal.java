/*
 * An interface defining a goal--which decomposes a goal-based Satisfaction Funciton
 */

package testbed;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public interface IGoal extends ITree{
    public boolean isSatisfy(Collection<ICapable> c);
    public Function<ISatisfy> aggregation(ISatisfy )
}