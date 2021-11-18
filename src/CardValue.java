public enum CardValue {
	Zero{ @Override public void Run(Card card) {} },
	One{ @Override public void Run(Card card) {} },
	Two{ @Override public void Run(Card card) {} },
	Three{ @Override public void Run(Card card) {} },
	Four{ @Override public void Run(Card card) {} },
	Five{ @Override public void Run(Card card) {} },
	Six{ @Override public void Run(Card card) {} },
	Seven{ @Override public void Run(Card card) {} },
	Eight{ @Override public void Run(Card card) {} },
	Nine{ @Override public void Run(Card card) {} },
	Twist{ @Override public void Run(Card card) { App.players.reverse(); } },
	Block{ @Override public void Run(Card card) { App.players.advance(); } },
	PlusTwo{ @Override public void Run(Card card) { App.GiveCards(App.players.next(), 2); } },
	PickColor{ @Override public void Run(Card card) { card.color = App.randomCardColor(); } },
	PickColorPlusFour{ @Override public void Run(Card card) { card.color = App.randomCardColor(); App.GiveCards(App.players.next(), 4);} };

	public abstract void Run(Card card);
}
