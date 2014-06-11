/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.abstractClass;
import java.util.*;
/**
 *
 * @author nkner_000
 */
public class realSet implements Collection<Double>{
    ArrayList<Interval> reals;
    ArrayList<Double> refLow;
    ArrayList<Double> refHigh;

    /**
     * returns the number of discrete intervals in the collection (i.e. the number of discontinuities)
     * @return 
     */
    @Override
    public int size() {
        int total=0;
        for(Interval i : reals)
            total+=i.size();
        return total;
    }
    
    public double measure() {
        double total=0;
        for(Interval i : reals)
            total+=i.measure();
        return total;
    }

    @Override
    public boolean isEmpty() {
        for(Interval i : reals)
            if(! i.isEmpty())
                return false;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for(Interval i : reals)
            if(i.contains(o))
                return true;
        return false;
    }

    @Override
    public Iterator<Double> iterator() {
        
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Double e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends Double> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
