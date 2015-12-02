public class Main {

	public Main() {

		// @Lets do business

		ObservableManager.getInstance().initialize();
		
		
		TestObserver testObserver=new TestObserver("TestObserver 1");

		TestObserver testObserver2=new TestObserver("TestObserver 2");
		
		ObservableManager.getInstance().getMyDataCenter().setValue(5);

	}

	public static void main(String[] args) {

		new Main();

	}

}
