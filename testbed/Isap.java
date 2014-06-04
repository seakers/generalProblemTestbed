/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed;

import java.util.TreeSet;

/**
 *
 * @author nkner_000
 */
public interface Isap extends IArch{
    public IValFunc getProblem ();
    public IElement getRootElement();
    
    public TreeSet<Element> getElement_hierarchy() {
        return element_hierarchy;
    }

    public void setElement_hierarchy(TreeSet<Element> element_hierarchy) {
        this.element_hierarchy = element_hierarchy;
    }

    public TreeSet<Goal> getGoal_hierarchy() {
        return goal_hierarchy;
    }

    public void setGoal_hierarchy(TreeSet<Goal> goal_hierarchy) {
        this.goal_hierarchy = goal_hierarchy;
    }

    public SAPClass getType() {
        return type;
    }
    
}

}
