package at.address.model;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pessoa {
	

	/**
	 * Classe Model para uma Person (pessoa).
	 *
	 * @author Marco Jakob
	 */
	public class Person {

	    private final StringProperty Name;
	    private final IntegerProperty ID;
	    private final IntegerProperty Phone;
	    
	    /**
	     *  Construtor padrão.
	     */
	    public Person() {
	        this(null);
	    }

	    
	    public Person(String Name) {
	        this.Name = new SimpleStringProperty(Name);
	      

	        // Alguns dados de exemplo, apenas para testes.
	        this.ID = new SimpleIntegerProperty(1001);
	        this.Phone = new SimpleIntegerProperty(1234);
	       
	    }

	    public String getName() {
	        return Name.get();
	    }

	    public void setName(String Name) {
	        this.Name.set(Name);
	    }

	    public StringProperty NameProperty() {
	        return Name;
	    }

	    public int getPhone() {
	        return Phone.get();
	    }

	    public void setPhone(int Phone) {
	        this.Phone.set(Phone);
	    }

	    public IntegerProperty PhoneProperty() {
	        return Phone;
	    }
	    
	    public int getID() {
	        return ID.get();
	    }

	    public void setID(int ID) {
	        this.ID.set(ID);
	    }

	    public IntegerProperty IDProperty() {
	        return ID;
	    }
	}
}
