/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DownSelect;
import java.util.*;
import testbed.*;
import testbedInternals.*;

/**
 * WARNING. USES A SINGLE HasCapPerfAtt PERFORMANCE ATTRIBUTE--MODIFY TO GENERALIZE
 * @author nkner_000
 */
public class DScapability implements ICapable{
    private HasCapPerfAtt h;
    private String name;
    
    public DScapability(String name) {
        this.name = name;
        h=new HasCapPerfAtt(this);
    }
    
    @Override
    public Collection<IPerf> getPerfAttr() {
        ArrayList<IPerf> out=new ArrayList<>();
        out.add(h);
        return out;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof DScapability))
            return false;
        return name.equals(o);
    }
    
    @Override
    public int hashCode(){
        return name.hashCode();
    }
    
    @Override
    public String toString(){
        return name;
    }
}
