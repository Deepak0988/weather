//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.11.10 at 08:42:02 PM IST 
//


package com.weather.soapservice.xjc;

import com.weather.soapservice.entity.WeatherEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="Weather" type="{http://www.weather.com/soapservice/xjc}Weather"/>
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
    "weather"
})
@XmlRootElement(name = "WeatherResponse")
public class WeatherResponse {

    @XmlElement(name = "Weather", required = true)
    protected Weather weather;

    /**
     * Gets the value of the weather property.
     * 
     * @return
     *     possible object is
     *     {@link Weather }
     *     
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * Sets the value of the weather property.
     * 
     * @param value
     *     allowed object is
     *     {@link Weather }
     *     
     */
    public void setWeather(Weather value) {
        this.weather = value;
    }
}
