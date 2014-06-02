/*
 *A real interval. Use minLim>maxLim  to indicate an empty interval.
 */

package testbedInternals;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public class Interval implements Collection {
    public double minLim;
    public double maxLim;

    public Interval(double left, double right) {
        this.minLim = left;
        this.maxLim = right;
    }
    
    public boolean contains(double d){
        return minLim<=d && maxLim>=d;
    }
    
    public boolean isLeftBound(){
        return Double.isFinite(minLim);
    }
    
    public boolean isRightBound(){
        return Double.isFinite(maxLim);
    }
    
    public boolean fullyBound(){
        return isLeftBound() && isRightBound();
    }

    /**
     * Technically infinity, returns maximum integer size as a hack.
     * @return Integer.MAX_VALUE or 0 is empty
     */
    @Override
    public int size() {
        return this.isEmpty()? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return minLim>maxLim;
    }

    @Override
    public boolean contains(Object o) {
        Double conv=(Double) o;
        return this.contains(conv.doubleValue());
    }

    /**
     * iterates through the bound of the interval
     * DOES NOT HIT EVERY REAL BETWEEN MIN AND MAX
     * @return an iterator that goes through the min and max values.
     */
    @Override
    public Iterator iterator() {
        Double[] tmp={minLim, maxLim};
        return Arrays.asList(tmp).iterator();
    }

    @Override
    public Object[] toArray() {
        Double[] out={minLim, maxLim};
        return out;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if(a.length<2)
            return (Object[]) Arrays.copyOf(this.toArray(), 2);
        
        System.arraycopy(this.toArray(), 0, a, 0, 2);
        if(a.length > 2){
            for(int i=2; i<a.length; i++)
                a[i]=null;
        }
        return a;
        //see: http://stackoverflow.com/questions/6542242/java-list-toarrayt-a-implementation
    }

    /**
     * increases the size of the interval to include the input value
     * @param e: A Double that needs to be included in the interval.
     * @return iff the interval has changed to accomodate e.
     */
    @Override
    public boolean add(Object e) {
        if(!this.contains(e)){
            Double tmp=(Double) e;
            minLim=Math.min(tmp,minLim);
            maxLim=Math.max(tmp,maxLim);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * removes a number from the interval...Hahaha.
     * You can NEVER remove enough reals to actually change anything. Nice try.
     * To remove a set of numbers adjust the min or max with set methods.
     * @return false
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for(Object d:c){
            Double dd=(Double) d;
            if(!this.contains(dd))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean out=false;
        for(Object d:c)
            out=this.add(d);
        return out;
    }

    /**
     * NO FINITE NUMBER OF REMOVES WILL EVER CHANGE THE INTERVAL!!!
     * @param c who cares?
     * @return false
     */
    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    /** 
     * Can't actually have a finite interval with anything other than a singleton c
     * @throws UnsupportedOperationException
     */
    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("can't have a finite interval");
    }

    @Override
    public void clear() {
        minLim=1;
        maxLim=-1;
    }
}