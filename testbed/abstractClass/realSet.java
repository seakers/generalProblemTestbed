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
public class RealSet implements Collection<Double>{
    public static final int EFF_INF_INT=Integer.MAX_VALUE; //value used to represent infinity with an integer

    boolean negInfIn;
    ArrayList<limit> lims;
    SortedSet<Double> discVals;
    public class limit implements Comparable{
        public double val;
        public boolean inclusive;

        public limit(double val, boolean inclusive) {
            this.val = val;
            this.inclusive = inclusive;
        }

        @Override
        public int compareTo(Object o) {
            if(null==o)
                throw new NullPointerException();
            if(o instanceof Double)
                return (int) Math.signum(val-(Double) o);
            if(o instanceof limit)
                return (int) Math.signum(val-((limit) o).val);
            else
                throw new IllegalArgumentException();
        }

    }
    public class limDblCmp implements Comparator{

        @Override
        public int compare(Object o1, Object o2) {
            if(o1 instanceof limit)
                return ((limit) o1).compareTo(o2);
            else if(o2 instanceof limit)
                return compare(o2,o1);
            else
                throw new IllegalArgumentException();
        }
        
    }

    private RealSet(boolean b, ArrayList<limit> l, SortedSet<Double> d){
        negInfIn=!b;
        lims=l;
        discVals=d;
    }
    public RealSet() {
        negInfIn=false;
        lims=new ArrayList<>();
        discVals=new TreeSet<>();
    }
    
    @Override
    public int size() {
        if(negInfIn || lims.size()>0)
            return EFF_INF_INT;
        else return discVals.size();
    }
    
    // public static boolean dblEquals(double a, double b){
    //     return Math.abs(a-b)<=Math.max(Math.ulp(a), Math.ulp(b));
    // }

    @Override
    public boolean isEmpty() {
        return !negInfIn && lims.isEmpty() && discVals.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * checks if this RealSet is a superset of the input interval
     * @param i the input interval
     * @return take a guess...
     */
    public boolean contains(Interval i){
        
    }
    /**
     * checks if the input double is included in this set of reals
     * @param d
     * @return 
     */
    public boolean contains(double d){
       return discVals.contains(d) || null!=inInterval(d, new int[]{-1,lims.size()});
    }
    /**
     * checks if the input double is an element of one of the continuous intervals
     * and returns the limits if it is.
     * recursive. call like inInterval(d, new int[]{-1, lims.size()}) to search all the intervals between +/- infinity. Going with any other limits is unsupported
     *  effectively this is just a binary search
     * the limIndx is of the following form:
     *    {lowerLimit, upperLimit}
     *    where lowerLimit and upperLimit are the indicies in lims that bound d.
     *    if lowerLimit=-1 assume that means d is bounded below by -infity
     *    if upperLimit=lims.size() assume that means d is bounded above by +infity
     *    if upperLimit=-1 that means that d is a limiting value of an inclusive (atleast partially closed) interval that contains d
     * @param d the double to look for
     * @return the limits of the interval that includes d. returns null if d is not in a continuous interval
     */
    private int[] inInterval(Double d, int[] limIndx){
        if(lims.size()==0)
            if(negInfIn)
                return new int[]{-1, lims.size()}; //in between -\inf and +\inf
            else
                return null;

        int midIndx=limIndx[0]+(limIndx[1]-limIndx[0])/2;
        if(midIndx<0) //means all other limits are greater.
            if(negInfIn)
                return new int[]{-1, 0};
            else
                return null;
        else if(midIndx>=lims.size()){
            int parity = (negInfIn) ?  0 :  1;
            if((parity + lims.size())%2==1) //if in an interval to +\infinty
                return new int[]{lims.size()-1, lims.size()};
            else
                return null;
        }
        else{
            int comp=lims.get(midIndx).compareTo(d);
            switch (Integer.signum(comp)){
                case -1:
                    limIndx[0]=midIndx;
                case 0:
                    if(lims.get(midIndx).inclusive)
                        return new int[]{midIndx,-1};
                    else
                        return null;
                case 1:
                    limIndx[1]=midIndx;
            }
            return inInterval(d,limIndx);
        }
                
    }
    /**
     * the opposite of the above. Infact it just checks if the input double is in the compliment of the above
     * TODO: For efficiency re-implement so that we don't end up copying EVERYTHING taking the copmliment
     * @param d
     * @param limIndx
     * @return 
     */
    private int[] outInterval(Double d, int[] limIndx){
        return this.compliment().inInterval(d, limIndx);
    }

    /**
     * this is a dangerous operation. Can't iterate through any continuous interval and get all the elements.
     * other ideas: generate numbers uniformly if have a continuous interval. loop over discrete values if don't
     * just throw an exception to hit people trying to do dumb things.
     * iterate through discrete values only?
     * @return 
     */
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * another dangerous operation for reasons as above
     * @return 
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * another dangerous operation for reasons as above
     * @return 
     */
    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Double[] discElemsArray(){
        return discVals.toArray(new Double[0]);
    }

    @Override
    public boolean add(Double e) {
        if(this.contains(e))
            return false;
        else
            return discVals.add(e);
    }
    public boolean add(Interval i) {
        if(this.contains(i) || i==null)
            return false;
        else
            
    }
    private boolean addInterval(Interval i){
        if(!this.contains(i)){
            int[] lowerLimInt=outInterval(i.getMinLim(), new int[] {-1, lims.size()});
            int[] upperLimInt=outInterval(i.getMaxLim(), new int[] {-1, lims.size()});
            int[] toWipe=new int[upperLimInt[0]-lowerLimInt[1]+1];
            for(int indx=0; indx<toWipe.length; indx++)
                toWipe[indx]=upperLimInt[0]-indx;
            for(int indx=0; indx<toWipe.length; indx++)
                lims.remove(toWipe[indx]);
            limit newLo=new limit(i.getMinLim(), i.isMinInc());
            limit newHi=new limit(i.getMaxLim(), i.isMaxInc());
            lims.add(lowerLimInt[0], newLo);
            lims.add(upperLimInt[1], newHi);
            return true;
        }else
            return false;
    }
    
    public RealSet compliment(){
        ArrayList<limit> tmp=new ArrayList(lims);
        for(limit cEnd : tmp)
            cEnd.inclusive=!cEnd.inclusive;
        //throw new UnsupportedOperationException();
        //TODO invert the discrete values. 
        //Maybe go back to discrete elements being repeated twice in the lims?
        return new RealSet(!negInfIn, tmp, new TreeSet<>());
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
