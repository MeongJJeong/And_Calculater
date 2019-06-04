package kr.ac.hanseo.calculater;

import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

public class ScoreProcess {

    //field
    public ArrayList<ScoreModel> scoreModels;
    public int total_score; //이수학점
    public double avg_score; //평균학점
    public int major_total; //전공 이수학점
    protected double major_avg; //전공  평균학점

    //constructor
    public ScoreProcess(ArrayList<ScoreModel> scoreModels){
        this.scoreModels=scoreModels;

        total_score =  totalCal(scoreModels);
        avg_score = avgCal(scoreModels);
        major_total = maj_totalCal(scoreModels);
        major_avg = maj_avgCal(scoreModels);
    }

    //method
    public double gradeCal(String grade){

        if(grade.equals("A+")){
            return 4.5;
        }
        if(grade.equals("A")){
            return 4;
        }
        if(grade.equals("B+")){
            return 3.5;
        }
        if(grade.equals("B")){
            return 3;
        }
        if(grade.equals("C+")){
            return 2.5;
        }
        if(grade.equals("C")){
            return 2;
        }
        if(grade.equals("D")){
            return 1.5;
        }
        if(grade.equals("F")){
            return 0;
        }
        if(grade.equals("PASS")){
            return 4.5;
        }
        if(grade.equals("FAIL")){
            return 4.5;
        }
        return 0;
    }

    private int totalCal(ArrayList<ScoreModel> scoreModels){
        int result=0;
        for(int i=0;i<scoreModels.size();i++){
            result+=scoreModels.get(i).score;
        }
        return result;
    }

    private double avgCal(ArrayList<ScoreModel> scoreModels){
        double result=0;
        int n=0;
        for(int i=0;i<scoreModels.size();i++){
            if(scoreModels.get(i).score!=0||scoreModels.get(i).score!=NULL){
                n=n+1;
                result=result+gradeCal(scoreModels.get(i).grade);
            }
        }
        if(n==0) return 0;
        return result/n;
    }

    private int maj_totalCal(ArrayList<ScoreModel> scoreModels){
        int result=0;
        for(int i=0;i<scoreModels.size();i++){
            if(scoreModels.get(i).major){
                result+=scoreModels.get(i).score;
            }
        }
        return result;
    }

    private double maj_avgCal(ArrayList<ScoreModel> scoreModels){
        double result=0;
        int n=0;
        for (int i=0;i<scoreModels.size();i++){
            if (scoreModels.get(i).major){
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
