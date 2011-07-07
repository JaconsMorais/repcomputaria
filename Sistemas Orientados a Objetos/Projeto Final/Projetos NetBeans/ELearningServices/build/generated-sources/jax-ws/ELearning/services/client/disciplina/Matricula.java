
package ELearning.services.client.disciplina;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for matricula complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="matricula">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idAluno" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idDisciplina" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idMatricula" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="notaFinal" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="notas" type="{http://services.ELearning/}nota" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "matricula", propOrder = {
    "idAluno",
    "idDisciplina",
    "idMatricula",
    "notaFinal",
    "notas"
})
public class Matricula {

    protected Long idAluno;
    protected Long idDisciplina;
    protected Long idMatricula;
    protected Float notaFinal;
    @XmlElement(nillable = true)
    protected List<Nota> notas;

    /**
     * Gets the value of the idAluno property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdAluno() {
        return idAluno;
    }

    /**
     * Sets the value of the idAluno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdAluno(Long value) {
        this.idAluno = value;
    }

    /**
     * Gets the value of the idDisciplina property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdDisciplina() {
        return idDisciplina;
    }

    /**
     * Sets the value of the idDisciplina property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdDisciplina(Long value) {
        this.idDisciplina = value;
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
     * Gets the value of the notaFinal property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNotaFinal() {
        return notaFinal;
    }

    /**
     * Sets the value of the notaFinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNotaFinal(Float value) {
        this.notaFinal = value;
    }

    /**
     * Gets the value of the notas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nota }
     * 
     * 
     */
    public List<Nota> getNotas() {
        if (notas == null) {
            notas = new ArrayList<Nota>();
        }
        return this.notas;
    }

}
