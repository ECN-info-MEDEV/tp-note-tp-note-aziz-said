package org.ecn.version2;

import lombok.Data;

@Data
class Plateau {
    private String[] rows;
    private String[] markers;
    private int round;

    public Plateau() {
        this.rows = new String[12];
        this.markers = new String[12];
        this.round = 0;
    }

    public void display() {
        System.out.println("Round: " + round);
        for (int i = 0; i < 12; i++) {
            System.out.print("Row " + (i + 1) + ": ");
            System.out.print(rows[i] + " ");
            System.out.println(markers[i]);
        }
    }

    public void addRow(String guess, String markers) {

    }

    public void reset() {
    }
}
