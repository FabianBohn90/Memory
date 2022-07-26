package com.example.memory

import android.view.View
import android.widget.ImageButton
import kotlinx.coroutines.delay

/**
 * Die Klasse MemoryLogic enthält eine Sammlung von Funktionen, welche die Kernlogik für das
 * Memory Spiel enthalten
 */
class MemoryLogic {

    /**
     * Diese Funktion geht alle Karten(ImageButtons) in der übergebenen Liste durch
     * und verdeckt jede Karte mit Hilfe des übergebenen Lambdas
     */
    fun hideAllCards(cards: List<ImageButton>, hideCard: (ImageButton) -> Unit) {
        // gehe alle Karten durch und verdecke verdecke jede Karte
        for (i in 0..23) run {
            hideCard(cards[i])
        }
    }

    /**
     *  Diese Funktion geht alle Felder durch und platziert nacheinander, mit Hilfe des
     *  übergebenen Lambdas (= Pfeilfunktion) eine Karte auf jedem Feld
     */
    suspend fun distributeCards(columns: Int, rows: Int, placeCards: (Int, Int) -> Unit) {

        // gehe alle Spalten durch
        for (i in 0..3) {
            // gehe alle Zeilen durch
            for (e in 0..5) {
                // platziere Karte in Spalte, Zeile
                placeCards(i, e)
                // verzögere Ablauf um 50ms
                delay(50)
            }
        }
    }

    // jetzt sollten die Karten auf dem Spielfeld erscheinen

    /**
     * Diese Funktion soll bestimmen, was passiert wenn man eine Karte anklickt
     */
    fun cardClicked(
        lastIndex: Int,
        thisIndex: Int,
        setImage: (Int) -> Unit,
        compareImages: (Int, Int) -> Unit
    ) {
        if (thisIndex != lastIndex) {
            setImage(thisIndex)
            compareImages(thisIndex, lastIndex)
        }
    }

    /**
     * Diese Funktion füllt eine neue Liste mit Bildern aus der Bilderquelle, sodass jedes Bild
     * aus der Bilderquelle zwei mal in der neuen Liste vorkommt und liefert diese zurück
     * Die Reihenfolge ist dabei zufällig
     */
    fun assignImages(numberOfCards: Int, imageSource: List<Int>): MutableList<Int> {
        // Die neue Liste
        val cardImageIDs = mutableListOf<Int>()

        while (cardImageIDs.size < numberOfCards) {
            cardImageIDs.add(imageSource[0])
            cardImageIDs.add(imageSource[1])
            cardImageIDs.add(imageSource[2])
            cardImageIDs.add(imageSource[3])
            cardImageIDs.add(imageSource[4])
            cardImageIDs.add(imageSource[5])
            cardImageIDs.add(imageSource[6])
            cardImageIDs.add(imageSource[7])
            cardImageIDs.add(imageSource[8])
            cardImageIDs.add(imageSource[9])
            cardImageIDs.add(imageSource[10])
            cardImageIDs.add(imageSource[11])
        }

        cardImageIDs.shuffle()
        // liefere die befüllte Liste zurück
        return cardImageIDs
    }

    /**
     * Diese Funktion vergleich die Bilder zweier Karten und lässt diese vom Spielfeld verschwinden
     */
    suspend fun compareCardImages(
        lastImage: Int,
        currentImage: Int,
        makeBothCardsInvisible: () -> Unit
    ) {
        // teste ob beide Bilder gleich sind
        if (currentImage == lastImage) {
            makeBothCardsInvisible()
            delay(50)
        }
    }

    /**
     * Diese Funktion prüft alle Karten in der übergebenen Liste auf Ihre Sichtbarkeit (visibility)
     * Liefert true zurück, falls es noch sichtbare Karten gibt
     */
    fun checkIfFoundAll(cards: List<ImageButton>): Boolean {
        var win = false
        if (
            cards[0 ].visibility == View.INVISIBLE && cards[1 ].visibility == View.INVISIBLE &&
            cards[2 ].visibility == View.INVISIBLE && cards[3 ].visibility == View.INVISIBLE &&
            cards[4 ].visibility == View.INVISIBLE && cards[5 ].visibility == View.INVISIBLE &&
            cards[6 ].visibility == View.INVISIBLE && cards[7 ].visibility == View.INVISIBLE &&
            cards[8 ].visibility == View.INVISIBLE && cards[9 ].visibility == View.INVISIBLE &&
            cards[10].visibility == View.INVISIBLE && cards[11].visibility == View.INVISIBLE &&
            cards[12].visibility == View.INVISIBLE && cards[13].visibility == View.INVISIBLE &&
            cards[14].visibility == View.INVISIBLE && cards[15].visibility == View.INVISIBLE &&
            cards[16].visibility == View.INVISIBLE && cards[17].visibility == View.INVISIBLE &&
            cards[18].visibility == View.INVISIBLE && cards[19].visibility == View.INVISIBLE &&
            cards[20].visibility == View.INVISIBLE && cards[21].visibility == View.INVISIBLE &&
            cards[22].visibility == View.INVISIBLE && cards[23].visibility == View.INVISIBLE
        ) {
            win = true
        }

        return win
    }
}
