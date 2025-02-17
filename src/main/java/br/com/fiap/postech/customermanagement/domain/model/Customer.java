package br.com.fiap.postech.customermanagement.domain.model;

/**
 * Represents a customer with personal and contact information.
 */
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

    /**
     * Constructs a new Customer with all fields.
     *
     * @param id            the unique identifier of the customer
     * @param name          the name of the customer
     * @param email         the email address of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     */
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

    /**
     * Constructs a new Customer without an ID.
     *
     * @param name          the name of the customer
     * @param email         the email address of the customer
     * @param phone         the phone number of the customer
     * @param cellPhone     the cell phone number of the customer
     * @param zipCode       the zip code of the customer's address
     * @param address       the address of the customer
     * @param addressNumber the address number of the customer
     * @param neighborhood  the neighborhood of the customer
     * @param city          the city of the customer
     * @param state         the state of the customer
     * @param complement    additional address information
     */
    public Customer(String name, String email, String phone, String cellPhone, String zipCode, String address, String addressNumber, String neighborhood, String city, String state, String complement) {
        this.id = null;
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

    /**
     * Default constructor.
     */
    public Customer() {
    }

    // Getters and setters for all fields

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

    /**
     * Updates the current customer with the details of another customer.
     *
     * @param customerID the ID of the customer to update
     * @param customer   the customer object containing updated details
     */
    public void update(final Long customerID, final Customer customer) {
        this.id = customerID;
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.cellPhone = customer.getCellPhone();
        this.zipCode = customer.getZipCode();
        this.address = customer.getAddress();
        this.addressNumber = customer.getAddressNumber();
        this.neighborhood = customer.getNeighborhood();
        this.city = customer.getCity();
        this.state = customer.getState();
        this.complement = customer.getComplement();
    }

}


