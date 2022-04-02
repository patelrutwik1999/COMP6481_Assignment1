package Assignment1;

//...............................................................
//Assignment 1
//© Rutwikkumar Sunilkumar Patel
//Written By: Rutwikkumar Sunilkumar Patel, Student Id: 40160646
//...............................................................

/**
 * ---------Program Description---------
 * Vaccine class is basically an overview of the methods and variables.
 * This is the Vaccine class which has all important variables namely vaccine brand, dose, price, expiry date and its id.
 * It also some static variables to keep the count of the objects created and also some static methods to use this variables.
 * Also, overridden methods like equals and toString are being implemented.
 * Getter and setter methods of the variables are being implemented.
 * Also default, parametrized, and copy constructors are being implemented in this segment of code.
 */

/**
 * Enum to store the brand of all the vaccines to be used.
 */
enum VaccineBrand {
    Moderna, Pfizer, CoVaxin, Covishield,
};

public class Vaccine {
    private double dose;
    private String expiry_date;
    private long id;
    private double price;
    private VaccineBrand brand;
    public static int count = 0;

    /**
     * This is the default constructor invoked when the Vaccine class object is being created.
     */
    public Vaccine() {
        count++;
        dose = 0.5;
        expiry_date = "24-01-2024";
        id = 784637846387L;
        price = 574;
        brand = VaccineBrand.Moderna;
    }

    /**
     * The parameteraized constructor, used to initialize the instance variables.
     * @param dose of the vaccine.
     * @param expiry_date of the vaccine.
     * @param id of the vaccine.
     * @param price of the vaccine.
     * @param brand of the vaccine.
     */
    public Vaccine(double dose, String expiry_date, long id, double price, VaccineBrand brand) {
        count++;
        this.dose = dose;
        this.expiry_date = expiry_date;
        this.id = id;
        this.price = price;
        this.brand = brand;
    }

    /**
     * This is the copy constructor, that stores the copy of the vaccine object to the current object.
     * @param vaccine object.
     */
    public Vaccine(Vaccine vaccine) {
        count++;
        this.dose = vaccine.dose;
        this.expiry_date = vaccine.expiry_date;
        this.id = vaccine.id;
        this.price = vaccine.price;
        this.brand = vaccine.brand;
    }

    /**
     * The methods gets the Id.
     * @return id of the current object.
     */
    public long getID() {
        return this.id;
    }

    /**
     * Setter method for dose.
     * @param dose it is the dosage of the vaccine.
     */
    public void setDose(double dose) {
        this.dose = dose;
    }

    /**
     * The method returns the dosage of the vaccine.
     * @return dose of the current vaccine object.
     */
    public double getDose() {
        return this.dose;
    }

    /**
     * The method sets the expiry date.
     * @param expiry_date of the vaccine.
     */
    public void setExpiryDate(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    /**
     * The method will return expiry date of the vaccine.
     * @return current expiry date current object.
     */
    public String getExpiryDate() {
        return this.expiry_date;
    }

    /**
     * The methods sets the price of the vaccine.
     * @param price of the vaccine.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * The method gets the price of the vaccine.
     * @return price of the current vaccine object.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * The method set the brand of the vaccine.
     * @param vaccine_brand brand of the vaccine.
     */
    public void setVaccineBrand(VaccineBrand vaccine_brand) {
        this.brand = vaccine_brand;
    }

    /**
     * The method returns the brand of the vaccine.
     * @return the brand of the current vaccine object.
     */
    public VaccineBrand getVaccineBrand() {
        return this.brand;
    }

    /**
     * The method return the count of the created vaccine objects till now.
     * @return the count of the number of objects created.
     */
    public static int findNumberOfCreatedVaccines() {
        return count;
    }


    /**
     * The method checks, if the objects are equal or not.
     * @param vac this is of the type Object.
     * @return the boolean value, returns yes if two objects are equal on the basis of the brand and dose. Otherwise it returns false.
     */
    @Override
    public boolean equals(Object vac) {
        if (this == vac) {
            return true;
        }
        if (this == null || getClass() != vac.getClass()) {
            return false;
        }

        Vaccine vaccine = (Vaccine) vac;
        if (this.brand.equals(vaccine.brand) && this.dose == vaccine.dose) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The toString method displays all the variables of the current object.
     * @return the string of all the variables of current object.
     */
    @Override
    public String toString() {
        return "Brand Name = " + this.brand + "\nId = " + this.id + "\nDose = " + this.dose
                + "\nExpiry Date = " + this.expiry_date + "\nPrice = $" + this.price;
    }
}
