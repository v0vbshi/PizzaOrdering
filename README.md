//Aleksandr Subbotin && Tracy Cuiyi Tang && Steven Tran && Cameron Sing && Yaxin Shi
//CISP 401 - Mo 6:30-9:35 PM
//Spring 2017
//Final Project (Team 6)
/*We wrote a java program that allows customers to order pizza online. On the top of the program, we designed a moving logo that attracts customers’ attention. Customers can select the buttons for different toppings on the pizza and the drink they want. Then the program will calculate the total amount after tax. Customers can either pay it with cash, debit card, or credit card. If the customer select the debit and credit card option, then the program will verify the card number and the expiration date. The program also has a clear button that allows customers to restart on their order.

To begin our pogram, we have our main class PizzaOrderMenu. In our class, we first created a border pane and declared all the global variables. Then we have the start method that includes the basic layout such as scene, stage, panes for titles, panes for buttons for selections, and default values for prices. After the start method, we created a main method that will launch the program. Then we created a method for card validation that will check customers’ debit or credit card’s expiration date and digits. The formOfPayment method will display the buttons to select different methods of payment. In case of mistakenly typing the wrong information, we also have a method, clearFormOfPayment, will clear the form of payment so that customers can reselect cash or card. Before checking customers’ card information, the program has to display a text box for customers to enter their information. Therefore, we created a method called showCardInfo to display card number, expire date, month, and year. Again, in case of human errors, we created a method, clear card info, that will allow users to restart typing their card information. We also created a method, clearTextFields, will allow customers to restart on their pizza order, in case if they want to choose different toppings and drinks. Then we created a method called showClearButtons to combine all of the clear features together into a clear button so that customers can restart on a completely different order. In order to make our program more interesting, we decided to add pictures next to the pizza and beverage buttons with showPizzaBeverages method. Under this method, we also included check boxes for toppings and different type beverages. After customers selected everything they wanted, we have methods called showTaxShowTotal, pricing, pricing2, setRB, and setChkbox to calculate the total prices for pizza and beverages then display the total amount the money the customers need to pay. At last, we created a method, cardValidation, will open a new scene that tells customers whether their card is valid or not. 

For the project, our group met twice a week, Monday and Saturday, to work on it together. Everyone worked very hard and spend a lot of times on this project. We hope that our hard work will get recognized. Aleksandr Subbotin created the outline and the foundation of the program. With his hard work, the rest of teammates can work on bettering the program. Tracy Cuiyi Tang worked on calculating the prices and clear buttons that serve major purposes in our program. Both clear buttons and prices are very important to the users and are key parts of this program.  Steven Tran worked on card validation which includes checking card expiration date and the correct amount of digits for debit and credit card. His hard work made it possible for us to make our program more convenient since many people use debit or credit card now days. Cameron Sing worked on reconstruct our program to make it more efficient and useable. In programming world, efficient is very important. If our program takes 10 mins to run then no one would ever use it. Therefore, Cameron’s hard work is very crucial in jobs like a computer programmer.  Yaxin Shi worked on the title of our program. The title of a program is very important because it is the first thing users see. In order to make a program’s title stands out from the rest of programs, a good title require a lot of hard work and time. Yaxin also worked on the power point, essays, and wrapping up the program by combining everything together. Overall, everyone did a great job in this project. We enjoy spending time with each other and putting efforts into this project.
*/