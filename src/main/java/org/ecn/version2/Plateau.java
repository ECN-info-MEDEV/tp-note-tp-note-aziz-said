package org.ecn.version2;

import lombok.Data;

import java.util.ArrayList;

@Data
class Plateau {
    private ArrayList<String> rows;
    private ArrayList<String> markers;
    private int round;

    public Plateau() {
        this.rows = new ArrayList<>();
        this.markers = new ArrayList<>();
        this.round = 0;
    }

    public void display() {
        System.out.println("Round: " + round);
        for (int i = 0; i < this.getRows().size(); i++) {
            System.out.print("Row " + (i + 1) + ": ");
            System.out.print(this.getRows().get(i) + " ");
            System.out.println(this.getMarkers().get(i));
        }
    }

    public void addRow(String guess, String marker) {
            this.rows.add(guess);
            this.markers.add(marker);
    }

    public void reset() {
        this.rows = new ArrayList<>();
        this.markers = new ArrayList<>();
    }
}
