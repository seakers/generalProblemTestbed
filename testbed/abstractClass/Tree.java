/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.abstractClass;
import java.util.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class Tree<T> implements Collection<T>{
    int cnt; //count of elements/nodes
    TreeNode root;
    
    public TreeNode<T> implements ITree{
        
    }

    @Override
    public int size() {
        return cnt;
    }

    @Override
    public boolean isEmpty() {
        return cnt==0;
    }

    @Override
    public boolean contains(Object o) {
        
        return root.subTreeContains(o);
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean add(T e) {
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
    public boolean addAll(Collection<? extends T> c) {
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
    
    public class TreeNode<T> extends AbsTree{
       T data; 

        /**
         * @param data data stored by the node
         * @param children list of children
         */
        public TreeNode(T data, List<ITree> children) {
            super(children);
            this.data = data;
        }

        /**
         * creates a leaf node
         * @param data data stored by this node
         */
        public TreeNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
        
        public boolean subTreeContains(T t){
            if(data==null)
                if(t==null)
                if(t.equals(data))
                return true;
            if(t==null && data==null)
                return true;
            Iterator chld=super.iterateChild();
            
            boolean isFound=false;
            while(!isFound && chld.hasNext()){
                TreeNode<T> nxtChld=(TreeNode<T>) chld.next();
                isFound=nxtChld.subTreeContains(t);
            }
            return isFound;
        }
        
    }
}
