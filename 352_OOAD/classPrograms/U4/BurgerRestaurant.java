public class BurgerRestaurant {
	private BugerBuilder burgerBuilder;
	public void setBuilder(BugerBuilder burgerBuilder) {
		this.burgerBuilder = burgerBuilder;
	}
	public Burger buildBurger() {
		burgerBuilder.buildBun();
		burgerBuilder.buildMeat();
		burgerBuilder.buildSalad();
		burgerBuilder.buildCheese();
		burgerBuilder.buildSauce();
		return burgerBuilder.build();
	}
}
