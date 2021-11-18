public class Card {
	public CardColor color;
	public CardValue value;

	Card(CardColor color, CardValue value) {
		this.color = color;
		this.value = value;
	}

	public void Use() {
		value.Run(this);
	}

	// Validate if card can be put on this card
	public Boolean Validate(Card card) {
		if (this.value == CardValue.PickColor) { return true; }
		if (this.value == CardValue.PickColorPlusFour) { return true; }

		if (this.color == card.color) { return true; }

		if (this.value == CardValue.PlusTwo) { return true; }
		if (this.value == CardValue.Twist) { return true; }
		if (this.value == CardValue.Block) { return true; }
		
		if (this.value == card.value) { return true; }

		return false;
	}
}
