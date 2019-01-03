/*
 * Copyright 2019 Stanislaw stasbar Baranski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */

package com.stasbar.app.goodreads

import java.io.StringReader
import java.io.StringWriter
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

object XML{
    inline fun <reified T> stringify(item: T): String {
        val jaxbContext = JAXBContext.newInstance(T::class.java)
        val jaxbMarshaller = jaxbContext.createMarshaller()
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, java.lang.Boolean.TRUE)
        val sw = StringWriter()
        jaxbMarshaller.marshal(item, sw)
        return sw.toString()
    }

    inline fun <reified T> parse(xmlContent: String): T {
        val jaxbContext = JAXBContext.newInstance(T::class.java)
        val jaxbUnmarshaller = jaxbContext.createUnmarshaller()
        return jaxbUnmarshaller.unmarshal(StringReader(xmlContent)) as T
    }
}
