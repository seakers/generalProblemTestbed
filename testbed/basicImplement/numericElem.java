/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testbed.basicImplement;

import testbed.abstractClass.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class numericElem extends AbsTree implements IElement, Comparable{
    int number;

    public numericElem(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Integer)
            return number-(Integer) o;
        else if(o instanceof numericElem)
            return this.number-((numericElem) o).number;
        else
            throw new IllegalArgumentException();
    }

    @Override
    public int hashCode() {
         return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final numericElem other = (numericElem) obj;
        if (this.number != other.number) {
            return false;
        }
        return true;
    }
}
