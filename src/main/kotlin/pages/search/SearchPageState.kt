package pages.search

import models.Movie
import react.RState

class SearchPageState(
    var query: String
) : RState {

    companion object {
        const val API_KEY = "<API-KEY>"
    }
    var movies: Array<Movie> = emptyArray()
}