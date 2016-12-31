package org.nb.model;

/**
 * Created by nikita.biloshytskyi on 12/31/2016.
 */
public class CountryEntity {

    private String countryCodeIsoAlpha2;
    private String countryNameDutch;
    private String countryNameEnglish;

    public CountryEntity(String countryCodeIsoAlpha2, String countryNameDutch, String countryNameEnglish) {
        this.countryCodeIsoAlpha2 = countryCodeIsoAlpha2;
        this.countryNameDutch = countryNameDutch;
        this.countryNameEnglish = countryNameEnglish;
    }

    public String getCountryCodeIsoAlpha2() {
        return countryCodeIsoAlpha2;
    }

    public void setCountryCodeIsoAlpha2(String countryCodeIsoAlpha2) {
        this.countryCodeIsoAlpha2 = countryCodeIsoAlpha2;
    }

    public String getCountryNameDutch() {
        return countryNameDutch;
    }

    public void setCountryNameDutch(String countryNameDutch) {
        this.countryNameDutch = countryNameDutch;
    }

    public String getCountryNameEnglish() {
        return countryNameEnglish;
    }

    public void setCountryNameEnglish(String countryNameEnglish) {
        this.countryNameEnglish = countryNameEnglish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (!countryCodeIsoAlpha2.equals(that.countryCodeIsoAlpha2)) return false;
        if (!countryNameDutch.equals(that.countryNameDutch)) return false;
        return countryNameEnglish.equals(that.countryNameEnglish);
    }

    @Override
    public int hashCode() {
        int result = countryCodeIsoAlpha2.hashCode();
        result = 31 * result + countryNameDutch.hashCode();
        result = 31 * result + countryNameEnglish.hashCode();
        return result;
    }
}