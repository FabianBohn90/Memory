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
        // todo Schreibe hier deinen Code
        for (i in 0..11) run {
            hideCard(cards[i])
        }
    }

    /**
     *  Diese Funktion geht alle Felder durch und platziert nacheinander, mit Hilfe des
     *  übergebenen Lambdas (= Pfeilfunktion) eine Karte auf jedem Feld
     */
    suspend fun distributeCards(columns: Int, rows: Int, placeCards: (Int, Int) -> Unit) {
        // gehe alle Spalten durch
        // gehe alle Zeilen durch
        // platziere Karte in Spalte, Zeile
        for (i in 0..3) {
            placeCards(columns, rows)
            delay(50)
            for (e in 0..5) {
                placeCards(columns, rows)
                // verzögere Ablauf um 50ms
                delay(50)
            }
        }
    }

    // jetzt sollten die Karten auf dem Spielfeld erscheinen

    /**
     * Diese Funktion soll bestimmen, was passiert wenn man eine Karte anklickt
     */
    fun cardClicked(lastIndex: Int, thisIndex: Int, setImage: (Int) -> Unit, compareImages: (Int, Int) -> Unit) {

        if (thisIndex != lastIndex) {
            compareImages(thisIndex, lastIndex)
            setImage(thisIndex)
        }

        // stelle sicher, dass es sich nicht um die gleiche Karte handelt
        // todo Schreibe hier deinen Code
        // setze das Bild
        // vergleiche die Bilder
        // todo Schreibe hier deinen Code
    }

    /**
     * Diese Funktion füllt eine neue Liste mit Bildern aus der Bilderquelle, sodass jedes Bild
     * aus der Bilderquelle zwei mal in der neuen Liste vorkommt und liefert diese zurück
     * Die Reihenfolge ist dabei zufällig
     */
    fun assignImages(numberOfCards: Int, imageSource: List<Int>): MutableList<Int> {

        // Die neue Liste
        val cardImageIDs = mutableListOf<Int>()


        // todo Schreibe hier deinen Code
        while (cardImageIDs.size < 23) {
            cardImageIDs.add(0, imageSource[0])
            cardImageIDs.add(1, imageSource[1])
            cardImageIDs.add(2, imageSource[2])
            cardImageIDs.add(3, imageSource[3])
            cardImageIDs.add(4, imageSource[4])
            cardImageIDs.add(5, imageSource[5])
            cardImageIDs.add(6, imageSource[6])
            cardImageIDs.add(7, imageSource[7])
            cardImageIDs.add(8, imageSource[8])
            cardImageIDs.add(9, imageSource[9])
            cardImageIDs.add(10, imageSource[10])
            cardImageIDs.add(11, imageSource[11])
        }
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
        // todo Schreibe hier deinen Code
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

        // todo Schreibe hier deinen Code
        for (i in cards) {
            if (cards.indexOf(i) == View.VISIBLE) {
                return false
            }
        }
        return true
    }
}
