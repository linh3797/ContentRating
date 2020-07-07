package com.mulitlevelrecyclerview;

/**
 * Created by Linh Nguyen Thuy on 26,May,2020
 */
public class Question {
    private int id;
    private String topic;
    private String note_question;
    private String question;
    private String tpye_question;
    private int total_answer;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private int is_first;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    private boolean expanded;


    public Question(int id, String topic, String question, String note_question, String tpye_question, int total_answer, int is_first,
                    String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, boolean expanded) {
        this.id = id;
        this.topic = topic;
        this.note_question = note_question;
        this.question = question;
        this.tpye_question = tpye_question;
        this.total_answer = total_answer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
        this.is_first = is_first;
        this.expanded = false;
    }

    public Question(int id, String topic, String question, String note_question, String tpye_question, int total_answer, int is_first,
                    String answer1, String answer2, String answer3, String answer4, String answer5, String answer6) {
        this.id = id;
        this.topic = topic;
        this.note_question = note_question;
        this.question = question;
        this.tpye_question = tpye_question;
        this.total_answer = total_answer;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
        this.is_first = is_first;
    }

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNote_question() {
        return note_question;
    }

    public void setNote_question(String note_question) {
        this.note_question = note_question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTpye_question() {
        return tpye_question;
    }

    public void setTpye_question(String tpye_question) {
        this.tpye_question = tpye_question;
    }

    public int getTotal_answer() {
        return total_answer;
    }

    public void setTotal_answer(int total_answer) {
        this.total_answer = total_answer;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public int getIs_first() {
        return is_first;
    }

    public void setIs_first(int is_first) {
        this.is_first = is_first;
    }

}
