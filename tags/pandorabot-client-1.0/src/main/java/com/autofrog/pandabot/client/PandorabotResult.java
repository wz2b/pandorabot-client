/*
 * PandoraBot java library
 * Copyright (c) 2011 Christopher Piggott
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.autofrog.pandabot.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chrisp
 */
@XmlRootElement(name="result")
@XmlAccessorType(XmlAccessType.FIELD)
public class PandorabotResult {

    @XmlAttribute(name="status")
    public int status;
    
    @XmlAttribute(name="botid")
    public String botId;

    @XmlAttribute(name="custid")
    public String custId;

    @XmlElement(name="input")
    public String input;

    @XmlElement(name="that")
    public String message;


    @Override
    public String toString() {
        return "Result{" + "status=" + status + ", custId=" + custId + ", input=" + input + ", message=" + message + '}';
    }


}
