/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbedInternals;
import testbed.*;
import java.util.*;

/**
 *
 * @author nkner_000
 */
public class CapabilityMap<T extends Collection<ICapable>> implements ICapableGen{
    Map<IElement, T> capMap;
    private boolean lock;
    
    public CapabilityMap(){
        capMap=new HashMap<IElement, T>();
    }

    public CapabilityMap(Map<IElement, T> capMap) {
        this.capMap = capMap;
    }
    
    @Override
    public Collection<ICapable> apply(IElement t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Collection<ICapable> applyAll(Collection<IElement> c){
        LinkedList<ICapable> out=new LinkedList<>();
        for(IElement e : c)
            out.addAll(this.apply(e));
        return out;
    }

    /**
     * prevents the CapabilityMap from accepting or removing any new mappings 
     */
    public void lock(){
        lock=true;
    }

    /**
     * allows the CapabilityMap to accept or remove any new mappings 
     */
    public void unlock(){
        lock=false;
    }

    /**
     * @return the number of mappings (elements -> Capabilities) in this lookup table
     */
    public int size() {
        return capMap.size();
    }

    public boolean isEmpty() {
        return capMap.isEmpty();
    }

    public boolean containsElem(IElement o) {
        return capMap.containsKey(o);
    }
    public boolean containsMap(IElement o, T caps){
        if(null==caps)
            return capMap.containsKey(o) && capMap.get(o)==null;
        else
            return caps.equals(capMap.get(o));
    }

    /**
     * Adds the e -> CollectOfCaps to the mapping 
     * @param e
     * @param CollectOfCaps
     * @return if the map changed as a result of the operation
     */
    public boolean add(IElement e, T CollectOfCaps) {
        if(!lock) 
            capMap.put(e, CollectOfCaps);
        return false;
    }

    public boolean remove(IElement e, T CollectOfCaps) {
        if(!lock)
            return capMap.remove(e, CollectOfCaps);
        else return false;
    }
    public boolean remove(IElement e) {
        if(!lock) {
            boolean out=false;
            if(capMap.containsKey(e) && capMap.get(e)==null)
                out=true; //want to note remove a key mapped to null as true
            return out || null!=capMap.remove(e); //if capMap.remove==null => didn't have key
        }
        return false;
    }

    public boolean containsAllElem(Collection<IElement> c) {
        for(IElement e : c)
            if(! this.containsElem(e))
                return false;
        return true;
    }

    public void clear() {
        capMap.clear();
    }

    @Override
    public String toString(){
        return capMap.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.capMap);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CapabilityMap<?> other = (CapabilityMap<?>) obj;
        if (!Objects.equals(this.capMap, other.capMap)) {
            return false;
        }
        return true;
    }

    
}