import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class App {
    public static CircularQueue<Player> players = new CircularQueue<Player>(4);
    public static Stack<Card> discardPile = new Stack<Card>();
    public static Stack<Card> drawPile = new Stack<Card>();

    public static void main(String[] args) throws Exception {
        Reset();
        
        while (!drawPile.empty()) {
            Player player = players.peek();
            Card playedCard = player.PlayCard(discardPile.peek());
            if (playedCard != null) {
                playedCard.Use();
                discardPile.add(playedCard);
            }
            if (player.cards.empty()) {
                System.out.println("Player " + player.name + " has won");
                break;
            }
            Draw();
            players.advance();
        }
    }

    public static void Reset() {
        // Add players
        for (int i = 0; i < 4; i++) {
            players.enqueue(new Player("Pik " + Integer.toString(i)));
        }

        // Add every card, for every color, for every value
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                drawPile.add(new Card(color, value));
            }
        }

        // Randomize draw pile
        Collections.shuffle(drawPile);
    
        // Give 7 cards to all players
        for (Player player : players) {
            GiveCards(player, 7);
        }

        // Put the first card in the draw pile
        discardPile.add(drawPile.pop());
    }

    public static CardColor randomCardColor() {
        return CardColor.values()[new Random().nextInt(CardColor.values().length)];
    }

    public static void GiveCards(Player player, int count) {
        System.out.println("Giving cards to player " + player.name);
        for (int i = 0; i < count; i++) {
            if (drawPile.isEmpty()) { continue; }
            player.GiveCard(drawPile.pop());
        }
    }

    public static void Draw() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("Cards in draw pile: " + drawPile.size());
        System.out.println("Cards in discard pile: " + discardPile.size());
        System.out.println("Current player: " + players.peek().name);
    }
}
