/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static java.lang.Float.parseFloat;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class layout extends Application  {
All k;

 
Button btn,btn1,btn3,dep,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
   Stage window;
    Scene scene1,scene2,scene3,scene4,scene5,scene6,scene7,scene9;
    
public static void main(String[] args) {
     launch(args); 
}



@Override
public void start (Stage PrimaryStage) throws Exception
{ window=PrimaryStage;
k=new All();

 window.setTitle("ATM");
    Label lb1=new Label("Welcome");
    lb1.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 60));
    Label lb2=new Label("Enter Your Card Number.(16-Digits)");
    TextField num = new TextField();
    btn=new Button ("Next");
VBox layout = new VBox(20);
layout.setAlignment(Pos.CENTER);
VBox layout2=new VBox(20);
layout2.setAlignment(Pos.CENTER);
HBox nlayout3=new HBox(20);
HBox elayout3=new HBox(20);
HBox elayout6=new HBox(20);
VBox layout3=new VBox(20);
layout3.setAlignment(Pos.CENTER);
nlayout3.setAlignment(Pos.CENTER);
elayout3.setAlignment(Pos.CENTER);
VBox layout4=new VBox(20);
VBox layout5=new VBox(20);
VBox layout6=new VBox(20);
VBox layout7=new VBox(20);
HBox elayout9=new HBox(20);
VBox layout9=new VBox(20);
 layout9.setAlignment(Pos.CENTER);
  elayout9.setAlignment(Pos.CENTER);
    dep=new Button ("Deposit");
    btn5=new Button ("Balance Enquiry");
    btn6=new Button ("WithDraw");
    btn7=new Button ("Navigate Through History");
 btn8=new Button("Last 5 Transactions");
 btn9=new Button ("Back to Option Menu");
 btn10=new Button ("Back to Option Menu ");
 btn11=new Button ("Back to Option Menu");
 btn12=new Button ("Back to Option Menu");
 btn13=new Button ("Back to Option Menu");
 
 btn7.setOnAction(e-> window.setScene(scene9));
 Button back=new Button("<<Previous");
        Button next=new Button("Next>>");
       Label view=new Label();
       
       back.setOnAction(e->{
           String x;
           x=k.prev();
           view.setText(x);
           
       });
       
        next.setOnAction(e->{
           String x;
           x=k.next();
           view.setText(x);
           
       });
       
       //layout
       
      btn13.setOnAction( e ->window.setScene(scene3));
       elayout9.getChildren().addAll(back,next);
       layout9.getChildren().addAll(view,elayout9,btn13);

   nlayout3.getChildren().addAll(dep,btn5,btn6);
   elayout3.getChildren().addAll(btn7,btn8);
layout3.getChildren().addAll(nlayout3,elayout3);
       layout.getChildren().add(lb1);
     layout.getChildren().addAll(lb2,num);
          Label note2 = new Label();
 layout.getChildren().addAll(btn,note2);
     btn.setOnAction(   e ->
       {if(num.getText().length()==16)
       window.setScene(scene2); 
       else
   {note2.setText("This is an unvalid card number.\nPlease enter a 16 digit number.");
}
       } );
       Label lb3=new Label("Enter the PassCode.(4-Digits)");
    TextField pass = new TextField();
   
   btn1=new Button ("Enter");
  Label note3=new Label();
    layout2.getChildren().add(lb3);
   layout2.getChildren().add(pass);  
  
    
   
   btn1.setOnAction(e ->
       {
         if(pass.getText().contentEquals(k.passcode))
       window.setScene(scene3); 
       else
   note3.setText("Wrong PassCode.\nEnter Again!!");
       });
  layout2.getChildren().addAll(btn1,note3);
   
   btn9.setAlignment(Pos.BOTTOM_LEFT);
   Label note5=new Label(); 
  
   btn5.setOnAction( e ->{
       window.setScene(scene5); 
       note5.setText("Your Current Balance is "+k.getbalance()+" L.E.");
       
        
        
                
            });
   
    layout5.getChildren().addAll(note5,btn9);
     btn9.setOnAction( e ->{
      
         window.setScene(scene3);
             });
  dep.setOnAction( e ->window.setScene(scene4));
  btn6.setOnAction( e ->window.setScene(scene6));
  btn12.setOnAction( e ->window.setScene(scene3));
  Label note11=new Label();
  btn8.setOnAction(e ->{
      window.setScene(scene7);
      
          note11.setText(k.present(k.his[0])+k.present(k.his[1])+k.present(k.his[2])+k.present(k.his[3])+k.present(k.his[4]));
          
      } 
  );
  
  layout7.getChildren().addAll(note11,btn12);

   btn10.setOnAction( e ->window.setScene(scene3));
   btn11.setOnAction( e ->window.setScene(scene3));
  
   Label note6=new Label ("Enter the amount you want to Deposit.");
   TextField am=new TextField();
btn14=new Button("Proceed");
btn13=new Button("Proceed");
Label note7=new Label();
btn13.setOnAction( e ->{
    k.deposit(parseFloat(am.getText()));
           note7.setText(am.getText()+" L.E is added to your account.Your new balance is "+k.getbalance()+" L.E/");
           
          
});

Label note10=new Label("Enter the amount you want to WithDraw.");
 TextField am2=new TextField();


Label note8=new Label();
        
btn14.setOnAction( e ->{
    
        
    if(k.withdraw(parseFloat(am2.getText())))
     note8.setText(am.getText()+" L.E is withdrawn from your account.Your new balance is "+k.getbalance()+" L.E.");
               
   else
    note8.setText("You donot have enough money for this transaction.\nYou must deposit money into your Account.");
       
}
); 
elayout6.getChildren().addAll(btn11,btn14);
layout6.getChildren().addAll(note10,am2,note8,elayout6);
  

HBox nlayout4=new HBox(20);
nlayout4.getChildren().addAll(btn10,btn13);
layout4.getChildren().addAll(note6,am,note7,nlayout4);

btn10.setAlignment(Pos.BOTTOM_LEFT);
btn13.setAlignment(Pos.BOTTOM_RIGHT);
 scene1=new Scene(layout,500,500);
scene2=new Scene(layout2,500,500);
scene3=new Scene(layout3,500,500);
scene4=new Scene(layout4,500,500);
scene5=new Scene(layout5,500,500);
scene6=new Scene(layout6,500,500);
scene7=new Scene(layout7,500,500);
scene9=new Scene(layout9,500,500);
window.setScene(scene1);
    window.show();
}

   
  
       
    
}