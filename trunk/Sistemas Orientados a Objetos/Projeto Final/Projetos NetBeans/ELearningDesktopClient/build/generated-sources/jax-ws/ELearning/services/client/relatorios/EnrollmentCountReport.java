
package ELearning.services.client.relatorios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enrollmentCountReport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enrollmentCountReport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countDisciplina" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nomeDisciplina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enrollmentCountReport", propOrder = {
    "countDisciplina",
    "nomeDisciplina"
})
public class EnrollmentCountReport {

    protected Integer countDisciplina;
    protected String nomeDisciplina;

    /**
     * Gets the value of the countDisciplina property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCountDisciplina() {
        return countDisciplina;
    }

    /**
     * Sets the value of the countDisciplina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCountDisciplina(Integer value) {
        this.countDisciplina = value;
    }

    /**
     * Gets the value of the nomeDisciplina property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    /**
     * Sets the value of the nomeDisciplina property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDisciplina(String value) {
        this.nomeDisciplina = value;
    }

}
