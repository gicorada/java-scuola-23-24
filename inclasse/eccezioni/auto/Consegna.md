# Gestione di auto con resa

## Consegna

Dato il file datiAuto.txt, il programma deve generare una lista di auto, e restituire la resa di ogni auto a schermo

## Indicazioni

E' necessario utilizzare due classi separate per la risoluzione dell'esercizio.  
La prima classe deve rappresentare un auto, con tutte le caratteristiche presenti nel file di input (nome, km percorsi, litri utilizzati).  
La seconda classe deve invece sfruttare la prima per creare una lista di auto, e per ognuna calcolare la resa e restituirla all'utente.

La classe che rappresenta l'auto deve occuparsi di calcolare la resa, e deve gestire le situazioni particolari in cui:
- I km percorsi sono negativi o nulli, ma i litri sono positivi
- I km percorsi sono positivi, ma i litri utilizzati sono negativi o nulli
- I km percorsi e i litri utilizzati sono negativi o nulli

In questi casi, la classe deve lanciare un'eccezione, che deve essere poi gestita dall'altra classe senza provocare un'interruzione del programma