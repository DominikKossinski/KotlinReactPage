package pages.movieDetails

import components.movieDetails.MovieDetailsStyles
import kotlinx.browser.window
import pages.search.SearchPageState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.css.*
import models.MovieDetails
import react.*
import react.dom.div
import styled.*


class MovieDetailsPage : RComponent<MovieDetailsProps, MovieDetailsState>() {

    override fun RBuilder.render() {
        val movie = state.movieDetails
        div {
            if (movie != null) {
                val color = when (movie.Title.hashCode() % 3) {
                    0 -> Color(" #ffde59")
                    1 -> Color("#ff66c4")
                    else -> Color(" #8c52ff")
                }
                val src = when (movie.Title.hashCode() % 3) {
                    0 -> "/images/popcorn.png"
                    1 -> "/images/claps.png"
                    else -> "/images/movie.png"
                }
                styledH1 {
                    css {
                        +MovieDetailsStyles.titleH1
                    }
                    +movie.Title
                }
                styledH3 {
                    css {
                        +MovieDetailsStyles.topInfoH3
                    }
                    +"PRODUCTION YEAR ${movie.Year}"
                }
                styledH3 {
                    css {
                        +MovieDetailsStyles.topInfoH3
                    }
                    +"DIRECTOR ${movie.Director}"
                }
                styledDiv {
                    styledDiv {

                    }
                    styledDiv {
                        css {
                            +MovieDetailsStyles.posterDiv
                            backgroundColor = if (movie.Poster != null && movie.Poster != "N/A") {
                                Color("#d9d9d9")
                            } else {
                                color
                            }
                        }
                        if (movie.Poster != null && movie.Poster != "N/A") {
                            styledImg {
                                css {
                                    +MovieDetailsStyles.posterImg
                                }
                                attrs.src = movie.Poster
                            }
                        } else {
                            styledImg {
                                css {
                                    +MovieDetailsStyles.posterImg
                                }
                                attrs.src = src
                            }
                        }
                    }
                    styledDiv {
                        css {
                            +MovieDetailsStyles.infoDiv
                        }
                        styledH3 {
                            css {
                                +MovieDetailsStyles.infoH3
                            }
                            +"Country: ${movie.Country}"
                        }
                        styledH3 {
                            css {
                                +MovieDetailsStyles.infoH3
                            }
                            +"Actors: ${movie.Actors}"
                        }
                        styledH3 {
                            css {
                                +MovieDetailsStyles.infoH3
                            }
                            +"Plot: ${movie.Plot}"
                        }
                        styledH3 {
                            css {
                                +MovieDetailsStyles.infoH3
                            }
                            +"Awards: ${movie.Awards}"
                        }
                    }
                }

            }
        }
    }

    private fun refreshMovie() {
        val mainScope = MainScope()
        mainScope.launch {
            val movie = getMovie(props.movieId)
            setState {
                this.movieDetails = movie
            }
        }
    }

    private suspend fun fetchMovieDetails(movieId: String): MovieDetails =
        window.fetch("http://www.omdbapi.com/?apikey=${SearchPageState.API_KEY}&i=$movieId")
            .await()
            .json()
            .await()
            .unsafeCast<MovieDetails>()


    private suspend fun getMovie(movieId: String): MovieDetails? {
        val response = fetchMovieDetails(movieId)
        if (response == undefined) {
            return null
        }
        return response
    }

    override fun MovieDetailsState.init() {
        movieDetails = null

        refreshMovie()
    }
}

fun RBuilder.movieDetails(handler: MovieDetailsProps.() -> Unit): ReactElement {
    return child(MovieDetailsPage::class) {
        this.attrs(handler)
    }
}