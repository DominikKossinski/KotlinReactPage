package models

data class SearchResponse(
    val Search: Array<Movie>?,
    val totalResults: String?,
    val Response: Boolean
)
