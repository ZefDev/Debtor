package com.mandriklab.debtor;

class Persons {
    private int id;
    private int imgIndikator;
    private String imagePerson;
    private String namePerson;
    private String date;
    private String day;
    private double coast;

    public Persons(int id, int imgIndikator, String imagePerson, String namePerson, String date, String day, double coast) {
        this.id = id;
        this.imgIndikator = imgIndikator;
        this.imagePerson = imagePerson;
        this.namePerson = namePerson;
        this.date = date;
        this.day = day;
        this.coast = coast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgIndikator() {
        return imgIndikator;
    }

    public void setImgIndikator(int imgIndikator) {
        this.imgIndikator = imgIndikator;
    }

    public String getImagePerson() {
        return imagePerson;
    }

    public void setImagePerson(String imagePerson) {
        this.imagePerson = imagePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getCoast() {
        return coast;
    }

    public void setCoast(double coast) {
        this.coast = coast;
    }
}
