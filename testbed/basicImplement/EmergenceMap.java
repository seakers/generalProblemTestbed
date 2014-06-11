/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.basicImplement;
import java.util.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class EmergenceMap implements IEmergence, Map<Collection<ICapable>, Collection<ICapable>>{
    Map<Collection<ICapable>, Collection<ICapable>> mapping;

    public EmergenceMap() {
        mapping=new HashMap();
    }
    
    public EmergenceMap(Map<Collection<ICapable>, Collection<ICapable>> mapping) {
        this.mapping = mapping;
    }
    
    @Override
    public Collection<ICapable> apply(Collection<ICapable> s) {
        return mapping.get(s);
    }

    
    /** mapping wrapper methods **/
    @Override
    public int size() {
        return mapping.size();
    }

    @Override
    public boolean isEmpty() {
        return mapping.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return mapping.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return mapping.containsValue(value);
    }

    @Override
    public Collection<ICapable> get(Object key) {
        return mapping.get(key);
    }

    @Override
    public Collection<ICapable> put(Collection<ICapable> key, Collection<ICapable> value) {
        return mapping.put(key, value);
    }

    @Override
    public Collection<ICapable> remove(Object key) {
        return mapping.remove(key);
    }

    @Override
    public void putAll(Map<? extends Collection<ICapable>, ? extends Collection<ICapable>> m) {
        mapping.putAll(m);
    }

    @Override
    public void clear() {
        mapping.clear();
    }

    @Override
    public Set<Collection<ICapable>> keySet() {
        return mapping.keySet();
    }

    @Override
    public Collection<Collection<ICapable>> values() {
        return mapping.values();
    }

    @Override
    public Set<Entry<Collection<ICapable>, Collection<ICapable>>> entrySet() {
        return mapping.entrySet();
    }
}
