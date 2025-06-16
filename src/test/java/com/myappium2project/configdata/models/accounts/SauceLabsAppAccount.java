package com.myappium2project.configdata.models.accounts;

/**
 * Data model representing a user account for the Sauce Labs demo mobile application.
 * <p>
 * Typically used for test data input (e.g., login, checkout) loaded from JSON resources.
 */
public class SauceLabsAppAccount {
    private String email;
    private String password;
    private String name;
    private String addressLine;
    private String city;
    private String region;
    private String zipCode;
    private String country;
    private String cardNumber;
    private String expDate;
    private String secCode;

    public SauceLabsAppAccount() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getSecCode() {
        return secCode;
    }

    @Override
    public String toString() {
        return "SauceAccount{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expDate='" + expDate + '\'' +
                ", secCode='" + secCode + '\'' +
                '}';
    }
}