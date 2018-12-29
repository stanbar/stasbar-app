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