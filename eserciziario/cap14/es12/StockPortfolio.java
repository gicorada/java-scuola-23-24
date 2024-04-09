package eserciziario.cap14.es12;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StockPortfolio {

    private static class Block {
        private int quantita;
        private final double prezzoUnitario;

        public Block(int quantita, double prezzoUnitario) {
            this.quantita = quantita;
            this.prezzoUnitario = prezzoUnitario;
        }
    }
    public static void main(String[] args) {
        LinkedList<Block> blocks = new LinkedList<>();


        try(Scanner s = new Scanner(System.in)) {
            while (true) {
                System.out.println("Inserisci il comando (buy/sell/quit):");
                String[] command = s.nextLine().split(" ");

                switch (command[0]) {
                    case "buy": {
                        int quantita = Integer.parseInt(command[1]);
                        double prezzoUnitario = Double.parseDouble(command[2]);
                        blocks.add(new Block(quantita, prezzoUnitario));

                        displayPortfolio(blocks);
                        break;
                    }
                    case "sell": {
                        int quantita = Integer.parseInt(command[1]);
                        double prezzoUnitario = Double.parseDouble(command[2]);
                        double profit = sellStock(blocks, quantita, (int) (prezzoUnitario * 100));
                        System.out.println("Profitto ottenuto dalla vendita: $" + profit);
                        displayPortfolio(blocks);
                        break;
                    }
                    case "quit":
                        System.exit(0);
                    default:
                        System.out.println("Comando non riconosciuto.");
                        break;
                }
            }
        }
    }

    static void displayPortfolio(List<Block> blocks) {
        System.out.println("Portfolio attuale:");
        for (Block block : blocks) {
            System.out.println("Quantità: " + block.quantita + ", Prezzo unitario: $" + block.prezzoUnitario / 100.0);
        }
    }

    static double sellStock(List<Block> blocks, int quantita, int prezzoUnitario) {
        double profitto = 0;
        int quantitaRimanente = quantita;

        for (Block block : blocks) {
            if (block.quantita >= quantitaRimanente) {
                profitto += quantitaRimanente * (prezzoUnitario - block.prezzoUnitario) / 100.0;
                block.quantita -= quantitaRimanente;
                if (block.quantita == 0) {
                    blocks.remove(block);
                }
                break;
            } else {
                profitto += block.quantita * (prezzoUnitario - block.prezzoUnitario) / 100.0;
                quantitaRimanente -= block.quantita;
                blocks.remove(block);
            }
        }

        return profitto;
    }
}

