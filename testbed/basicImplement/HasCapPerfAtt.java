/*
 * A marker for having a capability. Should not be compared to self or any other capability.
 */

package testbed.basicImplement;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class HasCapPerfAtt implements IPerf{
    ICapable parentCap; //if null we say that this corresponds to not having that capability.

    public HasCapPerfAtt(ICapable parentCap) {
        this.parentCap = parentCap;
    }
    
    
    @Override
    public int compareTo(Object o) {
        if(!(o instanceof HasCapPerfAtt))
            throw new IllegalArgumentException("can't compare HasCapPerfAtt "+this.toString()+" to "+o.toString());
        HasCapPerfAtt comp=(HasCapPerfAtt) o;
        if(comp.parentCap==null)
            if(this.parentCap==null)
                return 0;
            else
                return 1;
        else
            if(this.parentCap==null)
                return -1;
            else
                if(this.parentCap.equals(comp.parentCap))
                    return 0;
                else
                    throw new IllegalArgumentException("HasCapPerfAtt "+this.toString()+" has a different capability than"+comp.toString());
    }
    
    @Override
    public boolean equals(Object o){
        if(!(o instanceof HasCapPerfAtt))
            return false;
        HasCapPerfAtt comp=(HasCapPerfAtt) o;
        if(this.parentCap==null)
            return comp.parentCap==null;
        else
            return this.parentCap.equals(comp.parentCap);
    }
    
    @Override
    public int hashCode(){
        if(parentCap==null)
            return 0;
        else
            return this.parentCap.hashCode();
    }
    
}
