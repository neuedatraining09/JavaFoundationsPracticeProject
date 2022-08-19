package domain;
import java.time.LocalDateTime;

public class AccessRecords implements Comparable<AccessRecords> {
        private int turnstileID;
        private String building;
        private int floor;
        private LocalDateTime dateOfEntry;
        private LocalDateTime timeOfEntry;
        private int staffID;

        public AccessRecords(int turnstileID, String building, int floor, LocalDateTime dateOfEntry, LocalDateTime timeOfEntry, int staffID){
            this.turnstileID=turnstileID;
            this.building=building;
            this.floor=floor;
            this.dateOfEntry=dateOfEntry;
            this.timeOfEntry=timeOfEntry;
            this.staffID=staffID;
        }

        public int getTurnstileID() {
            return turnstileID;
        }

        public void setTurnstileID(int turnstileID) {
            this.turnstileID = turnstileID;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public LocalDateTime getDateOfEntry() {
            return dateOfEntry;
        }

        public void setDateOfEntry(LocalDateTime dateOfEntry) {
            this.dateOfEntry = dateOfEntry;
        }

        public LocalDateTime getTimeOfEntry() {
            return timeOfEntry;
        }

        public void setTimeOfEntry(LocalDateTime timeOfEntry) {
            this.timeOfEntry = timeOfEntry;
        }

        public int getStaffID() {
            return staffID;
        }

        public void setStaffID(int staffID) {
            this.staffID = staffID;
        }

        @Override
        public int compareTo(AccessRecords o) {
            return 0;
        }


    }
