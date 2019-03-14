package kr.ac.hanseo.calculater;

import java.util.ArrayList;
import java.util.List;

public class ScoreProcess {

    //field
    List<ScoreModel> scoreModels;
    int total;
    double avg;

    //constructor
    public ScoreProcess(){

    }

    //method
    public double gradeCal(String grade){

        if(grade=="A+"){
            return 4.5;
        }
        if(grade=="A"){
            return 4;
        }
        if(grade=="B+"){
            return 3.5;
        }
        if(grade=="B"){
            return 3;
        }
        if(grade=="C+"){
            return 2.5;
        }
        if(grade=="C"){
            return 2;
        }
        if(grade=="D"){
            return 1.5;
        }
        if(grade=="F"){
            return 0;
        }
        if(grade=="PASS"){
            return 4.5;
        }
        if(grade=="FAIL"){
            return 4.5;
        }
        return 0;
    }
//
//    public int totalCal(ScoreProcess s[]){
//        int result=0;
//        for(int i=0;i<s.length;i++){
//            result+=s[i].score;
//        }
//        return result;
//    }
//    public double avgCal(ScoreProcess s[]){
//        double result=0;
//        int n=0;
//        for(int i=0;i<s.length;i++){
//            if(s[i].score!=0){
//                n=n+1;
//                result=result+s[i].grade;
//            }
//        }
//        if(n==0) return 0;
//        return result/n;
//    }
//    public int cbx_totalCal(ScoreProcess s[]){
//        int result=0;
//        for(int i=0;i<s.length;i++){
//            if(s[i].major==true){
//                result+=s[i].score;
//            }
//        }
//        return result;
//    }
//    public double cbx_avgCal(List<ScoreModel> s){
//        double result=0;
//        int n=0;
//        for (int i=0;i<s.size();i++){
//            if (s.get(i).major==true){
//                if(s.get(i).score !=0){
//                    n=n+1;
//                    result=result+s.get(i).grade;
//                }
//            }
//        }
//        if(result==0) return 0;
//        return result/n;
//    }

}
