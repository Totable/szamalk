/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a20171129;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Diak {

	String név;
	int év;
	int id;

	public String getName() {
		return név;
	}

	@XmlElement
	public void setName(String name) {
		this.név = name;
	}

	public int getAge() {
		return év;
	}

	@XmlElement
	public void setAge(int age) {
		this.év = age;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

}