package entity.travel;

public class Travel {
    public String getSceneryname() {
        return sceneryname;
    }

    public void setSceneryname(String sceneryname) {
        this.sceneryname = sceneryname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "sceneryname='" + sceneryname + '\'' +
                ", city='" + city + '\'' +
                ", place='" + place + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    private String sceneryname;
    private String city;
    private String place;
    private String about;
    public Travel(){}
}
