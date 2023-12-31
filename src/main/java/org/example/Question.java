package org.example;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getAnswer(){
        return this.answer;
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.answer+this.question);
    }
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Question c2 = (Question) other;
        return this.answer.equals(c2.answer) && this.question.equals(c2.question);
    }
    @Override
    public String toString(){
        return question + "\n" + answer;
    }
}
