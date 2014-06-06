/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author nozomihitomi
 */
public class Architecture {
    
    private HashMap<decision,option>  arch;
    private Result result;  
    
    private boolean evaluated;
    private boolean feasible;
    
    public Architecture(){
        
    }
    
    //getters
    public HashMap<decision,option> getArch(){
        return arch;
    }    
    public Result getResult(){
        return result;
    }    
    
    public boolean equals(Architecture compareArch){
        return HashMap.equals(this.getArch(),compareArch.getArch());
    }
    
    public boolean isEvaluated(){
        return evaluated;
    }    
    public boolean isFeasible(){
        return feasible;
    }
    
    //setters
    public void setArchitecture(HashMap<decision,option> arch){
        this.arch = arch;
    }    
    public void setEvaluated(boolean evaluated){
        this.evaluated = evaluated;
    }    
    public void setFeasible(boolean feasible){
        this.feasible = feasible;
    }    
    public void setResult(Result result){
        this.result = result;
    }
    
    
    //Comparators
    public static Comparator<Architecture> ArchUtilityComparator = new Comparator<Architecture>() {
        @Override
        // order architectures in list with descending order
        public int compare(Architecture a1, Architecture a2) {
            double x = (a1.getResult().getUtility()- a2.getResult().getUtility());
            if(x>0) {
                return 1;
            } else if (x<0) {
                return -1;
            } else {
                return 0;
            }
        }
    };
    
    public static Comparator<Architecture> ArchCostComparator = new Comparator<Architecture>() {
        @Override
        // order architectures in list with descending order
        public int compare(Architecture a1, Architecture a2) {
            double x = (a1.getResult().getCost()- a2.getResult().getCost());
            if(x>0) {
                return 1;
            } else if (x<0) {
                return - 1;
            } else {
                return 0;
            }
        }
    };
    
    public static Comparator<Architecture> ArchBenefitComparator = new Comparator<Architecture>() {
        @Override
        // order architectures in list with descending order
        public int compare(Architecture a1, Architecture a2) {
            double x = (a1.getResult().getBenefit()- a2.getResult().getBenefit());
            if(x>0) {
                return 1;
            } else if (x<0) {
                return - 1;
            } else {
                return 0;
            }
        }
    };
    
    public static Comparator<Architecture> ArchCrowdDistComparator = new Comparator<Architecture>() {
        @Override
        public int compare(Architecture a1, Architecture a2) {
            double x = (a1.getResult().getCrowdingDistance() - a2.getResult().getCrowdingDistance());
            if(x<0) {
                return 1;
            } else if (x>0) {
                return - 1;
            } else {
                return 0;
            }
            
        }
    };
}
