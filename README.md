# Kotlin React Page

Simple web page written in Kotlin by using KotlinReact library. 
Web page uses IMDB api to allow user searching films.

To finalize project setup you need to insert your api key
in SearchPageState:
```kotlin
companion object {
        const val API_KEY = "<API-KEY>"
}    
```