
package ELearning.services.client.criterioavaliacao;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarCriterio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarCriterio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldCriterion" type="{http://services.ELearning/}criterioAvaliacao" minOccurs="0"/>
 *         &lt;element name="newCriterion" type="{http://services.ELearning/}criterioAvaliacao" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarCriterio", propOrder = {
    "oldCriterion",
    "newCriterion"
})
public class EditarCriterio {

    protected CriterioAvaliacao oldCriterion;
    protected CriterioAvaliacao newCriterion;

    /**
     * Gets the value of the oldCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public CriterioAvaliacao getOldCriterion() {
        return oldCriterion;
    }

    /**
     * Sets the value of the oldCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public void setOldCriterion(CriterioAvaliacao value) {
        this.oldCriterion = value;
    }

    /**
     * Gets the value of the newCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public CriterioAvaliacao getNewCriterion() {
        return newCriterion;
    }

    /**
     * Sets the value of the newCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link CriterioAvaliacao }
     *     
     */
    public void setNewCriterion(CriterioAvaliacao value) {
        this.newCriterion = value;
    }

}
