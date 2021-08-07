package com.techelevator.parks.model;

import java.time.LocalDate;

public class Itenary {

    private long itenaryId;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public long getItenaryId() {
        return itenaryId;
    }

    public void setItenaryId(long itenaryId) {
        this.itenaryId = itenaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
