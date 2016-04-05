package at.address.model;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;	
	/**
	 * Classe Model para uma Person (pessoa).
	 *
	 * @author Marco Jakob
	 */
	public class Person {

	    private final StringProperty Name;
	    private final IntegerProperty ID;
	    private final StringProperty Phone;
	    
	    /**
	     *  Construtor padrão.
	     */
  
	    public Person(Integer ID ,String Name,String Phone) {
	        this.Name = new SimpleStringProperty(Name);
	      

	        // Alguns dados de exemplo, apenas para testes.
	        this.ID = new SimpleIntegerProperty(ID);
	        this.Phone = new SimpleStringProperty(Phone);
	       
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

	    public String getPhone() {
	        return Phone.get();
	    }

	    public void setPhone(String Phone) {
	        this.Phone.set(Phone);
	    }

	    public StringProperty PhoneProperty() {
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

