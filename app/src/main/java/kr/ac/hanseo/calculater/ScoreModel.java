package kr.ac.hanseo.calculater;

public class ScoreModel {

    String subName;
    String grade;
    int score=0;
    boolean major=false;

    public ScoreModel(String grade,int score,boolean major){
        this.grade=grade;
        this.score=score;
        this.major=major;
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