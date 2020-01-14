package fr.formation.inti.entities;

import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.beanutils.converters.StringConverter;

@SuppressWarnings("restriction")
	public class DatePickerDemo  {	 
	    public void start(Stage stage) {
	 
	        DatePicker datePicker = new DatePicker();
	        datePicker.setValue(LocalDate.of(2016, 7, 25));
	        datePicker.setShowWeekNumbers(true);
	        
	        // Converter
	        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
	            DateTimeFormatter dateFormatter =
	                      DateTimeFormatter.ofPattern("dd-MM-yyyy");
	            
	            @Override
	            public String toString(LocalDate date) {
	                if (date != null) {
	                    return dateFormatter.format(date);
	                } else {
	                    return "";
	                }
	            }
	            @Override
	            public LocalDate fromString(String string) {
	                if (string != null && !string.isEmpty()) {
	                    return LocalDate.parse(string, dateFormatter);
	                } else {
	                    return null;
	                }
	            }
	        };   
	        datePicker.setConverter(converter);
	        datePicker.setPromptText("dd-MM-yyyy");
	        
	 
	        FlowPane root = new FlowPane();
	        root.getChildren().add(datePicker);
	        root.setPadding(new Insets(10));
	 
	        stage.setTitle("DatePicker (o7planning.org)");
	        Scene scene = new Scene(root, 300, 200);
	        stage.setScene(scene);
	        stage.show();
	    }
	 
	   
	}

