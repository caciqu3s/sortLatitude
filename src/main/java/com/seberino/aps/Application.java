package com.seberino.aps;

import com.seberino.aps.controller.GeolocationController;

public class Application {
    public static void main(String[] args) {
        GeolocationController controller = new GeolocationController();
        controller.printInsertionSort();
        controller.printSelectionSort();
        controller.printBubbleSort();
    }
}
