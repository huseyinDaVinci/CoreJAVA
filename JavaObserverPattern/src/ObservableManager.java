public class ObservableManager {

	private static ObservableManager mInstance;

	private MyDataCenter myDataCenter;

	MyDataCenter getMyDataCenter() {
		return myDataCenter;
	}

	void setMyDataCenter(MyDataCenter myDataCenter) {
		this.myDataCenter = myDataCenter;
	}

	/**Singleton pattern is used to prevent the creation of more than one ObservableManager instance
	 * @return
	 */
	public static synchronized ObservableManager getInstance() {

		if (null == mInstance) {

			mInstance = new ObservableManager();
		}
		return mInstance;
	}

	
	void initialize() {
		myDataCenter = new MyDataCenter(0);
	}

}
