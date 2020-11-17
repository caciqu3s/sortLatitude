package com.seberino.aps.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.seberino.aps.model.Geolocation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class GeolocationController {
    private List<Geolocation> geolocations;

    public GeolocationController() {
        this.getDataFromJson();
    }

    private void getDataFromJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.geolocations = mapper.readValue(new File("src/main/resources/geolocations.json"), new TypeReference<List<Geolocation>>() { });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Geolocation[] getArray() {
        return geolocations.toArray(new Geolocation[geolocations.size()]);
    }

    public void printGeolocations(Geolocation[] vetor) {
        for(Geolocation g : vetor) {
            System.out.println("Latitude: " + g.getLatitude() + "... Longitude: " + g.getLongitude());
        }
    }

    public void printInsertionSort() {
        long begin = System.currentTimeMillis();
        Geolocation[] array = insertionSort(getArray());
        long end = System.currentTimeMillis();

        printGeolocations(array);

        System.out.println("A ordenação foi feita em " + (end - begin) + "ms");
        createJSONFile(array, "insertion");
    }

    public void printSelectionSort() {
        long begin = System.currentTimeMillis();
        Geolocation[] array = selectionSort(getArray());
        long end = System.currentTimeMillis();

        printGeolocations(array);

        System.out.println("A ordenação foi feita em " + (end - begin) + "ms");
        createJSONFile(array, "selection");
    }

    public void printBubbleSort() {
        long begin = System.currentTimeMillis();
        Geolocation[] array = bubbleSort(getArray());
        long end = System.currentTimeMillis();

        printGeolocations(array);

        System.out.println("A ordenação foi feita em " + (end - begin) + "ms");
        createJSONFile(array, "bubble");
    }

    private Geolocation[] insertionSort(Geolocation[] array) {
        for (int i = 1; i < array.length; ++i) {
            Geolocation key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].getLatitude() > key.getLatitude()) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        return array;
    }

    private Geolocation[] selectionSort(Geolocation[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            int lowestIndex = j;

            for (int i = lowestIndex + 1; i < array.length; i++) {
                if (array[i].getLatitude() < array[lowestIndex].getLatitude()) {
                    lowestIndex = i;
                }
            }
            if (lowestIndex != j) {
                Geolocation t = array[j];
                array[j] = array[lowestIndex];
                array[lowestIndex] = t;
            }
        }

        return array;
    }

    private Geolocation[] bubbleSort(Geolocation[] array){
        boolean change = true;
        Geolocation aux;
        while (change) {
            change = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].getLatitude() > array[i + 1].getLatitude()) {
                    aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                    change = true;
                }
            }
        }

        return array;
    }

    private void createJSONFile(Geolocation[] array, String sortType) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/"+ sortType + ".json").toFile(), array);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
