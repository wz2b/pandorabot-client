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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author cepasp
 */
public class PandoraBot {

    public final String botId;
    public static final String botAddr = "http://www.pandorabots.com/pandora/talk-xml";
    private final HttpClient client;
    private final JAXBContext jc;
    private final Unmarshaller u;

    public PandoraBot(String botId) throws JAXBException {
        this.botId = botId;
        client = new HttpClient();
        jc = JAXBContext.newInstance(PandorabotResult.class);
        u = jc.createUnmarshaller();
    }

    public PandorabotResult ask(String custId, String what) throws Exception {
        PostMethod post = new PostMethod(botAddr);
        post.addParameter("botid", botId);
        post.addParameter("custid", custId);
        post.addParameter("input", what);

        int rc = client.executeMethod(post);

        System.out.println(post.getResponseBodyAsString());

        PandorabotResult result = (PandorabotResult) u.unmarshal(post.getResponseBodyAsStream());

        return result;
    }
}
