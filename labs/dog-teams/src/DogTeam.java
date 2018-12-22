public class DogTeam {

	private LLDogNode head;

	public DogTeam(Dog dog) {
		this.head = new LLDogNode(dog, null);
	}

	public void printTeam() {
		LLDogNode cur = head;
		int dogNumber = 1;

		System.out.println("----------------");

		while (cur != null) {
			System.out.println(dogNumber + ". " + cur.getContents().getName() + ", " + cur.getContents().getWeight());
			cur = cur.getLink();
			dogNumber += 1;
		}
	}

	public void insertHead(Dog dog) {
		// puts new node containing dog at the head of the list
		LLDogNode newDog = new LLDogNode(dog, null);
		newDog.setLink(head);
		head = newDog;
	}

	public void insertTail(Dog dog) {
		LLDogNode node = head;
		LLDogNode newDog = new LLDogNode(dog, null);

		if (head == null)
			head = newDog;

		while (node.getLink() != null)
			node = node.getLink();

		node.setLink(newDog);
	}

	public double weightDiff() {

		double lWeight = head.getContents().getWeight();
		double sWeight = head.getContents().getWeight();

		LLDogNode iterator = head;

		while (iterator != null) {
			if (iterator.getContents().getWeight() > lWeight)
				lWeight = iterator.getContents().getWeight();
			if (iterator.getContents().getWeight() < sWeight)
				sWeight = iterator.getContents().getWeight();

			iterator = iterator.getLink();

		}

		return lWeight - sWeight;

	}

	public void insertAfter(Dog dog, String dogName) {
		LLDogNode newDog = new LLDogNode(dog, null);
		LLDogNode iterator = head;
		while (iterator != null) {
			if (iterator.getContents().getName().equals(dogName)) {
				newDog.setLink(iterator.getLink());
				iterator.setLink(newDog);
				break;
			}
			iterator = iterator.getLink();
		}

	}

	public static void main(String[] args) {

		DogTeam team = new DogTeam(new Dog("dog1", 60));
		team.printTeam();
		System.out.println("weightDiff: " + team.weightDiff());

		team.insertTail(new Dog("dog0", 5));
		team.insertHead(new Dog("dog2", 90));
		System.out.println();
		team.printTeam();
		System.out.println("weightDiff: " + team.weightDiff());

		team.insertHead(new Dog("dog3", 7));
		team.insertAfter(new Dog("dog4", 100), "dog2");
		team.printTeam();

		team.insertTail(new Dog("dog10", 205));
		team.insertAfter(new Dog("dog9", 75), "dog10");

		team.printTeam();
		System.out.println("weightDiff: " + team.weightDiff());

	}
}
