# first-steps-first-repository
here my first projects in Kotlin and Java! and it's my first experience in GitHub

In real life, parking lots vary in size. At this stage, we will get better at making art imitate life. 
To do this, we will make our program customizable by adding a create command that allows the user to specify the number of spots. 
For example, the command create 3 makes a parking lot with three spots. The number of spots should be positive. 
The program output should be the following: Created a parking lot with 3 spots.

Other commands like park or leave should return an error Sorry, a parking lot has not been created. until the user enters the create command. 
If the user calls create again, the previous parking state should be reset.

It is also important to keep track of which spaces are occupied by which cars. 
For this, add a status command that prints all occupied spots in ascending order.
For each spot, it should print the spot number, the car’s plate registration number, 
and the color of the car, all separated by spaces like the example below. 
If there are no occupied spots, the program should print: Parking lot is empty.

The command reg_by_color prints all registration numbers of cars of a particular color, taking color as a parameter. 
The color may be written in uppercase or lowercase letters. For example, reg_by_color BLACK. 
The answer should contain registration numbers separated by commas. The order should be the same as in the status command. 
If there are no cars of this color, the output should be like this: No cars with color BLACK were found..

The command spot_by_color is similar to the previous one, but it prints the parking space numbers of all the cars of a particular color.

The command spot_by_reg returns you the number of the spot where a car is located based on its registration number, for example, spot_by_reg KA-01. 
This command will also return an error message if your car was not found: No cars with registration number KA-01 were found. 
For convenience, let's suppose that all car registration numbers are unique.
