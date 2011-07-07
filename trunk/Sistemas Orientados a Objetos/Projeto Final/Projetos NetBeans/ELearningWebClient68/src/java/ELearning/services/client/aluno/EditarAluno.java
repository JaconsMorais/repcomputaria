
package ELearning.services.client.aluno;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarAluno complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarAluno">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldStudent" type="{http://services.ELearning/}aluno" minOccurs="0"/>
 *         &lt;element name="newStudent" type="{http://services.ELearning/}aluno" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarAluno", propOrder = {
    "oldStudent",
    "newStudent"
})
public class EditarAluno {

    protected Aluno oldStudent;
    protected Aluno newStudent;

    /**
     * Gets the value of the oldStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Aluno }
     *     
     */
    public Aluno getOldStudent() {
        return oldStudent;
    }

    /**
     * Sets the value of the oldStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Aluno }
     *     
     */
    public void setOldStudent(Aluno value) {
        this.oldStudent = value;
    }

    /**
     * Gets the value of the newStudent property.
     * 
     * @return
     *     possible object is
     *     {@link Aluno }
     *     
     */
    public Aluno getNewStudent() {
        return newStudent;
    }

    /**
     * Sets the value of the newStudent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Aluno }
     *     
     */
    public void setNewStudent(Aluno value) {
        this.newStudent = value;
    }

}
