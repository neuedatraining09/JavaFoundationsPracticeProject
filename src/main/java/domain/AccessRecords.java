package domain;
import java.time.LocalDate;
import java.time.LocalTime;

public class AccessRecords implements Comparable<AccessRecords> {
        private int turnstileID;
        private String building;
        private int floor;
        private LocalDate dateOfEntry;
        private LocalTime timeOfEntry;
        private int staffID;

        public AccessRecords(int turnstileID, String building, int floor, LocalDate dateOfEntry, LocalTime timeOfEntry, int staffID){
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

        public LocalDate getDateOfEntry() {
            return dateOfEntry;
        }

        public void setDateOfEntry(LocalDate dateOfEntry) {
            this.dateOfEntry = dateOfEntry;
        }

        public LocalTime getTimeOfEntry() {
            return timeOfEntry;
        }

        public void setTimeOfEntry(LocalTime timeOfEntry) {
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

        //        NEED TO Override based on Building/Floor/Hour    ?
//        @Override
//        public int compareTo(AccessRecords u) {
//        if (getFloor() == null || u.getFloor() == null) {
//            return 0;
//            }
//            return getFloor().compareTo(u.getFloor());
//        }

    }
