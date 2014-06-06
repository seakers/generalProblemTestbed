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
public class TerminationCriteria {
    
    CriteriaType type;
    int evalLimit;
    
    public enum CriteriaType{
        MAXEVALS,EVALS_UNTIL_IMPROVE
    }
    
    public TerminationCriteria(CriteriaType type,int evals){
        this.type = type;
        this.evalLimit = evals;
    }
    
    public boolean isDone(int evals){
        switch(type){
            case MAXEVALS:
                return (evals>=evalLimit);
            default:
                return true;
        }
    }
    
    
}
