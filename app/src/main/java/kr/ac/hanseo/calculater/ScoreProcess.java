package kr.ac.hanseo.calculater;

import java.util.ArrayList;
import java.util.List;

public class ScoreProcess {

    //field
    public ArrayList<ScoreModel> scoreModels;
    int total_score; //이수학점
    double avg_score; //평균학점
    int major_total; //전공 이수학점
    double major_avg; //전공  평균학점

    //constructor
    public ScoreProcess(ArrayList<ScoreModel> scoreModels){
        this.scoreModels=scoreModels;

        total_score =  totalCal();
        avg_score = avgCal();
        major_total = maj_totalCal();
        major_avg = maj_avgCal();
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

    public int totalCal(){
        int result=0;
        for(int i=0;i<scoreModels.size();i++){
            result+=scoreModels.get(i).score;
        }
        return result;
    }
    public double avgCal(){
        double result=0;
        int n=0;
        for(int i=0;i<scoreModels.size();i++){
            if(scoreModels.get(i).score!=0){
                n=n+1;
                result=result+gradeCal(scoreModels.get(i).grade);
            }
        }
        if(n==0) return 0;
        return result/n;
    }
    public int maj_totalCal(){
        int result=0;
        for(int i=0;i<scoreModels.size();i++){
            if(scoreModels.get(i).major==true){
                result+=scoreModels.get(i).score;
            }
        }
        return result;
    }
    public double maj_avgCal(){
        double result=0;
        int n=0;
        for (int i=0;i<scoreModels.size();i++){
            if (scoreModels.get(i).major==true){
                if(scoreModels.get(i).score !=0){
                    n=n+1;
                    result=result+gradeCal(scoreModels.get(i).grade);
                }
            }
        }
        if(result==0) return 0;
        return result/n;
    }

}
