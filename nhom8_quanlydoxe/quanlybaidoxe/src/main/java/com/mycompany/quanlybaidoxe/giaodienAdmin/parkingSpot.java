package com.mycompany.quanlybaidoxe.giaodienAdmin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author trung
 */

public class parkingSpot {
    protected static long nextID=1;
    private long spotID=1;
    private boolean tinhTrang = false; 
    private String chuXe;
    private long Gia=0;
    

    public static void resetNextID() {
        parkingSpot.nextID = 1;  
        saveNextIDToFile(); 
    }

    public parkingSpot() {
        loadNextIDFromFile(); 
        this.spotID = nextID++;
        saveNextIDToFile(); 
    }
    public static long loadNextID(){
        loadNextIDFromFile();
        return nextID;
        
    }
    public static void saveNextIDToFile() {
        try (FileWriter writer = new FileWriter("nextID.txt")) {
            writer.write(Long.toString(nextID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadNextIDFromFile() {
        File file = new File("nextID.txt");
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextLong()) {
                    nextID = scanner.nextLong();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public parkingSpot(long spotID, String chuXe) {
        this.spotID = spotID;
        this.chuXe = chuXe;
    }

    public parkingSpot(long spotID, boolean tinhTrang, String chuXe, long Gia) {
        this.spotID = spotID;
        this.tinhTrang = tinhTrang;
        this.chuXe = chuXe;
        this.Gia = Gia;
    }

    public long getSpotID() {
        return spotID;
    }

    public void setSpotID(long spotID) {
        this.spotID = spotID;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getChuXe() {
        return chuXe;
    }

    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }

    public long getGia() {
        return Gia;
    }

    public void setGia(long Gia) {
        this.Gia = Gia;
    }
}

