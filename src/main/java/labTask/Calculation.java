package labTask;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Calculation {
	@NotNull
	int number1;
	@NotNull
	int number2;
	@NotNull
	String operation;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int calculate() {
	    int result;

	    switch (operation) {
	        case "+":
	            result = number1 + number2;
	            break;
	        case "-":
	            result = number1 - number2;
	            break;
	        case "*":
	            result = number1 * number2;
	            break;
	        case "/":
	            if (number2 == 0) {
	                throw new IllegalArgumentException("Cannot divide by zero!");
	            }
	            result = number1 / number2;
	            break;
	        default:
	            throw new IllegalArgumentException("Invalid Operator!");
	    }

	    return result;
	}

}
