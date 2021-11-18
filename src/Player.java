import java.util.Stack;

public class Player {
	public Stack<Card> cards = new Stack<Card>();
	public String name;

	Player(String name) {
		this.name = name;
	}

	public Card PlayCard(Card discardCard) {
		for (Card card : cards) {
			if (discardCard.Validate(card)) {
				cards.remove(card);
				return card;
			}
		}
		// Pickup two cards, since this player couldn't play anything
		App.GiveCards(this, 2);
		return null;
	}

	public void GiveCard(Card card) {
		cards.add(card);
	}
}
