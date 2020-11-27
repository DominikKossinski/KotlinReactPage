package components.movieItem

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RState
import react.ReactElement
import react.router.dom.navLink
import styled.*

class MovieItem : RComponent<MovieItemProps, RState>() {

    override fun RBuilder.render() {
        navLink<MovieItemProps>("/details/${props.movie.imdbID}") {
            styledDiv {
                css {
                    +MovieItemStyles.backgroundDiv
                }
                key = props.movie.imdbID

                styledH1 {
                    css {
                        +MovieItemStyles.titleH1
                    }
                    +props.movie.Title
                }
                styledH3 {
                    css {
                        +MovieItemStyles.infoH3
                    }
                    +"PRODUCTION YEAR ${props.movie.Year}"
                }
                val color = when (props.movie.Title.hashCode() % 3) {
                    0 -> Color(" #ffde59")
                    1 -> Color("#ff66c4")
                    else -> Color(" #8c52ff")
                }
                val src = when (props.movie.Title.hashCode() % 3) {
                    0 -> "/images/popcorn.png"
                    1 -> "/images/claps.png"
                    else -> "/images/movie.png"
                }
                styledDiv {
                    css {
                        overflow = Overflow.hidden
                        backgroundColor = if (props.movie.Poster != "N/A") {
                            Color("#d9d9d9")
                        } else {
                            color
                        }
                        padding(16.px)
                    }
                    styledDiv {
                        styledImg {
                            css {
                                +MovieItemStyles.movieImg
                            }
                            if (props.movie.Poster != "N/A") {
                                this.attrs.src = props.movie.Poster
                            } else {
                                this.attrs.src = src
                            }
                        }
                    }
                }
                styledH3 {
                    css {
                        +MovieItemStyles.typeH3
                    }
                    +"type: ${props.movie.Type.toUpperCase()}"
                }
            }
        }
    }
}

fun RBuilder.movieItem(handler: MovieItemProps.() -> Unit): ReactElement {
    return child(MovieItem::class) {
        this.attrs(handler)
    }
}