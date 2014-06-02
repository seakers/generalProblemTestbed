/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import java.util.*;
import testbed.*;
import java.util.function.*;

/**
 *
 * @author nkner_000
 */
public class SynergyCapableGen implements ICapableGen{
    private ICapableGen base;
    private IEmergence emergeGen;

    public SynergyCapableGen(ICapableGen base, IEmergence Capability) {
        this.base = base;
        this.emergeGen = Capability;
    }

    @Override
    public Collection<ICapable> apply(IElement e) {
        TreeSet<ICapable> out=new TreeSet<>();
        out.addAll(base.apply(e));
        out.addAll(emergeGen.apply(out));
        return out;
    } 

    public ICapableGen getBase() {
        return base;
    }

    public void setBase(ICapableGen base) {
        this.base = base;
    }

    public IEmergence getEmergeGen() {
        return emergeGen;
    }

    public void setEmergeGen(IEmergence emergeGen) {
        this.emergeGen = emergeGen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.base);
        hash = 23 * hash + Objects.hashCode(this.emergeGen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SynergyCapableGen other = (SynergyCapableGen) obj;
        if (!Objects.equals(this.base, other.base)) {
            return false;
        }
        if (!Objects.equals(this.emergeGen, other.emergeGen)) {
            return false;
        }
        return true;
    }
    
    
}
