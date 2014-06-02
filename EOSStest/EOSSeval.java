/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EOSStest;
import testbed.IArch;
import testbed.IValFunc;

/**
 *
 * @author nkner_000
 */
public class EOSSeval implements IValFunc{

    @Override
    public double[] getMetrics(IArch a) {
        
    }

    @Override
    public Object eval(Object o) {
        return getMetrics((IArch) o);
    }
    
}