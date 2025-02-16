package br.com.fiap.postech.customermanagement.domain.model;

public class Customer {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cellPhone;
    private String zipCode;
    private String address;
    private String addressNumber;
    private String neighborhood;
    private String city;
    private String state;
    private String complement;

    public Customer(Long id, String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cellPhone = cellPhone;
        this.zipCode = zipCode;
        this.address = address;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.complement = complement;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}


