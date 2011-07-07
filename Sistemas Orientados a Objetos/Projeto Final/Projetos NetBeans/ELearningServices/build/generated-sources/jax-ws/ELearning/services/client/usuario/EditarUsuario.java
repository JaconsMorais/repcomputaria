
package ELearning.services.client.usuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for editarUsuario complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="editarUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oldUser" type="{http://services.ELearning/}usuario" minOccurs="0"/>
 *         &lt;element name="newUser" type="{http://services.ELearning/}usuario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "editarUsuario", propOrder = {
    "oldUser",
    "newUser"
})
public class EditarUsuario {

    protected Usuario oldUser;
    protected Usuario newUser;

    /**
     * Gets the value of the oldUser property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getOldUser() {
        return oldUser;
    }

    /**
     * Sets the value of the oldUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setOldUser(Usuario value) {
        this.oldUser = value;
    }

    /**
     * Gets the value of the newUser property.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getNewUser() {
        return newUser;
    }

    /**
     * Sets the value of the newUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setNewUser(Usuario value) {
        this.newUser = value;
    }

}
