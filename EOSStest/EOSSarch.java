/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EOSStest;
import testbed.IArch;
import java.util.*;
import testbed.IElement;

/**
 *
 * @author nkner_000
 */
public class EOSSarch implements IArch{
    ArrayList<Orbit> orbs;
    
    public EOSSarch(String s){
        orbs=new ArrayList<>(4);
        for(int i=0; i<orbs.size(); i++)
            orbs.add(new Orbit(s.substring(i*7,(i+1)*7)));
    }
    
    @Override
    public TreeSet<IElement> getComponents(){
        return new TreeSet<>(orbs);
    }
}
