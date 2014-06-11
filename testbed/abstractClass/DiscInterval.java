/*
 * A discrete interval. The basic behaviors (bound, etc) follow from the encapsulating real interval.
 */

package testbed.abstractClass;

import java.util.Arrays;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public class DiscInterval extends Interval{
    TreeSet<Double> elems;
    
    public DiscInterval(double element){
        super(element, element);
    }
    
    public DiscInterval(Collection<Double>elements){
        super(min(elements), max(elements));
        elems=new TreeSet<>(elements);
    }
    
    @Override
    public int size() {
        return elems.size();
    }
    
    @Override
    public boolean contains(double d){
        return elems.contains(d);
    }
    
    @Override
    public boolean contains(Object o) {
        Double conv=(Double) o;
        return this.contains(conv.doubleValue());
    }
    
    @Override
    public boolean isEmpty() {
        return 0==this.size();
    }
    
    public static double min(Collection<Double> c){
        double out=Double.POSITIVE_INFINITY;
        for(double d:c)
            if(d < out)
                out=d;
        return out;
    }
    
    public static double max(Collection<Double> c){
        double out=Double.POSITIVE_INFINITY;
        for(double d:c)
            if(d > out)
                out=d;
        return out;
    }
    
    public double getMin(){
        return minLim;
    }
    public double getMax(){
        return maxLim;
    }
}
