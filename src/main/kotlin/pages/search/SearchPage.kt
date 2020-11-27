package pages.search

import components.movieList.movieList
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.html.js.onChangeFunction
import models.Movie
import models.SearchResponse
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.div
import styled.css
import styled.styledDiv
import styled.styledInput

class SearchPage : RComponent<RProps, SearchPageState>() {

    init {
        state = SearchPageState("star")
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                +SearchPageStyles.titleInputDiv
            }
            styledInput {
                css {
                    +SearchPageStyles.titleInput
                }
                attrs {
                    placeholder = "Type movie title..."
                    onChangeFunction = {
                        val input = it.target as HTMLInputElement
                        setState {
                            query = input.value
                        }
                        if (input.value.length >= 3) {
                            refreshMovies()
                        }
                    }
                }
            }
        }
        div {
            movieList {
                this.movies = state.movies
            }
        }
    }

    private fun refreshMovies() {
        val mainScope = MainScope()
        mainScope.launch {
            val movies = getMovies(state.query)
            setState {
                this.movies = movies
            }
        }
    }

    private suspend fun getMovies(query: String): Array<Movie> {
        val response = fetchMovies(query)
        if (response.Search == undefined) {
            return emptyArray()
        }
        console.log("Found: ${response.Search}")
        return response.Search
    }

    override fun SearchPageState.init() {
        query = "stat"
        refreshMovies()
    }

    private suspend fun fetchMovies(query: String): SearchResponse {
        return window.fetch("http://www.omdbapi.com/?apikey=${SearchPageState.API_KEY}&s=${query}")
            .await()
            .json()
            .await()
            .unsafeCast<SearchResponse>()
    }
}

fun RBuilder.searchPage(): ReactElement {
    return child(SearchPage::class) {}
}