/*
 * A single orbit of the EOSS architecture.
 */

package EOSStest;
import java.util.*;
import testbed.IElement;
import testbed.abstractClass.absTree;

/**
 *
 * @author nkner_000
 */
public class Orbit extends absTree implements IElement{
    boolean[] instruments;
    double inclination;
    double altitude;
    
    public Orbit(String s){
        if(s==null)
            throw new IllegalArgumentException("input string is null to Orbit Constructor");
        if(s.length()!=7)
            throw new IllegalArgumentException(s.length()+" length string input to Orbit. Should be length 7");
        instruments=new boolean[7];
        for(int i=0; i<instruments.length; i++){
            char c=s.charAt(i);
            switch(c){
                case '0':
                    instruments[i]=false;
                case '1':
                    instruments[i]=true;
                default:
                    throw new IllegalArgumentException("string input to Orbit Constructor should be 0's and 1's only. Character "+i+" is "+c);
            }
        }
    }
    
    @Override
    public String toString(){
        return "inc:"+inclination+" alt:"+altitude+" instruments"+instStr();
    }
    
    public String instStr(){
        char[] out=new char[7];
        for(int i=0;i<instruments.length; i++){
            if(instruments[i])
                out[i]='1';
            else
                out[i]='0';
        }
        return new String(out);
    }
}
