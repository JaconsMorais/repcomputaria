
package ELearning.services.client.professor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deletarProfessor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deletarProfessor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="professor" type="{http://services.ELearning/}professor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deletarProfessor", propOrder = {
    "professor"
})
public class DeletarProfessor {

    protected Professor professor;

    /**
     * Gets the value of the professor property.
     * 
     * @return
     *     possible object is
     *     {@link Professor }
     *     
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Sets the value of the professor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Professor }
     *     
     */
    public void setProfessor(Professor value) {
        this.professor = value;
    }

}
