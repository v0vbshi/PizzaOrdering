//Aleksandr Subbotin && Tracy Cuiyi Tang && Steven Tran && Cameron Sing && Yaxin Shi
//CISP 401 - Mo 6:30-9:35 PM
//Spring 2017
//Final Project (Team 6)
/*We wrote a java program that allows customers to order pizza online. On the top of the program, we designed a moving logo that attracts customers’ attention. Customers can select the buttons for different toppings on the pizza and the drink they want. Then the program will calculate the total amount after tax. Customers can either pay it with cash, debit card, or credit card. If the customer select the debit and credit card option, then the program will verify the card number and the expiration date. The program also has a clear button that allows customers to restart on their order.

To begin our program, we have our main class PizzaOrderMenu. In our class, we first created a border pane and declared all the global variables. Then we have the start method that includes the basic layout such as scene, stage, panes for titles, panes for buttons for selections, and default values for prices. After the start method, we created a main method that will launch the program. Then we created a method for card validation that will check customers’ debit or credit card’s expiration date and digits. The formOfPayment method will display the buttons to select different methods of payment. In case of mistakenly typing the wrong information, we also have a method, clearFormOfPayment, will clear the form of payment so that customers can reselect cash or card. Before checking customers’ card information, the program has to display a text box for customers to enter their information. Therefore, we created a method called showCardInfo to display card number, expire date, month, and year. Again, in case of human errors, we created a method, clear card info, that will allow users to restart typing their card information. We also created a method, clearTextFields, will allow customers to restart on their pizza order, in case if they want to choose different toppings and drinks. Then we created a method called showClearButtons to combine all of the clear features together into a clear button so that customers can restart on a completely different order. In order to make our program more interesting, we decided to add pictures next to the pizza and beverage buttons with showPizzaBeverages method. Under this method, we also included check boxes for toppings and different type beverages. After customers selected everything they wanted, we have methods called showTaxShowTotal, pricing, pricing2, setRB, and setChkbox to calculate the total prices for pizza and beverages then display the total amount the money the customers need to pay. At last, we created a method, cardValidation, will open a new scene that tells customers whether their card is valid or not. 

For the project, our group met twice a week, Monday and Saturday, to work on it together. Everyone worked very hard and spend a lot of times on this project. We hope that our hard work will get recognized. Aleksandr Subbotin created the outline and the foundation of the program. With his hard work, the rest of teammates can work on bettering the program. Tracy Cuiyi Tang worked on calculating the prices and clear buttons that serve major purposes in our program. Both clear buttons and prices are very important to the users and are key parts of this program.  Steven Tran worked on card validation which includes checking card expiration date and the correct amount of digits for debit and credit card. His hard work made it possible for us to make our program more convenient since many people use debit or credit card now days. Cameron Sing worked on reconstruct our program to make it more efficient and useable. In programming world, efficient is very important. If our program takes 10 mins to run then no one would ever use it. Therefore, Cameron’s hard work is very crucial in jobs like a computer programmer.  Yaxin Shi worked on the title of our program. The title of a program is very important because it is the first thing users see. In order to make a program’s title stands out from the rest of programs, a good title require a lot of hard work and time. Yaxin also worked on the power point, essays, and wrapping up the program by combining everything together. Overall, everyone did a great job in this project. We enjoy spending time with each other and putting efforts into this project.
*/

