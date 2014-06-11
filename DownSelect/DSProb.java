/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DownSelect;

import testbed.abstractClass.HeirarchalProblem;
import java.util.*;
import testbed.basicImplement.*;
import testbed.*;

/**
 *
 * @author nkner_000
 */
public class DSProb extends HeirarchalProblem{
   public DSProb(){
       super(getCapMap(), getGoalHeirar()); //TODO make it soe ICapable is instead numericElems by generics
   } 
   
   private static AndGoal getGoalHeirar(){
       //TODO fix the generics here too.
       ArrayList<ITree> grp1 =new ArrayList<>(4);
       for(int i=0; i<4; i++)
           grp1.add(new HasCapGoal(new DScapability((new Integer(i)).toString())));
       

       ArrayList<ITree> grp2 =new ArrayList<>(4);
       for(int i=5; i<9; i++)
           grp2.add(new HasCapGoal(new DScapability((new Integer(i)).toString())));
       
       ArrayList<ITree> grp3 =new ArrayList<>(4);
       for(int i=10; i<14; i++)
           grp3.add(new HasCapGoal(new DScapability((new Integer(i)).toString())));
       
       AndGoal subgoal1=new AndGoal(grp1);
       AndGoal subgoal2=new AndGoal(grp2);
       AndGoal subgoal3=new AndGoal(grp3);
       
       AndGoal out = new AndGoal(Arrays.asList(new AndGoal[]{subgoal1, subgoal2, subgoal3}));
       return out;
   }
   
   private static CapabilityMap<List<ICapable>> getCapMap(){
      CapabilityMap<List<ICapable>> out=new CapabilityMap<>();
      for(int i=0; i<=14; i++){
          DScapability d=new DScapability(Integer.toString(i));
          numericElem n=new numericElem(i);
          out.add(n, Arrays.asList(new ICapable[]{d}));
      }
      return out;
   }
}
