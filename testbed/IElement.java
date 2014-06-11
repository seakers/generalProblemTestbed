/*
 * A decomposition of an architecture.
 * A feature of a solution.
 */

package testbed;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public interface IElement extends ITree{
    //TODO: consider instead getting a set of alternates from the architecture
    public Tree<Collection<IElement>> getAlts(); //gets a set of elements that can be used instead of this one
}
