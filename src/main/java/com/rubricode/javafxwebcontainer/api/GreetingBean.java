/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rubricode.javafxwebcontainer.api;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chidieberennadi
 */
public class GreetingBean {
    @XmlAttribute
    public String text;

    public GreetingBean() {
    }

    public GreetingBean(String text) {
        this.text = text;
    }
}
