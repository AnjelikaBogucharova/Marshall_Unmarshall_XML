package marshalling_xml

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import java.io.File

fun main (){
    val hobby1 = listOf(
            Hobby("10", "Bycicle")
    )
    val person1 = Person(
            "Ivanov Viacheslav Igorevich",
            "1994-09-09",
            Hobbies(hobby1)
    )
    val hobby2 = listOf(
            Hobby("20", "Monocicle"),
            Hobby("100", "Fourcicle")
    )
    val person2 = Person(
            "Fdafds Afcbfh Hhfgndfg",
            "1984-11-11",
            Hobbies(hobby2)
    )
    val hobby3 = listOf(Hobby("30", "Tricicle"))
    val person3 = Person(
            "Kkpobmhtg Bklbjierg Okjdvopv",
            "1974-12-12",
            Hobbies(hobby3)
    )
    val persons = Persons(
            listOf(
                    person1,
                    person2,
                    person3
            )
    )

    // 1. Write Object to XML String

    val xml = writeXMLString(persons)
    println(xml)

    //2. Write Object to XML File
    val pathFile = System.getProperty("user.dir") + "\\persons.xml"
    writeXMLFile(persons, pathFile)

    //3. Convert XML File to Object

    var personsUnmarshal = convertXmlFileDataObject(pathFile, Persons::class.java)

    println("\r\nfrom file persons.xml\r\n" + personsUnmarshal)
}

/*
 * Convert Object to XML String
 */
fun writeXMLString(obj: Any): String {
    val xmlMapper = XmlMapper()
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    return xmlMapper.writeValueAsString(obj)
}
/*
 * Write Object to XML file
 */
fun writeXMLFile(obj: Any, pathFile: String) {
    val xmlMapper = XmlMapper()
    xmlMapper.enable(SerializationFeature.INDENT_OUTPUT)
    xmlMapper.writeValue(File(pathFile), obj)
}
/*
 * Write XML file to Object
 */
fun convertXmlFileDataObject(pathFile: String, cls: Class<*>): Any{
    val xmlMapper = XmlMapper()
    return xmlMapper.readValue(File(pathFile), cls)
}
    


