/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import testbed.*;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public abstract class HeirarchalProblem implements IValFunc {
    ICapableGen capGen;
    IGoal rootGoal;
    /**
     * Here we break the problem into several pieces:
     * One is the mapping of elements to capabilities \/
     * -> Which is itself broken into a mapping of problems into goals \/
     * -> Which are then mapped onto performance attributes (see ISatisfy.java)
     * -> The initial set of capabilities is re-fed to create a new set according to emergence rules (not in this file).
     * The capabilities are examined compared to Goals
     * -> Goals are themselves a heirarchy that must be input
     * -> The 
     */
    
    /**
     * 
     * @param a an architecture to evaluate
     * @return returns a list of doubles which are the metrics of the architecture.
     */
    @Override
    public Double[] apply(IArch a) {
        Collection<ICapable> caps=capGen.apply(a);
        
    }
}
