/*
 *A real interval. Use minLim>maxLim  to indicate an empty interval.
 */

package testbed.abstractClass;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public class Interval extends RealSet{

    private double minLim;
    private double maxLim;
    private boolean minInc;
    private boolean maxInc;
    
    public Interval(double left, double right) {
        this.minLim = left;
        this.maxLim = right;
    }
    
    /**
     * Technically infinity, returns maximum integer size as a hack.
     * @return Integer.MAX_VALUE or 0 is empty
     */
    public int size() {
        return this.isEmpty() ? 0 : Integer.MAX_VALUE;
    }
    
    public double measure() {
        return isEmpty() ? 0 : maxLim-minLim;
    }
    
    public boolean contains(double d){
        return minLim <= d && maxLim >= d;
    }
    
    public boolean isEmpty() {
        return minLim > maxLim;
    }

    public boolean contains(Object o) {
        Double conv=(Double) o;
        return this.contains(conv.doubleValue());
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

    public double getMinLim() {
        return minLim;
    }

    public void setMinLim(double minLim) {
        this.minLim = minLim;
    }

    public double getMaxLim() {
        return maxLim;
    }

    public void setMaxLim(double maxLim) {
        this.maxLim = maxLim;
    }

    public boolean isMinInc() {
        return minInc;
    }

    public void setMinInc(boolean minInc) {
        this.minInc = minInc;
    }

    public boolean isMaxInc() {
        return maxInc;
    }

    public void setMaxInc(boolean maxInc) {
        this.maxInc = maxInc;
    }
}