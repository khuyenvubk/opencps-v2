//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.02 at 10:14:04 AM ICT 
//


package org.opencps.api.serviceconfig.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.liferay.portal.kernel.util.StringPool;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceInfoId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="agencies" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="serviceInstruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceLevel" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="forCitizen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forBusiness" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalService" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="registration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="instructionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="submissionNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dossierTemplateId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="serviceProcessId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="optionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pattern" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceInfoId",
    "agencies",
    "serviceInstruction",
    "serviceLevel",
    "forCitizen",
    "forBusiness",
    "postalService",
    "registration",
    "instructionNote",
    "submissionNote",
    "dossierTemplateId",
    "serviceProcessId",
    "optionName",
    "pattern",
    "serviceUrl"
})
@XmlRootElement(name = "ListServiceInputModel")
public class ListServiceInputModel {
	@FormParam(value = "serviceInfoId")
    protected int serviceInfoId;
    @FormParam(value = "agencies")
    protected List<String> agencies;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "serviceInstruction")
    protected String serviceInstruction;
    @FormParam(value = "serviceLevel")
    protected int serviceLevel;
    @DefaultValue(StringPool.FALSE) @FormParam(value = "forCitizen")
    protected String forCitizen;
    @DefaultValue(StringPool.FALSE) @FormParam(value = "forBusiness")
    protected String forBusiness;
    @DefaultValue(StringPool.FALSE) @FormParam(value = "postalService")
    protected String postalService;
    @DefaultValue(StringPool.FALSE) @FormParam(value = "registration")
    protected String registration;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "instructionNote")
    protected String instructionNote;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "submissionNote")
    protected String submissionNote;
    @FormParam(value = "dossierTemplateId")
    protected int dossierTemplateId;
    @FormParam(value = "serviceProcessId")
    protected int serviceProcessId;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "forCitizen")
    protected String optionName;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "forCitizen")
    protected String pattern;
    @DefaultValue(StringPool.BLANK) @FormParam(value = "serviceUrl")
    protected String serviceUrl;

    /**
     * Gets the value of the serviceInfoId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getServiceInfoId() {
        return serviceInfoId;
    }

    /**
     * Sets the value of the serviceInfoId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceInfoId(int value) {
        this.serviceInfoId = value;
    }

    /**
     * Gets the value of the agencies property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agencies property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgencies().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAgencies() {
        if (agencies == null) {
            agencies = new ArrayList<String>();
        }
        return this.agencies;
    }

    /**
     * Gets the value of the serviceInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceInstruction() {
        return serviceInstruction;
    }

    /**
     * Sets the value of the serviceInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceInstruction(String value) {
        this.serviceInstruction = value;
    }

    /**
     * Gets the value of the serviceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getServiceLevel() {
        return serviceLevel;
    }

    /**
     * Sets the value of the serviceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceLevel(int value) {
        this.serviceLevel = value;
    }

    /**
     * Gets the value of the forCitizen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForCitizen() {
        return forCitizen;
    }

    /**
     * Sets the value of the forCitizen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForCitizen(String value) {
        this.forCitizen = value;
    }

    /**
     * Gets the value of the forBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForBusiness() {
        return forBusiness;
    }

    /**
     * Sets the value of the forBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForBusiness(String value) {
        this.forBusiness = value;
    }

    /**
     * Gets the value of the postalService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalService() {
        return postalService;
    }

    /**
     * Sets the value of the postalService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalService(String value) {
        this.postalService = value;
    }

    /**
     * Gets the value of the registration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistration(String value) {
        this.registration = value;
    }

    /**
     * Gets the value of the instructionNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructionNote() {
        return instructionNote;
    }

    /**
     * Sets the value of the instructionNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructionNote(String value) {
        this.instructionNote = value;
    }

    /**
     * Gets the value of the submissionNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmissionNote() {
        return submissionNote;
    }

    /**
     * Sets the value of the submissionNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmissionNote(String value) {
        this.submissionNote = value;
    }

    /**
     * Gets the value of the dossierTemplateId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getDossierTemplateId() {
        return dossierTemplateId;
    }

    /**
     * Sets the value of the dossierTemplateId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDossierTemplateId(int value) {
        this.dossierTemplateId = value;
    }

    /**
     * Gets the value of the serviceProcessId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getServiceProcessId() {
        return serviceProcessId;
    }

    /**
     * Sets the value of the serviceProcessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceProcessId(int value) {
        this.serviceProcessId = value;
    }

    /**
     * Gets the value of the optionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * Sets the value of the optionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionName(String value) {
        this.optionName = value;
    }

    /**
     * Gets the value of the pattern property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPattern(String value) {
        this.pattern = value;
    }
    
    public String getServiceUrl() {
        return serviceUrl;
    }

    /**
     * Sets the value of the serviceUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceUrl(String value) {
        this.serviceUrl = value;
    }
    
    

}
