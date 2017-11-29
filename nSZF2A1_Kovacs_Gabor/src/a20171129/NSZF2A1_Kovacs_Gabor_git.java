package a20171129;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Misaka
 */

public class NSZF2A1_Kovacs_Gabor_git {

    public static void main(String[] args) {

	  Diak diak1 = new Diak();
	  diak1.setId(100);
	  diak1.setName("Béla");
	  diak1.setAge(29);
          //--oda
	  try {

		File file = new File("file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Diak.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(diak1, file);
		jaxbMarshaller.marshal(diak1, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
          //--vissza
          try {

		File file = new File("file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Diak.class);

		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Diak customer = (Diak) jaxbUnmarshaller.unmarshal(file);
		System.out.println(customer);

	  } catch (JAXBException e) {
		e.printStackTrace();
	  }
    }
}
