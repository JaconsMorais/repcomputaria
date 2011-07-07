
package ELearning.services.client.disciplina;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for disciplina complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="disciplina">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="criteria" type="{http://services.ELearning/}criterioAvaliacao" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="dataFim" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idDisciplina" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="idProfessor" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="matriculas" type="{http://services.ELearning/}matricula" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nomeDisciplina" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numNotas" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "disciplina", propOrder = {
    "criteria",
    "dataFim",
    "dataInicio",
    "idDisciplina",
    "idProfessor",
    "matriculas",
    "nomeDisciplina",
    "numNotas"
})
public class Disciplina {

    @XmlElement(nillable = true)
    protected List<CriterioAvaliacao> criteria;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataFim;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataInicio;
    protected Long idDisciplina;
    protected Long idProfessor;
    @XmlElement(nillable = true)
    protected List<Matricula> matriculas;
    protected String nomeDisciplina;
    protected Integer numNotas;

    /**
     * Gets the value of the criteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the criteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CriterioAvaliacao }
     * 
     * 
     */
    public List<CriterioAvaliacao> getCriteria() {
        if (criteria == null) {
            criteria = new ArrayList<CriterioAvaliacao>();
        }
        return this.criteria;
    }

    /**
     * Gets the value of the dataFim property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFim() {
        return dataFim;
    }

    /**
     * Sets the value of the dataFim property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFim(XMLGregorianCalendar value) {
        this.dataFim = value;
    }

    /**
     * Gets the value of the dataInicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInicio() {
        return dataInicio;
    }

    /**
     * Sets the value of the dataInicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInicio(XMLGregorianCalendar value) {
        this.dataInicio = value;
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
     * Gets the value of the idProfessor property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdProfessor() {
        return idProfessor;
    }

    /**
     * Sets the value of the idProfessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdProfessor(Long value) {
        this.idProfessor = value;
    }

    /**
     * Gets the value of the matriculas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the matriculas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMatriculas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Matricula }
     * 
     * 
     */
    public List<Matricula> getMatriculas() {
        if (matriculas == null) {
            matriculas = new ArrayList<Matricula>();
        }
        return this.matriculas;
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

    /**
     * Gets the value of the numNotas property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumNotas() {
        return numNotas;
    }

    /**
     * Sets the value of the numNotas property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumNotas(Integer value) {
        this.numNotas = value;
    }

}
