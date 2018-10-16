public class FizzBuzz {

	public static void main(String[] args) {

		//Initialize i and increment it 61 times in a for loop
		for(Integer i = new Integer(1); i < 61; i++){

			//Make a new line at the start of each iteration
			// The line needs to be at the start because of the initial blank in the output
			System.out.println();

			//Whenever i is not a multiple of 3 or 5 then just print it
			if(i % 3 != 0 && i % 5 != 0){

				System.out.print(i);

			}

			//if i is a multiple of 3 output "Fizz"
			if(i % 3 == 0){
				System.out.print("Fizz");
			}
			
			//if i is a multiple of 5 output "Buzz"
			if(i % 5 == 0){
				System.out.print("Buzz");
			}


		}
	}


}