//PizzaOrderMenu

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class PizzaOrderMenu extends Application 
{
    //Create border pane
    BorderPane borderPane = new BorderPane(); 
    
    BorderPane borderPanePayments = new BorderPane();
    VBox vBoxPayment = new VBox();
    GridPane cardInfoPane = new GridPane();
    ImageView imagePizza = new ImageView("pizza.png");
    ImageView imageBeverages = new ImageView("beverages.png");
    ImageView pizzaLogo = new ImageView("pizzaLogo.jpg");
    
    //global variables 
    TextField tfPizza;
    TextField tfBeverage;
    TextField tfTax;
    TextField tfTotalPrice;
    double priceForPizza = 0.00;
    double priceForBeverage = 0.00;
    final double TAX = 0.08;
    double taxAmount = 0.00;
    double total = 0.00;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    
    
     
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) 
    {
        String pizzaPriceTotal = "$0.00";
        String beveragePrice = "$0.00";
        
        //final String TAX = "8.00";
        String taxTotal = "$0.00";
        String totalPrice = "$0.00";      

        showPizzaBeverages ();
        
        // ------  Vbox2 Right Panel -------------------------------------------
        VBox vbox2 = new VBox();
        vbox2.setPadding(new Insets(40, 30, 0, 10));
        vbox2.setSpacing(20);
        
        
        tfPizza = new TextField(pizzaPriceTotal);
        tfPizza.setEditable(false);
        Label lbPizza = new Label("Pizza:", tfPizza);
        lbPizza.setContentDisplay(ContentDisplay.BOTTOM);
        
        tfBeverage = new TextField(beveragePrice);
        tfBeverage.setEditable(false);
        Label lbBeverage = new Label("Beverage:", tfBeverage);
        lbBeverage.setContentDisplay(ContentDisplay.BOTTOM);
        
        tfTax = new TextField(taxTotal);
        tfTax.setEditable(false);
        Label lbTax = new Label("Tax: 8.00%", tfTax);
        lbTax.setContentDisplay(ContentDisplay.BOTTOM);
        
        tfTotalPrice = new TextField(totalPrice);
        tfTotalPrice.setEditable(false);
        Label lbTotalPrice = new Label("Total:", tfTotalPrice);
        lbTotalPrice.setContentDisplay(ContentDisplay.BOTTOM);    
        
        vbox2.getChildren().addAll(lbPizza, lbBeverage, lbTax, lbTotalPrice);        
        
        // ------ Label Top ----------------------------------------------------        
        Pane paneForText =  new Pane();
        Label lbField = new Label("The Best Pizza in Town");   
        lbField.setFont(Font.font("Times New Roman", FontWeight.BOLD, 42));
        lbField.setPadding(new Insets(30, 30, 10, 10));
        paneForText.getChildren().add(lbField);
        //--------Logo----------------------------------------------
        HBox pizzaLogoHBox = new HBox();
        pizzaLogoHBox.setPadding(new Insets(10, 10, 10, 20 ));
        pizzaLogoHBox.getChildren().addAll(pizzaLogo, paneForText);

        Line line = new Line(450, 200, -1200, 200);
        // Create a path transition 
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.INDEFINITE.millis(9000));
        pt.setPath(line);
        pt.setNode(lbField);
        pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play(); // Start animation 

        showClearButton();        
        borderPane.setRight(vbox2);
        borderPane.setTop(pizzaLogoHBox); 
        borderPane.setAlignment(pizzaLogoHBox, Pos.CENTER);
        borderPane.setBottom(borderPanePayments);

        Scene scene = new Scene(borderPane, 1000, 800);
        primaryStage.setTitle("Pizza Order Menu"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage       
    }    
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
     private void validateCard(TextField tfCardNumber, TextField tfMM, 
            TextField tfYY)
    {
        Calendar calendar = new GregorianCalendar();
        
        try{
        if(tfCardNumber.getText().length() < 16 || 
           tfCardNumber.getText().length() > 16)
            throw new ArithmeticException("Invalid Card Number");
        } catch (Exception ex1){
            cardValidation("Invalid Card Number");          
        }
        
        if(Integer.valueOf(tfMM.getText()) < 1 || 
                 Integer.valueOf(tfMM.getText()) > 12)
        {
            cardValidation("Invalid Date");            
        }
        else if((Integer.valueOf(tfMM.getText()) < (calendar.get(Calendar.MONTH) 
                + 1) && Integer.valueOf(tfYY.getText()) == year%100))
        {
            cardValidation("Card Expired");
        }
        else if(Integer.valueOf(tfYY.getText()) < (year%100))
        {            
            cardValidation("Card Expired");
        }
               
        else if (tfCardNumber.getText().length() == 16)
        {
            cardValidation("Valid Card");
        }
    }
    
    private void showFormOfPayment()
    {
        RadioButton rbCash = new RadioButton("Cash");
        rbCash.setSelected(true);
        RadioButton rbDebitCredit = new RadioButton("Debit/Credit");
        rbDebitCredit.setSelected(false);
        ToggleGroup paymentGroup = new ToggleGroup();
        rbCash.setToggleGroup(paymentGroup);
        rbDebitCredit.setToggleGroup(paymentGroup);            

        vBoxPayment.setPadding(new Insets(10, 30, 100, 30));
        vBoxPayment.setSpacing(20);
        vBoxPayment.getChildren().addAll(rbCash, rbDebitCredit);         
        
        Label lbPayment = new Label("Form of Payment");    
        lbPayment.setPadding(new Insets(30, 30, 14, 30));
        
        borderPanePayments.setLeft(vBoxPayment);
        borderPanePayments.setTop(lbPayment);
        BorderPane.setAlignment(lbPayment, Pos.TOP_LEFT);
        
        rbCash.setOnAction(e ->
        {
            clearCardInfo();            
        });
        
        rbDebitCredit.setOnAction(e ->
        {            
                showCardInfo();            
        });
        
        
    }
    
    private void clearFormOfPayment()
    {
        vBoxPayment.getChildren().clear();
        borderPanePayments.getChildren().clear();
        showClearButton();
    }    
    
    private void showCardInfo()
    {
        //GridPane cardInfoPane = new GridPane();
            cardInfoPane.setPadding(new Insets(0, 30, 30, 100));
            cardInfoPane.setHgap(5);
            cardInfoPane.setVgap(10);
            TextField tfCardNumber = new TextField("");
            tfCardNumber.setMaxWidth(120);
            tfCardNumber.setEditable(true);
            Label lbCardNumber = new Label("Card Number:");            
            Label lbExpireDate = new Label("Expire Date:");
            Label lbMM = new Label("  MM");
            
            TextField tfMM = new TextField();
            tfMM.setMaxWidth(30);
            tfMM.setEditable(true);
            
            TextField tfYY = new TextField();
            tfYY.setMaxWidth(30);
            tfYY.setEditable(true);
            Label lbYY = new Label(" YY");
            Button btValidate = new Button("Validate");
            cardInfoPane.add(lbCardNumber, 0, 0, 1, 1);
            cardInfoPane.add(tfCardNumber, 1, 0, 5, 1);
            cardInfoPane.add(lbExpireDate, 0, 1, 1, 1);
            cardInfoPane.add(lbMM, 1, 1, 1, 1);
            cardInfoPane.add(tfMM, 2, 1, 1, 1);
            cardInfoPane.add(lbYY, 3, 1, 1, 1);
            cardInfoPane.add(tfYY, 4, 1, 1, 1);
            cardInfoPane.add(btValidate, 3, 2, 2, 1);
            borderPanePayments.setCenter(cardInfoPane);
            
             btValidate.setOnAction(e ->
            {
                validateCard(tfCardNumber, tfMM, tfYY);
            });
    }
    
    private void clearCardInfo()
    {
        cardInfoPane.getChildren().clear();
        showClearButton();
    }
    
    private void clearTextFields()
    {
        priceForPizza = 0.00;
        priceForBeverage = 0.00;
        taxAmount = 0.00;
        total = 0.00;
        tfPizza.setText("$"+"0.00");
        
        tfBeverage.setText("$"+"0.00");
        tfTax.setText("$"+"0.00");
        tfTotalPrice.setText("$"+"0.00");
    }
    
    private void showClearButton()
    {
        VBox vBoxClear = new VBox();
        vBoxClear.setPadding(new Insets(30, 30, 30, 30));
        Button btClear = new Button("Clear");
        btClear.setPadding(new Insets(20, 20, 20, 20));
        vBoxClear.getChildren().add(btClear);
           
        
        
        borderPanePayments.setRight(vBoxClear);
        
        btClear.setOnAction(e ->
        {
            clearFormOfPayment();
            clearCardInfo(); 
            clearTextFields();
            showPizzaBeverages ();
        });
    }
    
    private void showPizzaBeverages ()
    {
         // ------ Border Pane for Toppings and Beverages ----------------------- 
        BorderPane borderPaneToppingsBeverages = new BorderPane();
        
            // ------ Pizza  --------------------------------------------------- 
            HBox hBox1 = new HBox();
            hBox1.setPadding(new Insets(60,30, 0, 30));
            hBox1.setSpacing(20);
        
            RadioButton rbPizza = new RadioButton("Pizza");
            rbPizza.setSelected(false);        
            rbPizza.setGraphic(imagePizza);
            rbPizza.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);         
            hBox1.getChildren().addAll(rbPizza);
        
            // ------ Beverages ----------------------------------------------- 
            HBox hBox2 = new HBox(); 
            hBox2.setPadding(new Insets(40, 30, 0, 30));
            hBox2.setSpacing(20);        
            RadioButton rbBeverages = new RadioButton("Beverages");
            rbBeverages.setSelected(false);
            rbBeverages.setGraphic(imageBeverages);
            rbBeverages.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);       
            hBox2.getChildren().addAll(rbBeverages);       
        
            borderPaneToppingsBeverages.setTop(hBox1);
            borderPaneToppingsBeverages.setCenter(hBox2);  
            
            borderPane.setCenter(borderPaneToppingsBeverages);
            BorderPane.setAlignment(hBox1, Pos.TOP_LEFT);
         
            //set actions for the radio buttons and check boxes, to change 
            //the price showing in the textfield
            rbPizza.setOnAction(e -> 
            {
                if(rbPizza.isSelected())
                {
                    
                    pricing(5,tfPizza);
                    
                    CheckBox chkPepperoni = new CheckBox("Pepperoni"); 
                    setChkBox(chkPepperoni, 2);

                    CheckBox chkMushrooms = new CheckBox("Mushrooms");  
                    setChkBox(chkMushrooms,1.25);
                    
                    CheckBox chkSausage = new CheckBox("Sausage");
                    setChkBox(chkSausage,.75);
                    
                    CheckBox chkExtraCheese = new CheckBox("Extra Cheese");  
                    setChkBox(chkExtraCheese,1);                 
                    
                    
                    hBox1.getChildren().addAll(chkPepperoni, chkMushrooms, chkSausage, chkExtraCheese);
                    if(!(rbBeverages.isSelected()))
                    {
                        showFormOfPayment();
                    }
                }
                
                else
                {
                    priceForPizza=0;
                    pricing(0,tfPizza); 
                    hBox1.getChildren().clear();
                    hBox1.getChildren().addAll(rbPizza);
                    
                    if(!(rbBeverages.isSelected()))
                    {
                        clearFormOfPayment();
                        clearCardInfo();
                    }
                }
            });
        
        rbBeverages.setOnAction(e ->
        {
            if(rbBeverages.isSelected())
            {
                RadioButton rbTea = new RadioButton("Tea");
                setRB(rbTea,1);
                RadioButton rbCola = new RadioButton("Beer");
                setRB(rbCola, 5);
                RadioButton rbRootBeer = new RadioButton("Root Beer");
                setRB(rbRootBeer, 1.50);
                RadioButton rbDietCola = new RadioButton("Wine");
                setRB(rbDietCola, 500);
                hBox2.getChildren().addAll(rbTea, rbCola, rbRootBeer, rbDietCola);
        
                ToggleGroup beveragesgroup = new ToggleGroup();
                rbTea.setToggleGroup(beveragesgroup);
                rbCola.setToggleGroup(beveragesgroup);
                rbRootBeer.setToggleGroup(beveragesgroup);
                rbDietCola.setToggleGroup(beveragesgroup);
                if(!(rbPizza.isSelected()))
                {
                    showFormOfPayment();
                }

            }
            else
            {
                priceForBeverage = 0 ; 
                tfBeverage.setText("$"+Double.toString(priceForBeverage));
                showTaxShowTotal();
                
                hBox2.getChildren().clear();
                hBox2.getChildren().addAll(rbBeverages);
                if(!(rbPizza.isSelected()))
                {
                    clearFormOfPayment();
                    clearCardInfo();
                }
            }            
        });
        
        rbPizza.setFocusTraversable(true);        
    }
    
    private void showTaxShowTotal()
    {
        taxAmount = (priceForPizza + priceForBeverage)* TAX ; 
        tfTax.setText("$"+ String.format("%.2f", Double.parseDouble(Double.toString(taxAmount))));
        total = (int)((priceForPizza + priceForBeverage + taxAmount)*100)/100.0 ; 
        tfTotalPrice.setText("$"+ String.format("%.2f", Double.parseDouble(Double.toString(total))));
    }
    
    private void pricing(double price, TextField tfPizza){

    priceForPizza += price; 
    tfPizza.setText("$"+ String.format("%.2f", Double.parseDouble(Double.toString(priceForPizza))));
    showTaxShowTotal();
    
    }
    private void pricing2(double price, TextField tfBeverage){
        
    priceForBeverage += price; 
    tfBeverage.setText("$"+Double.toString(priceForBeverage)+"0");
    showTaxShowTotal();
    }
    
    private void cardValidation(String one){
    
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Card Validation");
    alert.setHeaderText(null);
    alert.setContentText(one);
    alert.showAndWait();
    }

    private void setRB( RadioButton name , double price){ 
name.setOnAction(event ->{
    if (name.isSelected()){
        priceForBeverage=0;
        pricing2(price, tfBeverage);
    }
    else{
        pricing2(-price, tfBeverage);
    }
});    
    }
    
    private void setChkBox( CheckBox name , double price){ 
name.setOnAction(event ->{
    if (name.isSelected()){
        pricing(price, tfPizza);
    }
    else{
        pricing(-price, tfPizza);
    }
});
    
}
}