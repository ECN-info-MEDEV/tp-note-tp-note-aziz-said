package org.ecn.version2;

import lombok.Data;

@Data
public class RunResults {
    private Integer rounds;
    private Integer score;
    private Boolean win;

    private String summaryInfo;
    public RunResults(){
        this.rounds = 0;
        this.score = 0;
        this.win = false;
        this.summaryInfo = "";
    }

    public void incrementScore() {
        this.score++;
    }
    public void incrementRounds() {
        this.rounds++;
    }
}
