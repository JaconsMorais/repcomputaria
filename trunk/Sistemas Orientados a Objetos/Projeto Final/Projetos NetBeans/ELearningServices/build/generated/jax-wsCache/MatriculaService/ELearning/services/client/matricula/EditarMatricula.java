
package ELearning.services.client.matricula;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarMatricula complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarMatricula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldEnrollment" type="{http://services.ELearning/}matricula" minOccurs="0"/>
 *         &lt;element name="newEnrollment" type="{http://services.ELearning/}matricula" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarMatricula", propOrder = {
    "oldEnrollment",
    "newEnrollment"
})
public class EditarMatricula {

    protected Matricula oldEnrollment;
    protected Matricula newEnrollment;

    /**
     * Gets the value of the oldEnrollment property.
     * 
     * @return
     *     possible object is
     *     {@link Matricula }
     *     
     */
    public Matricula getOldEnrollment() {
        return oldEnrollment;
    }

    /**
     * Sets the value of the oldEnrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matricula }
     *     
     */
    public void setOldEnrollment(Matricula value) {
        this.oldEnrollment = value;
    }

    /**
     * Gets the value of the newEnrollment property.
     * 
     * @return
     *     possible object is
     *     {@link Matricula }
     *     
     */
    public Matricula getNewEnrollment() {
        return newEnrollment;
    }

    /**
     * Sets the value of the newEnrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matricula }
     *     
     */
    public void setNewEnrollment(Matricula value) {
        this.newEnrollment = value;
    }

}
