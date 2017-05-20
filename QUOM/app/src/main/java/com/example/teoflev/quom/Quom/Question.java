package com.example.teoflev.quom.Quom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Oppai on 4/23/2017.
 */

public class Question {
    private String question;
    private String answer;
    private ArrayList<String> possible;
    private List<String> returned;


    public Question(String question, String answer, ArrayList<String> possible) {

        this.possible = new ArrayList<String>();     // me to clear pou ginetai meta to diabasma twn pi8anwn apantisewn apo to arxeio to
        this.question = question;                    // this.possible 8a einai 0 afou einai apla deiktis sti domi pou dimiourgeitai sto
        this.answer = answer;                        // GetQuestions tou Category, ara 8eloume kainourgia domi gia ka8e erwtisi gia na
        this.possible.addAll(possible);              // krataei tis pi8anes meta to clear.possible()
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getPossible() {
        Collections.shuffle(possible);
        returned =  possible.subList(0,3);
        returned.add(answer);
        Collections.shuffle(returned);
        return returned;
    }

    public boolean is_correct(String answer){
      if (answer == this.answer)
        return true;
      else
        return false;
    }

}
