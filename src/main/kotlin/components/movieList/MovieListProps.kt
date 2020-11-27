package components

import models.Movie
import react.RProps

interface MovieListProps: RProps {
    var movies: Array<Movie>
}