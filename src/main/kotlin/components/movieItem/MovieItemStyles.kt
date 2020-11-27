package components.movieItem

import kotlinx.css.*
import styled.StyleSheet

object MovieItemStyles : StyleSheet("MovieItem", true) {

    val backgroundDiv by css {
        display = Display.inlineBlock
        paddingTop = 16.px
        paddingBottom = 16.px
        backgroundColor = Color.black
        margin(16.px)
        borderRadius = 25.px
        width = 25.pct
        hover {
            borderWidth = 5.px
            borderStyle = BorderStyle.solid
            borderColor = Color.red
        }
    }


    val titleH1 by css {
        fontFamily = "'Allerta Stencil',sans-serif"
        whiteSpace = WhiteSpace.nowrap
        overflow = Overflow.hidden
        textOverflow = TextOverflow.ellipsis
        textAlign = TextAlign.center
        color = Color.white
        margin(16.px)
    }

    val movieImg by css {
        height = 400.px
        display = Display.block
        marginRight = LinearDimension.auto
        marginLeft = LinearDimension.auto
    }

    val infoH3 by css {
        fontFamily = "'Amiko',sans-serif"
        width = 100.pct
        textAlign = TextAlign.center
        color = Color.white
    }

    val typeH3 by css {
        fontFamily = "'Amiko',sans-serif"
        textAlign = TextAlign.end
        color = Color.white
        paddingRight = 16.px
    }

}