/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed;
import java.util.*;
/**
 *
 * @author nkner_000
 */
public interface IArchProbAware extends IArch{
    public IValFunc getSolves();
    public Set<ICapable> getCapabilities();
    public Set<IPerf> getPerfAttr();
}
