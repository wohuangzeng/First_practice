package entity.hotel;

public class Hotel {
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelname='" + hotelname + '\'' +
                ", star='" + star + '\'' +
                ", hotelmessage='" + hotelmessage + '\'' +
                ", place='" + place + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    private String hotelname;
    private String star;
    private String hotelmessage;
    private String place;
    private String city;
    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getHotelmessage() {
        return hotelmessage;
    }

    public void setHotelmessage(String hotelmessage) {
        this.hotelmessage = hotelmessage;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Hotel(){}
    public Hotel(String hotelname,String star,String hotelmessage,String place,String city){
        this.hotelname=hotelname;
        this.star=star;
        this.hotelmessage=hotelmessage;
        this.place=place;
        this.city=city;
    }


}
