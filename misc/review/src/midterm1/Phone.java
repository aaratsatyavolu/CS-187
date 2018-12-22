package midterm1;

public class Phone {
	void answer() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		Phone myPhone = (Phone) new CellPhone();
		myPhone.answer();
	}
}
