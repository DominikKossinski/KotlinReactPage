package components.movieDetails

import kotlinx.css.*
import styled.StyleSheet

object MovieDetailsStyles : StyleSheet("MovieDetailsStyle", true) {

    val titleH1 by css {
        marginLeft = LinearDimension.auto
        marginRight = LinearDimension.auto
        fontFamily = "'Allerta Stencil',sans-serif"
        marginTop = 25.px
        marginBottom = 16.px
        textAlign = TextAlign.center
    }

    val topInfoH3 by css {
        marginLeft = LinearDimension.auto
        marginRight = LinearDimension.auto
        fontFamily = "'Amiko',sans-serif"
        textAlign = TextAlign.center
    }

    val posterImg by css {
        height = 400.px
    }

    val posterDiv by css {
        float = Float.left
        display = Display.inlineBlock
        padding(16.px)
        margin(25.px)
        borderRadius = 16.px
    }

    val infoDiv by css {
        float = Float.left
        padding(16.px)
        display = Display.inlineBlock
        margin(25.px)
        //height = 100.pct
        backgroundColor = Color.black
        color = Color.white
        width = 70.pc
    }

    val infoH3 by css {
        margin(10.px)
        fontFamily = "'Amiko',sans-serif"
    }
}