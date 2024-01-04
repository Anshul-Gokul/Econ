package econ;

import java.util.*;


public class GameTheory {

    public static class Player {
        private String name;
        private List<Double> payoffMatrix;

        public Player(String name, List<Double> payoffMatrix) {
            this.name = name;
            this.payoffMatrix = payoffMatrix;
        }

        public String getName() {
            return name;
        }

        public List<Double> getPayoffMatrix() {
            return payoffMatrix;
        }
    }

    public static class Game {
        private List<Player> players;

        public Game() {
            this.players = new ArrayList<>();
        }

        public void addPlayer(Player player) {
            players.add(player);
        }

        public List<Player> getPlayers() {
            return players;
        }


        public List<String> findNashEquilibria() {
            List<String> nashEquilibria = new ArrayList<>();

     
            int numPlayers = players.size();
            int[] strategyIndices = new int[numPlayers];
            int numStrategies = players.get(0).getPayoffMatrix().size();
            int[] maxPayoffIndices = new int[numPlayers];
            double[] maxPayoffs = new double[numPlayers];

            for (int i = 0; i < numStrategies; i++) {
                for (int j = 0; j < numPlayers; j++) {
                    strategyIndices[j] = i;
                }


                for (int j = 0; j < numPlayers; j++) {
                    Player player = players.get(j);
                    List<Double> payoffMatrix = player.getPayoffMatrix();
                    maxPayoffs[j] = payoffMatrix.get(i);
                    maxPayoffIndices[j] = i;

                    for (int k = 0; k < numStrategies; k++) {
                        if (k == i) continue;
                        int[] tempIndices = strategyIndices.clone();
                        tempIndices[j] = k;
                        double payoff = payoffMatrix.get(getIndex(tempIndices, numStrategies));
                        if (payoff > maxPayoffs[j]) {
                            maxPayoffs[j] = payoff;
                            maxPayoffIndices[j] = k;
                        }
                    }
                }


                boolean isNashEquilibrium = true;
                for (int j = 0; j < numPlayers; j++) {
                    if (maxPayoffs[j] < players.get(j).getPayoffMatrix().get(getIndex(strategyIndices, numStrategies))) {
                        isNashEquilibrium = false;
                        break;
                    }
                }

                if (isNashEquilibrium) {
                    StringBuilder equilibrium = new StringBuilder("Nash Equilibrium: ");
                    for (int j = 0; j < numPlayers; j++) {
                        Player player = players.get(j);
                        equilibrium.append(player.getName()).append(" chooses Strategy ")
                                  .append(maxPayoffIndices[j]).append(", ");
                    }
                    equilibrium.setLength(equilibrium.length() - 2); 
                    nashEquilibria.add(equilibrium.toString());
                }
            }

            return nashEquilibria;
        }

        private int getIndex(int[] indices, int numStrategies) {
            int index = 0;
            int multiplier = 1;

            for (int i = indices.length - 1; i >= 0; i--) {
                index += indices[i] * multiplier;
                multiplier *= numStrategies;
            }

            return index;
        }
    }

}
