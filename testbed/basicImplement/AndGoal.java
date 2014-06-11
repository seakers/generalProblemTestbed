/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.basicImplement;
import java.util.Collection;
import java.util.List;
import testbed.*;
import testbed.abstractClass.*;

/**
 *
 * @author nkner_000
 */
public class AndGoal extends AbsTree implements IGoal{

    public AndGoal(List<ITree> children) {
        super(children);
    }
    public AndGoal() {
    }


    /**
     * satisfied iff all children are satisfied--calls the children satisfaction recursively
     * @param c
     * @return 
     */
    @Override
    public ISatisfy isSatisfy(Collection<ICapable> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * satisfied iff children goals are satisfied. Assumes children return a Boolean Satisfaction
     * @param a
     * @param b
     * @return 
     */
    @Override
    public ISatisfy aggregation(IGoal a, IGoal b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * pretty durned obvious I hope.
     * @return 
     */
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
