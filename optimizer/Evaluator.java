/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizer;

/**
 *
 * @author nozomihitomi
 */
public class Evaluator {
    
    public Evaluator(ValueFunction valuefunciton){
        
    }
    /**
     * evaluateArch will compute the benefit, cost, and utility of an architecture.
     * While computing the benefit, the capability and satisfaction information 
     * will be computed. Included is an explanation facility that will keep 
     * track of why an architecture achieved a certain benefit (This is achieved
     * by explaining the capabilities and satisfaction of requirements)
     * @param arch
     */
    public void evaluateArch(Architecture arch){
        Result result = new Result();
        
        result.setBenefit(computeBenefit());
        result.setCost(computeCost());
        result.setUtility(computeUtility());
        
        
        arch.setEvaluated(true);
        arch.setResult(result);
    }
    
    private double computeBenefit(){
        double benefit=0;
        
        return benefit;
    }
    
    private double computeCost(){
        double cost=0;
        
        return cost;
    }
    
    private double computeUtility(){
        double utility=0;
        
        return utility;
    }
}
