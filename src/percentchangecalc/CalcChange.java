/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percentchangecalc;

/**
 *
 * @author nyand
 */
public class CalcChange {
    
    public static double calcSellPoint(double begin, double percent){
        
        double output = 0;
        output = begin + (begin * percent);
        return output;
    }
    public static double calcSellPoint(double begin, double percent, double fee)
    {
        double mid = calcSellPoint(begin,percent);
        double output = processFee(mid, fee);
        return output;
    }
    
    public static double calcBuyPoint(double begin, int percent){
        
        double output = 0;
        output = -(percent - begin);
        return output;
    }
    
    public static double processFee(double begin, double percent){
        double output = 0;
        output = begin + begin*percent;
        return output;
    }
    
}
