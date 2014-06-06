/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package optimizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author nozomihitomi
 */
public class Result {
    private double cost;
    private double benefit;
    private double utility;
    private double crowdingDistance;
    
    private TreeMap<String,ArrayList<Fact>> explanations;
    private TreeMap<String,Double> subobjective_scores2;
    private HashMap<function,performance> capability;
    
    
    //getters
    public double getBenefit(){
        return benefit;
    }
    public double getCost(){
        return cost;
    }
    public double getCrowdingDistance(){
        return crowdingDistance;
    }
    public double getUtility(){
        return utility;
    }
    
    //setters
    public void setBenefit(double benefit){
        this.benefit = benefit;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    public void setCrowdingDistance(double crowdingDistance){
        this.crowdingDistance = crowdingDistance;
    }
    public void setUtility(double utility){
        this.utility = utility;
    }
}
