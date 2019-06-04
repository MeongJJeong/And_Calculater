package kr.ac.hanseo.calculater;

public class ScoreModel {

    public String subName;
    public String grade;
    public int score;
    public boolean major;
    public boolean model=false;

    public ScoreModel(String grade,int score,boolean major){
        this.grade=grade;
        this.score=score;
        this.major=major;
    }

    public ScoreModel(boolean model){
        this.model = model;
    }

    public String getSubName(){
        return subName;
    }
    public void setSubName(String subName){
        this.subName=subName;
    }

    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public boolean isMajor() {
        return major;
    }
    public void setMajor(boolean major) {
        this.major = major;
    }
}