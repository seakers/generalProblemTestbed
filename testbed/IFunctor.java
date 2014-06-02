/*
 * A generic class to hold a function that maps one thing to another.
 * It is expected that classes which inherit from this class will create their
 *    own funciton names and then just cast into the appropriate types to 
 *    satisfy this interface. Doing so allows for type-checking.
 */

package testbed;

/**
 *
 * @author nkner_000
 */
public interface IFunctor {
    public Object eval(Object o);
}
