package pages.movieDetails

import models.MovieDetails
import react.RState

interface MovieDetailsState : RState {
    var movieDetails: MovieDetails?
}