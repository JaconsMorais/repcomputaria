
package ELearning.services.client.professor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nota complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCriterion" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idMatricula" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idNota" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notaCriterio" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nota", propOrder = {
    "idCriterion",
    "idMatricula",
    "idNota",
    "notaCriterio"
})
public class Nota {

    protected Long idCriterion;
    protected Long idMatricula;
    protected Long idNota;
    protected Float notaCriterio;

    /**
     * Gets the value of the idCriterion property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdCriterion() {
        return idCriterion;
    }

    /**
     * Sets the value of the idCriterion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdCriterion(Long value) {
        this.idCriterion = value;
    }

    /**
     * Gets the value of the idMatricula property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdMatricula() {
        return idMatricula;
    }

    /**
     * Sets the value of the idMatricula property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdMatricula(Long value) {
        this.idMatricula = value;
    }

    /**
     * Gets the value of the idNota property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdNota() {
        return idNota;
    }

    /**
     * Sets the value of the idNota property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdNota(Long value) {
        this.idNota = value;
    }

    /**
     * Gets the value of the notaCriterio property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNotaCriterio() {
        return notaCriterio;
    }

    /**
     * Sets the value of the notaCriterio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNotaCriterio(Float value) {
        this.notaCriterio = value;
    }

}
