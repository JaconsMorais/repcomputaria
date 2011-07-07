
package ELearning.services.client.nota;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadastrarNota complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadastrarNota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newGrade" type="{http://services.ELearning/}nota" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarNota", propOrder = {
    "newGrade"
})
public class CadastrarNota {

    protected Nota newGrade;

    /**
     * Gets the value of the newGrade property.
     * 
     * @return
     *     possible object is
     *     {@link Nota }
     *     
     */
    public Nota getNewGrade() {
        return newGrade;
    }

    /**
     * Sets the value of the newGrade property.
     * 
     * @param value
     *     allowed object is
     *     {@link Nota }
     *     
     */
    public void setNewGrade(Nota value) {
        this.newGrade = value;
    }

}
