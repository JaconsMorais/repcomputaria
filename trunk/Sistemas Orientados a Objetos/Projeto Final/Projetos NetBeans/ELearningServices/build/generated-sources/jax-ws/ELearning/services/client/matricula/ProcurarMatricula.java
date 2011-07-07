
package ELearning.services.client.matricula;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procurarMatricula complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procurarMatricula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enrollment" type="{http://services.ELearning/}matricula" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procurarMatricula", propOrder = {
    "enrollment"
})
public class ProcurarMatricula {

    protected Matricula enrollment;

    /**
     * Gets the value of the enrollment property.
     * 
     * @return
     *     possible object is
     *     {@link Matricula }
     *     
     */
    public Matricula getEnrollment() {
        return enrollment;
    }

    /**
     * Sets the value of the enrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Matricula }
     *     
     */
    public void setEnrollment(Matricula value) {
        this.enrollment = value;
    }

}
