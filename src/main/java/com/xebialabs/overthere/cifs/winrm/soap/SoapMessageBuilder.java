/*
 * Copyright (c) 2008-2014, XebiaLabs B.V., All rights reserved.
 *
 *
 * Overthere is licensed under the terms of the GPLv2
 * <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most XebiaLabs Libraries.
 * There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
 * this software, see the FLOSS License Exception
 * <http://github.com/xebialabs/overthere/blob/master/LICENSE>.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
 * Floor, Boston, MA 02110-1301  USA
 */
package com.xebialabs.overthere.cifs.winrm.soap;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;

import static com.xebialabs.overthere.cifs.winrm.Namespaces.NS_SOAP_ENV;

public class SoapMessageBuilder {

    private Document doc = DocumentHelper.createDocument();

    public EnvelopeBuilder envelope() {
        Element envelope = doc.addElement(QName.get("Envelope", NS_SOAP_ENV));
        return new EnvelopeBuilder(envelope);
    }

    public class EnvelopeBuilder {
        private Element envelope;

        public EnvelopeBuilder(Element envelope) {
            this.envelope = envelope;
        }

        public HeaderBuilder header() {
            Element header = envelope.addElement(QName.get("Header", NS_SOAP_ENV));
            return new HeaderBuilder(header);
        }

        public BodyBuilder body() {
            Element body = envelope.addElement(QName.get("Body", NS_SOAP_ENV));
            return new BodyBuilder(body);
        }
    }

    public Document getDocument() {
        return doc;
    }
}
