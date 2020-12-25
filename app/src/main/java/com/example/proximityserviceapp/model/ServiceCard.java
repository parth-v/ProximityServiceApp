package com.example.proximityserviceapp.model;

public class ServiceCard {

    private int Id;
    private int imageservice;
    private String serviceTitle;
    private String quantityservices;
    private String urlservice;

    public ServiceCard(int id, int imageservice, String serviceTitle, String quantityservices) {
        Id = id;
        this.imageservice = imageservice;
        this.serviceTitle = serviceTitle;
        this.quantityservices = quantityservices;
    }

    public ServiceCard(int imageservice, String serviceTitle, String quantityservices) {
        this.imageservice = imageservice;
        this.serviceTitle = serviceTitle;
        this.quantityservices = quantityservices;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImageservice() {
        return imageservice;
    }

    public void setImageservice(int imageservice) {
        this.imageservice = imageservice;
    }

    public String getserviceTitle() {
        return serviceTitle;
    }

    public void setserviceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getQuantityservices() {
        return quantityservices;
    }

    public void setQuantityservices(String quantityservices) {
        this.quantityservices = quantityservices;
    }

    public String getUrlservice() {
        return urlservice;
    }

    public void setUrlservice(String urlservice) {
        this.urlservice = urlservice;
    }

    @Override()
    public boolean equals(Object other) {
        if (other instanceof com.example.proximityserviceapp.model.ServiceCard) {
            com.example.proximityserviceapp.model.ServiceCard serviceCard = (com.example.proximityserviceapp.model.ServiceCard) other;
            return serviceCard.getId()==(this.getId());
        }

        return false;
    }
}
