
package ELearning.services.client.criterioavaliacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procurarCriterio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procurarCriterio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criterion" type="{http://services.ELearning/}criterioAvaliacao" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procurarCriterio", propOrder = {
    "criterion"
})
public class ProcurarCriterio {

    protected CriterioAvaliacao criterion;

    /**
     * Gets the value of the criterion property.
     * 
     * @return
     *     possible object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public CriterioAvaliacao getCriterion() {
        return criterion;
    }

    /**
     * Sets the value of the criterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public void setCriterion(CriterioAvaliacao value) {
        this.criterion = value;
    }

}
