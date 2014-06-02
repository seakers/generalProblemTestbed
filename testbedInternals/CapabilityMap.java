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
public class CapabilityMap implements ICapableGen{
    Map<IElement, Collection<ICapable>> capMap;
    
    @Override
    public Collection<ICapable> apply(IElement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}