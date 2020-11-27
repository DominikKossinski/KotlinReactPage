package pages.search

import kotlinx.css.*
import styled.StyleSheet

object SearchPageStyles : StyleSheet("SearchPageStyle", true) {
    val titleInput by css {
        marginLeft = LinearDimension.auto
        marginRight = LinearDimension.auto
        backgroundColor = Color.black
        borderRadius = 16.px
        marginBottom = 25.px
        marginTop = 25.px
        color = Color.white
        width = 50.pct
        fontSize = 25.px
        padding(10.px)
        borderColor = Color.transparent
        outline = Outline.none
        placeholder {
            color = Color.gray
        }
    }

    val titleInputDiv by css {
        marginLeft = LinearDimension.auto
        marginRight = LinearDimension.auto
        textAlign = TextAlign.center
    }

}