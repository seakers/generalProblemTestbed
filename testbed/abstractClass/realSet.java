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
public class realSet implements Collection{
    ArrayList<Interval> intvls; //TODO: actually more efficient if keep an ordred set of numbers representing in/out of the set
    ArrayList<Double> refLow;
    ArrayList<Double> refHigh;

    /**
     * returns the number of discrete intervals in the collection (i.e. the number of discontinuities)
     * @return 
     */
    @Override
    public int size() {
        int total=0;
        for(Interval i : intvls)
            total+=i.size();
        return total;
    }
    
    public double measure() {
        double total=0;
        for(Interval i : intvls)
            total+=i.measure();
        return total;
    }

    @Override
    public boolean isEmpty() {
        for(Interval i : intvls)
            if(! i.isEmpty())
                return false;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for(Interval i : intvls)
            if(i.contains(o))
                return true;
        return false;
    }

    public boolean add(Double e) {
        if
            return false;
        if(null==e && this.contains(e))
            return false;
    }
    public boolean add(Interval i){
    }

    public boolean remove(Double e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean remove(Interval i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Iterator<Double> iterator() {
        
    }
}
