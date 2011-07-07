
package ELearning.services.client.professor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarProfessor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarProfessor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldProfessor" type="{http://services.ELearning/}professor" minOccurs="0"/>
 *         &lt;element name="newProfessor" type="{http://services.ELearning/}professor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarProfessor", propOrder = {
    "oldProfessor",
    "newProfessor"
})
public class EditarProfessor {

    protected Professor oldProfessor;
    protected Professor newProfessor;

    /**
     * Gets the value of the oldProfessor property.
     * 
     * @return
     *     possible object is
     *     {@link Professor }
     *     
     */
    public Professor getOldProfessor() {
        return oldProfessor;
    }

    /**
     * Sets the value of the oldProfessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Professor }
     *     
     */
    public void setOldProfessor(Professor value) {
        this.oldProfessor = value;
    }

    /**
     * Gets the value of the newProfessor property.
     * 
     * @return
     *     possible object is
     *     {@link Professor }
     *     
     */
    public Professor getNewProfessor() {
        return newProfessor;
    }

    /**
     * Sets the value of the newProfessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Professor }
     *     
     */
    public void setNewProfessor(Professor value) {
        this.newProfessor = value;
    }

}
