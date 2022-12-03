import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CatCafe implements Iterable<Cat> {
	public CatNode root;

	public CatCafe() {
	}


	public CatCafe(CatNode dNode) {
		this.root = dNode;
	}

	// Constructor that makes a shallow copy of a CatCafe
	// New CatNode objects, but same Cat objects
	public CatCafe(CatCafe cafe) {
		/*
		 * TODO: ADD YOUR CODE HERE
		 */
		CatCafe newCafe = new CatCafe();
		CatCafeIterator cafeIterator = new CatCafeIterator();
		for (Cat cat: cafe){

			while (cafeIterator.hasNext()){
				newCafe.root = cafe.root;
				newCafe.root.senior = cafe.root.senior;
				newCafe.root.junior = cafe.root.junior;
				newCafe.root.parent = cafe.root.parent;
			}
		}

		}




	// add a cat to the cafe database
	public void hire(Cat c) {
		if (root == null) 
			root = new CatNode(c);
		else
			root = root.hire(c);
	}

	// removes a specific cat from the cafe database
	public void retire(Cat c) {
		if (root != null)
			root = root.retire(c);
	}

	// get the oldest hire in the cafe
	public Cat findMostSenior() {
		if (root == null)
			return null;

		return root.findMostSenior();
	}

	// get the newest hire in the cafe
	public Cat findMostJunior() {
		if (root == null)
			return null;

		return root.findMostJunior();
	}

	// returns a list of cats containing the top numOfCatsToHonor cats 
	// in the cafe with the thickest fur. Cats are sorted in descending 
	// order based on their fur thickness. 
	public ArrayList<Cat> buildHallOfFame(int numOfCatsToHonor) {
		/*
		 * TODO: ADD YOUR CODE HERE
		 */
		ArrayList<Cat> listOfHonor = new ArrayList<>(numOfCatsToHonor);
		if(numOfCatsToHonor == 1){
			listOfHonor.add(root.catEmployee);
		} else {
			while (root != null && numOfCatsToHonor != 1) {
				// add the root first
				listOfHonor.add(root.catEmployee);
				// add the child that has thicker fur
				if (root.senior.catEmployee.getFurThickness() > root.junior.catEmployee.getFurThickness()) {
					listOfHonor.add(root.senior.catEmployee);
				} else {
					listOfHonor.add(root.junior.catEmployee);
				}
				retire(root.catEmployee);
				numOfCatsToHonor--;
			}
		}
		return listOfHonor;
	}

	// Returns the expected grooming cost the cafe has to incur in the next numDays days
	public double budgetGroomingExpenses(int numDays) {
		/*
		 * TODO: ADD YOUR CODE HERE
		 */


		return 0;
	}

	// returns a list of list of Cats. 
	// The cats in the list at index 0 need be groomed in the next week. 
	// The cats in the list at index i need to be groomed in i weeks. 
	// Cats in each sublist are listed in from most senior to most junior. 
	public ArrayList<ArrayList<Cat>> getGroomingSchedule() {
		/*
		 * TODO: ADD YOUR CODE HERE
		 */
		return null;
	}


	public Iterator<Cat> iterator() {
		return new CatCafeIterator();
	}


	public class CatNode {
		public Cat catEmployee;
		public CatNode junior;
		public CatNode senior;
		public CatNode parent;

		public CatNode(Cat c) {
			this.catEmployee = c;
			this.junior = null;
			this.senior = null;
			this.parent = null;
		}

		// add the c to the tree rooted at this and returns the root of the resulting tree
		public CatNode hire (Cat c) {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			// add the element to the heap as binary search tree
			insertCat(null, root, c);

			// search the node of c
			CatNode cur = searchCat(root, c);


			//rotate
			while(cur != root){
				maxHeapify(cur);
				cur = cur.parent;
			}
			return cur;
		}


		//Helper method to do correct rotation
		private void maxHeapify(CatNode cur){
			//if c has thicker fur than its junior,  do right rotation
			if (cur.junior != null && cur.catEmployee.getFurThickness() < cur.junior.catEmployee.getFurThickness()) {
				rightRotate(cur);
			}
			// if c has thinner fur than its senior, do left rotation
			else if (cur.senior != null && cur.catEmployee.getFurThickness() < cur.senior.catEmployee.getFurThickness()) {
				leftRotate(cur);
			}
		}

		//Helper method: search cat
		private CatNode searchCat(CatNode root, Cat c){
			CatNode cur = root;
			while (true) {
				if (c.compareTo(cur.catEmployee) > 0) {
					return searchCat(cur.senior, c);
				}
				else if (c.compareTo(cur.catEmployee) < 0) {
					return searchCat(cur.junior, c);
				}
				else {
					break;
				}
			}
			return cur;
		}

		//Helper method: insert cat
		private CatNode insertCat(CatNode parent, CatNode root, Cat c){
			if (root == null){
				root = new CatNode(c);
				root.parent = parent;
			}
			// if seniority of cur cat - c < 0 => c is less senior
			else if (c.compareTo(root.catEmployee) < 0 ){
				root.junior = insertCat(root, root.junior, c);
			}
			// if seniority of cur cat - c > 0 => c is more senior
			else if (c.compareTo(root.catEmployee) > 0 ) {
				root.senior = insertCat(root, root.senior, c);
			}
			return root;
		}


		//helper method: left rotation
		private void leftRotate(CatNode x){
			CatNode y = x.senior; // assign x as the parent of the left subtree of y
			x.senior = y.junior;
			if (y.junior != null) {
				y.junior.parent = x;
			}
			y.parent = x.parent;
			if(x.parent == null){
				root = y;
			}
			//if x is the left child of its parent p, make y as the left child of p
			else if (x == x.parent.junior) {
				x.parent.junior = y;
			} else { // assign y as the right child of p
				x.parent.senior = y;
			}
			y.junior = x;
			x.parent = y; // make y as the parent of x

			}

		//helper method: right rotation
		private void rightRotate(CatNode x){
			//assign y as the parent of the right subtree of x
			CatNode y = x.junior;
			x.junior = y.senior;
			if(y.senior != null){
				y.senior.parent = x;
			}
			y.parent = x.parent;
			if(x.parent == null){
				root = y;
			}
			// if y the right child of its parent p, make x as the right child of p
			else if (x == x.parent.senior) {
				x.parent.senior = y;
			} else { //assign x as the left child of p
				x.parent.junior = y;
			}
			y.senior = x;
			y.parent = x; // make x as the parent of y
		}

		// remove c from the tree rooted at this and returns the root of the resulting tree
		public CatNode retire(Cat c) {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			// remove seniorC to the left subtree
			CatNode cur = searchCat(root, c);
			root = removeCat(root, c);


			while(cur.parent != null && cur.catEmployee.getFurThickness() < cur.parent.catEmployee.getFurThickness()) {
				// if maxHeap still maintains, no need to downheap
				// if maxheap breaks, do downheap
				// determine which of the two children should be swapped in the parent position to do correct rotation

					maxHeapify(cur);
					cur = cur.parent;
			}
			return root;
		}



		//helper method: removeCat
		private CatNode removeCat(CatNode root, Cat c) {

			if (root == null) { //tree is empty so nothing to remove
				return null;
			}
			//if seniority of c < root.key, search to the left
			else if (c.compareTo(root.catEmployee) < 0) {
				root.junior = removeCat(root.junior, c);
			}
			//if seniority of c > root.key, search to the right
			else if (c.compareTo(root.catEmployee) > 0) {
				root.senior = removeCat(root.senior, c);
			}
			//if there is no left child, make root equal to right child
			else if (root.junior == null) {
				root = root.senior;
			}
			//if there is no right child, make root equal to left child
			else if (root.senior == null){

				root = root.junior;
			}
			// if c has both children
			else{
				//find most senior in the left subtree and update the root, replace c with mostSenior
				root.catEmployee = root.junior.findMostSenior();
				//call recursively remove on the left subtree to remove the most senior one
				root.junior = removeCat(root.junior, root.catEmployee);
			}
			return root;
		}

		// find the cat with highest seniority in the tree rooted at this
		public Cat findMostSenior() {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			if(root.senior == null){
				return root.catEmployee;
			} else {
				root = root.senior;
			}
			return root.findMostSenior();
		}

		// find the cat with lowest seniority in the tree rooted at this
		public Cat findMostJunior() {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			if(root.junior == null){
				return root.catEmployee;
			} else {
				root = root.junior;
			}
			return root.findMostJunior();
		}

		// Feel free to modify the toString() method if you'd like to see something else displayed.
		public String toString() {
			String result = this.catEmployee.toString() + "\n";
			if (this.junior != null) {
				result += "junior than " + this.catEmployee.toString() + " :\n";
				result += this.junior.toString();
			}
			if (this.senior != null) {
				result += "senior than " + this.catEmployee.toString() + " :\n";
				result += this.senior.toString();
			} /*
			if (this.parent != null) {
				result += "parent of " + this.catEmployee.toString() + " :\n";
				result += this.parent.catEmployee.toString() +"\n";
			}*/
			return result;
		}
	}


	private class CatCafeIterator implements Iterator<Cat> {
		// HERE YOU CAN ADD THE FIELDS YOU NEED
		ArrayList<CatNode> catArrayList;


		private CatCafeIterator() {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			insertJunior(root);
		}

		private void insertJunior(CatNode current) {
			// store all the left nodes of the given BST in an array
			// so that the last node will be the smallest value in the BST.
			while (current.junior != null) {
				catArrayList.add(root);
				current = current.junior;
			}
		}

		public Cat next() {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// remove the last node from the array
			int last = catArrayList.size() - 1;
			CatNode cur = catArrayList.get(last);
			catArrayList.remove(last);
			// add all the left nodes of the right subtree of the removed topmost node in the array
			// the new last node in the array will point to the next node in the inorder traversal
			if (cur.senior != null) {
				insertJunior(root.senior);
			}
			// return the removed node.
			return cur.catEmployee;
		}

		public boolean hasNext() {
			/*
			 * TODO: ADD YOUR CODE HERE
			 */
			return !catArrayList.isEmpty();

		}
	}


	public void printTree(CatNode root)
	{
		//Thanks, GeeksForGeeks!:D
		printTree(root, 0);
		System.out.println("\n\n----------------------------------------------------------\n\n");

	}
	private void printTree(CatNode root, int spaceCount)
	{
		if(root==null)
			return;

		int spacing = spaceCount+20;

		printTree(root.senior, spacing);


		System.out.println();
		for(int index=0; index < spacing; index++)
			System.out.print(" ");
		System.out.println(root.catEmployee);

		printTree(root.junior, spacing);
	}

	public static void main(String[] args) {
		Cat B = new Cat("Buttercup", 45, 53, 5, 85.0);
		Cat C = new Cat("Chessur", 8, 23, 2, 250.0);
		Cat J = new Cat("Jonesy", 0, 21, 12, 30.0);	
		Cat JJ = new Cat("JIJI", 156, 17, 1, 30.0);
		Cat JTO = new Cat("J. Thomas O'Malley", 21, 10, 9, 20.0);
		Cat MrB = new Cat("Mr. Bigglesworth", 71, 0, 31, 55.0);
		Cat MrsN = new Cat("Mrs. Norris", 100, 68, 15, 115.0);
		Cat T = new Cat("Toulouse", 180, 37, 14, 25.0);


		Cat BC = new Cat("Blofeld's cat", 6, 72, 18, 120.0);
		Cat L = new Cat("Lucifer", 10, 44, 20, 50.0);

	}


}


