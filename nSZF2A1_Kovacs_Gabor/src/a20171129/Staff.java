/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20171129;

/**
 *
 * @author Misaka
 */
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonView;

public class Staff {
    
	@JsonView(Views.Normal.class)
	private String name;

	@JsonView(Views.Normal.class)
	private int age;

	@JsonView(Views.Normal.class)
	private String position;

	@JsonView(Views.Manager.class)
	private BigDecimal salary;

	@JsonView(Views.Normal.class)
	private List<String> skills;

    void setName(String mkyong) {
        this.name=mkyong;
    }

    void setAge(int i) {
        this.age=i;
    }

    void setPosition(String developer) {
        this.position=developer;
    }

    void setSalary(BigDecimal bigDecimal) {
        this.salary=bigDecimal;
    }

    void setSkills(List<String> skills) {
        this.skills=skills;
    }
}