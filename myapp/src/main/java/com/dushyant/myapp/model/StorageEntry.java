package com.dushyant.myapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storage_entries")
public class StorageEntry {

    @Id
    private String id;
    private String kisanId;
    private String kisanName;
    private int bags;
    private double ratePerBag;
    private String dateIn;
    private String dateOut;
    private String status;
    private String withdrawalType;
    private String traderName;

    public String getWithdrawalType() {
        return withdrawalType;
    }

    public void setWithdrawalType(String withdrawalType) {
        this.withdrawalType = withdrawalType;
    }

    public String getTraderName() {
        return traderName;
    }

    public void setTraderName(String traderName) {
        this.traderName = traderName;
    }

    public StorageEntry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKisanId() {
        return kisanId;
    }

    public void setKisanId(String kisanId) {
        this.kisanId = kisanId;
    }

    public String getKisanName() {
        return kisanName;
    }

    public void setKisanName(String kisanName) {
        this.kisanName = kisanName;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public double getRatePerBag() {
        return ratePerBag;
    }

    public void setRatePerBag(double ratePerBag) {
        this.ratePerBag = ratePerBag;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}