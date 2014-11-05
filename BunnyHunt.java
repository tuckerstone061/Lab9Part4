/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author tucker.stone061
 */

public class BunnyHunt {

    // class variables
    private static Object[][] field;
    private static Model model;
    private static View view;
    private static Controller controller;
    private static int numberOfRows;
    private static int numberOfColumns;

    /**
     * Main class for starting a bunny hunt; no parameters
     * are needed or used.
     * @param args
     */
    public static void main(String args[]) {
        numberOfRows = 20;
        numberOfColumns = 20;
        field = new Object[numberOfRows][numberOfColumns];
        model = new Model(field);
        view = new View(field);
        controller = new Controller(model, view);
    }
}

