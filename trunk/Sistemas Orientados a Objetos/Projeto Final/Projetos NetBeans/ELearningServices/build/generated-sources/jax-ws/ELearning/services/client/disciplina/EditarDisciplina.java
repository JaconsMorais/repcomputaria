
package ELearning.services.client.disciplina;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarDisciplina complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarDisciplina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldDiscipline" type="{http://services.ELearning/}disciplina" minOccurs="0"/>
 *         &lt;element name="newDiscipline" type="{http://services.ELearning/}disciplina" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarDisciplina", propOrder = {
    "oldDiscipline",
    "newDiscipline"
})
public class EditarDisciplina {

    protected Disciplina oldDiscipline;
    protected Disciplina newDiscipline;

    /**
     * Gets the value of the oldDiscipline property.
     * 
     * @return
     *     possible object is
     *     {@link Disciplina }
     *     
     */
    public Disciplina getOldDiscipline() {
        return oldDiscipline;
    }

    /**
     * Sets the value of the oldDiscipline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Disciplina }
     *     
     */
    public void setOldDiscipline(Disciplina value) {
        this.oldDiscipline = value;
    }

    /**
     * Gets the value of the newDiscipline property.
     * 
     * @return
     *     possible object is
     *     {@link Disciplina }
     *     
     */
    public Disciplina getNewDiscipline() {
        return newDiscipline;
    }

    /**
     * Sets the value of the newDiscipline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Disciplina }
     *     
     */
    public void setNewDiscipline(Disciplina value) {
        this.newDiscipline = value;
    }

}
