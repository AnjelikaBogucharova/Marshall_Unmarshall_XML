package marshalling_xml

import com.fasterxml.jackson.dataformat.xml.annotation.*


data class Persons(
        @field: JacksonXmlElementWrapper(useWrapping = false)
        @field: JacksonXmlProperty(localName = "Person")
        var person: List<Person>?=null
)


data class Person(
        var name: String?= null,
        var birthday: String?= null,
        var hobbies: Hobbies?= null
)

data class Hobbies(
        @field: JacksonXmlElementWrapper(useWrapping = false)
        var hobby: List<Hobby>?=null
)

data class Hobby(var complexity: String?=null, var hobby_name: String?=null)