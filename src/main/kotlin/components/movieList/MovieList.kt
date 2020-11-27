package components.movieList

import components.MovieListProps
import components.movieItem.movieItem
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import styled.styledDiv

class MovieList : RComponent<MovieListProps, RState>() {

    override fun RBuilder.render() {
        styledDiv {
            props.movies.forEach {
                movieItem {
                    this.movie = it
                }
            }
        }
    }
}

fun RBuilder.movieList(handler: MovieListProps.() -> Unit): ReactElement {
    return child(MovieList::class) {
        this.attrs(handler)
    }
}