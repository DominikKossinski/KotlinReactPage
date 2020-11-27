package app

import pages.movieDetails.movieDetails
import pages.movieDetails.MovieDetailsProps
import pages.search.searchPage
import react.*
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch


class App : RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        browserRouter {
            route<MovieDetailsProps>("/details/:movieId") {
                movieDetails {
                    this.movieId = it.match.params.movieId
                }
            }
            switch {
                route("/", exact = true) {
                    searchPage()
                }
            }
        }
    }
}

