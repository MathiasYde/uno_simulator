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
		// These cards can be put on any other card
		if (this.value == CardValue.PickColor) { return true; }
		if (this.value == CardValue.PickColorPlusFour) { return true; }

		// Cards beyond here must match color
		if (this.color == card.color) { return true; }

		// These cards can be put on any other card with same color
		if (this.value == CardValue.PlusTwo) { return true; }
		if (this.value == CardValue.Twist) { return true; }
		if (this.value == CardValue.Block) { return true; }
		
		// These cards must match in color and value
		if (this.value == card.value) { return true; }

		return false;
	}
}
