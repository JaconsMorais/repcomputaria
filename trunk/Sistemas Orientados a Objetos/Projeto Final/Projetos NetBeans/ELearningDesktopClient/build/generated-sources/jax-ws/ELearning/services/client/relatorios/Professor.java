
package ELearning.services.client.relatorios;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for professor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="professor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.ELearning/}pessoa">
 *       &lt;sequence>
 *         &lt;element name="disciplinas" type="{http://services.ELearning/}disciplina" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "professor", propOrder = {
    "disciplinas"
})
public class Professor
    extends Pessoa
{

    @XmlElement(nillable = true)
    protected List<Disciplina> disciplinas;

    /**
     * Gets the value of the disciplinas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disciplinas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisciplinas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Disciplina }
     * 
     * 
     */
    public List<Disciplina> getDisciplinas() {
        if (disciplinas == null) {
            disciplinas = new ArrayList<Disciplina>();
        }
        return this.disciplinas;
    }

}
