/*
 * An interface defining a goal--which decomposes a goal-based Satisfaction Funciton
 */

package testbed;
import java.util.*;
import java.util.function.*;

/**
 *
 * @author nkner_000
 */
public interface IGoal extends ITree{
    public ISatisfy isSatisfy(Collection<ICapable> c);
    public ISatisfy aggregation(IGoal a, IGoal b);
    public String getName();
}