/*
 * Generates a list of capabilities. In the documentation this is the "Capability Function"
 */

package testbed;
import java.util.*;
import java.util.function.Function;

/**
 *
 * @author nkner_000
 */
public interface ICapableGen extends Function<IElement, Collection<ICapable>>{
//    
// public Collection<ICapable> getCapabilities(IElement e); //consider outputting a Collection rather than a list.
}
