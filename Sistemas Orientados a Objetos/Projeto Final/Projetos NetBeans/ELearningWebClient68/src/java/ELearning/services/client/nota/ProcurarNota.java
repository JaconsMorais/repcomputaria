
package ELearning.services.client.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procurarNota complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procurarNota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="grade" type="{http://services.ELearning/}nota" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procurarNota", propOrder = {
    "grade"
})
public class ProcurarNota {

    protected Nota grade;

    /**
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link Nota }
     *     
     */
    public Nota getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nota }
     *     
     */
    public void setGrade(Nota value) {
        this.grade = value;
    }

}
