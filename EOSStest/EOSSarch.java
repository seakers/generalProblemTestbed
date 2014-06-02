/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EOSStest;
import testbed.IArch;
import java.util.*;
import testbedInternals.absTree;

/**
 *
 * @author nkner_000
 */
public class EOSSarch extends absTree implements IArch{
    public EOSSarch(String s){
        super(Arrays.asList(parseStr(s)));
    }
    public static Orbit[] parseStr(String s){
        Orbit[] orbs=new Orbit[4];
        for(int i=0; i<orbs.length; i++)
            orbs[i]=new Orbit(s.substring(i*7,(i+1)*7));
        return orbs;
    }
}
