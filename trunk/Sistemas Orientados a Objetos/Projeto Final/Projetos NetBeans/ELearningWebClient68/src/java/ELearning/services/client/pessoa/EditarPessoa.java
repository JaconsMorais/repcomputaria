
package ELearning.services.client.pessoa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarPessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarPessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldPerson" type="{http://services.ELearning/}pessoa" minOccurs="0"/>
 *         &lt;element name="newPerson" type="{http://services.ELearning/}pessoa" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarPessoa", propOrder = {
    "oldPerson",
    "newPerson"
})
public class EditarPessoa {

    protected Pessoa oldPerson;
    protected Pessoa newPerson;

    /**
     * Gets the value of the oldPerson property.
     * 
     * @return
     *     possible object is
     *     {@link Pessoa }
     *     
     */
    public Pessoa getOldPerson() {
        return oldPerson;
    }

    /**
     * Sets the value of the oldPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pessoa }
     *     
     */
    public void setOldPerson(Pessoa value) {
        this.oldPerson = value;
    }

    /**
     * Gets the value of the newPerson property.
     * 
     * @return
     *     possible object is
     *     {@link Pessoa }
     *     
     */
    public Pessoa getNewPerson() {
        return newPerson;
    }

    /**
     * Sets the value of the newPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pessoa }
     *     
     */
    public void setNewPerson(Pessoa value) {
        this.newPerson = value;
    }

}
