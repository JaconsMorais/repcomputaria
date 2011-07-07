
package ELearning.services.client.usuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procurarUsuario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procurarUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="user" type="{http://services.ELearning/}usuario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procurarUsuario", propOrder = {
    "user"
})
public class ProcurarUsuario {

    protected Usuario user;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setUser(Usuario value) {
        this.user = value;
    }

}
