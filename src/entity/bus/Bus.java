package entity.bus;

public class Bus {
    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Bus{" +
                "busname='" + busname + '\'' +
                ", route='" + route + '\'' +
                ", city='" + city + '\'' +
                ", money='" + money + '\'' +
                '}';
    }

    private String busname;
    private String route;
    private String city;
    private String money;
    public Bus(){}
}
