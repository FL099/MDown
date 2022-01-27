# Markdown Converter

Ziel ist es, einen eigenen Markdown-Converter zu entwickeln, die Gestaltung als Spring Projekt kommt daher, 
dass er dann theoretisch in mehreren Projekten einsetzbar wäre und ich die Technologie gerade erst gelernt habe
und mich verbessern möchte

## Bestandteile
* Model - das ist die eigentliche Logik,
  * ***DocumentElement*** beschreibt ein einzelnes Markup - Element (tag in html, "#" o.ä. in Markdown)
  * ***ElementTag*** beschreibt die unterstützten HTML Elemente
  * ***FileType*** beschreibt die Ausgabeformate
* ***auth, controller, interfaces*** und ***services*** sind für die Funktion als Web-Anwendung da
* Der Rest ist vom Framework usw

## Funktion

Anfangs sollte der Converter über das Web-Interface Markdown-Text entgegennehmen und in HTML umwandeln können,
später ist geplant, die Funktionalität zu erweitern:  
- [ ] In pdf umwandeln
- [ ] In .docx (oder offenen Standard) umwandeln
- [ ] Aus Files lesen
- [ ] Aus Json lesen
- [ ] Aus HTML in andere Formate umwandeln
- [ ] Aus pdf in andere Formate umwandeln

## Benutzung

über ```/api/md``` **(GET)** kann abgefragt werden, welche umwandlungsmöglichkeiten von Markdown 
zu anderen Formaten momentan verfügbar sind  

über ```/api/html``` **(GET)** kann abgefragt werden, welche umwandlungsmöglichkeiten von HTML
zu anderen Formaten momentan verfügbar sind

über die jeweiligen **POST**-Methoden (zB ```/api/md/html```) kann der gewünschte Text an die api übergeben werden, 
und wird im gewünschten Format retourniert (in diesem Fall HTML)

## Sonstiges
